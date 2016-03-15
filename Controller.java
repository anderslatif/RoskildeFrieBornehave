import java.util.List;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

public class Controller {

    public static ObservableList getObservableList(){
        List<Child> children = new ArrayList<>();
        ObservableList<Child> observableChildren = FXCollections.observableList(children);

        Child perJ = new Child(
                "Per Jensen", "Løvestuen", "1611121342", "Anna Jensen", 45712893, 23872376, "Langgade 14", "Hans Jensen", 45872309, 56473748, "Langgade 14");

        children.add(perJ);

        return observableChildren;
    }
}
