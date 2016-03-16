import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
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
import javafx.util.Callback;

import java.util.ArrayList;
import java.util.List;

public class Overview {


    static ObservableList<Child> observableList = Controller.getObservableList();
    static ObservableList<Child> enrolledChildren;
    static ObservableList<Child> waitingListChildren;

    public static AnchorPane getAnchorPane(boolean isOnTheWaitingList) {
        AnchorPane anchor = new AnchorPane();
        TableView list = new TableView();


        if(isOnTheWaitingList){
            list.setItems(checkIfWaitingListChildOrNot());
        } else {
            list.setItems(checkIfChildIsEnrolled());
        }

        list.setEditable(true);

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
        roomComboBox.getItems().addAll(
                "Løvestuen",
                "Tigerstuen",
                "Bjørnestuen"
        );
        roomComboBox.setMaxWidth(Double.MAX_VALUE);
        grid.add(roomComboBox, 1, 1);
        roomComboBox.setOnAction( e -> {
            Child child = (Child) list.getSelectionModel().getSelectedItem();
            child.setRoom(roomComboBox.getValue().toString());
        });


        Button deleteChild = new Button("Fjern");
        deleteChild.setTooltip(new Tooltip("Fjerner barnet fra listen"));
        grid.add(deleteChild, 0, 14);

        deleteChild.setOnAction( e -> {
            Child child = (Child) list.getSelectionModel().getSelectedItem();
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
        });


        if(isOnTheWaitingList) {
            Button clearButton = new Button("Clear");
            clearButton.setTooltip(new Tooltip("Rydder alle ovenstående felter, \n nu er du klar til at indtaste et nyt barn til ventelisten"));
            grid.add(clearButton, 0, 12);
            clearButton.setOnAction(e -> {
                list.getSelectionModel().select(null);
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
            newChildButton.setMaxWidth(Double.MAX_VALUE);
            grid.add(newChildButton, 1, 12);
            newChildButton.setOnAction(e -> {
                try {
                    Child child = new Child(textField1.getText(), "Venteliste", textField3.getText(), textField4.getText(),
                            Integer.parseInt(textField5.getText()), Integer.parseInt(textField6.getText()), textField7.getText(),
                            textField8.getText(), Integer.parseInt(textField9.getText()), Integer.parseInt(textField10.getText()), textField11.getText());
                    waitingListChildren.add(child);
                } catch (Exception err) {
                    System.out.println(err + " We really should check if the user has input int values in a better way.");
                }
            });


            Button enrollChild = new Button("Placér i en stue");
            enrollChild.setMaxWidth(Double.MAX_VALUE);
            grid.add(enrollChild, 1, 14);
            enrollChild.setOnAction(e -> {
                Child child = (Child) list.getSelectionModel().getSelectedItem();
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
                }
            });

/*            TableColumn<Child, String> numberColumn = new TableColumn<>("#");
            numberColumn.setMinWidth(30);
            numberColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Child, String>, ObservableValue<String>>() {
                @Override public ObservableValue<String> call(TableColumn.CellDataFeatures<Child, String> p) {
                    return new ReadOnlyObjectWrapper(list.getItems().indexOf(p.getValue()) + "");
                }
            });
            numberColumn.setSortable(false);
            list.getColumns().add(numberColumn);*/


        }

        textField1.setOnKeyTyped( e -> {
            for(Child chi: observableList){
                Child child = (Child) list.getSelectionModel().getSelectedItem();
                if(chi == child){
                    chi.setChildName(textField1.getText());
                }
            }
        });


        textField3.setOnKeyTyped( e -> {
            for(Child chi: observableList){
                Child child = (Child) list.getSelectionModel().getSelectedItem();
                if(chi == child){
                    chi.setSecurityNumber(textField3.getText());
                }
            }
        });

        textField4.setOnKeyTyped( e -> {
            for(Child chi: observableList){
                Child child = (Child) list.getSelectionModel().getSelectedItem();
                if(chi == child){
                    chi.setFirstParentName(textField4.getText());
                }
            }
        });

        textField5.setOnKeyTyped( e -> {
            for(Child chi: observableList){
                Child child = (Child) list.getSelectionModel().getSelectedItem();
                if(chi == child){
                    chi.setFirstParentNumber(Integer.parseInt(textField5.getText()));
                }
            }
        });

        textField6.setOnKeyTyped( e -> {
            for(Child chi: observableList){
                Child child = (Child) list.getSelectionModel().getSelectedItem();
                if(chi == child){
                    chi.setFirstParentSecondNumber(Integer.parseInt(textField6.getText()));
                }
            }
        });

        textField7.setOnKeyTyped( e -> {
            for(Child chi: observableList){
                Child child = (Child) list.getSelectionModel().getSelectedItem();
                if(chi == child){
                    chi.setFirstParentAddress(textField7.getText());
                }
            }
        });

        textField8.setOnKeyTyped( e -> {
            for(Child chi: observableList){
                Child child = (Child) list.getSelectionModel().getSelectedItem();
                if(chi == child){
                    chi.setSecondParentName(textField8.getText());
                }
            }
        });

        textField9.setOnKeyTyped( e -> {
            for(Child chi: observableList){
                Child child = (Child) list.getSelectionModel().getSelectedItem();
                if(chi == child){
                    chi.setSecondParentNumber(Integer.parseInt(textField9.getText()));
                }
            }
        });

        textField10.setOnKeyTyped( e -> {
            for(Child chi: observableList){
                Child child = (Child) list.getSelectionModel().getSelectedItem();
                if(chi == child){
                    chi.setSecondParentSecondNumber(Integer.parseInt(textField10.getText()));
                }
            }
        });

        textField11.setOnKeyTyped( e -> {
            for(Child chi: observableList){
                Child child = (Child) list.getSelectionModel().getSelectedItem();
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

        list.getColumns().addAll(nameColumn, roomColumn, securityNumberColumn);

        anchor.setTopAnchor(list, 10.0);
        anchor.setLeftAnchor(list, 100.0);
        anchor.setBottomAnchor(list, 50.0);
        anchor.setRightAnchor(grid, 10.0);
        anchor.setTopAnchor(grid, 10.0);
        anchor.setLeftAnchor(grid, 1050.0);

        anchor.getChildren().addAll(list, grid);
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
