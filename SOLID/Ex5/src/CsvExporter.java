import java.nio.charset.StandardCharsets;

public class CsvExporter extends Exporter {

    @Override
    protected ExportResult doExport(ExportRequest req) {
        String title = req.title == null ? "" : req.title;
        String body  = req.body  == null ? "" : req.body;
        String csv = "title,body\n" + csvField(title) + "," + csvField(body) + "\n";
        return new ExportResult("text/csv", csv.getBytes(StandardCharsets.UTF_8));
    }

    // RFC 4180: wrap field in quotes if it contains comma, quote, or newline.
    // Escapes internal quotes by doubling them — lossless, no data corruption.
    private static String csvField(String value) {
        if (value.indexOf(',') < 0 && value.indexOf('"') < 0
                && value.indexOf('\n') < 0 && value.indexOf('\r') < 0) {
            return value;
        }
        return '"' + value.replace("\"", "\"\"") + '"';
    }
}
