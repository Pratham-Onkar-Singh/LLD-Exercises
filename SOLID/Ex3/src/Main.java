
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Placement Eligibility ===");
        StudentProfile s = new StudentProfile("23BCS1001", "Ayaan", 8.10, 72, 18, LegacyFlags.NONE);
        List<EligibilityRule> rules = new ArrayList<>();
        rules.add(new DisciplinaryEligibilityRule());
        rules.add(new CGREligibilityRule(8.0));
        rules.add(new AttendanceEligibilityRule(75));
        rules.add(new CreditsEligibilityRule(20));
        EligibilityEngine engine = new EligibilityEngine(new FakeEligibilityStore(), rules);
        engine.runAndPrint(s);
    }
}
