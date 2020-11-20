package DAO;

/**
 * @ClassName goods
 * @Description TODO
 * @Author 孙浩瑞
 * @Date 2020/9/21 22:46
 */
public class Goods {
    private int ID;
    private String name;
    private double inprice;
    private double outprice;
    private int account;
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getInprice() {
        return inprice;
    }
    public void setInprice(double inprice) {
        this.inprice = inprice;
    }
    public double getOutprice() {
        return outprice;
    }

    public void setOutprice(double outprice) {
        this.outprice = outprice;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }
}
