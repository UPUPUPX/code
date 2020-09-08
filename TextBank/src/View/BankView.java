package View;

import DataService.Data;
import DataService.DataOperator;
import Model.ClipBoardModel;
import Model.GetCounts;


import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

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
    private int rows;

    public BankView() {
        super();
        setTitle("文本银行");
        setSize(964, 643);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JScrollPane scrollPane = new JScrollPane();
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        String[] rowValues = { "文本内容" };
        this.setLocationRelativeTo(null);
        ImageIcon imageIcon=new ImageIcon("./lib/TextBank.png");
        this.setIconImage(imageIcon.getImage());

        GetCounts getCounts=new GetCounts();
        int counts=getCounts.getCount();

        tableModel = new DefaultTableModel(rowValues,1);
        tableModel.addTableModelListener(new TableModelListener() {
            public void tableChanged(TableModelEvent e) {
                int type = e.getType();
                int row = e.getFirstRow();
                rows=row;
                /*if (type == TableModelEvent.INSERT) { rows=row;}
                else if (type == TableModelEvent.UPDATE){ rows=row;}
                else if (type == TableModelEvent.DELETE) { rows=row;}
                else { rows=row;}*/ }});

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
                if (e.getSource()==addButton){
                    String[] rowValues = {TextField.getText()};
                    tableModel.addRow(rowValues);
                    Data data=new Data();
                    data.setId(rows);
                    data.setSummary(TextField.getText());
                    new AddTextView(data.getId(),data.getSummary());
                    TextField.setText(null);
                }
            }
        });
        panel.add(addButton);
        addButton.setFocusPainted(false);

        final JButton delButton = new JButton("删除文本");
        delButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==delButton){
                    int[] selectedRows = table.getSelectedRows();
                    for (int row = 0; row < selectedRows.length; row++) {
                        tableModel.removeRow(selectedRows[row] - row);
                        DataOperator dataOperator=new DataOperator();
                        try {
                            Data data=dataOperator.Find(selectedRows[row]);
                            dataOperator.delete(data);
                        } catch (SQLException | InterruptedException throwables) {
                            throwables.printStackTrace();
                        }
                    }
                }
            }
        });
        panel.add(delButton);
        delButton.setFocusPainted(false);

        final JButton checkButton = new JButton("查看文本");
        checkButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==checkButton){
                    rows=table.getSelectedRow();
                    System.out.println(rows);
                    new CheckTextView(rows);
                }
            }
        });
        panel.add(checkButton);
        checkButton.setFocusPainted(false);

        final JButton copyButton = new JButton("复制文本");
        copyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==copyButton){
                    int[] selectedRows = table.getSelectedRows();
                    for (int row = 0; row < selectedRows.length; row++) {
                        DataOperator dataOperator=new DataOperator();
                        Data data;
                        try {
                            data=dataOperator.Find(row);
                            if (data!=null){
                                ClipBoardModel clipBoardModel=new ClipBoardModel();
                                clipBoardModel.setSysClipboardText(data.getText());
                            }
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    }
                }
            }
        });
        panel.add(copyButton);
        copyButton.setFocusPainted(false);
        setVisible(true);

        if (counts>0){
            for (int i = 0; i < counts+2; i++) {
                DataOperator dataOperator=new DataOperator();
                try {
                    Data data= dataOperator.Find(i);
                    if (data!=null){
                        String[] rowValue = {data.getSummary()};
                        tableModel.removeRow(0);
                        tableModel.addRow(rowValue);
                    }else{
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

        }else{
        }
    }

    public static void main(String[] args) {
        new BankView();
    }
}

