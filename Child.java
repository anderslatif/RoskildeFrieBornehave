import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;


public class Child {

        //Child
        private SimpleStringProperty childName;
        private SimpleStringProperty room;
        private SimpleStringProperty securityNumber;

        //First parent
        private SimpleStringProperty firstParentName;
        private SimpleIntegerProperty firstParentNumber;
        private SimpleIntegerProperty firstParentSecondNumber;
        private SimpleStringProperty firstParentAddress;

        //Second parent
        private SimpleStringProperty secondParentName;
        private SimpleIntegerProperty secondParentNumber;
        private SimpleIntegerProperty secondParentSecondNumber;
        private SimpleStringProperty secondParentAddress;

        public Child(String childName, String room, String securityNumber, String firstParentName, int firstParentNumber, int firstParentSecondNumber, String firstParentAddress, String secondParentName, int secondParentNumber, int secondParentSecondNumber, String secondParentAddress) {
            this.childName = new SimpleStringProperty(childName);
            this.room = new SimpleStringProperty(room);
            this.securityNumber = new SimpleStringProperty(securityNumber);
            this.firstParentName = new SimpleStringProperty(firstParentName);
            this.firstParentNumber = new SimpleIntegerProperty(firstParentNumber);
            this.firstParentSecondNumber = new SimpleIntegerProperty(firstParentSecondNumber);
            this.firstParentAddress = new SimpleStringProperty(firstParentAddress);
            this.secondParentName = new SimpleStringProperty (secondParentName);
            this.secondParentNumber = new SimpleIntegerProperty(secondParentNumber);
            this.secondParentSecondNumber = new SimpleIntegerProperty(secondParentSecondNumber);
            this.secondParentAddress = new SimpleStringProperty(secondParentAddress);
        }

    public String getChildName() {
        return childName.get();
    }

    public SimpleStringProperty childNameProperty() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName.set(childName);
    }

    public String getRoom() {
        return room.get();
    }

    public SimpleStringProperty roomProperty() {
        return room;
    }

    public void setRoom(String room) {
        this.room.set(room);
    }

    public String getSecurityNumber() {
        return securityNumber.get();
    }

    public SimpleStringProperty securityNumberProperty() {
        return securityNumber;
    }

    public void setSecurityNumber(String securityNumber) {
        this.securityNumber.set(securityNumber);
    }

    public String getFirstParentName() {
        return firstParentName.get();
    }

    public SimpleStringProperty firstParentNameProperty() {
        return firstParentName;
    }

    public void setFirstParentName(String firstParentName) {
        this.firstParentName.set(firstParentName);
    }

    public int getFirstParentNumber() {
        return firstParentNumber.get();
    }

    public SimpleIntegerProperty firstParentNumberProperty() {
        return firstParentNumber;
    }

    public void setFirstParentNumber(int firstParentNumber) {
        this.firstParentNumber.set(firstParentNumber);
    }

    public int getFirstParentSecondNumber() {
        return firstParentSecondNumber.get();
    }

    public SimpleIntegerProperty firstParentSecondNumberProperty() {
        return firstParentSecondNumber;
    }

    public void setFirstParentSecondNumber(int firstParentSecondNumber) {
        this.firstParentSecondNumber.set(firstParentSecondNumber);
    }

    public String getFirstParentAddress() {
        return firstParentAddress.get();
    }

    public SimpleStringProperty firstParentAddressProperty() {
        return firstParentAddress;
    }

    public void setFirstParentAddress(String firstParentAddress) {
        this.firstParentAddress.set(firstParentAddress);
    }

    public String getSecondParentName() {
        return secondParentName.get();
    }

    public SimpleStringProperty secondParentNameProperty() {
        return secondParentName;
    }

    public void setSecondParentName(String secondParentName) {
        this.secondParentName.set(secondParentName);
    }

    public int getSecondParentNumber() {
        return secondParentNumber.get();
    }

    public SimpleIntegerProperty secondParentNumberProperty() {
        return secondParentNumber;
    }

    public void setSecondParentNumber(int secondParentNumber) {
        this.secondParentNumber.set(secondParentNumber);
    }

    public int getSecondParentSecondNumber() {
        return secondParentSecondNumber.get();
    }

    public SimpleIntegerProperty secondParentSecondNumberProperty() {
        return secondParentSecondNumber;
    }

    public void setSecondParentSecondNumber(int secondParentSecondNumber) {
        this.secondParentSecondNumber.set(secondParentSecondNumber);
    }

    public String getSecondParentAddress() {
        return secondParentAddress.get();
    }

    public SimpleStringProperty secondParentAddressProperty() {
        return secondParentAddress;
    }

    public void setSecondParentAddress(String secondParentAddress) {
        this.secondParentAddress.set(secondParentAddress);
    }
}
