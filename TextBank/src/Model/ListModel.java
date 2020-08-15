package Model;

import javax.swing.*;

/**
 * @ClassName ListModel
 * @Description TODO
 * @Author 孙浩瑞
 * @Date 2020/8/15 10:28
 */
public class ListModel extends AbstractListModel implements ComboBoxModel{

    private String[] choose={"纪念日","重要的一天","旅行过的城市","我的好朋友"};
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
