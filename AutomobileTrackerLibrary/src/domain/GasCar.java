package domain;

import java.util.Date;
import java.util.List;

public class GasCar extends Automobile
{
    private GasCar(String make, String model, int year, String colour, double odometerReading, String id, String name, String owner)
    {
        super(make, model, year, colour, odometerReading, id, name, owner);
    }

    public static GasCar getInstance(String make, String model, int year, String colour, double odometerReading, String id, String name, String owner)
    {
        if (make == null || model == null || make.isEmpty() || model.isEmpty())
            throw new IllegalArgumentException("Make and model must both be populated");
        if (year < 1900)
            throw new IllegalArgumentException("Year outside bounds");
        if (odometerReading < 0)
            throw new IllegalArgumentException("Odometer reading outside bounds");
        GasCar car = new GasCar(make, model, year, colour, odometerReading, id, name, owner);
        car.setType("Gas");
        return car;
    }

    @Override
    public void addMaintenanceItem(MaintenanceItem item)
    {
        this.getMaintenanceItems().add(item);
    }

    @Override
    public void addMaintenanceItem(String type, Date date, String id)
    {
        this.getMaintenanceItems().add(MaintenanceItem.getInstance(type, date, id));
    }

    @Override
    public void addMaintenanceList(List<MaintenanceItem> list)
    {
        this.getMaintenanceItems().addAll(list);
    }
}
