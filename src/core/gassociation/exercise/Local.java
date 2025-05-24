package core.gassociation.exercise;

public class Local {
    private String address;
    private Seminary seminary;

    public Local(String address) {
        this.address = address;
    }

    public void print() {
        System.out.println(this.getAddress() + ": receberá o seminário " + this.getSeminaryTitle());
    }

    public void setSeminary(Seminary seminary) {
        this.seminary = seminary;
    }

    public String getAddress() {
        return address;
    }

    public String getSeminaryTitle() {
        return seminary.getTitle();
    }
}
