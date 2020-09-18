package Model;

import javax.swing.*;

/**
 * @ClassName listModel
 * @Description TODO
 * @Author 孙浩瑞
 * @Date 2020/9/16 8:06
 */
public class listModel extends AbstractListModel implements ComboBoxModel{
    private String[] choose={"一个重要的纪念日","一个重要的城市","一个重要的人","一件重要的事件","一所重要的学校"};
    private String selection=null;
    @Override
    public int getSize() { return choose.length; }
    @Override
    public Object getElementAt(int index) {
        return choose[index];
    }
    @Override
    public void setSelectedItem(Object anItem) {
        selection=(String)anItem;
    }
    @Override
    public Object getSelectedItem() {
        return selection;
    }
}
