package domain;

import java.util.Date;

public class MaintenanceItem
{
    private Date date;
    private String type;
    private String id;

    public static final String OIL_CHANGE = "Oil Change";
    public static final String TIRE_ROTATION = "Tire Rotation";
    public static final String WAX_VEHICLE = "Wax Vehicle";

    private MaintenanceItem(String type, Date date, String id)
    {
        this.type = type;
        this.date = date;
        this.id = id;
    }

    public static MaintenanceItem getInstance(String type, Date date, String id)
    {
        if (type == null || (!type.equals(OIL_CHANGE) && !type.equals(TIRE_ROTATION) && !type.equals(WAX_VEHICLE)))
            throw new IllegalArgumentException("Illegal maintenance type");
        return new MaintenanceItem(type, date, id);
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }
}
