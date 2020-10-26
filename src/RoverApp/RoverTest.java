package RoverApp;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoverTest {
    //https://kata-log.rocks/mars-rover-kata
    @ParameterizedTest
    @CsvSource({
            "N,E",
            "E,S",
            "S,W",
            "W,N"
    })
    void turnsRightClockwise(String startFacing, String endsFacing) {
        //arrange
        Rover rover = new Rover(startFacing);
        //act
        rover.go("R");
        //assert
        assertEquals(endsFacing, rover.getFacing());
    }

    @ParameterizedTest
    @CsvSource({
            "N,W",
            "W,S",
            "S,E",
            "E,N"
    })
    void turnsLeftAnticlockwise(String startFacing, String endFacing) {
        //Arrange
        Rover rover = new Rover(startFacing);
        //Act
        rover.go("L");
        //assert
        assertEquals(endFacing, rover.getFacing());
    }
}
