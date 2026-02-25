import java.util.*;

public class EligibilityEngine {
    private final FakeEligibilityStore store;
    private final List<EligibilityRule> rules;
    private final Printer printer;

    public EligibilityEngine(FakeEligibilityStore store, List<EligibilityRule> rules, Printer printer) { 
        this.store = store; 
        this.rules = rules;
        this.printer = printer;
    }

    public void runAndPrint(StudentProfile s) {
        EligibilityEngineResult r = evaluate(s);
        printer.print(s, r);
        store.save(s.rollNo, r.status);
    }

    public EligibilityEngineResult evaluate(StudentProfile s) {
        List<String> reasons = new ArrayList<>();
        
        for (EligibilityRule rule: rules) {
            Optional<String> eligibile = rule.check(s);
            if(eligibile.isPresent()) reasons.add(eligibile.get());
        }

        String status = reasons.isEmpty() ? "ELIGIBLE" : "NOT_ELIGIBLE";

        return new EligibilityEngineResult(status, reasons);
    }
}
