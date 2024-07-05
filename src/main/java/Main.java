import config.AppConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.UserService;

public class Main {

    public static void main(String[] args) {
        var applicationContext = new AnnotationConfigApplicationContext(AppConfiguration.class);
        UserService userService = applicationContext.getBean(UserService.class);

        System.out.println(userService.findById(2L));
    }
}
