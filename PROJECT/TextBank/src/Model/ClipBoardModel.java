package Model;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;

/**
 * @ClassName lip
 * @Description TODO
 * @Author 孙浩瑞
 * @Date 2020/8/15 15:49
 */
public class ClipBoardModel {

    public void setSysClipboardText(String writeMe) {
        Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable tText = new StringSelection(writeMe);
        clip.setContents(tText, null);
        JOptionPane.showMessageDialog(null, "已复制到剪切板");
    }
}
