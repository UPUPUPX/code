package Model;

import javax.swing.*;

public class RegList extends AbstractListModel implements ComboBoxModel{
    private String[] choose={"系部","教材科","教师","班级"};
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