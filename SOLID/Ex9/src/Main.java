public class Main {
    public static void main(String[] args) {
        System.out.println("=== Evaluation Pipeline ===");
        Submission sub = new Submission("23BCS1007", "public class A{}", "A.java");

        IRubric rubric = new Rubric();
        IPlagiarismChecker pc = new PlagiarismChecker();
        ICodeGrader grader = new CodeGrader();
        IReportWriter writer = new ReportWriter();
        new EvaluationPipeline(rubric, pc, grader, writer).evaluate(sub);
    }
}
