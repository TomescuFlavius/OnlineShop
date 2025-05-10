package app.orderDetails.models;

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

    public OrderDetail(String text) {
        text.split(",");
        this.id = Integer.parseInt(text.split(",")[0]);
        this.orderId = Integer.parseInt(text.split(",")[1]);
        this.productId = Integer.parseInt(text.split(",")[2]);
        this.price = Double.parseDouble(text.split(",")[3]);
        this.quantity = Integer.parseInt(text.split(",")[4]);
    }

    public String descriere(){
        String text="";
        text+="id:"+id+"\n";
        text+="orderId:"+orderId+"\n";
        text+="productId:"+productId+"\n";
        text+="price:"+price+"\n";
        text+="quantity:"+quantity+"\n";
        return text;
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

    public String toSaveOrderDetail(){
        return id+","+orderId+","+productId+","+price+","+quantity;
    }
}
