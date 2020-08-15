package View;

import DataService.Data;
import DataService.DataOperator;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 * @ClassName BankView
 * @Description TODO
 * @Author 孙浩瑞
 * @Date 2020/8/14 18:43
 */
public class BankView extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTable table;
    private DefaultTableModel tableModel;
    private JTextField TextField;

    public BankView() {
        super();
        setTitle("文本银行");
        setSize(964, 643);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JScrollPane scrollPane = new JScrollPane();
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        String[] rowValues = { "文本内容" };

        tableModel = new DefaultTableModel(rowValues,1);
        tableModel.addTableModelListener(new TableModelListener() {
            public void tableChanged(TableModelEvent e) {
                int type = e.getType();//获得事件的类型
                int row = e.getFirstRow();//获得触发此次事件的表格行索引
                if (type == TableModelEvent.INSERT) {//判断是否插入行触发
                    Data data=new Data();
                    data.setId(row);
                    new AddTextView(data.getId());
                } else if (type == TableModelEvent.UPDATE) {  //判断是否修改行触发
                    System.out.print("修改行触发");

                    //判断是否删除行触发
                } else if (type == TableModelEvent.DELETE) {

                } else {
                    System.out.println("其他原因触发");
                }
            }
        });
        table = new JTable(tableModel);

        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setRowHeight(30);
        scrollPane.setViewportView(table);
        final JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.SOUTH);
        final JLabel aLabel = new JLabel("添加文本标题");
        panel.add(aLabel);
        TextField = new JTextField(30);
        panel.add(TextField);

        final JButton addButton = new JButton("添加文本");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String[] rowValues = {TextField.getText() };
                tableModel.addRow(rowValues);//向表格中添加一行
                TextField.setText(null);
            }
        });
        panel.add(addButton);
        addButton.setFocusPainted(false);

        final JButton delButton = new JButton("删除文本");
        delButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 获得表格中的选中行
                int[] selectedRows = table.getSelectedRows();
                for (int row = 0; row < selectedRows.length; row++) {
                    //从表格模型中移除表格中的选中行
                    tableModel.removeRow(selectedRows[row] - row);
                }
            }
        });
        panel.add(delButton);
        delButton.setFocusPainted(false);

        final JButton checkButton = new JButton("查看文本");
        delButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 获得表格中的选中行
                int[] selectedRows = table.getSelectedRows();
                for (int row = 0; row < selectedRows.length; row++) {
                    new CheckTextView(row);
                }
            }
        });
        panel.add(checkButton);
        checkButton.setFocusPainted(false);

        final JButton copyButton = new JButton("复制文本");
        delButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 获得表格中的选中行
                int[] selectedRows = table.getSelectedRows();
                for (int row = 0; row < selectedRows.length; row++) {
                    //从表格模型中查看表格中的选中行

                }
            }
        });
        panel.add(copyButton);
        copyButton.setFocusPainted(false);
    }
}

