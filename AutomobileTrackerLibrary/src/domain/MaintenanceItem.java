package domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Car for automobile maintenance items
 */
public class MaintenanceItem implements Serializable
{
    private Date date;
    private String type;
    private String id;

    /** If the maintenance type is an oil change */
    public static final String OIL_CHANGE = "Oil Change";

    /** If the maintenance type is a tire rotation */
    public static final String TIRE_ROTATION = "Tire Rotation";

    /** If the maintenance type is waxing a vehicle */
    public static final String WAX_VEHICLE = "Wax Vehicle";

    /**
     * Private constructor for a maintenance item
     * @param type
     * @param date
     * @param id
     */
    private MaintenanceItem(String type, Date date, String id)
    {
        this.type = type;
        this.date = date;
        this.id = id;
    }

    /**
     * Returns an instance of an automobile maintenance item
     * @param type Type of maintenance item (oil change, tire rotation, or wax vehicle)
     * @param date Date of maintenance
     * @param id ID of maintenance item
     * @return Instance of a maintenance item
     * @throws IllegalArgumentException if the type is not one of OIL_CHANGE, TIRE_ROTATION, or WAX_VEHICLE
     */
    public static MaintenanceItem getInstance(String type, Date date, String id) throws IllegalArgumentException
    {
        if (type == null || (!type.equals(OIL_CHANGE) && !type.equals(TIRE_ROTATION) && !type.equals(WAX_VEHICLE)))
            throw new IllegalArgumentException("Illegal maintenance type");
        return new MaintenanceItem(type, date, id);
    }

    /**
     * Returns he date of maintenance
     * @return Date of maintenance
     */
    public Date getDate()
    {
        return date;
    }

    /**
     * Sets the date of maintenance
     * @param date Date of maintenance
     */
    public void setDate(Date date)
    {
        this.date = date;
    }

    /**
     * Returns the type of maintenance
     * @return Type of maintenance
     */
    public String getType()
    {
        return type;
    }

    /**
     * Sets the type of maintenance
     * @param type Type of maintenance
     * @throws IllegalArgumentException if the type is not one of OIL_CHANGE, TIRE_ROTATION, or WAX_VEHICLE
     */
    public void setType(String type) throws IllegalArgumentException
    {
        if (type == null || (!type.equals(OIL_CHANGE) && !type.equals(TIRE_ROTATION) && !type.equals(WAX_VEHICLE)))
            throw new IllegalArgumentException("Illegal maintenance type");
        this.type = type;
    }

    /**
     * Returns the ID of the maintenance item
     * @return ID of the maintenance item
     */
    public String getId()
    {
        return id;
    }

    /**
     * Sets the ID of the maintenance item
     * @param id ID of the maintenance item
     */
    public void setId(String id)
    {
        this.id = id;
    }
}
