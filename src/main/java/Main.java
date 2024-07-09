import config.AppConfiguration;
import model.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.UserService;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        var applicationContext = new AnnotationConfigApplicationContext(AppConfiguration.class);
        UserService userService = applicationContext.getBean(UserService.class);

        userService.save(User.builder()
                .name("test")
                .createdAt(LocalDate.now())
                .build());
    }
}
