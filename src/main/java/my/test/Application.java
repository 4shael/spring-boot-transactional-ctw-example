package my.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(exclude = TransactionAutoConfiguration.class)
@EnableTransactionManagement(mode = AdviceMode.ASPECTJ)
public class Application {

    private final UserService userService;

    @Autowired
    public Application(UserService userService) {
        this.userService = userService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return (args -> {
            User user = new User();
            //user.setId(10);
            user.setLogin("usss");
            user.setPassword("passss");
            userService.save(user);
        });
    }
}
