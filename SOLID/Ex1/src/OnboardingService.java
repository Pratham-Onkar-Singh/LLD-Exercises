import java.util.*;

public class OnboardingService {
    private final StudentStore store;
    private final DataParser dataParser;
    private final StudentDataValidater studentDataValidater;
    private final InfoDisplay infoDisplay;

    public OnboardingService(StudentStore store) {
        this.store = store; 
        this.dataParser = new DataParser();
        this.studentDataValidater = new StudentDataValidater();
        this.infoDisplay = new InfoDisplay();
    }

    // Intentionally violates SRP: parses + validates + creates ID + saves + prints.
    public void registerFromRawInput(String raw) {
        System.out.println("INPUT: " + raw);

        // Parsing of data (BEFORE):
        // Map<String,String> kv = new LinkedHashMap<>();
        // String[] parts = raw.split(";");
        // for (String p : parts) {
        //     String[] t = p.split("=", 2);
        //     if (t.length == 2) kv.put(t[0].trim(), t[1].trim());
        // }
        // AFTER IMPLEMENTING SRP:
        Map<String, String> studentData = this.dataParser.getParsedStudentData(raw);


        // Extracting all the fields from the raw string and
        //  validation inline, printing inline (BEFORE):
        // String name = kv.getOrDefault("name", "");
        // String email = kv.getOrDefault("email", "");
        // String phone = kv.getOrDefault("phone", "");
        // String program = kv.getOrDefault("program", "");

        // List<String> errors = new ArrayList<>();
        // if (name.trim().isEmpty()) errors.add("name is required");
        // if (email.trim().isEmpty() || !email.contains("@")) errors.add("email is invalid");
        // if (phone.trim().isEmpty() || !phone.chars().allMatch(Character::isDigit)) errors.add("phone is invalid");
        // if (!(program.equals("CSE") || program.equals("AI") || program.equals("SWE"))) errors.add("program is invalid");
        List<String> errors = studentDataValidater.validate(studentData);

        // Error handling
        if (!errors.isEmpty()) {
            infoDisplay.displayError(errors);
            return;
        }

        // Genrating Student Id and student record
        String id = IdUtil.nextStudentId(store.count());
        StudentRecord studentRecord = new StudentRecord(id, studentData.get("name"), studentData.get("email"), studentData.get("phone"), studentData.get("program"));

        // Saving to FakeDB
        store.save(studentRecord);

        // Printing information
        infoDisplay.displaySuccess(studentRecord, store.count());
    }
}
