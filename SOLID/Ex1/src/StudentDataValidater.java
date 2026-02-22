import java.util.*;

public class StudentDataValidater {

  public List<String> validate(Map<String, String> studentData) {
    // Extracting data:
    String name = studentData.getOrDefault("name", "");
    String email = studentData.getOrDefault("email", "");
    String phone = studentData.getOrDefault("phone", "");
    String program = studentData.getOrDefault("program", "");

    // Validating gotten data:
    List<String> errors = new ArrayList<>();
    if (name.trim().isEmpty()) errors.add("name is required");
    if (email.trim().isEmpty() || !email.contains("@")) errors.add("email is invalid");
    if (phone.trim().isEmpty() || !phone.chars().allMatch(Character::isDigit)) errors.add("phone is invalid");
    if (!(program.equals("CSE") || program.equals("AI") || program.equals("SWE"))) errors.add("program is invalid");

    return errors;
  } 
}