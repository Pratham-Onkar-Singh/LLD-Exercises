
import java.util.List;

public interface StudentStore {
  public void save(StudentRecord studentRecord);
  public int count();
  public List<StudentRecord> all();
}
