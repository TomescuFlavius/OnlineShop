package app.views;

import app.costumers.models.Costumer;
import app.costumers.services.CostumerService;
import app.orderDetails.services.OrderDetailsService;
import app.orders.services.OrderService;
import app.products.models.Product;
import app.products.services.ProductService;

import java.util.Scanner;

public class View
{
    private Scanner scanner;
    private CostumerService costumerService;
    private ProductService productService;
    private OrderService orderService;
    private OrderDetailsService orderDetailsService;
    private Costumer costumer;
    private Product product;

    public View(Costumer costumer1){
        scanner=new Scanner(System.in);
        costumerService=new CostumerService();
        productService= new ProductService();
        orderService = new OrderService();
        orderDetailsService= new OrderDetailsService();
        costumer=costumer1;
        this.play();
    }


    private void meniu(){
        System.out.println("1.");
        System.out.println("2.");
    }

    public void play(){
        boolean run=true;
        while (run){
            meniu();
            int option = scanner.nextInt();
            switch (option){

                case 1:
                    System.out.println("");
                    break;

                default:
                    System.out.println("invalid choice");

            }
        }
    }



}
