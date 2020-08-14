package Service;


import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.*;
import java.io.IOException;

/**
 * @ClassName Monitoe
 * @Description TODO
 * @Author 孙浩瑞
 * @Date 2020/8/14 16:16
 */
class ClipboardMonitor implements ClipboardOwner{

    private Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

    public ClipboardMonitor(){
        if (clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)){
            clipboard.setContents(clipboard.getContents(null), this);
        }
    }

    @Override
    public void lostOwnership(Clipboard clipboard, Transferable contents) {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String str = null;
        if (clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)){
            try {
                str = (String)clipboard.getData(DataFlavor.stringFlavor);
            } catch (UnsupportedFlavorException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        StringSelection tmp = new StringSelection(str);
        clipboard.setContents(tmp, this);
    }
}
