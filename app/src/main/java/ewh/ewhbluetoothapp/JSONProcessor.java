package ewh.ewhbluetoothapp;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * The purpose of this class is to contain the methods necessary for doing backend tasks, such
 * as processing the JSON file into representable data.
 *
 * Created by sonia on 2/9/16.
 */
public class JSONProcessor {

    final String TEMPERATURE = "temperature";
    final String PH = "pH";
    final String TURBIDITY = "turbidity";
    final String USAGE = "usage";
    final String CONDUCTIVITY = "conductivity";

    JSONObject currentJSON;

    //Todo: should probably figure out how to parse JSON files within this class
    public JSONProcessor(String JSONFile) throws ParseException {

        JSONParser parser = new JSONParser();
        currentJSON = (JSONObject) ((JSONArray) parser.parse(JSONFile)).get(0);
    }

    public int getMetric(String metricName) {
        switch (metricName) {
            case TEMPERATURE:
                return Integer.parseInt(Long.toString((Long) currentJSON.get(TEMPERATURE)));
            case PH:
                return Integer.parseInt(Long.toString((Long) currentJSON.get(PH)));
            case TURBIDITY:
                return Integer.parseInt(Long.toString((Long) currentJSON.get(TURBIDITY)));
            case USAGE:
                return Integer.parseInt(Long.toString((Long) currentJSON.get(USAGE)));
            case CONDUCTIVITY:
                return Integer.parseInt(Long.toString((Long) currentJSON.get(CONDUCTIVITY)));
            default:
                return 0;
        }
    }
}
