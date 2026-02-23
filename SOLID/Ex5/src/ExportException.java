// Thrown when an exporter cannot handle the given request in its format.
// Part of the base contract so callers don't need instanceof checks.
public class ExportException extends RuntimeException {

  public ExportException(String message) {
    super(message);
  }

  public ExportException(String message, Throwable cause) {
    super(message, cause);
  }
}
