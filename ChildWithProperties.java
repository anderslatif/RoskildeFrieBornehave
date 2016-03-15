import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Joachim on 15-03-2016.
 */
public class ChildWithProperties {

        //Child
        private SimpleStringProperty childName;
        private SimpleStringProperty room;
        private SimpleLongProperty securityNumber;

        //First parent
        private SimpleStringProperty firstParentName;
        private SimpleIntegerProperty firstParentNumber;
        private SimpleStringProperty firstParentAddress;

        //Second parent
        private SimpleStringProperty secondParentName;
        private SimpleIntegerProperty secondParentNumber;
        private SimpleStringProperty secondParentAddress;

        public ChildWithProperties(String childName, String room, int securityNumber, String firstParentName, int firstParentNumber, String firstParentAddress, String secondParentName, int secondParentNumber, String secondParentAddress) {
            this.childName = new SimpleStringProperty(childName);
            this.room = new SimpleStringProperty(room);
            this.securityNumber = new SimpleLongProperty(securityNumber);
            this.firstParentName = new SimpleStringProperty(firstParentName);
            this.firstParentNumber = new SimpleIntegerProperty(firstParentNumber);
            this.firstParentAddress = new SimpleStringProperty(firstParentAddress);
            this.secondParentName = new SimpleStringProperty (secondParentName);
            this.secondParentNumber = new SimpleIntegerProperty(secondParentNumber);
            this.secondParentAddress = new SimpleStringProperty(secondParentAddress);
        }

        public String getChildName() {
            return childName.get();
        }

        public SimpleStringProperty childNameProperty() {
            return childName;
        }

        public void setchildName(String childName) {
            this.childName.set(childName);
        }

        public String getRoom() {
            return room.get();
        }

        public SimpleStringProperty roomProperty() {
            return room;
        }

        public void setroom(String room) {
            this.room.set(room);
        }

        public long getSecurityNumber() {
            return securityNumber.get();
        }

        public SimpleLongProperty securityNumberProperty() {
            return securityNumber;
        }

        public void setSecurityNumber(long securityNumber) {
            this.securityNumber.set(securityNumber);
        }

        public String getFirstParentName() {
            return firstParentName.get();
        }

        public SimpleStringProperty firstParentName() {
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
