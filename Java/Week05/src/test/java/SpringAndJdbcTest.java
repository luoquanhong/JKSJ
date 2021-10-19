import com.config.javaconfig.javaConfig;
import com.dataBaseUtils.JDBCUtils;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.*;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {javaConfig.class})
public class SpringAndJdbcTest {


    ApplicationContext applicationContext = null;

    @Autowired
    private Connection connection;

    @Autowired
    private HikariDataSource hikariDataSource;

    @Autowired
    private JDBCUtils jdbcUtils;

    @Before
    public void setUp() {
//        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        applicationContext = new AnnotationConfigApplicationContext(javaConfig.class);
    }

    /**
     * 使用Hikar连接池去连接mysql
     */
    @Test
    public void testQueryDataFromJHikariDataSource() {
        String result = null;
        try {
            result = jdbcUtils.queryDataDeleteSomeFormat(hikariDataSource.getConnection(), "select * from SC;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("the result is: " + result);
    }

    /**
     * 使用原生jdbc接口连接池去连接mysql查询
     */
    @Test
    public void testQueryDataFromJDBC() {
        String result = jdbcUtils.queryDataDeleteSomeFormat(connection, "select * from SC;");
        System.out.println("the result is: " + result);
    }

    /**
     * 使用原生jdbc接口连接池去添加数据
     */
    @Test
    public void testCreateDataFromJDBC() {
        int result = 0;
        try {
            result = jdbcUtils.executeSql(connection, "INSERT INTO SC (Sno, Cno, grade) VALUES (\"666759\",\"C103\",7123)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("the result is: " + result);
    }

    /**
     * 使用原生jdbc接口连接池去更新数据
     */
    @Test
    public void testUpdateDataFromJDBC() {
        int result = 0;
        result = jdbcUtils.executeSqlWithCommitTransaction(connection, "UPDATE SC SET grade=1900 WHERE Cno=\"A01\"");
        System.out.println("the result is: " + result);
    }

    /**
     * 使用原生jdbc接口连接池去批处理数据
     */
    @Test
    public void testUpdateDataFromJDBCWithBatch() {
        List<String> sqlList = Arrays.asList("UPDATE SC SET grade=1520 WHERE Cno=\"A01\"", "UPDATE SC SET grade=120 WHERE Cno=\"C100\"");
        int result[] = new int[sqlList.size()];
        try {
            result = jdbcUtils.executeSqlWithBatch(connection, sqlList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("the result is: " + Arrays.toString(result));
    }
}
