
import java.util.List;

public class InfoDisplay {
  public void displaySuccess(FakeDb db, StudentRecord studentRecord) {
    System.out.println("OK: created student " + studentRecord.id);
    System.out.println("Saved. Total students: " + db.count());
    System.out.println("CONFIRMATION:");
    System.out.println(studentRecord);
  }

  public void displayError(List<String> errors) {
    System.out.println("ERROR: cannot register");
    for (String e : errors) System.out.println("- " + e);
  }
}
