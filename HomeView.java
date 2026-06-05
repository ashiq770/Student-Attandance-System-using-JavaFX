import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HomeView {

    private Stage stage;

    public HomeView(Stage stage) {
        this.stage = stage;
    }

    public void show() {

        Label title = new Label("Attendance Management System");

        Button teacherBtn = new Button("Teacher Panel");
        Button studentBtn = new Button("Student Panel");

        teacherBtn.setPrefWidth(200);
        studentBtn.setPrefWidth(200);

        teacherBtn.setOnAction(e ->
                new TeacherView(stage).show());

        studentBtn.setOnAction(e ->
                new StudentView(stage).show());

        VBox root = new VBox(20);

        root.setAlignment(Pos.CENTER);

        root.getChildren().addAll(
                title,
                teacherBtn,
                studentBtn
        );

        Scene scene = new Scene(root, 600, 400);

        stage.setScene(scene);
        stage.show();
    }
}