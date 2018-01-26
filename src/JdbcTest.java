import java.math.BigDecimal;
import java.sql.*;

/**
 * Created by Haorenpu on 24/01/2018.
 */
public class JdbcTest {

    private final static String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private final static String URL = "jdbc:sqlserver://192.168.101.243:1433;DatabaseName=CherryBrand_MGP;useLOBs=false";
    private static final String USER="sa";
    private static final String PASSWORD="sa";

    public static void insert(BigDecimal www) {
        Connection conn = null;
        try {

            // 加载mysql驱动程序
            Class.forName(DRIVER);
            // 连接localhost上的mysql,并指定使用test数据库，用户名为root,密码为***
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            if (!conn.isClosed()) {
                System.out.println("数据库连接成功！"); //验证是否连接成功
            }

            String sql = "insert into dbo.HRP_TEST (Quantity) VALUES (?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setBigDecimal(1, www);
            ps.execute();

            //输出结果集（类似.net中的DataSet/DataTable）
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    conn = null;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
