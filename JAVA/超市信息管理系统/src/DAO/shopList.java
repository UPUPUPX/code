package DAO;

/**
 * @ClassName List
 * @Description TODO
 * @Author 孙浩瑞
 * @Date 2020/9/26 21:06
 */
public class shopList {
    private int id;
    private int count;
    private String time;
    private String name;
    private double price;
    private String running;
    public String getRunning() {
        return running;
    }
    public void setRunning(String running) {
        this.running = running;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}
