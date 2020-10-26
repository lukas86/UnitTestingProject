package testSimple;

import org.junit.jupiter.api.*;
import testSimple.PopulationSearch;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PopulationSearchTest {

    PopulationSearch populationSearch;

    @BeforeEach
    public void setupTest() {
        populationSearch = new PopulationSearch();
    }

    @Test
    public void findPopulation() {
        String city = "Bangalore";
        assertEquals(200000, populationSearch.getPopulation(city));
    }

    @Test
    public void findPopulationWithEmptyInput() {
        String city = "";
        assertThrows(NullPointerException.class, () -> populationSearch.getPopulation(city));
    }

    @Test
    public void findPopulationWithInvalidInput() {
        String city = "XYZ";
        assertThrows(NullPointerException.class, () -> populationSearch.getPopulation(city));
    }


}
