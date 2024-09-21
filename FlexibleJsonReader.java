package utility;
import org.json.JSONArray;
import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.nio.charset.StandardCharsets;

public class FlexibleJsonReader {

    // Method to read the entire JSON array and return a list of maps
    public static List<Map<String, String>> getAllData(String filePath) throws Exception {
        // Read the JSON file using a relative file path
        String content = new String(Files.readAllBytes(Paths.get(filePath)), StandardCharsets.UTF_8);
        JSONArray jsonArray = new JSONArray(content);

        // Create a list to store all the JSON objects as maps
        List<Map<String, String>> dataList = new ArrayList<>();

        // Iterate through the JSON array and convert each object into a map
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            Map<String, String> data = new HashMap<>();

            // Add key-value pairs to the map
            for (String key : jsonObject.keySet()) {
                data.put(key, jsonObject.getString(key));
            }
            dataList.add(data);  // Add each map to the list
        }

        return dataList;
    }
}