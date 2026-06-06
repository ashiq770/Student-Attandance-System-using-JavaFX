import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        stage.setTitle("Attendance Management System");

        HomeView home = new HomeView(stage);
        home.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}