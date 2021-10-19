import com.alibaba.druid.pool.DruidDataSource;
import com.config.javaconfig.javaConfig;
import com.dataBaseUtils.JDBCUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import java.sql.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {javaConfig.class})
public class SpringAndJdbcTest {


    ApplicationContext applicationContext = null;

    @Before
    public void setUp() {
//        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        applicationContext = new AnnotationConfigApplicationContext(javaConfig.class);
    }

    @Autowired
    private DruidDataSource druidDataSource;

    @Autowired
    private JDBCUtils jdbcUtils;

    @Test
    public void testQueryDataFromJDBC() {
        try {
            Connection connection = druidDataSource.getConnection();
            String result = jdbcUtils.queryDataDeleteSomeFormat(connection, "select * from SC;");
            System.out.println("the result is: " + result);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
