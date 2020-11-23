package DAO;

public class AUDIT {
    private int ID;
    private String BName;
    private String CoName;
    private String TName;
    private int flag;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getBName() {
        return BName;
    }

    public void setBName(String BName) {
        this.BName = BName;
    }

    public String getCoName() {
        return CoName;
    }

    public void setCoName(String coName) {
        CoName = coName;
    }

    public String getTName() {
        return TName;
    }

    public void setTName(String TName) {
        this.TName = TName;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
