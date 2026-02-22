
import java.util.Optional;

public class CGREligibilityRule implements EligibilityRule {
  private final double minCGR;

  public CGREligibilityRule(double minCGR) {
      this.minCGR = minCGR;
  }

  @Override
  public Optional<String> check(StudentProfile studentProfile) {
    return studentProfile.cgr < minCGR ? Optional.of("CGR below %.2f".formatted(minCGR)) : Optional.empty();
  }
}
