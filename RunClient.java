import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Side;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.effect.InnerShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
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
        tab1.setContent(View.getAnchorPane(false));
        Tab tab2 = new Tab();
        tab2.setText("Vagtplan");
        AgendaSample agenda = new AgendaSample();
        tab2.setContent(agenda.getPanel(stage));
        Tab tab3 = new Tab();
        tab3.setText("Venteliste");
        tab3.setContent(View.getAnchorPane(true));
        tabPane.getTabs().addAll(tab1, tab2, tab3);

        HBox top = new HBox();
        Label header = new Label("Roskilde Frie Børnehave");
        header.setFont(new Font("Cambria", 42));
        header.setPadding(new Insets(20, 0, 0, 66));
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

        FadeTransition fadeTransition = new FadeTransition(Duration.millis(4000), imageView);
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0.3);
        fadeTransition.setCycleCount(Timeline.INDEFINITE);
        fadeTransition.setAutoReverse(true);
        fadeTransition.play();

        top.getChildren().addAll(imageView, header);

        borderPane = new BorderPane();
        borderPane.setTop(top);
        borderPane.setLeft(tabPane);


        Scene scene = new Scene(borderPane);
        imageView.setOnMouseEntered( e -> scene.setCursor(Cursor.HAND));
        imageView.setOnMouseExited( e -> scene.setCursor(Cursor.DEFAULT));

        borderPane.prefHeightProperty().bind(scene.heightProperty());
        borderPane.prefWidthProperty().bind(scene.widthProperty());
        stage.setMaximized(true);
        stage.getIcons().add(new Image("file:src/Logo.png"));
        stage.setScene(scene);
        stage.show();
    }

    public void getDancingBaby(){

        Stage stage = new Stage();

        VBox vBox = new VBox();
        vBox.setStyle("-fx-background-color: rgba(0, 0, 0, 0.1); -fx-background-radius: 10;");

        InnerShadow innerShadow = new InnerShadow();
        innerShadow.setOffsetX(4.0f);
        innerShadow.setOffsetY(4.0f);

        Text textLabel = new Text();
        textLabel.setEffect(innerShadow);
        textLabel.setX(10.0f);
        textLabel.setY(50.0f);
        textLabel.setCache(true);
        textLabel.setText("Congratulations! \nNow click on me.");
        textLabel.setFill(Color.SILVER);
        textLabel.setFont(Font.font(null, FontWeight.BOLD, 30));

        Image image = new Image("dancingbaby.gif");
        ImageView imageView = new ImageView(image);
        vBox.getChildren().addAll(textLabel, imageView);

        Scene scene = new Scene(vBox, image.getWidth()+20, 2*image.getHeight(), Color.TRANSPARENT);

        imageView.setOnMouseClicked( e -> stage.close());
        imageView.setOnMouseEntered( e -> {
            imageView.setEffect(new Reflection());
            scene.setCursor(Cursor.HAND);
        });
        imageView.setOnMouseExited( e -> {
            imageView.setEffect(null);
            scene.setCursor(Cursor.DEFAULT);
        });

        stage.setTitle("You won!");
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.getIcons().add(image);
        stage.show();
    }

}
