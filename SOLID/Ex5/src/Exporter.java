// Base contract:
// - req must be non-null
// - null title/body fields are treated as empty strings
// - never returns null
// - may throw ExportException for format-specific failures
public abstract class Exporter {

    // Enforces non-null req centrally so subclasses don't have to repeat it.
    public final ExportResult export(ExportRequest req) {
        if (req == null) {
            throw new IllegalArgumentException("ExportRequest must not be null");
        }
        return doExport(req);
    }

    // Subclasses implement this, req is guaranteed non-null.
    protected abstract ExportResult doExport(ExportRequest req);
}
