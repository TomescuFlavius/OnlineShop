package app.views;

import app.users.models.User;
import app.users.models.UserTypes;
import app.users.services.UserService;

import java.util.Scanner;
//todo:imbunatatire clase cu mostenire si polimorfism!!!


public class ViewLogin {
    private Scanner scanner;
    private UserService userService;
    private UserTypes userType;


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
        System.out.println("ADMIN/EMPLOYEE/CLIENT");
        UserTypes userTypes=UserTypes.valueOf(scanner.nextLine());




        User user = this.userService.getUserByNameAndPassword(name,password);
        if(user ==null){
            System.out.println("Incorrect name/password");
        }
        else if(user.getType()==UserTypes.ADMIN){
            ViewAdmin view =new ViewAdmin(user);
        }
        else if (user.getType()==UserTypes.CLIENT){
            ViewClient viewClient=new ViewClient(user);
        }
        else if(user.getType()==UserTypes.EMPLOYEE){
            ViewEmployee viewEmployee=new ViewEmployee(user);
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
        System.out.println("ADMIN/EMPLOYEE/CLIENT");
        UserTypes userType=UserTypes.valueOf(scanner.nextLine());


        User user =new User(adress,password,name,billingAdress,userType);
        user.setId(userService.generateId());
        userService.saveUsers();
        if(user.getType()==UserTypes.ADMIN){
            ViewAdmin viewAdmin =new ViewAdmin(user);
        }
        else if (user.getType()==UserTypes.CLIENT){
            ViewClient viewClient=new ViewClient(user);
        }
        else if(user.getType()==UserTypes.EMPLOYEE){
            ViewEmployee viewEmployee=new ViewEmployee(user);
        }


    }




}