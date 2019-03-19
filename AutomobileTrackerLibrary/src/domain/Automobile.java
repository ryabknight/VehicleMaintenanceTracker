package domain;

import com.sun.javaws.exceptions.InvalidArgumentException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Abstract superclass for Automobile objects.
 */
public abstract class Automobile implements Serializable
{
    private String make;
    private String model;
    private int year;
    private String colour;
    private double odometerReading;
    private String id;
    private String name;
    private String owner;
    private ArrayList<MaintenanceItem> maintenanceItems;
    private String type;

    /** If the car type is electric */
    public static final String ELECTRIC_CAR = "electric";

    /** If the car type is gas */
    public static final String GAS_CAR = "gas";

    /** If the car type is diesel */
    public static final String DIESEL_CAR = "diesel";

    /** If the
    /**
     * Constructor for the Automobile class
     *
     * @param make Make or manufacturer of automobile
     * @param model Model of automobile
     * @param year Model year of automobile
     * @param colour Colour of automobile
     * @param odometerReading Odometer reading of automobile
     * @param id ID of automobile
     * @param name Name of automobile
     * @param owner Name of owner of automobile
     */
    Automobile(String make, String model, int year, String colour, double odometerReading, String id, String name, String owner)
    {
        this.make = make;
        this.model = model;
        this.year = year;
        this.colour = colour;
        this.odometerReading = odometerReading;
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.maintenanceItems = new ArrayList<>();
    }

    /**
     * Returns make or manufacturer of the automobile
     * @return make or manufacturer
     */
    public String getMake()
    {
        return make;
    }

    /**
     * Sets make or manufacturer of the automobile
     * @param make make or manufacturer of the automobile
     * @throws IllegalArgumentException if make is null
     */
    public void setMake(String make) throws IllegalArgumentException
    {
        if (make == null)
            throw new IllegalArgumentException("Make cannot be null");
        this.make = make;
    }

    /**
     * Returns the model of the automobile
     * @return model of the automobile
     */
    public String getModel()
    {
        return model;
    }

    /**
     * Sets the model of the automobile
     * @param model Model of the automobile
     * @throws IllegalArgumentException if the model is null
     */
    public void setModel(String model) throws IllegalArgumentException
    {
        if (make == null)
            throw new IllegalArgumentException("Model cannot be null");
        this.model = model;
    }

    /**
     * Returns the model year of the automobile
     * @return model year of the automobile
     */
    public int getYear()
    {
        return year;
    }

    /**
     * Sets the model year of the automobile
     * @param year Model year of the automobile
     * @throws IllegalArgumentException if year is less than 1900
     */
    public void setYear(int year) throws IllegalArgumentException
    {
        if (year < 1900)
            throw new IllegalArgumentException("Year must be greater than 1900");
        this.year = year;
    }

    /**
     * Returns the colour of the automobile
     * @return Colour of the automobile
     */
    public String getColour()
    {
        return colour;
    }

    /**
     * Sets the colour of the automobile
     * @param colour Colour of the automobile
     */
    public void setColour(String colour)
    {
        this.colour = colour;
    }

    /**
     * Returns the odometer reading of the automobile
     * @return Odometer reading of the automobile
     */
    public double getOdometerReading()
    {
        return odometerReading;
    }

    /**
     * Sets the odometer reading of the automobile
     * @param odometerReading Odometer reading of the automobile
     * @throws IllegalArgumentException if odometerReading is less than 0
     */
    public void setOdometerReading(double odometerReading) throws IllegalArgumentException
    {
        if (odometerReading < 0)
            throw new IllegalArgumentException("Reading must be greater than 0");
        this.odometerReading = odometerReading;
    }

    /**
     * Returns the ID of the automobile
     * @return ID of the automobile
     */
    public String getId()
    {
        return id;
    }

    /**
     * Sets the ID of the automobile
     * @param id ID of the automobile
     */
    public void setId(String id)
    {
        this.id = id;
    }

    /**
     * Returns the name of the automobile
     * @return Name of the automobile
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name of the automobile
     * @param name Name of the automobile
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Returns the name of the owner of the automobile
     * @return Name of the owner of the automobile
     */
    public String getOwner()
    {
        return owner;
    }

    /**
     * Sets the name of the owner of the automobile
     * @param owner Name of the owner of the automobile
     */
    public void setOwner(String owner)
    {
        this.owner = owner;
    }

    /**
     * Returns the type of the automobile (Electric, gas, or diesel)
     * @return Type of the automobile
     */
    public String getType()
    {
        return type;
    }

    /**
     * Sets the type of the automobile (For the subclasses)
     * @param type Type of the automobile
     */
    void setType(String type)
    {
        this.type = type;
    }

    /**
     * Returns the list of maintenance items for the automobile
     * @return List of maintenance items for the automobile
     */
    public ArrayList<MaintenanceItem> getMaintenanceItems()
    {
        return maintenanceItems;
    }

    /**
     * Adds a maintenance item to the automobile
     * @param item Maintenance item to add
     * @throws IllegalArgumentException if the maintenance type is illegal (i.e. oil change on an electric car)
     */
    public abstract void addMaintenanceItem(MaintenanceItem item) throws IllegalArgumentException;

    /**
     * Adds a maintenance item to the automobile
     * @param type Type of the maintenance
     * @param date Date of the maintenance
     * @param id ID of the maintenance
     * @throws IllegalArgumentException if the maintenance type is illegal (i.e. oil change on an electric car)
     */
    public abstract void addMaintenanceItem(String type, Date date, String id) throws IllegalArgumentException;

    /**
     * Adds a list of maintenance items to an automobile
     * @param list List of items to add
     * @throws IllegalArgumentException if a maintenance type is illegal (i.e. oil change on an electric car)
     */
    public abstract void addMaintenanceList(List<MaintenanceItem> list) throws IllegalArgumentException;
}
