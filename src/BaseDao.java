import org.apache.log4j.Logger;

import java.io.InputStream;
import java.sql.*;
import java.util.List;
import java.util.Properties;


/*工具类:抽取重用的代码*/
public abstract class BaseDao<T> {
    public static Logger logger = Logger.getLogger(String.valueOf(BaseDao.class));
    public static Connection conn = null;
    public static PreparedStatement pst = null;
    public ResultSet rs = null;
    public static Properties ps = null;


    static {//静态块，只会执行一次
        InputStream inputStream = BaseDao.class.getResourceAsStream("/db.properties");
        try {
            ps.load(inputStream);
            //获取配置文件里的属性
            String driver = ps.getProperty("jdbc.driver");
            String url = ps.getProperty("jdbc.url");
            String username = ps.getProperty("jdbc.username");
            String password = ps.getProperty("jdbc.password");
            Class.forName(driver);
            conn = DriverManager.getConnection(url,username,password);

            logger.debug("creat connection success ,conn variable is:" + conn);
            System.out.println("123");
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            ps.clear();
        }

    }
    // 2.回收资源
    public static void releaseResource(ResultSet rs,Statement st ,Connection conn) {
        try {
            if(rs!=null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(st!=null) {
                st.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(conn!=null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //3.抽取一个通用的增删改
    public static int  update(String sql ,Object...params) {//可变参数
//        getConn();
        try {
            pst = conn.prepareStatement(sql);
            //占位符赋值
            for(int i=0;i<params.length;i++) {
                pst.setObject((i+1), params[i]);
            }
            int result  = pst.executeUpdate();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            releaseResource(null,pst,conn);
        }
        return -1;
    }


    //4.抽取一个通用的查询
public List<T> query(String sql,Object...params) {//可变参数
    try {
        pst = conn.prepareStatement(sql);
        //占位符赋值
        for (int i= 0;params !=null&&i<params.length;i++) {
            pst.setObject((i+1),params[i]);
        }
        rs = pst.executeQuery();
        List<T> result = handlerResultSet(rs);
        return result;
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        releaseResource(rs,pst,conn);
    }
    return null;
}
public abstract List<T> handlerResultSet(ResultSet rs2);

    public static void main(String[] args) {

    }
}



