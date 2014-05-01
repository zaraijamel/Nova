package name.oleg.map;

import name.oleg.io.pagereader.PageContent;
import name.oleg.io.pagereader.PageReader;
import name.oleg.map.exception.RequestLimitExceededException;
import name.oleg.util.HttpUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class GoogleGeocodingV3Service implements GeocodingService {
    private static final String BASE_REQUEST_URL = "http://maps.googleapis.com/maps/api/geocode/json";

    @Autowired
    private PageReader pageReader;

    @Override
    public Coordinate getCoordinate(String searchAddresses) throws IOException {
        String requestUrl = getRequestUrl(searchAddresses);
        String page = readPage(requestUrl);
        return parseCoordinate(page);
    }

    private Coordinate parseCoordinate(String page) throws IOException {
        try {
            JSONObject coordinatesObject = new JSONObject(page);
            String status = coordinatesObject.getString("status");
            if (status.equals("OVER_QUERY_LIMIT")) {
                throw new RequestLimitExceededException();
            }
            if (status.equals("ZERO_RESULTS")) {
                return null;
            }
            JSONArray resultsArray = coordinatesObject.getJSONArray("results");
            JSONObject resultObject = resultsArray.getJSONObject(0);
            JSONObject geometryObject = resultObject.getJSONObject("geometry");
            JSONObject locationObject = geometryObject.getJSONObject("location");
            return new Coordinate(locationObject.getDouble("lat"), locationObject.getDouble("lng"));
        } catch (JSONException e) {
            throw new IOException(e);
        }
    }

    private String readPage(String url) throws IOException {
        PageContent pageContent = pageReader.readPage(url);
        return pageContent.getPage();
    }

    private String getRequestUrl(String searchAddress) throws UnsupportedEncodingException {
        Map<String, String> requestParameters = new LinkedHashMap<String, String>();
        requestParameters.put("sensor", "false");
        requestParameters.put("address", searchAddress);
        return BASE_REQUEST_URL + "?" + HttpUtil.buildQueryParameters(requestParameters);
    }
}
