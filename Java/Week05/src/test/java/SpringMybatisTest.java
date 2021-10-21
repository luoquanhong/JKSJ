import com.Application;
import com.entity.Student;
import com.service.SCService;
import com.service.StudentService;
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

    @Autowired
    private StudentService studentService;

    @Test
    public void testMyBatis_QueryData_SC(){
        System.out.println(String.format("the result is: %s", service.queryAllData()));
    }

    @Test
    public void testMyBatis_QueryData_Student_ResultToJson(){
        System.out.println(String.format("the result is: %s", studentService.queryAllDataToJson()));
    }

    @Test
    public void testMyBatis_QueryData_Student(){
        System.out.println(String.format("the result is: %s", studentService.queryAllData()));
    }

    @Test
    public void testMyBatis_CreateData_Student(){
        Student student = Student.builder().age(12).sex("男").Sname("帅哥二号").dept("心理学系").Sno("9521899").build();
        System.out.println(String.format("the result is: %s", studentService.createDataToStudentTable(student)));
    }
}
