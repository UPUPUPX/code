package DAO;

public class USER {
    private int ID;
    private String USERNAME;
    private String USERPASS;
    private int STATE;
    private String SHENFEN;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public void setUSERNAME(String USERNAME) {
        this.USERNAME = USERNAME;
    }

    public String getUSERPASS() {
        return USERPASS;
    }

    public void setUSERPASS(String USERPASS) {
        this.USERPASS = USERPASS;
    }

    public int getSTATE() {
        return STATE;
    }

    public void setSTATE(int STATE) {
        this.STATE = STATE;
    }

    public String getSHENFEN() {
        return SHENFEN;
    }

    public void setSHENFEN(String SHENFEN) {
        this.SHENFEN = SHENFEN;
    }
}
