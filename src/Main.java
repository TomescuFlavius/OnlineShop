import app.orders.models.StatusOrder;
import app.users.models.Admin;
import app.users.models.Client;
import app.users.models.Employee;
import app.users.models.User;
import app.users.services.UserService;
import app.views.ViewLogin;

import java.sql.SQLOutput;

import static app.users.models.UserTypes.ADMIN;
import static app.users.models.UserTypes.CLIENT;

public class Main {
    public static void main(String[] args) {

        ViewLogin viewLogin=new ViewLogin();
        viewLogin.play1();
//
//        Client client = new Client(1,"c","c","c","c","1");
//        Admin admin=new Admin(2,"a","a","a","a","a");
//        Employee employee=new Employee(3,"e","e","e","e",3);
//        UserService  userService=new UserService();
//
//
//        userService.addUser(client);
//        userService.addUser(admin);
//        userService.addUser(employee);
//
//
//        userService.saveUsers();
//        userService.showUser();





    }
}