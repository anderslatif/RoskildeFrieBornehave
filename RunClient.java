import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class RunClient extends Application {


    BorderPane borderPane;

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Roskilde Frie Børnehave");


        TabPane tabPane = new TabPane();
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        tabPane.setSide(Side.LEFT);
        tabPane.setTabMinHeight(60);
        tabPane.setTabMinWidth(185);
        Tab tab1 = new Tab();
        tab1.setText("Oversigt");
        tab1.setContent(Overview.getAnchorPane(false));
        Tab tab2 = new Tab();
        tab2.setText("Vagtplan");
        AgendaSample agenda = new AgendaSample();
        tab2.setContent(agenda.getPanel(stage));
        Tab tab3 = new Tab();
        tab3.setText("Venteliste");
        tab3.setContent(Overview.getAnchorPane(true));
        tabPane.getTabs().addAll(tab1, tab2, tab3);

        HBox top = new HBox();
        Label header = new Label("Roskilde Frie Børnehave");
        header.setFont(new Font("Cambria", 42));
        header.setPadding(new Insets(20, 0, 0, 40));
        header.setTextFill(Color.WHITE);
        top.setStyle("-fx-background-color: #3c8823");
        top.setPadding(new Insets(10, 0, 0, 20));
        top.setMinHeight(100);
        top.setMinWidth(1000);

        Image logo = new Image("Logo.png");
        ImageView imageView = new ImageView();
        imageView.setFitHeight(80);
        imageView.setFitWidth(80);
        imageView.setImage(logo);

        imageView.setOnMouseClicked( e -> getDancingBaby());

        FadeTransition ft = new FadeTransition(Duration.millis(4000), imageView);
        ft.setFromValue(1.0);
        ft.setToValue(0.1);
        ft.setCycleCount(Timeline.INDEFINITE);
        ft.setAutoReverse(true);
        ft.play();

        top.getChildren().addAll(imageView, header);

        borderPane = new BorderPane();
        borderPane.setTop(top);
        borderPane.setLeft(tabPane);
        //borderPane.setCenter(Overview.getAnchorPane());

        Scene scene = new Scene(borderPane);
        borderPane.prefHeightProperty().bind(scene.heightProperty());
        borderPane.prefWidthProperty().bind(scene.widthProperty());
        stage.setMaximized(true);
        stage.getIcons().add(new Image("file:src/Logo.png"));
        stage.setScene(scene);
        stage.show();
    }

    public void getDancingBaby(){

        Stage stage = new Stage();

        StackPane root = new StackPane();
        root.setStyle("-fx-background-color: rgba(0, 0, 0, 0.1); -fx-background-radius: 10;");

        Image image = new Image("dancingbaby.gif");
        ImageView imageView = new ImageView(image);
        root.getChildren().add(imageView);

        imageView.setOnMouseClicked( e -> stage.close());
        imageView.setOnMouseEntered( e -> imageView.setEffect(new Reflection()));
        imageView.setOnMouseExited( e -> imageView.setEffect(null));

        Scene scene = new Scene(root, image.getWidth(), 2*image.getHeight(), Color.TRANSPARENT);
        stage.setTitle("Experimenting");
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
    }

}
