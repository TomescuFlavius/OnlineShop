package app.orders.services;

import app.orders.models.Order;
import app.system.CartItem;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class OrderService {

    private File file;
    private List<Order> orders;

    public OrderService() {
        file = new File("C:\\mycode\\oop\\OnlineShop\\src\\app\\orders\\file\\orders.txt");
        orders = new ArrayList<Order>();
        this.loadOrders();

    }

    public void loadOrders() {
        try{
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Order order = new Order(line);
                orders.add(order);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveOrders(){
        try {
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(orders);
            printWriter.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String toSaveOrders(){
        String output="";
        int i;
        for(i=0;i<orders.size();i++){
            output += orders.get(i).toSaveOrder()+"\n";
        }
        return output+orders.get(i).toSaveOrder();
    }

    public Order getOrderById(int id){
        for(Order order:orders){
            if(order.getId()==id){
                return order;
            }
        }
        return null;
    }

    private int generateId() {
        Random random = new Random();
        int randomId = random.nextInt(1000) + 1;
        while (this.getOrderById(randomId) != null) {
            randomId = random.nextInt(1000) + 1;
        }
        return randomId;
    }

    public void showOrders(){
        for(Order order:orders){
            System.out.println(order);
        }
    }

    public List<Order> getOrderByUserId(int userId){
        List<Order> filteredOrders=      new ArrayList<>();
        for (Order order:orders){
            if(order.getCustomerId()==userId){
                filteredOrders.add(order);
            }
        }
        return filteredOrders;
    }



}
