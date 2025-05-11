package app.views;

import app.users.models.User;
import app.users.services.UserService;

import java.util.Scanner;

public class ViewLogin {
    private Scanner scanner;
    private UserService userService;


    public ViewLogin() {
        scanner=new Scanner(System.in);
        userService = new UserService();
        this.play1();
    }
    private void meniu(){
        System.out.println("Apasati tasta 1 pentru login");
        System.out.println("Apasati tasta 2 pentru inregistrare");
    }

    public void play1(){
        boolean run=true;
        while (run){
            meniu();
            int option= Integer.parseInt(scanner.nextLine());
            switch (option){
                case 1:this.login();
                break;
                case 2:this.signIn();
                break;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    public void login(){
        System.out.println("Name:");
        String name= scanner.nextLine();
        System.out.println("Password:");
        String password= scanner.nextLine();

        User user = this.userService.getUserByNameAndPassword(name,password);
        if(user ==null){
            System.out.println("Incorrect name/password");
        }
        else{
            View view =new View(user);
        }
    }

    public void signIn(){
        System.out.println("adress:");
        String adress=scanner.nextLine();
        System.out.println("password:");
        String password=scanner.nextLine();
        System.out.println("name:");
        String name = scanner.nextLine();
        System.out.println("billing adress:");
        String billingAdress=scanner.nextLine();

        User user =new User(adress,password,name,billingAdress);
        user.setId(userService.generateId());
        userService.saveUsers();
        View view=new View(user);

    }




}