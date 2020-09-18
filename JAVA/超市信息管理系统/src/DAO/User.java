package DAO;

public class User {
    private String name;
    private String pass;
    private String question;
    private String answer;
    private int state;
    private String departement;
    public String getDepartement() { return departement; }
    public void setDepartement(String departement) { this.departement = departement; }
    public int getState() { return state; }
    public void setState(int state) { this.state = state; }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPass() {
        return pass;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }
    public String getQuestion() {
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }
    public String getAnswer() {
        return answer;
    }
    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
