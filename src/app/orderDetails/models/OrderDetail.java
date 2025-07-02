package app.orderDetails.models;

import app.users.models.User;

public class OrderDetail {
    private int id;
    private int orderId;
    private int productId;
    private double price;
    private int quantity;

    public OrderDetail(int id, int orderId, int productId, double price, int quantity) {
        this.id = id;
        this.orderId = orderId;
        this.productId = productId;
        this.price = price;
        this.quantity = quantity;
    }
    public OrderDetail( int orderId, int productId, double price, int quantity) {
        this.orderId = orderId;
        this.productId = productId;
        this.price = price;
        this.quantity = quantity;
    }

    public OrderDetail(String text) {
        text.split(",");
        this.id = Integer.parseInt(text.split(",")[0]);
        this.orderId = Integer.parseInt(text.split(",")[1]);
        this.productId = Integer.parseInt(text.split(",")[2]);
        this.price = Double.parseDouble(text.split(",")[3]);
        this.quantity = Integer.parseInt(text.split(",")[4]);
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    @Override
    public boolean equals(Object o){
        OrderDetail orderDetail = (OrderDetail) o;
        return  orderDetail.getId()==((OrderDetail) o).getId() &&
                orderDetail.getOrderId()==(((OrderDetail) o).getOrderId());
    }

    public String toString(){
        return "id:"+id+"\n"+"orderId:"+orderId+"\n"+"productId:"+productId+"\n"+"price:"+price+"\n"+"quantity:"+quantity+"\n";
}



}
