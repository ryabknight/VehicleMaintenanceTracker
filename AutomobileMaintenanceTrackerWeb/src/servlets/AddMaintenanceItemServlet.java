package servlets;

import domain.MaintenanceItem;
import util.ManageData;
import utility.MaintenanceTracker;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "AddMaintenanceItemServlet")
public class AddMaintenanceItemServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        MaintenanceTracker mt = MaintenanceTracker.getInstance();
        mt.loadAutomobileList(ManageData.loadVehicles(getServletContext()));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try
        {
            date = sdf.parse(request.getParameter("date"));
        } catch (ParseException e)
        {
            e.printStackTrace();
        }
        String type = request.getParameter("type");
        String carId = request.getParameter("carId");
        switch(type)
        {
            case MaintenanceItem.OIL_CHANGE:
                mt.addOilChange(carId, date);
                break;
            case MaintenanceItem.TIRE_ROTATION:
                mt.addTireRotation(carId, date);
                break;
            case MaintenanceItem.WAX_VEHICLE:
                mt.addWaxVehicle(carId, date);
                break;
        }
        ManageData.saveVehicles(getServletContext(), mt.getAutomobileList());
        response.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }
}
