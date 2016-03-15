import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class RunClient extends Application {


    BorderPane borderPane;
    Button oversigtButton, vagtplanButton, ventelisteButton;

    public static void main(String[] args) {
        launch(args);

        Controller cont = new Controller();
        cont.getObservableList();

        Child perJ = new Child("Per Jensen");
        Child craigL = new Child("Craig Larman");
        Child davidE = new Child("David Ema");
        Child sørenT = new Child("Søren Thestrup");

        cont.children.add(perJ);
        cont.children.add(craigL);
        cont.children.add(davidE);
        cont.children.add(sørenT);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Roskilde Frie Børnehave");

        Image schedule = new Image("schedule.png");
        ImageView imageView = new ImageView();
        imageView.setFitHeight(600);
        imageView.setFitWidth(1000);
        imageView.setImage(schedule);

        TabPane tabPane = new TabPane();
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        tabPane.setSide(Side.LEFT);
        tabPane.setTabMinHeight(60);
        tabPane.setTabMinWidth(185);
        Tab tab1 = new Tab();
        tab1.setText("Oversigt");
        //tab1.setContent();
        Tab tab2 = new Tab();
        tab2.setText("Vagtplan");
        tab2.setContent(imageView);
        Tab tab3 = new Tab();
        tab3.setText("Venteliste");
        //tab3.setContent();
        tabPane.getTabs().addAll(tab1, tab2, tab3);

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
        borderPane.setLeft(tabPane);






        Scene scene = new Scene(borderPane);
        borderPane.prefHeightProperty().bind(scene.heightProperty());
        borderPane.prefWidthProperty().bind(scene.widthProperty());
        stage.setMaximized(true);
        stage.setScene(scene);
        stage.show();
    }
}
