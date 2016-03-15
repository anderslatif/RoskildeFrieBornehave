import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Overview {

    public static AnchorPane getAnchorPane() {
        AnchorPane anchor = new AnchorPane();
        TableView list = new TableView(Controller.getObservableList());
        list.setEditable(true);

        GridPane grid = new GridPane();
        Label label1 = new Label("Navn: ");
        TextField textField1 = new TextField();
        grid.add(label1, 0, 0);
        grid.add(textField1, 1, 0);
        Label label2 = new Label("CPR: ");
        TextField textField2 = new TextField();
        grid.add(label2, 0, 1);
        grid.add(textField2, 1, 1);
        Label label3 = new Label("Stue: ");
        TextField textField3 = new TextField();
        grid.add(label3, 0, 2);
        grid.add(textField3, 1, 2);
        Label label4 = new Label("Forældre 1: ");
        TextField textField4 = new TextField();
        grid.add(label4, 0, 3);
        grid.add(textField4, 1, 3);
        Label label5 = new Label("Privat Tlf.: ");
        TextField textField5 = new TextField();
        grid.add(label5, 0, 4);
        grid.add(textField5, 1, 4);
        Label label6 = new Label("Arbejds Tlf.: ");
        TextField textField6 = new TextField();
        grid.add(label6, 0, 5);
        grid.add(textField6, 1, 5);
        Label label7 = new Label("Adresse: ");
        TextField textField7 = new TextField();
        grid.add(label7, 0, 6);
        grid.add(textField7, 1, 6);
        Label label8 = new Label("Forældre 2: ");
        TextField textField8 = new TextField();
        grid.add(label8, 0, 7);
        grid.add(textField8, 1, 7);
        Label label9 = new Label("Privat Tlf.: ");
        TextField textField9 = new TextField();
        grid.add(label9, 0, 8);
        grid.add(textField9, 1, 8);
        Label label10 = new Label("Arbejds Tlf.: ");
        TextField textField10 = new TextField();
        grid.add(label10, 0, 9);
        grid.add(textField10, 1, 9);
        Label label11 = new Label("Adresse: ");
        TextField textField11 = new TextField();
        grid.add(label11, 0, 10);
        grid.add(textField11, 1, 10);
        grid.setVgap(8);
        grid.setHgap(8);

        textField1.setOnKeyTyped( e -> System.out.println("enter entered"));

        //Table
        TableColumn<Child, String> nameColumn = new TableColumn<>("Navn");
        nameColumn.setMinWidth(300);
        nameColumn.setCellValueFactory(e -> e.getValue().childNameProperty());
        nameColumn.setOnEditCommit( (TableColumn.CellEditEvent<Child, String> t) -> {
            (t.getTableView().getItems().get(
                    t.getTablePosition().getRow())
            ).setChildName(t.getNewValue());
        });

        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        TableColumn<Child, String> roomColumn = new TableColumn<>("Stue");
        roomColumn.setMinWidth(300);
        roomColumn.setCellValueFactory(e -> e.getValue().roomProperty());
        roomColumn.setOnEditCommit( (TableColumn.CellEditEvent<Child, String> t) -> {
            (t.getTableView().getItems().get(
                    t.getTablePosition().getRow())
            ).setRoom(t.getNewValue());
        });
        roomColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        TableColumn<Child, String> securityNumberColumn = new TableColumn<>("CPR-nummer");
        securityNumberColumn.setMinWidth(300);
        securityNumberColumn.setCellValueFactory(e -> e.getValue().securityNumberProperty());
        securityNumberColumn.setOnEditCommit( (TableColumn.CellEditEvent<Child, String> t) -> {
            (t.getTableView().getItems().get(
                    t.getTablePosition().getRow())
            ).setSecurityNumber(t.getNewValue());
        });
        securityNumberColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        //Tilføj barnets oplysninger til vores table
        list.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if(list.getSelectionModel().getSelectedItem() != null){
                Child child = (Child) list.getSelectionModel().getSelectedItem();
                textField1.setText(child.getChildName());
                textField2.setText(child.getSecurityNumber());
                textField3.setText(child.getRoom());
                textField4.setText(child.getFirstParentName());
                textField5.setText(Integer.toString(child.getFirstParentNumber()));
                textField6.setText(Integer.toString(child.getFirstParentSecondNumber()));
                textField7.setText(child.getFirstParentAddress());
                textField8.setText(child.getSecondParentName());
                textField9.setText(Integer.toString(child.getSecondParentNumber()));
                textField10.setText(Integer.toString(child.getSecondParentSecondNumber()));
                textField11.setText(child.getSecondParentAddress());
            }
        });

        //Add fields
        TextField addName = new TextField();
        addName.setPromptText("Navn");
        addName.setMaxWidth(nameColumn.getPrefWidth());

        TextField addRoom = new TextField();
        addRoom.setMaxWidth(roomColumn.getPrefWidth());
        addRoom.setPromptText("Stue");

        TextField addSecurityNumber = new TextField();
        addSecurityNumber.setMaxWidth(securityNumberColumn.getPrefWidth());
        addSecurityNumber.setPromptText("CPR-nummer");

        list.getColumns().addAll(nameColumn, roomColumn, securityNumberColumn);

        anchor.setTopAnchor(list, 10.0);
        anchor.setLeftAnchor(list, 100.0);
        anchor.setBottomAnchor(list, 50.0);
        anchor.setRightAnchor(grid, 10.0);
        anchor.setTopAnchor(grid, 10.0);
        anchor.setLeftAnchor(grid, 1400.0);

        anchor.getChildren().addAll(list, grid);
        return anchor;
    }
}
