import com.pojo.CityInfo;
import com.pojo.Student;
import com.starter.CustomStarter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {CustomStarter.class})
public class CustomStarterTest {

    @Autowired
    private Student student;

    @Test
    public void testCase_CustomStarter_Case01(){
        student.setName("Mike");
        student.setId(2021);
        student.setBeanName("testCase_CustomStarter_Case01");
        System.out.println(student);
    }

}
