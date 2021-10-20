import com.Application;
import com.service.SCService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class SpringMybatisTest {


    @Autowired
    private SCService service;

    @Test
    public void testMyBatis_QueryData_SC(){
        System.out.println(String.format("the result is: %s", service.queryAllData()));
    }
}
