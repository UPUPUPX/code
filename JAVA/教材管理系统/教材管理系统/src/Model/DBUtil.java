package Model;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
    private static DataSource ds;
    private static Connection conn;
    static {
        try {
            Properties pro = new Properties();
            InputStream is = DBUtil.class.getResourceAsStream("/sqlite.properties");
            pro.load(is);
            ds = BasicDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConn() throws SQLException {

        if (conn == null || conn.isClosed()) {
            conn = ds.getConnection();
        }
        return conn;
    }
    public static void closeConn() throws SQLException {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } finally {
            conn = null;
        }
    }
    private DBUtil() {
    }
}
