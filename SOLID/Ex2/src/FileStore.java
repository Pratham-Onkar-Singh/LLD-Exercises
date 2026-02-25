import java.util.*;

public class FileStore implements InvoiceStore {
    // key = invoice Id and Value = invoice
    private final Map<String, String> files = new HashMap<>();

    @Override
    public void save(String invId, String content) { files.put(invId, content); }
    @Override
    public int countLines(String invId) {
        String c = files.getOrDefault(invId, "");
        if (c.isEmpty()) return 0;
        return c.split("\n").length;
    }
}
