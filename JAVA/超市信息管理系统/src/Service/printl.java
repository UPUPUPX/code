package Service;
import DAO.shopList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

public class printl {
    public printl(LinkedList<shopList> list) throws IOException{
        String path = "d:\\bill.txt";
        File file = new File(path);
        if(file.exists()){
            file.getParentFile().delete();
            file.getParentFile().mkdirs();
        }
        file.createNewFile();
        // write
        FileWriter fw = new FileWriter(file, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("#######欢迎光临#######"+System.getProperty( "line.separator" ));

        for (int i=0; i<list.size(); i++) {
            shopList shopList=list.get(i);
            bw.write("商品:"+shopList.getName()+shopList.getCount()+"个(件)"+"单价:"+shopList.getPrice()+"元"+System.getProperty( "line.separator" ));
            //bw.write(+shopList.getCount()+System.getProperty( "line.separator" ));
            //bw.write("商品价格:"+shopList.getPrice()+System.getProperty( "line.separator" ));
        }
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        bw.write(formatter.format(date)+System.getProperty( "line.separator" ));
        bw.write("******************************************"+System.getProperty( "line.separator" ));
        bw.flush();
        bw.close();
        fw.close();
       /* // read
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String str = br.readLine();
        System.out.println(str);*/
    }
}
