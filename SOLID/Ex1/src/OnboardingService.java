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

    public void registerFromRawInput(String raw) {
        System.out.println("INPUT: " + raw);

        // Parsing raw student data
        Map<String, String> studentData = this.dataParser.getParsedStudentData(raw);

        // Validating studentData
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
