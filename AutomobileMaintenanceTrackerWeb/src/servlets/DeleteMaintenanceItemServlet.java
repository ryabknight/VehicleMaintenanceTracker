package servlets;

import util.ManageData;
import utility.MaintenanceTracker;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteMaintenanceItemServlet")
public class DeleteMaintenanceItemServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        MaintenanceTracker mt = MaintenanceTracker.getInstance();
        mt.loadAutomobileList(ManageData.loadVehicles(getServletContext()));
        String id = request.getParameter("id");
        mt.removeMaintenanceItemById(id);
        ManageData.saveVehicles(getServletContext(), mt.getAutomobileList());
        response.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }
}
