package app.views;

import app.costumers.models.Costumer;
import app.costumers.services.CostumerService;

import java.util.Scanner;

public class ViewLogin {
    private Scanner scanner;
    private CostumerService costumerService;


    public ViewLogin() {
        scanner=new Scanner(System.in);
        costumerService= new CostumerService();
        this.play1();
    }
    private void meniu(){
        System.out.println("Apasati tasta 1 pentru login");
        System.out.println("Apasati tasta 1 pentru inregistrare");
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

        Costumer costumer= this.costumerService.getCostumerByNameAndPassword(name,password);
        if(costumer==null){
            System.out.println("Incorrect name/password");
        }
        else{
            View view =new View(costumer);
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

        Costumer costumer=new Costumer(adress,password,name,billingAdress);
        costumer.setId(costumerService.generateId());
        costumerService.saveCostumers();
        View view=new View(costumer);

    }




}