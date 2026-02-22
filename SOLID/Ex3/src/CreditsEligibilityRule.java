import java.util.Optional;

public class CreditsEligibilityRule implements EligibilityRule {
  private final int minCredits;

  public CreditsEligibilityRule(int minCredits) {
    this.minCredits = minCredits;
  }

  @Override
  public Optional<String> check(StudentProfile studentProfile) {
    return studentProfile.earnedCredits < minCredits ? Optional.of("credits below %d".formatted(minCredits)) : Optional.empty();
  }
}
