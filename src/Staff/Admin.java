package Staff;

import java.util.Vector;
import USER.User;

public class Admin extends Employee{



    private Vector<User> users;
    private Vector<String> logFiles;


    public Admin(String surname, String name) {
        super(surname,name);
        this.users = new Vector<>();
        this.setLogFiles(new Vector<>());
    }


    public void addUser(User user) {
        users.add(user);
        logAction("Added user: " + getSurname() + getName());
    }


    public void removeUser(User user) {
        users.remove(user);
        logAction("Removed user: " + getSurname() + getName());
    }

    //private void logAction(String string) {}


    public void updateUser(User user) {
        logAction("Updated user: " + getSurname() + getName());
    }



    public void logAction(String action) {
        logFiles.add(action);
        System.out.println("Logged: " + action);
    }



    // public void viewLogFiles(){
    //   System.out.println("Log Files:");

    //    for (String log : logFiles) {
    //         System.out.println(log);
    //     }
    // }


    public Vector<String> getLogFiles() {
        return logFiles;
    }


    public void setLogFiles(Vector<String> logFiles) {
        this.logFiles = logFiles;
    }




}
