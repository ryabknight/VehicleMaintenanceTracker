package util;

import domain.Automobile;
import domain.DieselCar;
import domain.ElectricCar;
import domain.GasCar;
import utility.MaintenanceTracker;

import javax.servlet.ServletContext;
import java.io.*;
import java.util.ArrayList;

public class ManageData
{
    public static void saveVehicles(ServletContext context, ArrayList<Automobile> list)
    {
        String path = context.getRealPath("/WEB-INF/vehicles.ser");
        try
        {
            File file = new File(path);
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file, false));
            oos.writeObject(list);
            oos.close();
        }
        catch(Exception e)
        {

        }
    }

    public static ArrayList<Automobile> loadVehicles(ServletContext context)
    {
        String path = context.getRealPath("/WEB-INF/vehicles.ser");
        ArrayList<Automobile> list = new ArrayList<>();
        try
        {
            File file = new File(path);
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            list = (ArrayList<Automobile>)ois.readObject();
            ois.close();
        }
        catch(Exception e)
        {
            list.add(ElectricCar.getInstance("Tesla", "S", 2017, "Red", 14000, "E1234", "tesla", "Elon"));
            list.add(GasCar.getInstance("VW", "Beetle", 2000, "Blue", 151000, "G1234", "bug", "Ryan"));
            list.add(DieselCar.getInstance("Ford", "F-250", 2019, "White", 2000, "D1234", "truck", "Bob"));

        }
        return list;
    }
}
