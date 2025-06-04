package core.gassociation.exercise;

public class Place {
    private String address;
    //private Seminary seminary;

    public Place(String address) {
        this.address = address;
    }

    public void print() {
        System.out.println(this.getAddress());
    }

    public void show(int index) {
        System.out.println(index + " - " + this.getAddress());
    }

//    public void setSeminary(Seminary seminary) {
//        this.seminary = seminary;
//    }

    public String getAddress() {
        return address;
    }

//    public String getSeminaryTitle() {
//        return seminary.getTitle();
//    }
}
