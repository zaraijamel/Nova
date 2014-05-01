package name.oleg.map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/service-context.xml"})
public class GeocodingServiceTest {

    @Autowired
    private GeocodingService geocodingService;

    @Test
    public void requestCoordinateTest() throws IOException {
        Coordinate coordinate = geocodingService.getCoordinate("Беларусь, Минск, проспект Независимост, 174");
        if (coordinate != null) {
            System.err.println(coordinate.getLatitude());
            System.err.println(coordinate.getLongitude());
        }
    }
}
