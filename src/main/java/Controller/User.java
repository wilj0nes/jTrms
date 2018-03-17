package Controller;

public class User {

    private int id;
    private String firstName;
    private String lastName;
    private float funds;
    private int type;
    private String email;

    public User(int id, String firstName, String lastName, float funds, int type, String email){
        this.setId(id);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setFunds(funds);
        this.setType(type);
        this.setEmail(email);
    }

    public User(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public float getFunds() {
        return funds;
    }

    public void setFunds(float funds) {
        this.funds = funds;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}