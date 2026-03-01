public class EvaluationPipeline {
    private final IRubric rubric;
    private final IPlagiarismChecker pc;
    private final ICodeGrader grader;
    private final IReportWriter writer;

    public EvaluationPipeline(IRubric rubric, IPlagiarismChecker pc, ICodeGrader grader, IReportWriter writer) {
        this.rubric = rubric;
        this.grader = grader;
        this.pc = pc;
        this.writer = writer;
    }

    public void evaluate(Submission sub) {
        int plag = pc.check(sub);
        System.out.println("PlagiarismScore=" + plag);

        int code = grader.grade(sub, rubric);
        System.out.println("CodeScore=" + code);

        String reportName = writer.write(sub, plag, code);
        System.out.println("Report written: " + reportName);

        int total = plag + code;
        String result = (total >= 90) ? "PASS" : "FAIL";
        System.out.println("FINAL: " + result + " (total=" + total + ")");
    }
}
