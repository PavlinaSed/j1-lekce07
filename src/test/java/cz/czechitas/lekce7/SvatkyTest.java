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
        Svatky svatky = new Svatky();
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
        String jmenoJeVSeznamu = "Klaudie";
        String jmenoNeniVSeznamu = "Julie";

        // Act
        boolean resultJeVSeznamu = svatky.jeVSeznamu(jmenoJeVSeznamu);
        boolean resultNeniVSeznamu = svatky.jeVSeznamu(jmenoNeniVSeznamu);

        // Assert
        assertTrue(resultJeVSeznamu, "Očekávala jsem, že " + jmenoJeVSeznamu + " je v seznamu jmen.");
        assertFalse(resultNeniVSeznamu, "Očekávala jsem, že " + jmenoNeniVSeznamu + " není v seznamu jmen.");
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
        Svatky svatky = new Svatky();
        svatky.pridejSvatek("Marcela", 20, 4);
        String jmenoJePridane = "Marcela";
        MonthDay datumPridanehoJmenaJe = MonthDay.of(4, 20);

        boolean resultJmenoJePridane = svatky.jeVSeznamu(jmenoJePridane);

        assertTrue(resultJmenoJePridane);
        assertEquals(MonthDay.of(4, 20), svatky.vratKdyMaSvatek("Marcela"));
        // System.out.println(svatky.getSeznamJmen());      VYPISE SEZNAM JMEN VCETNE MARCELY
    }

    /**
     * Testuje metodu {@link Svatky#pridejSvatek(String, int, java.time.Month)}
     */
    @Test
    void pridejSvatekDenMesicMonth() {
        Svatky svatky = new Svatky();
        svatky.pridejSvatek("Markéta", 13, 7);
        String jmenoJePridane = "Markéta";
        int denPridanehoJmena = 13;
        int mesicPridanehoJmena = 7;

        boolean resultJmenoJePridane = svatky.jeVSeznamu(jmenoJePridane);

        assertTrue(resultJmenoJePridane);
        assertEquals(MonthDay.of(7, 13), svatky.vratKdyMaSvatek("Markéta"));
    }

    /**
     * Testuje metodu {@link Svatky#pridejSvatek(String, MonthDay)}
     */
    @Test
    void pridejSvatekMonthDay() {
        Svatky svatky = new Svatky();

        svatky.pridejSvatek("Pavel", 29, 6);
        String jmenoJePridane = "Pavel";
        int denPridanehoJmena = 29;
        Month mesicPridanehoJmena = Month.JUNE;

        boolean resultJmenoJePridane = svatky.jeVSeznamu(jmenoJePridane);

        assertTrue(resultJmenoJePridane);
        assertEquals(MonthDay.of(6, 29), svatky.vratKdyMaSvatek("Pavel"));
    }

    /**
     * Testuje metodu {@link Svatky#smazSvatek(String)}
     */
    @Test
    void smazSvatek() {
        Svatky svatky = new Svatky();
        svatky.smazSvatek("Pankrác");

        assertEquals(36, svatky.getPocetJmen());
    }
}
