import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AttendanceStore {

    private static ObservableList<Student> students =
            FXCollections.observableArrayList();

    static {
        students.add(new Student("S001", "Ashiq"));
        students.add(new Student("S002", "Sajuti"));
        students.add(new Student("S003", "Rakib"));
    }

    public static ObservableList<Student> getStudents() {
        return students;
    }

    public static void addStudent(String id, String name) {
        students.add(new Student(id, name));
    }

    public static Student findStudent(String id) {

        for(Student s : students) {
            if(s.getId().equalsIgnoreCase(id)) {
                return s;
            }
        }

        return null;
    }
}