package GetContent;

import DataBaseOperator.DataOperator;


import java.awt.*;
import java.awt.datatransfer.*;
import java.io.IOException;

/**
 * @ClassName GetContentFromClipboard
 * @Description TODO
 * @Author 孙浩瑞
 * @Date 2020/8/13 15:42
 */
public class GetContentFromClipboard {

    public String getClipboard() {
        Clipboard sysClip = Toolkit.getDefaultToolkit().getSystemClipboard();
        /*
        获取剪切板中的内容
        */
        Transferable clipTf = sysClip.getContents(null);

        if (clipTf != null) {
            // 检查内容是否是文本类型
            if (clipTf.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                try {
                    String str=clipTf.toString();
                    DataOperator dataOperator=new DataOperator();
                    dataOperator.Insert(str);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
        return clipTf.toString();
    }

    /**
     * 将字符串复制到剪切板。
     */
    public void setSysClipboardText(String str) {
        Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable tText = new StringSelection(str);
        clip.setContents(tText, null);
    }

    /**
     * 从剪切板获得图片。
     */
    public Image getImageFromClipboard() throws Exception {
        Clipboard sysc = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable cc = sysc.getContents(null);
        if (cc == null)
            return null;
        else if (cc.isDataFlavorSupported(DataFlavor.imageFlavor))
            return (Image) cc.getTransferData(DataFlavor.imageFlavor);
        return null;
    }

    /**
     * 复制图片到剪切板。
     */
    public void setClipboardImage(final Image image) {
        Transferable trans = new Transferable() {
            public DataFlavor[] getTransferDataFlavors() {
                return new DataFlavor[] { DataFlavor.imageFlavor };
            }

            public boolean isDataFlavorSupported(DataFlavor flavor) {
                return DataFlavor.imageFlavor.equals(flavor);
            }

            public Object getTransferData(DataFlavor flavor)
                    throws UnsupportedFlavorException, IOException {
                if (isDataFlavorSupported(flavor))
                    return image;
                throw new UnsupportedFlavorException(flavor);
            }

        };
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(trans, null);
    }
}
