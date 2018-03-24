package Servlets;

public class InfoPOJO {
    private String emailInput;
    private String passInput;

    public InfoPOJO(){
        super();
    }

    public InfoPOJO(String emailInput, String passInput){
        this.setEmailInput(emailInput);
        this.setPassInput(passInput);
    }

    public String getEmailInput() {
        return emailInput;
    }
    public void setEmailInput(String emailInput) {
        this.emailInput = emailInput;
    }
    public String getPassInput() {
        return passInput;
    }
    public void setPassInput(String passInput) {
        this.passInput = passInput;
    }

    @Override
    public String toString(){
        return "[email: " + this.getEmailInput() + ", password: " + this.getPassInput() + "]";
    }
}
