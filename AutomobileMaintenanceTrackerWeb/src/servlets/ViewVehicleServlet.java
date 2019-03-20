package servlets;

import domain.Automobile;
import util.ManageData;
import utility.MaintenanceTracker;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ViewVehicleServlet")
public class ViewVehicleServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String id = request.getParameter("id");
        MaintenanceTracker mt = MaintenanceTracker.getInstance();
        mt.loadAutomobileList(ManageData.loadVehicles(getServletContext()));
        Automobile a = mt.getAutomobileById(id);
        request.setAttribute("vehicle", a);
        request.setAttribute("maintenanceItems", a.getMaintenanceItems());
        getServletContext().getRequestDispatcher("/WEB-INF/jsps/viewVehicleForm.jsp").forward(request, response);
    }
}
