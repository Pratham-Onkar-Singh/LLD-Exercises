import java.nio.charset.StandardCharsets;

public class PdfExporter extends Exporter {

    private static final int MAX_BODY_CHARS = 20;

    @Override
    protected ExportResult doExport(ExportRequest req) {
        String body = req.body == null ? "" : req.body;
        // Throws ExportException (part of base contract) — no LSP violation.
        if (body.length() > MAX_BODY_CHARS) {
            throw new ExportException("PDF cannot handle content > 20 chars");
        }
        String fakePdf = "PDF(" + req.title + "):" + body;
        return new ExportResult("application/pdf", fakePdf.getBytes(StandardCharsets.UTF_8));
    }
}
