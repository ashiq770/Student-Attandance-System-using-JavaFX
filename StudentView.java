import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StudentView {

    private Stage stage;

    public StudentView(Stage stage) {
        this.stage = stage;
    }

    public void show() {

        Label title = new Label("Student Attendance");

        TextField idField = new TextField();
        idField.setPromptText("Enter Student ID");

        Label resultLabel = new Label();

        Button submitBtn =
                new Button("Submit Attendance");

        submitBtn.setOnAction(e -> {

            String id =
                    idField.getText().trim();

            Student student =
                    AttendanceStore.findStudent(id);

            if(student != null) {

                student.markAttendance();

                resultLabel.setText(
                        "Attendance Submitted Successfully!"
                );

            } else {

                resultLabel.setText(
                        "Student Not Found!"
                );
            }
        });

        Button homeBtn =
                new Button("Back Home");

        homeBtn.setOnAction(e ->
                new HomeView(stage).show());

        VBox root = new VBox(15);

        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);

        root.getChildren().addAll(
                title,
                idField,
                submitBtn,
                resultLabel,
                homeBtn
        );

        Scene scene =
                new Scene(root, 500, 400);

        stage.setScene(scene);
        stage.show();
    }
}