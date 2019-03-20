package servlets;


import com.google.gson.Gson;
import domain.Automobile;
import util.ManageData;
import utility.MaintenanceTracker;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = "GetVehiclesServlet")
public class GetVehiclesServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        MaintenanceTracker mt = MaintenanceTracker.getInstance();
        mt.loadAutomobileList(ManageData.loadVehicles(getServletContext()));
//        mt.addAutomobile(Automobile.ELECTRIC_CAR, "make", "model", 2000, "blue",
//                123, "name", "bob");
//        mt.addAutomobile(Automobile.GAS_CAR, "make", "model", 1999, "red",
//                123, "name", "frank");

        request.setAttribute("vehicles", mt.getAutomobileList());
        ManageData.saveVehicles(getServletContext(), mt.getAutomobileList());
        getServletContext().getRequestDispatcher("/WEB-INF/jsps/vehicleList.jsp").forward(request, response);
    }
}
