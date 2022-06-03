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

      userService.add(new User("Harry", "Potter", "mrPotter@hogwards.magic", new Car("Nimbus", 2000)));
      userService.add(new User("Ron", "Weasley", "Ron11@hogwards.magic", new Car("Comet", 140)));
      userService.add(new User("Draco", "Malfoy", "KingOfSlyzerin@hogwards.magic", new Car("Nimbus", 2001)));
      userService.add(new User("Oleg", "Tinkoff", "OlegTinkoff@mail.ru", new Car("Porshe", 911)));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Transport model = "+user.getCar().getModel()+" "+user.getCar().getSeries());
         System.out.println();
      }

      List<User> users1 = userService.getTrueUser("Nimbus", 2000);
      for (User user : users1) {
         System.out.println();
         System.out.print("User ");
         System.out.print(" Id = "+user.getId());
         System.out.print(" First Name = "+user.getFirstName());
         System.out.print(" Last Name = "+user.getLastName());
         System.out.print(" Email = "+user.getEmail());
         System.out.println(" use transport model = "+user.getCar().getModel()+" "+user.getCar().getSeries());
         System.out.println();
      }

      context.close();
   }
}
