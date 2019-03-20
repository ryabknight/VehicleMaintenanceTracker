package servlets;

import util.ManageData;
import utility.MaintenanceTracker;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddVehicleServlet")
public class AddVehicleServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String type = request.getParameter("carType");
        String name = request.getParameter("carName");
        String make = request.getParameter("carMake");
        String model = request.getParameter("carModel");
        int year = Integer.parseInt(request.getParameter("carYear"));
        double odometer = Double.parseDouble(request.getParameter("carOdometerReading"));
        String owner = request.getParameter("carOwner");
        String colour = request.getParameter("carColour");

        MaintenanceTracker mt = MaintenanceTracker.getInstance();
        mt.loadAutomobileList(ManageData.loadVehicles(getServletContext()));
        mt.addAutomobile(type, make, model, year, colour, odometer, name, owner);
        ManageData.saveVehicles(getServletContext(), mt.getAutomobileList());
        response.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        getServletContext().getRequestDispatcher("/WEB-INF/jsps/addVehicleForm.jsp").forward(request, response);
    }
}
