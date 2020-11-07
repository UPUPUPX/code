package DataService;

/**
 * @ClassName Data
 * @Description TODO
 * @Author 孙浩瑞
 * @Date 2020/8/15 14:26
 */
public class Data {
    private int id;
    private String text;
    private String summary;

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
