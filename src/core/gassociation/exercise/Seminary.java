package core.gassociation.exercise;

public class Seminary {
    private String title;
    private Professor teacher;
    private Place address;
    public Academician[] participants;

    public Seminary(String title) {
        this.title = title;
    }

    public Seminary(String title, Professor teacher, Place address) {
        this.title = title;
        this.teacher = teacher;
        this.address = address;
    }

    public void print() {
        System.out.println("--------------------------------------------");
        System.out.println("Seminário " + getTitle());
        if(this.teacher != null) {
            System.out.print("Ministrado pelo professor " + this.teacher.getName());
            System.out.println(", " + this.teacher.getSpecialty());
        }
        System.out.println("place: " + this.address.getAddress());
        if(this.participants != null) {
            System.out.println("Participantes:");
            for(int i = 0; i < this.participants.length; i++) {
                System.out.println((i+1) + ". " + this.participants[i].getName());
            }
        }
        System.out.println("--------------------------------------------");
    }
    
    public void show(int index) {
        System.out.println("--------------------------------------------");
        System.out.println(index + " - Seminário " + getTitle());
        if(this.teacher != null) {
            System.out.print("Ministrado pelo professor " + this.teacher.getName());
            System.out.println(", " + this.teacher.getSpecialty());
        }
        System.out.println("place: " + this.address.getAddress());
        if(this.participants != null) {
            System.out.println("Participantes:");
            for(int i = 0; i < this.participants.length; i++) {
                System.out.println((i+1) + ". " + this.participants[i].getName());
            }
        }
        System.out.println("--------------------------------------------");
    }

    public void setProfessor(Professor teacher) {
        this.teacher = teacher;
    }

    public void setPlace(Place address) {
        this.address = address;
    }

    public String getTitle() {
        return title;
    }

    public Academician[] getParticipants() {
        return participants;
    }
}
