package DAO;
public class dealer {
    private String dealer;
    private int dealerid;
    private String dealergoos;
    private String producetime;
    private String deadline;
    private int goodsid;
    private int count;
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getDealer() {
        return dealer;
    }
    public void setDealer(String dealer) {
        this.dealer = dealer;
    }
    public int getDealerid() {
        return dealerid;
    }

    public void setDealerid(int dealerid) {
        this.dealerid = dealerid;
    }

    public String getDealergoos() {
        return dealergoos;
    }

    public void setDealergoos(String dealergoos) {
        this.dealergoos = dealergoos;
    }

    public String getProducetime() {
        return producetime;
    }

    public void setProducetime(String producetime) {
        this.producetime = producetime;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public int getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(int goodsid) {
        this.goodsid = goodsid;
    }
}

