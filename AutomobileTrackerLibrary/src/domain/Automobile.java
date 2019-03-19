package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    public String getMake()
    {
        return make;
    }

    public void setMake(String make)
    {
        this.make = make;
    }

    public String getModel()
    {
        return model;
    }

    public void setModel(String model)
    {
        this.model = model;
    }

    public int getYear()
    {
        return year;
    }

    public void setYear(int year)
    {
        this.year = year;
    }

    public String getColour()
    {
        return colour;
    }

    public void setColour(String colour)
    {
        this.colour = colour;
    }

    public double getOdometerReading()
    {
        return odometerReading;
    }

    public void setOdometerReading(double odometerReading)
    {
        this.odometerReading = odometerReading;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getOwner()
    {
        return owner;
    }

    public void setOwner(String owner)
    {
        this.owner = owner;
    }

    public String getType()
    {
        return type;
    }

    void setType(String type)
    {
        this.type = type;
    }

    public ArrayList<MaintenanceItem> getMaintenanceItems()
    {
        return maintenanceItems;
    }

    public abstract void addMaintenanceItem(MaintenanceItem item);

    public abstract void addMaintenanceItem(String type, Date date, String id);

    public abstract void addMaintenanceList(List<MaintenanceItem> list);
}
