
import java.util.Optional;

public class DisciplinaryEligibilityRule implements EligibilityRule {

  @Override
  public Optional<String> check(StudentProfile studentProfile) {
    return studentProfile.disciplinaryFlag != LegacyFlags.NONE ? Optional.of("disciplinary flag present") : Optional.empty();
  }
}
