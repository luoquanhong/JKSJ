import org.h2.jdbcx.JdbcConnectionPool;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
public class SpringAndJdbcTest {


    ApplicationContext applicationContext = null;

    @Before
    public void setUp(){
        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @Test
    public void testH2DataBase(){
        JdbcConnectionPool bean = applicationContext.getBean(JdbcConnectionPool.class);
        try {
            Connection connection = bean.getConnection();
            System.out.println(connection.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
