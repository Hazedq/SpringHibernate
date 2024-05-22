package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.persistence.NoResultException;
import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        User user1 = new User("Gaara", "in the desert", "gaara@tail.com");
        User user2 = new User("Killer", "Bee", "killer@tail.com");
        User user3 = new User("Naruto", "Uzumaki", "naruto@tail.com");
        User user4 = new User("Ricudou", "Sennin", "ricudou@tail.com");

        Car car1 = new Car("Shukaku", 1);
        Car car2 = new Car("Hachibi", 8);
        Car car3 = new Car("Kurama", 9);
        Car car4 = new Car("Monstr", 10);

        userService.add(user1.setCar(car1).setUser(user1));
        userService.add(user2.setCar(car2).setUser(user2));
        userService.add(user3.setCar(car3).setUser(user3));
        userService.add(user4.setCar(car4).setUser(user4));

        System.out.println(userService.getUserByCar("Shukaku", 1));
        System.out.println(userService.getUserByCar("Hachibi", 8));
        System.out.println(userService.getUserByCar("Kurama", 9));
        System.out.println(userService.getUserByCar("Monstr", 10));

        context.close();
    }

}
