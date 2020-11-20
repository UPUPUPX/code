package View;

import DAO.BOOK;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JBook extends JFrame implements ActionListener {

    JButton BookBuy;
    JButton Store;
    JButton Deliver;
    JButton Charge;
    JButton Supplier;
    JButton Jbook;
    JButton jButton;
    BOOK book;
    JTable table;
    DefaultTableModel tableModel;
    JTextField textField;
    int rows;

    public JBook(){
        super();
        BookBuy = new JButton("教材订购管理");
        BookBuy.setText("教材订购管理");
        BookBuy.setBounds(10,48,200,46);
        BookBuy.setFont(new Font("", Font.BOLD,24));
        getContentPane().add(BookBuy);

        Store = new JButton("库存管理");
        Store.setText("库存管理");
        Store.setBounds(10,106,200,46);
        Store.setFont(new Font("", Font.BOLD,24));
        getContentPane().add(Store);

        Deliver = new JButton("出库管理");
        Deliver.setText("出库管理");
        Deliver.setBounds(10,164,200,46);
        Deliver.setFont(new Font("", Font.BOLD,24));
        getContentPane().add(Deliver);

        Charge = new JButton("收费管理");
        Charge.setText("收费管理");
        Charge.setBounds(10,222,200,46);
        Charge.setFont(new Font("", Font.BOLD,24));
        getContentPane().add(Charge);

        Supplier = new JButton("供应商管理");
        Supplier.setText("供应商管理");
        Supplier.setBounds(10,280,200,46);
        Supplier.setFont(new Font("", Font.BOLD,24));
        getContentPane().add(Supplier);

        Jbook = new JButton("教材科信息");
        Jbook.setText("教材科信息");
        Jbook.setBounds(10,338,200,46);
        Jbook.setFont(new Font("", Font.BOLD,24));
        getContentPane().add(Jbook);

        jButton = new JButton();
        jButton.setBorder(new TitledBorder(null,"",TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION,null,null));
        jButton.setForeground(new Color(0xCA51FF));
        jButton.setFont(new Font("", Font.BOLD, 36));
        jButton.setText("教材管理系统--当前登录为教材科");
        jButton.setBounds(100,0,600,36);
        jButton.setBorderPainted(false);
        jButton.setFocusPainted(false);
        jButton.setContentAreaFilled(false);
        getContentPane().add(jButton);
        setTitle("教材管理系统");
        setSize(800,600);
        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon imageIcon = new ImageIcon("");
        this.setIconImage(imageIcon.getImage());
        this.setLocationRelativeTo(null);

        String[] rowValues = {" "};
        tableModel = new DefaultTableModel(rowValues,1);
        tableModel.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                int type = e.getType();
                int row = e.getFirstRow();
                rows = row;
            }
        });
        table = new JTable(tableModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setRowHeight(30);
        final JScrollPane scrollPane = new JScrollPane();
        getContentPane().add(scrollPane,BorderLayout.CENTER);
        scrollPane.setViewportView(table);
        final JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.SOUTH);

        final JLabel label = new JLabel("TTTT");
        panel.add(label);
        textField = new JTextField(30);
        panel.add(textField);

        final JButton addButton = new JButton("添加文本");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==addButton){
                    String[] rowValues = {textField.getText()};
                    tableModel.addRow(rowValues);
                    textField.setText(null);
                }
            }
        });
        panel.add(addButton);
        addButton.setFocusPainted(false);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
