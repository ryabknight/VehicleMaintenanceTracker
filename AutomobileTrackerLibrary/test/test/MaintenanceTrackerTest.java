package test;

import domain.*;
import org.junit.Before;
import org.junit.Test;
import utility.MaintenanceTracker;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.*;

public class MaintenanceTrackerTest
{
    private MaintenanceTracker maintenanceTracker;
    private ElectricCar electricCar;
    private GasCar gasCar;
    private DieselCar dieselCar;

    @Before
    public void setUp() throws Exception
    {
        maintenanceTracker = MaintenanceTracker.getInstance();
        maintenanceTracker.loadAutomobileList(new ArrayList<>());
        electricCar = ElectricCar.getInstance("Tesla", "Model S", 2017, "Red", 14000, "E1234", "tesla", "Elon");
        gasCar = GasCar.getInstance("Volkswagen", "Beetle", 2000, "Blue", 151000, "G1234", "bug", "Ryan");
        dieselCar = DieselCar.getInstance("Ford", "F-250 XL", 2019, "White", 2000, "D1234", "truck", "Bob");
    }

    /**
     * Test adding an electric car by parameters
     */
    @Test
    public void addAutomobile1()
    {
        maintenanceTracker.addAutomobile(Automobile.ELECTRIC_CAR, electricCar.getMake(), electricCar.getModel(),
                electricCar.getYear(), electricCar.getColour(), electricCar.getOdometerReading(),
                electricCar.getName(), electricCar.getOwner());
        Automobile a = maintenanceTracker.getAutomobileList().get(0);
        assertTrue(a instanceof ElectricCar);
        assertEquals(electricCar.getMake(), a.getMake());
        assertEquals(electricCar.getModel(), a.getModel());
        assertEquals(electricCar.getYear(), a.getYear());
        assertEquals(electricCar.getColour(), a.getColour());
        assertEquals(electricCar.getOdometerReading(), a.getOdometerReading(), 0);
        assertEquals(electricCar.getName(), a.getName());
        assertEquals(electricCar.getOwner(), a.getOwner());
    }

    /**
     * Test adding a gas car by parameters
     */
    @Test
    public void addAutomobile2()
    {
        maintenanceTracker.addAutomobile(Automobile.GAS_CAR, gasCar.getMake(), gasCar.getModel(),
                gasCar.getYear(), gasCar.getColour(), gasCar.getOdometerReading(),
                gasCar.getName(), gasCar.getOwner());
        Automobile a = maintenanceTracker.getAutomobileList().get(0);
        assertTrue(a instanceof GasCar);
        assertEquals(gasCar.getMake(), a.getMake());
        assertEquals(gasCar.getModel(), a.getModel());
        assertEquals(gasCar.getYear(), a.getYear());
        assertEquals(gasCar.getColour(), a.getColour());
        assertEquals(gasCar.getOdometerReading(), a.getOdometerReading(), 0);
        assertEquals(gasCar.getName(), a.getName());
        assertEquals(gasCar.getOwner(), a.getOwner());
    }

    /**
     * Test adding a diesel car by parameters
     */
    @Test
    public void addAutomobile3()
    {
        maintenanceTracker.addAutomobile(Automobile.DIESEL_CAR, dieselCar.getMake(), dieselCar.getModel(),
                dieselCar.getYear(), dieselCar.getColour(), dieselCar.getOdometerReading(),
                dieselCar.getName(), dieselCar.getOwner());
        Automobile a = maintenanceTracker.getAutomobileList().get(0);
        assertTrue(a instanceof DieselCar);
        assertEquals(dieselCar.getMake(), a.getMake());
        assertEquals(dieselCar.getModel(), a.getModel());
        assertEquals(dieselCar.getYear(), a.getYear());
        assertEquals(dieselCar.getColour(), a.getColour());
        assertEquals(dieselCar.getOdometerReading(), a.getOdometerReading(), 0);
        assertEquals(dieselCar.getName(), a.getName());
        assertEquals(dieselCar.getOwner(), a.getOwner());
    }

    /**
     * Test for adding null type
     */
    @Test
    public void addAutomobile4()
    {
        try
        {
            maintenanceTracker.addAutomobile(null, "a", "a", 1950, "", 0, null, null);
            fail();
        }
        catch (IllegalArgumentException e)
        {
            assertTrue(true);
        }
    }

