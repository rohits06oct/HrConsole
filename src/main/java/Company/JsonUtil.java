package Company;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;

public class JsonUtil {
    private static ObjectMapper mapper = new ObjectMapper();
    private static JSONObject employeeObject = new JSONObject();
    private static JSONArray jsonArray;

    /**
     * Get the old json values from the file
     * put it into new employee object with old objects
     * print the new added employee object in pretty format
     * save it to my json file
     */
    public static void writeJson_Values(String filePath, Employee emp) throws IOException {
        try {
            jsonArray = readJson_Values(filePath);

        } catch (ParseException p) {
        }
        if (jsonArray == null) {
            JSONArray newJsonArray = new JSONArray();
            newJsonArray.add(emp);
            employeeObject.put("Employee", newJsonArray);
           String jsonStrEmp = mapper.writeValueAsString(emp);
            System.out.println("jsonStrEmp"+ jsonStrEmp);

            mapper.writeValue(new File(filePath), employeeObject);
            System.out.println("You add an employee successfully");
        } else {
            jsonArray.add(emp);
            employeeObject.put("Employee", jsonArray);
            mapper.writeValue(new File(filePath), employeeObject);
            System.out.println("You add an employee successfully");
        }
    }

    /**
     * jsonParse is connect with my file and get the object
     * object is assign to the employeeDetails and return it
     */
    public static JSONArray readJson_Values(String filePath) throws IOException, ParseException {
        Object obj = new JSONParser().parse(new FileReader(filePath));
        employeeObject = (JSONObject) obj;
        jsonArray = (JSONArray) employeeObject.get("Employee");
        return jsonArray;
    }
}


//        ObjectMapper objectMapper = new ObjectMapper();
//        File file = new File(filePath);
//        JsonResponse jsonResponse = objectMapper.readValue(file, JsonResponse.class);
//        System.out.println(jsonResponse.Employee.get(0).getFirstName());