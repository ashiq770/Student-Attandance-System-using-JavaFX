import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TeacherView {

    private Stage stage;

    public TeacherView(Stage stage) {
        this.stage = stage;
    }

    public void show() {

        Label title = new Label("Teacher Dashboard");

        TableView<Student> table = new TableView<>();

        TableColumn<Student, String> idCol =
                new TableColumn<>("ID");

        idCol.setCellValueFactory(
                new PropertyValueFactory<>("id"));

        TableColumn<Student, String> nameCol =
                new TableColumn<>("Name");

        nameCol.setCellValueFactory(
                new PropertyValueFactory<>("name"));

        TableColumn<Student, Integer> attendanceCol =
                new TableColumn<>("Attendance");

        attendanceCol.setCellValueFactory(
                new PropertyValueFactory<>("attendance"));

        table.getColumns().addAll(
                idCol,
                nameCol,
                attendanceCol
        );

        table.setItems(
                FXCollections.observableArrayList(
                        AttendanceStore.getStudents()
                )
        );

        TextField idField = new TextField();
        idField.setPromptText("Student ID");

        TextField nameField = new TextField();
        nameField.setPromptText("Student Name");

        Button addBtn = new Button("Add Student");

        addBtn.setOnAction(e -> {

            String id = idField.getText().trim();
            String name = nameField.getText().trim();

            if(!id.isEmpty() && !name.isEmpty()) {

                AttendanceStore.addStudent(id, name);

                table.setItems(
                        FXCollections.observableArrayList(
                                AttendanceStore.getStudents()
                        )
                );

                table.refresh();

                idField.clear();
                nameField.clear();
            }
        });

        Button homeBtn = new Button("Back Home");

        homeBtn.setOnAction(e ->
                new HomeView(stage).show());

        VBox root = new VBox(10);

        root.setPadding(new Insets(20));

        root.getChildren().addAll(
                title,
                table,
                idField,
                nameField,
                addBtn,
                homeBtn
        );

        Scene scene = new Scene(root, 700, 500);

        stage.setScene(scene);
        stage.show();
    }
}