    /**
     * Test for adding invalid type
     */
    @Test
    public void addAutomobile5()
    {
        try
        {
            maintenanceTracker.addAutomobile("wrong", "a", "a", 1950, "", 0, null, null);
            fail();
        }
        catch (IllegalArgumentException e)
        {
            assertTrue(true);
        }
    }

    /**
     * Test for adding invalid make/model
     */
    @Test
    public void addAutomobile6()
    {
        try
        {
            maintenanceTracker.addAutomobile(Automobile.ELECTRIC_CAR, "", null, 1950, "", 0, null, null);
            fail();
        }
        catch (IllegalArgumentException e)
        {
            assertTrue(true);
        }
    }

    /**
     * Test getting an automobile by id
     */
    @Test
    public void getAutomobileById1()
    {
        maintenanceTracker.addAutomobile(Automobile.ELECTRIC_CAR, electricCar.getMake(), electricCar.getModel(),
                electricCar.getYear(), electricCar.getColour(), electricCar.getOdometerReading(),
                electricCar.getName(), electricCar.getOwner());
        Automobile a = maintenanceTracker.getAutomobileList().get(0);
        Automobile b = maintenanceTracker.getAutomobileById(a.getId());
        assertTrue(a instanceof ElectricCar);
        assertEquals(a.getMake(), b.getMake());
        assertEquals(a.getModel(), b.getModel());
        assertEquals(a.getYear(), b.getYear());
        assertEquals(a.getColour(), b.getColour());
        assertEquals(a.getOdometerReading(), b.getOdometerReading(), 0);
        assertEquals(a.getName(), b.getName());
        assertEquals(a.getOwner(), b.getOwner());
    }

    /**
     * Test getting an id that does not exist
     */
    @Test
    public void getAutomobileById2()
    {
        maintenanceTracker.addAutomobile(Automobile.ELECTRIC_CAR, electricCar.getMake(), electricCar.getModel(),
                electricCar.getYear(), electricCar.getColour(), electricCar.getOdometerReading(),
                electricCar.getName(), electricCar.getOwner());
        Automobile a = maintenanceTracker.getAutomobileById("wrong");
        assertNull(a);
    }

    /**
     * Test removing an automobile by id
     */
    @Test
    public void removeAutomobileById1()
    {
        maintenanceTracker.addAutomobile(Automobile.ELECTRIC_CAR, electricCar.getMake(), electricCar.getModel(),
                electricCar.getYear(), electricCar.getColour(), electricCar.getOdometerReading(),
                electricCar.getName(), electricCar.getOwner());
        Automobile a = maintenanceTracker.getAutomobileList().get(0);
        Automobile b = maintenanceTracker.removeAutomobileById(a.getId());
        assertTrue(a instanceof ElectricCar);
        assertEquals(a.getMake(), b.getMake());
        assertEquals(a.getModel(), b.getModel());
        assertEquals(a.getYear(), b.getYear());
        assertEquals(a.getColour(), b.getColour());
        assertEquals(a.getOdometerReading(), b.getOdometerReading(), 0);
        assertEquals(a.getName(), b.getName());
        assertEquals(a.getOwner(), b.getOwner());
        assertEquals(0, maintenanceTracker.getAutomobileList().size());
    }

    /**
     * Test removing an id that does not exist
     */
    @Test
    public void removeAutomobileById2()
    {
        maintenanceTracker.addAutomobile(Automobile.ELECTRIC_CAR, electricCar.getMake(), electricCar.getModel(),
                electricCar.getYear(), electricCar.getColour(), electricCar.getOdometerReading(),
                electricCar.getName(), electricCar.getOwner());
        Automobile a = maintenanceTracker.getAutomobileById("wrong");
        assertNull(a);
        assertEquals(1, maintenanceTracker.getAutomobileList().size());
    }

