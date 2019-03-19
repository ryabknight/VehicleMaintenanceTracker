package domain;

import java.util.Date;
import java.util.List;

public class ElectricCar extends Automobile
{
    private ElectricCar(String make, String model, int year, String colour, double odometerReading, String id, String name, String owner)
    {
        super(make, model, year, colour, odometerReading, id, name, owner);
    }

    public static ElectricCar getInstance(String make, String model, int year, String colour, double odometerReading, String id, String name, String owner) throws IllegalArgumentException
    {
        if (make == null || model == null || make.isEmpty() || model.isEmpty())
            throw new IllegalArgumentException("Make and model must both be populated");
        if (year < 1900)
            throw new IllegalArgumentException("Year outside bounds");
        if (odometerReading < 0)
            throw new IllegalArgumentException("Odometer reading outside bounds");
        ElectricCar car = new ElectricCar(make, model, year, colour, odometerReading, id, name, owner);
        car.setType("Electric");
        return car;
    }

    @Override
    public void addMaintenanceItem(MaintenanceItem item) throws IllegalArgumentException
    {
        if (item.getType().equals(MaintenanceItem.OIL_CHANGE))
            throw new IllegalArgumentException();
        this.getMaintenanceItems().add(item);
    }

    @Override
    public void addMaintenanceItem(String type, Date date, String id) throws IllegalArgumentException
    {
        if (type.equals(MaintenanceItem.OIL_CHANGE))
            throw new IllegalArgumentException();
        this.getMaintenanceItems().add(MaintenanceItem.getInstance(type, date, id));
    }

    @Override
    public void addMaintenanceList(List<MaintenanceItem> list) throws IllegalArgumentException
    {
        list.forEach(item -> {
            if (item.getType().equals(MaintenanceItem.OIL_CHANGE))
                throw new IllegalArgumentException();
        });
        this.getMaintenanceItems().addAll(list);
    }
}
