package VIEW;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
/**
 * @ClassName adminprintlist
 * @Description TODO
 * @Author 孙浩瑞
 * @Date 2020/9/19 21:46
 */
public class adminprintlist extends JPanel{
        public static Color bluegreen =new Color(0,127,127);
        protected Color selectedColor = new Color(240, 200, 100);
        protected Color northColor = Color.decode("#a6a6a6");
        protected Color labelColor = new Color(0, 130, 30);
        protected Font labelFont = new Font("", Font.PLAIN, 20);
        protected Font fontf = new Font("", Font.PLAIN, 36);
        protected Color weekLabelColor = new Color(120, 120, 150);
        protected Color weekendFontColor = new Color(100, 200, 100);
        protected Color dateFontColor = Color.BLACK;
        protected final int startYear;
        protected final int lastYear;
        protected final String[] weekStrings = { "日", "一", "二", "三", "四", "五", "六" };
        protected JDialog dialog;
        protected JSpinner yearSpinner;
        protected JSpinner monthSpinner;
        protected JButton[][] dayButtons = new JButton[6][7];
        protected ButtonGroup buttonGroup = new ButtonGroup();
        protected DateFormat format;
        protected Date date;
        protected String selectedDay;
        protected boolean isConfirm;
        JTextField textField;
        JButton exit;
        public String showit(){return textField.getText();}
        public boolean isConfirm() { return isConfirm; }
        public String getDateText() { return format.format(getDate()); }
        public void setDate(Date date) { this.date = date; }
        public Date getDate() { return date; }
        public static void main(String[] args) {
        final JFrame frame = new JFrame("时间选择器");
        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(480, 320);
        frame.setLocationRelativeTo(null);
        final JTextField textField = new JTextField(40);
        textField.setPreferredSize(new Dimension (300,50));
        frame.add(textField);
        final JButton choosedate = new JButton("选择日期");
        choosedate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Dimension dialogSize = new Dimension(400, 250);
                Point screen = choosedate.getLocationOnScreen();
                Point point = new Point(screen.x, screen.y + choosedate.getPreferredSize().height + 5);
                adminprintlist adminprintlist = new adminprintlist();
                String selectedDate = adminprintlist.showDateDialog(frame, point, dialogSize);
                if (adminprintlist.isConfirm()) {
                    textField.setText(selectedDate);
                }
            }
        });
        choosedate.setPreferredSize(new Dimension (100,50));
        choosedate.setBackground(bluegreen);
        frame.add(choosedate);
        frame.setVisible(true);
        final JButton print = new JButton("导出数据");
        print.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        print.setPreferredSize(new Dimension (100,50));
        print.setBackground(bluegreen);
        frame.add(print);
    }
        public adminprintlist() {
            this(new SimpleDateFormat("yyyyMMdd"));
        }
        public adminprintlist(DateFormat format) {
            this(format, new Date());
        }
        public adminprintlist(DateFormat format, Date date) {
            this(format, date, 1980, 2080);
        }
        public adminprintlist(DateFormat format, Date date, int startYear, int lastYear) {
            this.date = date;
            this.format = format;
            this.startYear = startYear;
            this.lastYear = lastYear;
            selectedDay = getCalendar().get(Calendar.DAY_OF_MONTH) + "";
            setLayout(new BorderLayout());
            setBackground(Color.WHITE);
            JPanel northPanel = createNorthPanal();
            northPanel.setPreferredSize(new Dimension(0, 40));
            add(northPanel, BorderLayout.NORTH);
            JPanel centerPanel = createCenterPanal();
            add(centerPanel, BorderLayout.CENTER);
            JPanel southPanel = createSouthPanel();
            southPanel.setPreferredSize(new Dimension(0, 40));
            add(southPanel, java.awt.BorderLayout.SOUTH);
        }
        private JPanel createNorthPanal() {
            Calendar c = getCalendar();
            int currentYear = c.get(Calendar.YEAR);
            int currentMonth = c.get(Calendar.MONTH) + 1;
            JPanel northPanel = new JPanel();
            northPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 8));
            northPanel.setBackground(northColor);
            yearSpinner = new JSpinner(new SpinnerNumberModel(currentYear, startYear, lastYear, 1));
            yearSpinner.setEditor(new JSpinner.NumberEditor(yearSpinner, "####"));
            yearSpinner.setPreferredSize(new Dimension(60, 25));
            yearSpinner.addChangeListener(new ChangeListener() {
                public void stateChanged(ChangeEvent e) {
                    updateDate(Calendar.YEAR, (Integer) yearSpinner.getValue());
                }
            });
            northPanel.add(yearSpinner);
            JLabel yearLabel = new JLabel("年");
            yearLabel.setForeground(labelColor);
            yearLabel.setFont(labelFont);
            northPanel.add(yearLabel);
            northPanel.add(Box.createHorizontalStrut(15));
            monthSpinner = new JSpinner(new SpinnerNumberModel(currentMonth, 1, 12, 1));
            monthSpinner.setEditor(new JSpinner.NumberEditor(monthSpinner, "##"));
            monthSpinner.setPreferredSize(new Dimension(60, 25));
            monthSpinner.addChangeListener(new ChangeListener() {
                public void stateChanged(ChangeEvent e) {
                    updateDate(Calendar.MONTH, (Integer) monthSpinner.getValue() - 1);
                }
            });
            northPanel.add(monthSpinner);
            JLabel monthLabel = new JLabel("月");
            monthLabel.setForeground(labelColor);
            monthLabel.setFont(labelFont);
            northPanel.add(monthLabel);
            return northPanel;
        }
        private JPanel createCenterPanal() {
            JPanel centerPanel = new JPanel();
            centerPanel.setFont(new Font("微软雅黑", Font.PLAIN, 13));
            centerPanel.setLayout(new GridLayout(7, 7));
            centerPanel.setBackground(Color.WHITE);
            for (int i = 0; i < 7; i++) {
                RolloverBackgroundButton cell = new RolloverBackgroundButton(weekStrings[i]);
                cell.clearDefaultAttribute();
                cell.setHorizontalAlignment(JLabel.RIGHT);
                cell.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                cell.setNormalForeground(weekLabelColor);
                centerPanel.add(cell);
            }
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 7; j++) {
                    final RolloverBackgroundButton numberButton = new RolloverBackgroundButton("");
                    numberButton.clearDefaultAttribute();
                    numberButton.setHorizontalAlignment(SwingConstants.RIGHT);
                    numberButton.setNormalForeground(dateFontColor);
                    numberButton.setSelectedForeground(selectedColor);
                    numberButton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            if (numberButton.getText().length() == 0) {
                                return;
                            }
                            selectedDay = numberButton.getText();
                            updateDate(Calendar.DAY_OF_MONTH, Integer.parseInt(numberButton.getText()));
                            ComponentTool.clearButtonGroupSelected(buttonGroup);
                            numberButton.setSelected(true);
                            ComponentTool.updateButtonSelectedForeground(buttonGroup, selectedColor);
                        }
                    });
                    if (j == 0 || j == 6) {
                        numberButton.setNormalForeground(weekendFontColor);
                    } else {
                        numberButton.setNormalForeground(dateFontColor);
                    }
                    dayButtons[i][j] = numberButton;
                    centerPanel.add(numberButton);
                    buttonGroup.add(numberButton);
                }
            }
            return centerPanel;
        }
        private JPanel createSouthPanel() {
            JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 2));
            southPanel.setOpaque(false);
            JButton todayButton = new RolloverBackgroundButton("今天");
            todayButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    today();
                }
            });
            southPanel.add(todayButton);
            JButton cancelButton = new RolloverBackgroundButton("取消");
            cancelButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    cancel();
                }
            });
            southPanel.add(cancelButton);
            JButton confirmButton = new RolloverBackgroundButton("确定");
            confirmButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    confirm();
                }
            });
            southPanel.add(confirmButton);

            return southPanel;
        }
        public String showDateDialog(Window owner, Point dialogPoint) {
            return showDateDialog(owner, dialogPoint, new Dimension(400, 250));
        }
        public String showDateDialog(Window owner, Point dialogPoint, Dimension size) {
            if (dialog == null) {
                dialog = createDialog(owner, size);
            }
            dialog.setLocationRelativeTo(owner);
            if (dialogPoint != null) {
                dialog.setLocation(dialogPoint);
            }
            updateDayButtonsText();
            dialog.setVisible(true);
            return getDateText();
        }
        protected JDialog createDialog(Window owner, Dimension size) {
            JDialog dialog = new JDialog(owner, "日期时间选择") {
                public void setVisible(boolean b) {
                    if (b) {
                        isConfirm = false;
                    }
                    super.setVisible(b);
                }
            };
            dialog.setModal(true);
            dialog.setSize(size);
            dialog.setContentPane(this);
            dialog.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    cancel();
                }
            });
            return dialog;
        }
        protected void cancel() {
            isConfirm = false;
            dialog.setVisible(false);
        }
        protected void today() {
            date = new Date();
            Calendar c = getCalendar();
            yearSpinner.setValue(c.get(Calendar.YEAR));
            monthSpinner.setValue(c.get(Calendar.MONTH) + 1);
            selectedDay = c.get(Calendar.DAY_OF_MONTH) + "";
            setDate(c.getTime());
            updateDayButtonsText();
        }
        protected void confirm() {
            isConfirm = true;
            dialog.setVisible(false);
        }
        protected void updateDate(int type, int value) {
            Calendar c = getCalendar();
            if (type == Calendar.MONTH) {
                int day = c.get(Calendar.DAY_OF_MONTH);
                c.set(Calendar.DAY_OF_MONTH, 1);
                c.set(type, value);
                int maxMonth_to = c.getActualMaximum(Calendar.DAY_OF_MONTH);
                if (Integer.parseInt(selectedDay) <= maxMonth_to) {
                    c.set(Calendar.DAY_OF_MONTH, day);
                } else {
                    selectedDay = "1";
                }
            } else {
                c.set(type, value);
            }
            setDate(c.getTime());
            if (type != Calendar.DAY_OF_MONTH) {
                updateDayButtonsText();
            }
        }
        protected void updateDayButtonsText() {
            Calendar c = getCalendar();
            c.set(Calendar.DAY_OF_MONTH, 1);
            int maxDayNo = c.getActualMaximum(Calendar.DAY_OF_MONTH);
            int dayNo = 2 - c.get(Calendar.DAY_OF_WEEK);
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 7; j++) {
                    String s = "";
                    if (dayNo >= 1 && dayNo <= maxDayNo) {
                        s = String.valueOf(dayNo);
                    }
                    dayButtons[i][j].setText(s);
                    if (s.equals(selectedDay)) {
                        ComponentTool.clearButtonGroupSelected(buttonGroup);
                        dayButtons[i][j].setSelected(true);
                        ComponentTool.updateButtonSelectedForeground(buttonGroup, selectedColor);
                    }
                    dayNo++;
                }
            }
        }
        protected Calendar getCalendar() {
            Calendar result = Calendar.getInstance();
            result.setTime(getDate());
            return result;
        }
        public static class ComponentTool {
            public static void updateButtonSelectedForeground(ButtonGroup buttonGroup, Color selectedColor) {
                for (Enumeration<AbstractButton> enumBtn = buttonGroup.getElements(); enumBtn.hasMoreElements();) {
                    RolloverBackgroundButton button = (RolloverBackgroundButton) enumBtn.nextElement();
                    if (!button.isSelected()) {
                        button.setSelectedForeground(null);
                    } else {
                        button.setSelectedForeground(selectedColor);
                    }
                    button.repaint();
                }
            }
            public static void clearButtonGroupSelected(ButtonGroup buttonGroup) {
                for (Enumeration<AbstractButton> button = buttonGroup.getElements(); button.hasMoreElements();) {
                    button.nextElement().setSelected(false);
                }
            }
        }
        public static class RolloverBackgroundButton extends JButton {
            protected Color normalBackground;
            protected Color pressedBackground;
            protected Color rolloverBackground;
            protected Color selectedBackground;
            protected Color normalBorderColor;
            protected Color pressedBorderColor;
            protected Color rolloverBorderColor;
            protected Color selectedBorderColor;
            protected Color normalForeground;
            protected Color pressedForeground;
            protected Color rolloverForeground;
            protected Color selectedForeground;
            {
                initRolloverButton();
            }
            public RolloverBackgroundButton(String text) {
                super(text);
            }
            private void initRolloverButton() {
                setRolloverEnabled(true);
                setBorderPainted(false);
                setContentAreaFilled(false);
                setFocusPainted(false);
                setFont(new Font(Font.DIALOG, Font.PLAIN, 14));
                setNormalBackground(new Color(215, 216, 216));
                setPressedBackground(new Color(215, 216, 216, 100));
                setNormalBorderColor(new Color(174, 173, 174));
                setRolloverBorderColor(new Color(95, 205, 245));
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void paint(Graphics g) {
                Graphics2D ccs = (Graphics2D) g;
                ccs.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                Paint oldPaint = ccs.getPaint();
                if (isSelected() && selectedBackground != null) {
                    ccs.setPaint(selectedBackground);
                    ccs.fillRect(0, 0, getWidth(), getHeight());
                } else if (getModel().isPressed() && pressedBackground != null) {
                    ccs.setPaint(pressedBackground);
                    ccs.fillRect(0, 0, getWidth(), getHeight());
                } else if (getModel().isRollover() && rolloverBackground != null) {
                    ccs.setPaint(rolloverBackground);
                    ccs.fillRect(0, 0, getWidth(), getHeight());
                } else if (normalBackground != null) {
                    ccs.setPaint(normalBackground);
                    ccs.fillRect(0, 0, getWidth(), getHeight());
                }
                ccs.setPaint(oldPaint);
                if (isSelected() && selectedForeground != null) {
                    setForeground(selectedForeground);
                } else if (getModel().isPressed() && pressedForeground != null) {
                    setForeground(pressedForeground);
                } else if (getModel().isRollover() && rolloverForeground != null) {
                    setForeground(rolloverForeground);
                } else if (normalForeground != null) {
                    setForeground(normalForeground);
                }
                super.paint(ccs);
                if (isSelected() && selectedBorderColor != null) {
                    ccs.setPaint(selectedBorderColor);
                    ccs.drawRect(0, 0, getWidth() - 1, getHeight() - 1);// 边框
                } else if (getModel().isPressed() && pressedBorderColor != null) {// 鼠标按下时
                    ccs.setPaint(pressedBorderColor);
                    ccs.drawRect(0, 0, getWidth() - 1, getHeight() - 1);// 边框
                } else if (getModel().isRollover() && rolloverBorderColor != null) {// 鼠标悬浮时
                    ccs.setPaint(rolloverBorderColor);
                    ccs.drawRect(0, 0, getWidth() - 1, getHeight() - 1);// 边框
                } else if (normalBorderColor != null) {// 默认无状态时
                    ccs.setPaint(normalBorderColor);
                    ccs.drawRect(0, 0, getWidth() - 1, getHeight() - 1);// 边框
                }
                ccs.setPaint(oldPaint);
            }
            public void clearDefaultAttribute() {
                setNormalBackground(null);
                setPressedBackground(null);
                setNormalBorderColor(null);
                setRolloverBorderColor(null);
            }
            public void setNormalBackground(Color normalBackground) { this.normalBackground = normalBackground; }
            public void setPressedBackground(Color pressedBackground) { this.pressedBackground = pressedBackground; }
            public void setNormalBorderColor(Color normalBorderColor) { this.normalBorderColor = normalBorderColor; }
            public void setRolloverBorderColor(Color rolloverBorderColor) { this.rolloverBorderColor = rolloverBorderColor; }
            public void setNormalForeground(Color normalForeground) { this.normalForeground = normalForeground; }
            public void setSelectedForeground(Color selectedForeground) { this.selectedForeground = selectedForeground; }
        }
}
