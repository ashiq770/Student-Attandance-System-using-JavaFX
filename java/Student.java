public class Student {

    private String id;
    private String name;
    private int attendance;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        this.attendance = 0;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAttendance() {
        return attendance;
    }

    public void markAttendance() {
        attendance++;
    }
}