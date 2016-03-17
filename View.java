import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Callback;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class View {


    static ObservableList<Child> observableList = Controller.getObservableList();
    static ObservableList<Child> enrolledChildren;
    static ObservableList<Child> waitingListChildren;

    public static AnchorPane getAnchorPane(boolean isOnTheWaitingList) {
        AnchorPane anchor = new AnchorPane();
        TableView tableView = new TableView();

        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);



        if(isOnTheWaitingList){
            tableView.setItems(checkIfWaitingListChildOrNot());
        } else {
            tableView.setItems(checkIfChildIsEnrolled());
        }

        tableView.setEditable(true);

        GridPane grid = new GridPane();
        Label label1 = new Label("Navn: ");
        TextField textField1 = new TextField();
        grid.add(label1, 0, 0);
        grid.add(textField1, 1, 0);
        Label label2 = new Label("Stue: ");
        grid.add(label2, 0, 1);
        Label label3 = new Label("CPR: ");
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

        ComboBox roomComboBox = new ComboBox();
        roomComboBox.setStyle("-fx-background-color: white;");
        roomComboBox.getItems().addAll(
                "Løvestuen",
                "Tigerstuen",
                "Bjørnestuen"
        );
        roomComboBox.setMaxWidth(Double.MAX_VALUE);
        grid.add(roomComboBox, 1, 1);
        roomComboBox.setOnAction( e -> {
            Child child = (Child) tableView.getSelectionModel().getSelectedItem();
            child.setRoom(roomComboBox.getValue().toString());
        });


        Button deleteChild = new Button("Fjern");
        deleteChild.setTooltip(new Tooltip("Fjerner barnet fra listen"));
        grid.add(deleteChild, 0, 14);

        deleteChild.setOnAction( e -> {
            Child child = (Child) tableView.getSelectionModel().getSelectedItem();
                for(Child chi : observableList){
                    if(chi == child) {
                        enrolledChildren.remove(chi);
                        waitingListChildren.remove(chi);
                    }
                }
            for(Child chi : waitingListChildren){
                if(chi == child){
                    waitingListChildren.remove(chi);
                }
            }
            for(Child chi : enrolledChildren){
                if(chi == child){
                    enrolledChildren.remove(chi);
                }
            }
        });


        if(isOnTheWaitingList) {
            Button clearButton = new Button("Clear");
            clearButton.setTooltip(new Tooltip("Rydder alle ovenstående felter, \n nu er du klar til at indtaste et nyt barn til ventelisten"));
            grid.add(clearButton, 0, 12);
            clearButton.setOnAction(e -> {
                tableView.getSelectionModel().select(null);
                textField1.clear();
                textField3.clear();
                textField4.clear();
                textField5.clear();
                textField6.clear();
                textField7.clear();
                textField8.clear();
                textField9.clear();
                textField10.clear();
                textField11.clear();


            });


            Button newChildButton = new Button("Tilføj barn til ventelisten");
            newChildButton.setTooltip(new Tooltip("Husk at trykke clear før du udfylder"));
            newChildButton.setMaxWidth(Double.MAX_VALUE);
            grid.add(newChildButton, 1, 12);
            newChildButton.setOnAction(e -> {
                try {
                    Child child = new Child(textField1.getText(), "Venteliste", textField3.getText(), textField4.getText(),
                            Integer.parseInt(textField5.getText()), Integer.parseInt(textField6.getText()), textField7.getText(),
                            textField8.getText(), Integer.parseInt(textField9.getText()),
                            Integer.parseInt(textField10.getText()), textField11.getText());
                        waitingListChildren.add(child);
                } catch (Exception err) {
                    Label label = new Label("Har du indtastet alt\n, og er det korrekt?");
                    FadeTransition fadeTransition = new FadeTransition(Duration.millis(8000), label);
                    fadeTransition.setFromValue(1.0);
                    fadeTransition.setToValue(0.0);
                    fadeTransition.play();
                    grid.add(label, 1, 16);
                }
            });


            Button enrollChild = new Button("Placér i en stue");
            enrollChild.setMaxWidth(Double.MAX_VALUE);
            grid.add(enrollChild, 1, 14);
            enrollChild.setOnAction(e -> {
                Child child = (Child) tableView.getSelectionModel().getSelectedItem();
                child.setRoom(roomComboBox.getValue().toString());
                if(!(child.getRoom().equalsIgnoreCase("venteliste"))) {
                    waitingListChildren.remove(child);
                    enrolledChildren.add(child);
                    textField1.clear();
                    textField3.clear();
                    textField4.clear();
                    textField5.clear();
                    textField6.clear();
                    textField7.clear();
                    textField8.clear();
                    textField9.clear();
                    textField10.clear();
                    textField11.clear();
                    Label label = new Label("Barnet er placeret \n vælg Oversigt fanen");
                    FadeTransition fadeTransition = new FadeTransition(Duration.millis(8000), label);
                    fadeTransition.setFromValue(1.0);
                    fadeTransition.setToValue(0.0);
                    fadeTransition.play();
                    grid.add(label, 1, 16);
                } else {
                    Label label = new Label("Vælg en stue til barnet \ni den næst-øverste\nkategori: stue");
                    FadeTransition fadeTransition = new FadeTransition(Duration.millis(8000), label);
                    fadeTransition.setFromValue(1.0);
                    fadeTransition.setToValue(0.0);
                    fadeTransition.play();
                    grid.add(label, 1, 16);

                    Label warningLabel = new Label("Stue");
                    warningLabel.setTextFill(Color.RED);
                    FadeTransition fadeTransition2 = new FadeTransition(Duration.millis(8000), warningLabel);
                    fadeTransition2.setFromValue(1.0);
                    fadeTransition2.setToValue(0.0);
                    grid.add(warningLabel, 0, 1);
                    fadeTransition2.play();

                }
            });

/*            TableColumn<Child, String> numberColumn = new TableColumn<>("#");
            numberColumn.setMinWidth(30);
            numberColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Child, String>, ObservableValue<String>>() {
                @Override public ObservableValue<String> call(TableColumn.CellDataFeatures<Child, String> p) {
                    return new ReadOnlyObjectWrapper(tableView.getItems().indexOf(p.getValue()) + "");
                }
            });
            numberColumn.setSortable(false);
            tableView.getColumns().add(numberColumn);*/


        }

        textField1.setOnKeyTyped( e -> {
            for(Child chi: observableList){
                Child child = (Child) tableView.getSelectionModel().getSelectedItem();
                if(chi == child){
                    chi.setChildName(textField1.getText());
                }
            }
        });


        textField3.setOnKeyTyped( e -> {
            for(Child chi: observableList){
                Child child = (Child) tableView.getSelectionModel().getSelectedItem();
                if(chi == child){
                    chi.setSecurityNumber(textField3.getText());
                }
            }
        });

        textField4.setOnKeyTyped( e -> {
            for(Child chi: observableList){
                Child child = (Child) tableView.getSelectionModel().getSelectedItem();
                if(chi == child){
                    chi.setFirstParentName(textField4.getText());
                }
            }
        });

        textField5.setOnKeyTyped( e -> {
            for(Child chi: observableList){
                Child child = (Child) tableView.getSelectionModel().getSelectedItem();
                if(chi == child){
                    chi.setFirstParentNumber(Integer.parseInt(textField5.getText()));
                }
            }
        });

        textField6.setOnKeyTyped( e -> {
            for(Child chi: observableList){
                Child child = (Child) tableView.getSelectionModel().getSelectedItem();
                if(chi == child){
                    chi.setFirstParentSecondNumber(Integer.parseInt(textField6.getText()));
                }
            }
        });

        textField7.setOnKeyTyped( e -> {
            for(Child chi: observableList){
                Child child = (Child) tableView.getSelectionModel().getSelectedItem();
                if(chi == child){
                    chi.setFirstParentAddress(textField7.getText());
                }
            }
        });

        textField8.setOnKeyTyped( e -> {
            for(Child chi: observableList){
                Child child = (Child) tableView.getSelectionModel().getSelectedItem();
                if(chi == child){
                    chi.setSecondParentName(textField8.getText());
                }
            }
        });

        textField9.setOnKeyTyped( e -> {
            for(Child chi: observableList){
                Child child = (Child) tableView.getSelectionModel().getSelectedItem();
                if(chi == child){
                    chi.setSecondParentNumber(Integer.parseInt(textField9.getText()));
                }
            }
        });

        textField10.setOnKeyTyped( e -> {
            for(Child chi: observableList){
                Child child = (Child) tableView.getSelectionModel().getSelectedItem();
                if(chi == child){
                    chi.setSecondParentSecondNumber(Integer.parseInt(textField10.getText()));
                }
            }
        });

        textField11.setOnKeyTyped( e -> {
            for(Child chi: observableList){
                Child child = (Child) tableView.getSelectionModel().getSelectedItem();
                if(chi == child){
                    chi.setSecondParentAddress(textField11.getText());
                }
            }
        });



        //Table
        TableColumn<Child, String> nameColumn = new TableColumn<>("Navn");
        nameColumn.setMinWidth(300);
        nameColumn.setCellValueFactory(e -> e.getValue().childNameProperty());
        nameColumn.setOnEditCommit( (TableColumn.CellEditEvent<Child, String> t) -> {
            (t.getTableView().getItems().get(
                    t.getTablePosition().getRow())
            ).setChildName(t.getNewValue());
            Child child = (Child) tableView.getSelectionModel().getSelectedItem();
            textField1.setText(child.getChildName());
        });

        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        TableColumn<Child, String> roomColumn = new TableColumn<>("Stue");
        if(isOnTheWaitingList){roomColumn.setText("Tilstand");}
        roomColumn.setMinWidth(300);
        roomColumn.setCellValueFactory(e -> e.getValue().roomProperty());


        TableColumn<Child, String> securityNumberColumn = new TableColumn<>("CPR-nummer");
        securityNumberColumn.setMinWidth(300);
        securityNumberColumn.setCellValueFactory(e -> e.getValue().securityNumberProperty());
        securityNumberColumn.setOnEditCommit( (TableColumn.CellEditEvent<Child, String> t) -> {
            (t.getTableView().getItems().get(
                    t.getTablePosition().getRow())
            ).setSecurityNumber(t.getNewValue());
            Child child = (Child) tableView.getSelectionModel().getSelectedItem();
            textField1.setText(child.getSecurityNumber());
        });
        securityNumberColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        //Tilføj barnets oplysninger til vores table
        tableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if(tableView.getSelectionModel().getSelectedItem() != null){
                Child child = (Child) tableView.getSelectionModel().getSelectedItem();
                textField1.setText(child.getChildName());
                roomComboBox.setValue(child.getRoom());
                textField3.setText(child.getSecurityNumber());
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

        tableView.getColumns().addAll(nameColumn, roomColumn, securityNumberColumn);

        anchor.setTopAnchor(tableView, 10.0);
        anchor.setLeftAnchor(tableView, 100.0);
        anchor.setBottomAnchor(tableView, 50.0);
        anchor.setRightAnchor(grid, 10.0);
        anchor.setTopAnchor(grid, 10.0);
        anchor.setLeftAnchor(grid, 1050.0);

        anchor.getChildren().addAll(tableView, grid);
        return anchor;
    }


    public static ObservableList<Child> checkIfWaitingListChildOrNot(){
        List<Child> waitingChild = new ArrayList<>();
        waitingListChildren = FXCollections.observableList(waitingChild);
        for(Child chi: observableList){
            if(chi.getRoom().equalsIgnoreCase("venteliste")){
                waitingListChildren.add(chi);
            }
        }
        return waitingListChildren;
    }


    public static ObservableList<Child> checkIfChildIsEnrolled(){
        List<Child> waitingChild = new ArrayList<>();
        enrolledChildren = FXCollections.observableList(waitingChild);
        for(Child chi: observableList){
            if(!(chi.getRoom().equalsIgnoreCase("venteliste"))){
                enrolledChildren.add(chi);
            }
        }
        return enrolledChildren;
    }



}