    /**
     * Test updating an automobile
     */
    @Test
    public void updateAutomobile1()
    {
        maintenanceTracker.addAutomobile(Automobile.ELECTRIC_CAR, electricCar.getMake(), electricCar.getModel(),
                electricCar.getYear(), electricCar.getColour(), electricCar.getOdometerReading(),
                electricCar.getName(), electricCar.getOwner());
        Automobile a = maintenanceTracker.getAutomobileList().get(0);
        a = maintenanceTracker.updateAutomobile(a.getId(), dieselCar.getMake(), dieselCar.getModel(),
                dieselCar.getYear(), dieselCar.getColour(), dieselCar.getOdometerReading(),
                dieselCar.getName(), dieselCar.getOwner());
        assertEquals(dieselCar.getMake(), a.getMake());
        assertEquals(dieselCar.getModel(), a.getModel());
        assertEquals(dieselCar.getYear(), a.getYear());
        assertEquals(dieselCar.getColour(), a.getColour());
        assertEquals(dieselCar.getOdometerReading(), a.getOdometerReading(), 0);
        assertEquals(dieselCar.getName(), a.getName());
        assertEquals(dieselCar.getOwner(), a.getOwner());
    }

    /**
     * Test updating an automobile with an id that doesn't exist
     */
    @Test
    public void updateAutomobile2()
    {
        maintenanceTracker.addAutomobile(Automobile.ELECTRIC_CAR, electricCar.getMake(), electricCar.getModel(),
                electricCar.getYear(), electricCar.getColour(), electricCar.getOdometerReading(),
                electricCar.getName(), electricCar.getOwner());
        Automobile a = maintenanceTracker.updateAutomobile("wrong", dieselCar.getMake(), dieselCar.getModel(),
                dieselCar.getYear(), dieselCar.getColour(), dieselCar.getOdometerReading(),
                dieselCar.getName(), dieselCar.getOwner());
        assertNull(a);
    }

    /**
     * Get a maintenance item by id
     */
    @Test
    public void getMaintenanceItemById1()
    {
        maintenanceTracker.addAutomobile(Automobile.ELECTRIC_CAR, electricCar.getMake(), electricCar.getModel(),
                electricCar.getYear(), electricCar.getColour(), electricCar.getOdometerReading(),
                electricCar.getName(), electricCar.getOwner());
        Automobile a = maintenanceTracker.getAutomobileList().get(0);
        Date d =  new Date();
        maintenanceTracker.addTireRotation(a.getId(), d);
        MaintenanceItem m = maintenanceTracker.getMaintenanceItemById(a.getMaintenanceItems().get(0).getId());
        assertEquals(d, m.getDate());
    }

    /**
     * Get a maintenance item by id that doesn't exist
     */
    @Test
    public void getMaintenanceItemById2()
    {
        maintenanceTracker.addAutomobile(Automobile.ELECTRIC_CAR, electricCar.getMake(), electricCar.getModel(),
                electricCar.getYear(), electricCar.getColour(), electricCar.getOdometerReading(),
                electricCar.getName(), electricCar.getOwner());
        Automobile a = maintenanceTracker.getAutomobileList().get(0);
        Date d =  new Date();
        maintenanceTracker.addTireRotation(a.getId(), d);
        MaintenanceItem m = maintenanceTracker.getMaintenanceItemById("wrong");
        assertNull(m);
    }

    /**
     * Test removing a maintenance item
     */
    @Test
    public void removeMaintenanceItemById1()
    {
        maintenanceTracker.addAutomobile(Automobile.ELECTRIC_CAR, electricCar.getMake(), electricCar.getModel(),
                electricCar.getYear(), electricCar.getColour(), electricCar.getOdometerReading(),
                electricCar.getName(), electricCar.getOwner());
        Automobile a = maintenanceTracker.getAutomobileList().get(0);
        Date d =  new Date();
        maintenanceTracker.addTireRotation(a.getId(), d);
        MaintenanceItem m = maintenanceTracker.removeMaintenanceItemById(a.getMaintenanceItems().get(0).getId());
        assertEquals(d, m.getDate());
        assertEquals(0, a.getMaintenanceItems().size());
    }

