package cz.czechitas.lekce7;

import org.junit.jupiter.api.Test;

import java.time.Month;
import java.time.MonthDay;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Filip Jirsák
 */
class SvatkyTest {

    /**
     * Testuje metodu {@link Svatky#vratKdyMaSvatek(String)}
     */
    @Test
    void vratKdyMaSvatek() {
        //Arrange
        Svatky svatky = new Svatky();

        //Assert
        assertEquals(MonthDay.of(5, 26), svatky.vratKdyMaSvatek("Filip"));
        assertNull(svatky.vratKdyMaSvatek("Pavlína"));
    }

    /**
     * Testuje metodu {@link Svatky#jeVSeznamu(String)}
     */
    @Test
    void jeVSeznamu() {
        // Arrange
        Svatky svatky = new Svatky();
        String nameInList = "Klaudie";
        String nameNotInList = "Julie";

        // Act
        boolean isInList = svatky.jeVSeznamu(nameInList);
        boolean isNotInList = svatky.jeVSeznamu(nameNotInList);

        // Assert
        assertTrue(isInList, "Očekávala jsem, že " + nameInList + " je v seznamu jmen.");
        assertFalse(isNotInList, "Očekávala jsem, že " + nameNotInList + " není v seznamu jmen.");
    }


    /**
     * Testuje metodu {@link Svatky#getPocetJmen()}
     */
    @Test
    void getPocetJmen() {
        Svatky svatky = new Svatky();
        assertEquals(37, svatky.getPocetJmen());
    }

    /**
     * Testuje metodu {@link Svatky#getSeznamJmen()}
     */
    @Test
    void getSeznamJmen() {
        Svatky svatky = new Svatky();
        assertEquals(37, svatky.getSeznamJmen().size());
    }

    /**
     * Testuje metodu {@link Svatky#pridejSvatek(String, int, int)}
     */
    @Test
    void pridejSvatekDenMesicInt() {
        //Arrange
        Svatky svatky = new Svatky();
        String expectedName = "Marcela";
        MonthDay expectedDate = MonthDay.of(4, 20);

        //Act
        svatky.pridejSvatek("Marcela", 20, 4);
        boolean isAdded = svatky.jeVSeznamu(expectedName);

        //Assert
        assertTrue(isAdded);
        assertEquals(expectedDate, svatky.vratKdyMaSvatek(expectedName));
    }

    /**
     * Testuje metodu {@link Svatky#pridejSvatek(String, int, java.time.Month)}
     */
    @Test
    void pridejSvatekDenMesicMonth() {
        //Arrange
        Svatky svatky = new Svatky();
        String addedName = "Markéta";

        //Act
        svatky.pridejSvatek(addedName, 13, Month.JULY);
        boolean isAdded = svatky.jeVSeznamu(addedName);

        //Assert
        assertTrue(isAdded);
        assertEquals(MonthDay.of(7, 13), svatky.vratKdyMaSvatek(addedName));
    }

    /**
     * Testuje metodu {@link Svatky#pridejSvatek(String, MonthDay)}
     */
    @Test
    void pridejSvatekMonthDay() {
        //Arrange
        Svatky svatky = new Svatky();
        String nameToBeAdded = "Pavel";

        //Act
        svatky.pridejSvatek(nameToBeAdded, MonthDay.of(6, 29));
        boolean isAdded = svatky.jeVSeznamu(nameToBeAdded);

        //Assert
        assertTrue(isAdded);
        assertEquals(MonthDay.of(6, 29), svatky.vratKdyMaSvatek(nameToBeAdded));
    }

    /**
     * Testuje metodu {@link Svatky#smazSvatek(String)}
     */
    @Test
    void smazSvatek() {
        //Arrange
        Svatky svatky = new Svatky();
        String nameToBeDeleted = "Pankrác";

        //Act
        svatky.smazSvatek(nameToBeDeleted);
        boolean isDeleted = svatky.jeVSeznamu(nameToBeDeleted);

        //Assert
        assertEquals(36, svatky.getPocetJmen());
        assertFalse(isDeleted);
    }
}
