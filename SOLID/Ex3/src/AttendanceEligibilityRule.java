
import java.util.Optional;

public class AttendanceEligibilityRule implements EligibilityRule {
  private final int minAttendance;

  public AttendanceEligibilityRule(int minAttendance) {
      this.minAttendance = minAttendance;
  }

  @Override
  public Optional<String> check(StudentProfile studentProfile) {
    return studentProfile.attendancePct < minAttendance ? Optional.of("attendance below %d".formatted(minAttendance)) : Optional.empty();
  }
}
