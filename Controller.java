import java.util.List;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

public class Controller {

    List<Child> children = new ArrayList<>();
    ObservableList<Child> observableChildren = FXCollections.observableList(children);

    public ObservableList getObservableList(){
        return observableChildren;
    }
}