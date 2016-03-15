public class Child {

    //Attributes for Child
    private String childName;
    private String room;
    private long securityNumber;

    //Attributes for the first Parent
    private String firstParentName;
    private int firstParentNumber;
    private String firstParentAddress;

    //Attributes for the second Parent
    private String secondParentName;
    private int secondParentNumber;
    private String secondParentAddress;

    //Constructor with all attributes
    public Child (String childName, String room, int securityNumber, String firstParentName, int firstParentNumber, String firstParentAddress, String secondParentName, int secondParentNumber, String secondParentAddress) {
        this.childName = childName;
        this.room = room;
        this.securityNumber = securityNumber;
        this.firstParentName = firstParentName;
        this.firstParentNumber = firstParentNumber;
        this.firstParentAddress = firstParentAddress;
        this.secondParentName = secondParentName;
        this.secondParentNumber = secondParentNumber;
        this.secondParentAddress = secondParentAddress;
    }

    //Getters and setters
    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public long getSecurityNumber() {
        return securityNumber;
    }

    public void setSecurityNumber(int securityNumber) {
        this.securityNumber = securityNumber;
    }

    public String getFirstParentName() {
        return firstParentName;
    }

    public void setFirstParentNumber(int firstParentNumber) {
        this.firstParentNumber = firstParentNumber;
    }

    public String getFirstParentAddress() {
        return firstParentAddress;
    }

    public String getSecondParentName() {
        return secondParentName;
    }

    public void setSecondParentNumber(int SecondParentNumber) {
        this.secondParentNumber = secondParentNumber;
    }

    public String getSecondParentAddress() {
        return secondParentAddress;
    }

}
