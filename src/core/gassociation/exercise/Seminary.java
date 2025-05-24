package core.gassociation.exercise;

public class Seminary {
    private String title;
    private Professor teacher;
    private Local address;
    public Academician[] participants;

    public Seminary(String title) {
        this.title = title;
    }

    public Seminary(String title, Professor teacher, Local address) {
        this.title = title;
        this.teacher = teacher;
        this.address = address;
    }

    public void print() {
        System.out.println("Seminário " + getTitle());
        if(this.teacher != null) {
            System.out.print("ministrado pelo professor " + this.teacher.getName());
        System.out.println(", " + this.teacher.getSpecialty());
        }
        System.out.println("Local: " + this.address.getAddress());
        if(this.participants != null) {
            System.out.println("Participantes:");
            for(int i = 0; i < this.participants.length; i++) {
                System.out.println((i+1) + ". " + this.participants[i].getName());
            }
        }
    }

    public void setProfessor(Professor teacher) {
        this.teacher = teacher;
    }

    public void setLocal(Local address) {
        this.address = address;
    }

    public void setParticipant(Academician participant, int index) {
        participants[index] = participant;
        //this.participants = participants;
    }

    public String getTitle() {
        return title;
    }

//        public Professor getTeacher() {
//            return teacher;
//        }
//
//        public Local getAddress() {
//            return address;
//        }

    public Academician[] getParticipants() {
        return participants;
    }
}
