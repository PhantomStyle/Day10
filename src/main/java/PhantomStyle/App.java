package PhantomStyle;

import PhantomStyle.dao.PersonDao;
import PhantomStyle.dao.PersonService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
        PersonDao bean = applicationContext.getBean(PersonDao.class);
        System.out.println(bean.findAll());
    }
}
