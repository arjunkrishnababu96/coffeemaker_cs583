package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import junit.framework.TestCase;

public class InventoryTest extends TestCase {
    CoffeeMaker cm;
    Recipe r1;

    protected void setUp() throws Exception {
        cm = new CoffeeMaker();

        super.setUp();
    }

    // positive test -- Arjun Krishna Babu
    public void testAddInventory_positive_1()  {
        /* Ensure positive values can be added to the inventory */

        try {
            cm.addInventory("3", "4", "5", "6");
        } catch (InventoryException e) {
            fail("InventoryException for addInventory(3,4,5,6)");
        }
    }

    // positive test -- Arjun Krishna Babu
    public void testAddInventory_positive_2()   {
        /* Ensure 0 values can be added to the inventory */
        try {
            cm.addInventory("0", "0", "0", "0");
        } catch (InventoryException e)  {
            fail("InventoryException for addInventory(0,0,0,0)");
        }
    }

    // positive test -- Arjun Krishna Babu
    public void testAddInventoryTwice_positive_3() throws InventoryException {
        // add to inventory twice, and see if the values in inventory add up

        // set all inventory values to 0
        cm.setInventory_chocolate(0);
        cm.setInventory_coffee(0);
        cm.setInventory_milk(0);
        cm.setInventory_sugar(0);

        // coffee=1, milk=3, sugar=5, chocolate=7
        cm.addInventory("1", "3", "5", "7");

        // coffee=2, milk=4, sugar=6, chocolate=8
        cm.addInventory("2", "4", "6", "8");

        // verify that the inventory addition is as expected
        assertEquals(1+2, cm.getInventory_coffee());
        assertEquals(3+4, cm.getInventory_milk());
        assertEquals(5+6, cm.getInventory_sugar());
        assertEquals(7+8, cm.getInventory_chocolate());
    }

    // negative test -- Arjun Krishna Babu
    public void testAddInventory_negative_1()  {
        /* Ensure negative values cannot be added to the inventory */

        try {
            cm.addInventory("-3", "-4", "-5", "-6");
            fail("InventoryException should be thrown for addInventory(-3, -4, -5, -6)");
        } catch (InventoryException e) {
            // success if thrown
        }
    }

    // negative test -- Arjun Krishna Babu
    public void testAddInventory_negative_2()   {
        /* Ensure non-integer values cannot be added to the inventory */

        try {
            cm.addInventory("1.2", "3.4", "5.6", "7.8");
            fail("InventoryException should be thrown for addInventory(1.2, 3.4, 5.6, 7.8)");
        } catch (InventoryException e)  {
            // success if thrown
        }
    }

    // positive test -- Arjun Krishna Babu
    public void test_checkInventory() throws InventoryException {
        /* ensure value returned by checkInventory() is as expected */

        // set all inventory values to 0
        cm.setInventory_chocolate(0);
        cm.setInventory_coffee(0);
        cm.setInventory_milk(0);
        cm.setInventory_sugar(0);

        // coffee=2, milk=4, sugar=6, chocolate=8
        cm.addInventory("2", "4", "6", "8");

        final String EXPECTED = "Coffee: 2\nMilk: 4\nSugar: 6\nChocolate: 8\n";

        assertEquals(EXPECTED, cm.checkInventory());
    }
}
