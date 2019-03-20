package utility;

import domain.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Class for tracking automobiles and automobile maintenance
 */
public class MaintenanceTracker
{
    private static ArrayList<Automobile> automobileList;
    private static MaintenanceTracker maintenanceTracker = null;

    private MaintenanceTracker()
    {
        automobileList = new ArrayList<>();
    }

    /**
     * Singleton pattern method to return an instance of the maintenance tracker
     * @return Instance of the maintenance tracker
     */
    public static MaintenanceTracker getInstance()
    {
        if (maintenanceTracker != null)
            return maintenanceTracker;
        return new MaintenanceTracker();
    }

    /**
     * Method to add an automobile to the tracker by parameters.
     * The type parameter determines the type of vehicle.
     * The type parameter values are found in static fields in the Automobile class.
     * @param type Type of vehicle (electric, gas, or diesel)
     * @param make Make of vehicle
     * @param model Model of vehicle
     * @param year Year of vehicle
     * @param colour Colour of vehicle
     * @param odometerReading Odometer reading of vehicle
     * @param name Name of vehicle
     * @param owner Name of owner of vehicle
     * @throws IllegalArgumentException if the type is not one of electric, gas, or diesel
     */
    public void addAutomobile(String type, String make, String model, int year, String colour, double odometerReading,
                              String name, String owner) throws IllegalArgumentException
    {
        String id = UUID.randomUUID().toString();
        if (type == null)
            throw new IllegalArgumentException("Type can't be null");
        switch (type.toLowerCase())
        {
            case Automobile.ELECTRIC_CAR:
                automobileList.add(ElectricCar.getInstance(make, model, year, colour, odometerReading, id, name, owner));
                break;
            case Automobile.GAS_CAR:
                automobileList.add(GasCar.getInstance(make, model, year, colour, odometerReading, id, name, owner));
                break;
            case Automobile.DIESEL_CAR:
                automobileList.add(DieselCar.getInstance(make, model, year, colour, odometerReading, id, name, owner));
                break;
            default:
                throw new IllegalArgumentException("Invalid automobile type");
        }
    }

    /**
     * Returns the automobile with ID matching the ID paramter
     * @param id ID of automobile to fetch
     * @return Automobile found, or null if not found
     */
    public Automobile getAutomobileById(String id)
    {
        for (Automobile a:automobileList)
        {
            if (a.getId().equals(id))
                return a;
        }
        return null;
    }

    /**
     * Removes an automobile from the tracker by its ID
     * @param id ID of automobile to remove
     * @return Automobile removed, or null if not found
     */
    public Automobile removeAutomobileById(String id)
    {
        for (Automobile a:automobileList)
        {
            if (a.getId().equals(id))
                return automobileList.remove(automobileList.indexOf(a));
        }
        return null;
    }

    /**
     * Updates a vehicle matching the ID in the id parameter of the method.
     * Updates all values to match those given in this method.
     * @param id ID of automobile to be changed
     * @param make Make of automobile to be changed
     * @param model Model of automobile to be changed
     * @param year Model year of automobile to be chanegd
     * @param colour Colour of automobile to be changed
     * @param odometerReading Odometer reading of automobile to be changed
     * @param name Name of automobile to be changed
     * @param owner Owner of automobile to be changed
     * @return Automobile that has been updated, or null if not found
     * @throws IllegalArgumentException if make or model is null, odometer reading is less than 0,
     *                  or year is less than 1900
     */
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

    /**
     * Returns a maintenance item in the tracker by its ID
     * @param itemId ID of item to retrieve
     * @return Maintenance item with matching ID, or null if not found
     */
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

    /**
     * Removes a maintenance item from the tracker with matching ID
     * @param itemId ID of item to be removed
     * @return Maintenance item removed, or null if not found
     */
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

    /**
     * Adds an oil change maintenance item to the automobile matching the automobileId parameter
     * @param automobileId ID of automobile to add an oil change to
     * @param date Date of maintenance
     * @throws IllegalArgumentException
     */
    public void addOilChange(String automobileId, Date date) throws IllegalArgumentException
    {
        Automobile automobile = getAutomobileById(automobileId);
        if (automobile != null)
            automobile.addMaintenanceItem(MaintenanceItem
                    .getInstance(MaintenanceItem.OIL_CHANGE, date, UUID.randomUUID().toString()));
    }

    /**
     * Adds a tire rotation maintenance item to the automobile matching the automobileId parameter
     * @param automobileId ID of automobile to add a tire rotation to
     * @param date Date of maintenance
     */
    public void addTireRotation(String automobileId, Date date)
    {
        Automobile automobile = getAutomobileById(automobileId);
        if (automobile != null)
            automobile.addMaintenanceItem(MaintenanceItem
                    .getInstance(MaintenanceItem.TIRE_ROTATION, date, UUID.randomUUID().toString()));
    }

    /**
     * Adds a wax vehicle maintenance item to the automobile matching the automobileId parameter
     * @param automobileId ID of automobile to add a wax vehicle to
     * @param date Date of maintenance
     */
    public void addWaxVehicle(String automobileId, Date date)
    {
        Automobile automobile = getAutomobileById(automobileId);
        if (automobile != null)
            automobile.addMaintenanceItem(MaintenanceItem
                    .getInstance(MaintenanceItem.WAX_VEHICLE, date, UUID.randomUUID().toString()));
    }

    /**
     * Loads a list of automobiles to the tracker.
     * Replaces any items that existed in the list previously.
     * @param list List of automobiles for the tracker to track
     */
    public void loadAutomobileList(List<Automobile> list)
    {
        automobileList = new ArrayList<>();
        automobileList.addAll(list);
    }

    /**
     * Returns a list of Automobiles held in the tracker.
     * @return List of automobiles in the tracker
     */
    public ArrayList<Automobile> getAutomobileList()
    {
        ArrayList<Automobile> list = new ArrayList<>();
        list.addAll(automobileList);
        return list;
    }
}
