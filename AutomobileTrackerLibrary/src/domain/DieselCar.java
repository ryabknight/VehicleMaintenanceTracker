package domain;

import java.util.Date;
import java.util.List;

/**
 * Class for a diesel car
 */
public class DieselCar extends Automobile
{
    /**
     * Private constructor for diesel car class
     * @param make
     * @param model
     * @param year
     * @param colour
     * @param odometerReading
     * @param id
     * @param name
     * @param owner
     */
    private DieselCar(String make, String model, int year, String colour, double odometerReading, String id, String name, String owner)
    {
        super(make, model, year, colour, odometerReading, id, name, owner);
    }

    /**
     * Returns an instance of a diesel car
     * @param make make of car
     * @param model model of car
     * @param year model year of car
     * @param colour colour of car
     * @param odometerReading odometer reading of car
     * @param id ID of car
     * @param name name of car
     * @param owner name of owner of car
     * @return An instance of an electric car
     * @throws IllegalArgumentException if model or make is empty/null, year is less than 1900, or odometer
     *                      reading is less than 0
     */
    public static DieselCar getInstance(String make, String model, int year, String colour, double odometerReading, String id, String name, String owner)
    {
        if (make == null || model == null || make.isEmpty() || model.isEmpty())
            throw new IllegalArgumentException("Make and model must both be populated");
        if (year < 1900)
            throw new IllegalArgumentException("Year outside bounds");
        if (odometerReading < 0)
            throw new IllegalArgumentException("Odometer reading outside bounds");
        DieselCar car = new DieselCar(make, model, year, colour, odometerReading, id, name, owner);
        car.setType(Automobile.DIESEL_CAR);
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
