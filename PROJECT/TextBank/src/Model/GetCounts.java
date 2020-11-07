package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @ClassName GetCounts
 * @Description TODO
 * @Author 孙浩瑞
 * @Date 2020/8/16 10:40
 */
public class GetCounts {
    public int getCount() {
        int count = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select count(*) from DataSource";
        try {
            Connection con=DBUtil.getConn();
            if (con!=null) {
                ps=con.prepareStatement(sql);
                rs=ps.executeQuery();
                if(rs.next()) {
                    count=rs.getInt(1);
                }
            }
        } catch (Exception e) { }
        return count;
    }
}
