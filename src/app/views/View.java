package app.views;

import app.orderDetails.models.OrderDetail;
import app.orders.models.Order;
import app.users.models.User;
import app.users.services.UserService;
import app.orderDetails.services.OrderDetailsService;
import app.orders.services.OrderService;
import app.products.models.Product;
import app.products.services.ProductService;
import app.system.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class View {
    private Scanner scanner;
    private UserService userService;
    private ProductService productService;
    private OrderService orderService;
    private OrderDetailsService orderDetailsService;
    private User user;
    private Cart cart;


    public View(User user1) {
        scanner = new Scanner(System.in);
        userService = new UserService();
        productService = new ProductService();
        orderService = new OrderService();
        orderDetailsService = new OrderDetailsService();
        cart= new Cart();
        user = user1;
        this.play();
    }


    private void meniu() {
        System.out.println("1.Products");
        System.out.println("2.Orders IDS");
        System.out.println("3.Afisati detaliile comenzii");
        System.out.println("4.Adaugare produs in cos");
        System.out.println("5.Vizualizare cos");
        System.out.println("6.Editare cantitate produs");
        System.out.println("7.Eliminare produs");
        System.out.println("8.Trimitere comanda");
        System.out.println("9.Anulare comanda");
        System.out.println("10.Editare comanda");

        //actiuni pe comenzi
        //trimitere comanda
        //anulare comanda
        //editare comanda
        //statistica
        //cel mai cumparat produs de el
    }

    public void play() {
        boolean run = true;
        while (run) {
            meniu();
            int option = Integer.parseInt(scanner.nextLine());
            switch (option) {

                case 1:
                    this.showProducts();
                    break;
                case 2:
                    this.showOrders();
                    break;
                case 3:
                    this.showDetalis();
                    break;
                case 4:
                    this.addInCart();
                    break;
                case 5:
                    this.showCart();
                    break;
                case 6:
                    this.editCart();
                    break;
                case 7:
                    this.deleteCartItem();
                    break;
                default:
                    System.out.println("invalid choice");

            }
        }
    }


    public void showProducts() {
        this.productService.showProducts();
    }


    public void showOrders() {
        List<Order> orders = this.orderService.getOrderByUserId(user.getId());
        for (Order order : orders) {
            System.out.println("id-ul comenzii:" + order.getId() + "cu suma:" + order.getAmount());
        }
    }


    public void showDetalis(){
        System.out.println("id-ul comenzii pentru detalii:");
        int orderId =Integer.parseInt(scanner.nextLine());
        List<OrderDetail> orderDetails= this.orderDetailsService.getOrderDetailsByOrderId(orderId);

        for(OrderDetail orderDetail: orderDetails){
            System.out.println(productService.getProductById(orderDetail.getProductId()).getName());
            System.out.println("Pretul per product:"+orderDetail.getPrice()+"\n"+ "Numar produse:" +orderDetail.getQuantity());
        }
    }


    public void showCart(){this.cart.showCart();}


    public void addInCart() {

        productService.showProducts();
        System.out.println("Alegeti produsul(numele):");
        String name = scanner.nextLine();
        Product product= productService.getProductByName(name);
        if(product!=null){
            System.out.println("Introduceti cantitatea");
            int cantity = Integer.parseInt(scanner.nextLine());
            cart.addItem(productService.getProductByName(name),cantity);
        }
    }


    public void editCart(){
        showCart();
        System.out.println("Nume produs pe care vreti sa il modificati:");
        String name=scanner.nextLine();
        CartItem cartItem1= cart.getCartItemByProductName(name);
            System.out.println("Introduceti cantitatea:");
            int cantity=Integer.parseInt(scanner.nextLine());
            cart.editCartItem(cantity);
    }


    public void deleteCartItem(){
        showCart();
        System.out.println("Nume produs pe care vreti sa il stergeti");
        String name=scanner.nextLine();
        cart.deleteCartItemByName(name);
        System.out.println("Articolul a fost sters");
    }




}
