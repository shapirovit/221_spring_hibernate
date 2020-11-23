package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

//      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
//      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
//      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
//      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

//      Car car1 = new Car("BMV", 312);
//      Car car2 = new Car("Reno", 6);
//      Car car3 = new Car("Audi", 8);
//      userService.add(new User("User5", "Lastname5", "user5@mail.ru", car1));
//      userService.add(new User("User6", "Lastname6", "user6@mail.ru", car2));
//      userService.add(new User("User555", "Lastname555", "user555@mail.ru", car3));

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println(user.getCar() == null ? "hasn't car" : user.getCar().getModel() + " " + user.getCar().getSeries());
            System.out.println();
        }

        User user11 = userService.getUserByCar("Reno", 6);
        System.out.println(user11.getFirstName() + " have " + user11.getCar().getModel() + " " + user11.getCar().getSeries());

        User user12 = userService.getUserByCar("Audi", 8);
        System.out.println(user12.getFirstName() + " have " + user12.getCar().getModel() + " " + user12.getCar().getSeries());

        context.close();
    }
}
