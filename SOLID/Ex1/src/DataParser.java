import java.util.*;

class DataParser {
  
  public Map<String, String> getParsedStudentData(String rawData) {
    Map<String, String> parsedData = new LinkedHashMap<>();
    String[] parts = rawData.split(";");
    for (String p : parts) {
        String[] t = p.split("=", 2);
        if (t.length == 2) parsedData.put(t[0].trim(), t[1].trim());
    }

    return parsedData;
  }
}