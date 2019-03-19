package utlility;

import domain.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class MaintenanceTracker
{
    private static ArrayList<Automobile> automobileList;
    private static MaintenanceTracker maintenanceTracker = null;

    private MaintenanceTracker()
    {
        automobileList = new ArrayList<>();
    }

    public static MaintenanceTracker getInstance()
    {
        if (maintenanceTracker != null)
            return maintenanceTracker;
        return new MaintenanceTracker();
    }

    public void addAutomobile(String type, String make, String model, int year, String colour, double odometerReading,
                              String name, String owner) throws IllegalArgumentException
    {
        String id = UUID.randomUUID().toString();
        if (type == null)
            throw new IllegalArgumentException("Type can't be null");
        switch (type.toLowerCase())
        {
            case "electric":
                automobileList.add(ElectricCar.getInstance(make, model, year, colour, odometerReading, id, name, owner));
                break;
            case "gas":
                automobileList.add(GasCar.getInstance(make, model, year, colour, odometerReading, id, name, owner));
                break;
            case "diesel":
                automobileList.add(DieselCar.getInstance(make, model, year, colour, odometerReading, id, name, owner));
                break;
            default:
                throw new IllegalArgumentException("Invalid automobile type");
        }
    }

    public Automobile getAutomobileById(String id)
    {
        for (Automobile a:automobileList)
        {
            if (a.getId().equals(id))
                return a;
        }
        return null;
    }

    public Automobile removeAutomobileById(String id)
    {
        for (Automobile a:automobileList)
        {
            if (a.getId().equals(id))
                return automobileList.remove(automobileList.indexOf(a));
        }
        return null;
    }

    public Automobile updateAutomobile(String id, String make, String model, int year, String colour,
                                       double odometerReading, String name, String owner) throws IllegalArgumentException
    {
        Automobile automobile = getAutomobileById(id);
        if (automobile == null)
            return null;
        automobile.setMake(make);
        automobile.setModel(model);
        automobile.setYear(year);
        automobile.setColour(colour);
        automobile.setOdometerReading(odometerReading);
        automobile.setName(name);
        automobile.setOwner(owner);
        return automobile;
    }

    public MaintenanceItem getMaintenanceItemById(String itemId)
    {
        for (Automobile a:automobileList)
        {
            for (MaintenanceItem mi:a.getMaintenanceItems())
            {
                if (itemId.equals(mi.getId()))
                    return mi;
            }
        }
        return null;
    }

    public MaintenanceItem removeMaintenanceItemById(String itemId)
    {
        for (Automobile a:automobileList)
        {
            for (MaintenanceItem mi:a.getMaintenanceItems())
            {
                if (itemId.equals(mi.getId()))
                    return a.getMaintenanceItems().remove(a.getMaintenanceItems().indexOf(mi));
            }
        }
        return null;
    }

    public void addOilChange(String automobileId, Date date) throws IllegalArgumentException
    {
        Automobile automobile = getAutomobileById(automobileId);
        if (automobile != null)
            automobile.addMaintenanceItem(MaintenanceItem
                    .getInstance(MaintenanceItem.OIL_CHANGE, date, UUID.randomUUID().toString()));
    }

    public void addTireRotation(String automobileId, Date date)
    {
        Automobile automobile = getAutomobileById(automobileId);
        if (automobile != null)
            automobile.addMaintenanceItem(MaintenanceItem
                    .getInstance(MaintenanceItem.TIRE_ROTATION, date, UUID.randomUUID().toString()));
    }

    public void addWaxVehicle(String automobileId, Date date)
    {
        Automobile automobile = getAutomobileById(automobileId);
        if (automobile != null)
            automobile.addMaintenanceItem(MaintenanceItem
                    .getInstance(MaintenanceItem.WAX_VEHICLE, date, UUID.randomUUID().toString()));
    }

    public void loadAutomobileList(List<Automobile> list)
    {
        automobileList = new ArrayList<>();
        automobileList.addAll(list);
    }

    public ArrayList<Automobile> getAutomobileList()
    {
        ArrayList<Automobile> list = new ArrayList<>();
        list.addAll(automobileList);
        return list;
    }
}
