package app.orderDetails.services;

import app.orderDetails.models.OrderDetail;
import app.orders.models.Order;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderDetailsService {
    private File orderDetailsFile;
    private List<OrderDetail> orderDetails;

    public OrderDetailsService() {
        this.orderDetailsFile=new File("C:\\mycode\\oop\\OnlineShop\\src\\app\\orderDetails\\file\\orderDetails.txt");
        this.orderDetails=new ArrayList<>();
        this.loadOrderDetails();
    }

    public void loadOrderDetails() {
        try{
            Scanner scanner=new Scanner(orderDetailsFile);
            while(scanner.hasNextLine()) {
                String line=scanner.nextLine();
                OrderDetail orderDetail=new OrderDetail(line);
                orderDetails.add(orderDetail);

            }

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveOrderDetails() {
        try {
            FileWriter fileWriter=new FileWriter(orderDetailsFile);
            PrintWriter printWriter=new PrintWriter(fileWriter);
            printWriter.println(toSaveorderDetails());
            printWriter.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String toSaveorderDetails() {
        String output="";
        int i;
        for(i=0;i<orderDetails.size()-1;i++) {
            output=output+orderDetails.get(i).toSaveOrderDetail()+"\n";
        }
        return output+orderDetails.get(i).toSaveOrderDetail();
    }

    public void showOrderDetails() {
        for(OrderDetail orderDetail:orderDetails) {
            System.out.println(orderDetail);
        }
    }

    public List<OrderDetail> getOrderDetailsByOrderId(int orderId){
        List<OrderDetail> filteredList = new ArrayList<>();
        for(OrderDetail orderDetail1 :orderDetails){
            if(orderDetail1.getOrderId()==orderId){
                filteredList.add(orderDetail1);
            }
        }
        return filteredList;

    }


    public List<OrderDetail> getOrderDetailsByProductId(int productId){
        List<OrderDetail> filteredList = new ArrayList<>();
        for(OrderDetail orderDetail1 :orderDetails){
            if(orderDetail1.getProductId()==productId){
                filteredList.add(orderDetail1);
            }
        }
        return filteredList;

    }


}
