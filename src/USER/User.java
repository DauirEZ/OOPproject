package USER;

import java.security.MessageDigest;
import java.util.Objects;
import java.security.NoSuchAlgorithmException;

public class User extends UserDecorator implements UserFactory, News{

    private String surname, name;
    private String id, login, password, hashPassword;
    private Language language;



    //constructors
    public User() {

    }

    public User(String name,String surname) {
        this.name = name;
        this.surname = surname;
    }

    public User(String name, String surname, String id) {
        this.setName(name);
        this.setSurname(surname);
        this.id = id;
    }


    public User(String name, String surname, String id, String login, String password) {
        this(name, surname, id);
        this.login = login;
        //this.hashPassword = hashFunc(password);
    }


    public void User(String login2, String password2) {
        this.login = login2;
        //this.hashPassword = hashFunc(password2);
    }



    // getters and setters:
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHashPassword() {
        return hashPassword;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }



    //hashcode
    public int hashCode() {
        return Objects.hash(id, login, getName(), password, getSurname());
    }

    //equals
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        return Objects.equals(id, other.id) && Objects.equals(login, other.login) && Objects.equals(getName(), other.getName())
                && Objects.equals(password, other.password) && Objects.equals(getSurname(), other.getSurname());
    }

    //to string
    public String toString() {
        return "User:  name=" + getName() + ", surname=" + getSurname() + ", id=" + id + ", login=" + login + " ";
    }



    public static User enterSystem(String login_, String password_) throws InvalidPasswordException {
        String hashp = hashFunc(password_);
        for (User u : Data.getData().users) {
            try {
                if (u.getHashPassword().equals(hashp) && u.login.equals(login_))
                    return u;
                else {
                    throw new InvalidPasswordException("Password is invalid");
                }
            }
            catch(InvalidPasswordException e) {
                System.out.println("Invalid login or Password,please repeat again");
            }
        }
        return null;
    }


    public void outSystem() {

    }




    public void hashFunc(String password) {}

    @Override
    public void createUser() {

    }

    @Override
    public void addResearcher() {
        super.addResearcher();
    }

    @Override
    public void viewNews() {

    }

}
