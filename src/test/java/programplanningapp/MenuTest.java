package programplanningapp;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MenuTest {
    private Menu menu;
    private String description;
    private MenuOption quitOption = new QuitMenuOption("Quit");

    /**
     * Setup member variables for tests.
     */
    @Before
    public void setUp() {
        description = "this is a menu description";
        menu = new Menu(description);
    }

    /**
     * Test getMenuOptionByValue().
     */
    @Test
    public void testGetMenuOptionByValue() {
        menu.addOption(quitOption);
        int value = 1;

        assertEquals(menu.getMenuOptionByValue(1), quitOption);
    }

    /**
     * Test hasMenuOption().
     */
    @Test
    public void testHasOption() {
        menu.addOption(quitOption);
        int value = 1;

        assertTrue(menu.hasOption(1));
        assertFalse(menu.hasOption(2));
    }

    /**
     * Test getAddOption().
     */
    @Test
    public void testAddOption() {
        menu.addOption(quitOption);

        assertTrue(menu.hasOption(1));
    }
}
