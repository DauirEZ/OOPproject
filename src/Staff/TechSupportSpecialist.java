package Staff;


import java.util.ArrayList;

public class TechSupportSpecialist {
    ArrayList<String> techMessages;
    private String name;
    private int id;
    private String email;
    private int age;
    private int salary;
    private Object login;
    private Object password;
    private boolean registered;
    private boolean authorized;

    public TechSupportSpecialist(String name, int id, String email, int age, int salary) {
        this.name=name;
        this.id=id;
        this.email=email;
        this.age=age;
        this.salary=salary;
        this.login = null;
        this.password = null;
        this.registered = false;
        this.authorized = false;
        this.techMessages = new ArrayList<String>();
    }
    public void addVeryImportantMessage(String message) {
        techMessages.add(message);
    }

    public void readVeryImportantMessages() {
        if (techMessages.isEmpty()) {
            System.out.println("No messages");
        } else {
            System.out.println("Very Important Messages:");
            for (Object message : techMessages) {
                System.out.println(message);
            }
        }
    }
}
