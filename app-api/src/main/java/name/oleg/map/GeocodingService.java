package name.oleg.map;

import java.io.IOException;

public interface GeocodingService {

    public Coordinate getCoordinate(String searchAddress) throws IOException;
}