    /**
     * Test removing a maintenance item that doesn't exist
     */
    @Test
    public void removeMaintenanceItemById2()
    {
        maintenanceTracker.addAutomobile(Automobile.ELECTRIC_CAR, electricCar.getMake(), electricCar.getModel(),
                electricCar.getYear(), electricCar.getColour(), electricCar.getOdometerReading(),
                electricCar.getName(), electricCar.getOwner());
        Automobile a = maintenanceTracker.getAutomobileList().get(0);
        Date d =  new Date();
        maintenanceTracker.addTireRotation(a.getId(), d);
        MaintenanceItem m = maintenanceTracker.removeMaintenanceItemById("wrong");
        assertNull(m);
    }

    @Test
    public void addOilChange1()
    {
        maintenanceTracker.addAutomobile(Automobile.GAS_CAR, gasCar.getMake(), gasCar.getModel(),
                gasCar.getYear(), gasCar.getColour(), gasCar.getOdometerReading(),
                gasCar.getName(), gasCar.getOwner());
        Automobile a = maintenanceTracker.getAutomobileList().get(0);
        Date d =  new Date();
        maintenanceTracker.addOilChange(a.getId(), d);
        assertEquals(1, a.getMaintenanceItems().size());
        assertEquals(d, a.getMaintenanceItems().get(0).getDate());
        assertEquals(MaintenanceItem.OIL_CHANGE, a.getMaintenanceItems().get(0).getType());
    }

    /**
     * Test adding an illegal maintenance item to an electric vehicle
     */
    @Test
    public void addOilChange2()
    {
        maintenanceTracker.addAutomobile(Automobile.ELECTRIC_CAR, electricCar.getMake(), electricCar.getModel(),
                electricCar.getYear(), electricCar.getColour(), electricCar.getOdometerReading(),
                electricCar.getName(), electricCar.getOwner());
        Automobile a = maintenanceTracker.getAutomobileList().get(0);
        Date d =  new Date();
        try
        {
            maintenanceTracker.addOilChange(a.getId(), d);
            fail();
        }
        catch (IllegalArgumentException e)
        {
            assertTrue(true);
        }
    }

    /**
     * Test adding a tire rotation maintenance item
     */
    @Test
    public void addTireRotation()
    {
        maintenanceTracker.addAutomobile(Automobile.ELECTRIC_CAR, electricCar.getMake(), electricCar.getModel(),
                electricCar.getYear(), electricCar.getColour(), electricCar.getOdometerReading(),
                electricCar.getName(), electricCar.getOwner());
        Automobile a = maintenanceTracker.getAutomobileList().get(0);
        Date d =  new Date();
        maintenanceTracker.addTireRotation(a.getId(), d);
        assertEquals(1, a.getMaintenanceItems().size());
        assertEquals(d, a.getMaintenanceItems().get(0).getDate());
        assertEquals(MaintenanceItem.TIRE_ROTATION, a.getMaintenanceItems().get(0).getType());
    }

    /**
     * Test adding a wax vehicle maintenance item
     */
    @Test
    public void addWaxVehicle()
    {
        maintenanceTracker.addAutomobile(Automobile.ELECTRIC_CAR, electricCar.getMake(), electricCar.getModel(),
                electricCar.getYear(), electricCar.getColour(), electricCar.getOdometerReading(),
                electricCar.getName(), electricCar.getOwner());
        Automobile a = maintenanceTracker.getAutomobileList().get(0);
        Date d =  new Date();
        maintenanceTracker.addWaxVehicle(a.getId(), d);
        assertEquals(1, a.getMaintenanceItems().size());
        assertEquals(d, a.getMaintenanceItems().get(0).getDate());
        assertEquals(MaintenanceItem.WAX_VEHICLE, a.getMaintenanceItems().get(0).getType());
    }

    /**
     * Test loading a pre-defined list into the tracker and getting it from the tracker
     */
    @Test
    public void loadAndGetAutomobileList()
    {
        ArrayList<Automobile> list = new ArrayList<>();
        list.add(electricCar);
        list.add(gasCar);
        list.add(dieselCar);
        maintenanceTracker.loadAutomobileList(list);
        ArrayList<Automobile> newList = maintenanceTracker.getAutomobileList();
        assertEquals(3, newList.size());
        assertEquals(electricCar.getId(), newList.get(0).getId());
        assertEquals(gasCar.getId(), newList.get(1).getId());
        assertEquals(dieselCar.getId(), newList.get(2).getId());
    }
}