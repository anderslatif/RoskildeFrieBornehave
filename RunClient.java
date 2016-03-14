import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class RunClient extends Application {

    Scene scene;
    BorderPane borderPane;
    Button oversigtButton, vagtplanButton, ventelisteButton;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Roskilde Frie Børnehave");

        HBox top = new HBox();
        Label header = new Label("Roskilde Frie Børnehave");
        header.setFont(new Font("Cambria", 36));
        header.setTextFill(Color.WHITE);
        top.getChildren().add(header);
        top.setStyle("-fx-background-color: #3c8823");
        top.setPadding(new Insets(20, 0, 0, 20));
        top.setMinHeight(85);
        top.setMinWidth(1000);

        VBox left = new VBox(8);
        oversigtButton = new Button("Oversigt");
        oversigtButton.setMinWidth(100);
        vagtplanButton = new Button("Vagtplan");
        vagtplanButton.setMinWidth(100);
        ventelisteButton = new Button("Venteliste");
        ventelisteButton.setMinWidth(100);
        left.getChildren().addAll(oversigtButton, vagtplanButton, ventelisteButton);
        left.setPadding(new Insets(20, 0, 0, 20));
        left.setMinHeight(600);
        left.setMinWidth(125);

        borderPane = new BorderPane();
        borderPane.setTop(top);
        borderPane.setLeft(left);

        scene = new Scene(borderPane);

        stage.setScene(scene);
        stage.show();
    }
}
