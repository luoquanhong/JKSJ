import com.config.LoadBeanFromAnnotation;
import com.config.javaconfig.LoadBeanFromJavaConfig;
import com.config.LoadBeanFromXmlFiles;
import com.config.javaconfig.javaConfig;
import com.pojo.CityInfo;
import com.pojo.Fruit;
import com.pojo.PeopleInfo;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanLoadTest {

    ApplicationContext applicationContext = null;


    /**
     * 通过加载xml配置文件方式来获取bean
     */
    @Test
    public void testCase_LoadSpringBeanFromXml() {
        LoadBeanFromXmlFiles loadBeanFromXmlFiles = new LoadBeanFromXmlFiles();
        applicationContext = loadBeanFromXmlFiles.loadBeanFromXmlFiles("applicationContext.xml");
        Fruit fruit = applicationContext.getBean(Fruit.class);
        fruit.setFruitWeight(200);
        fruit.setFruitName("apple");
        fruit.setFruitCountry("USA");
        fruit.setFruitPrice(20);
        System.out.println(fruit);
    }

    /**
     * 通过扫描@Component注解来加载Bean
     */
    @Test
    public void testCase_LoadSpringBeanFromAnnotation() {
        LoadBeanFromAnnotation loadBeanFromAnnotation = new LoadBeanFromAnnotation();
        applicationContext = loadBeanFromAnnotation.loadBeanFromXmlAnnotation("com");
        PeopleInfo peopleInfo = applicationContext.getBean(PeopleInfo.class);
        peopleInfo.setPeopleAge(12);
        peopleInfo.setPeopleName("Mike");
        peopleInfo.setPeopleCountry("China");
        System.out.println(peopleInfo);
    }

    /**
     * 通过识别注解:@Configuration和@Bean注解来加载Bean
     */
    @Test
    public void testCase_LoadSpringBeanFromJavaConfig() {
        applicationContext = new AnnotationConfigApplicationContext(LoadBeanFromJavaConfig.class);
        CityInfo cityInfo = applicationContext.getBean(CityInfo.class);
        System.out.println(cityInfo);
    }

    /**
     * 通过加载多个@Configuration和文件以及@Bean的期别名来加载
     */
    @Test
    public void testCase_LoadSpringBeanFromMoreJavaConfig() {
        applicationContext = new AnnotationConfigApplicationContext(javaConfig.class);
        CityInfo cityInfo = applicationContext.getBean("cityHangzhou", CityInfo.class);
        System.out.println(cityInfo);
    }
}
