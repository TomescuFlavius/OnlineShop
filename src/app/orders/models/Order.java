package app.orders.models;

public class Order {
    private int id;
    private int customerId;
    private double amount;
    private String orderEmail;
    private StatusOrder status;

    public Order(int id, int customerId, double amount, String orderEmail, StatusOrder status) {
        this.id = id;
        this.customerId = customerId;
        this.amount = amount;
        this.orderEmail = orderEmail;
        this.status = status;
    }
    public Order( int customerId, double amount, String orderEmail) {
        this.customerId = customerId;
        this.amount = amount;
        this.orderEmail = orderEmail;
    }

    public Order(String text){
        text.split(",");
        this.id = Integer.parseInt(text.split(",")[0]);
        this.customerId = Integer.parseInt(text.split(",")[1]);
        this.amount = Double.parseDouble(text.split(",")[2]);
        this.orderEmail = text.split(",")[3];
        this.status = StatusOrder.valueOf(text.split(",")[4]);//conversia de la enum la  string
    }

    public String descriere() {
        String text="";
        text+="id"+this.id+"\n";
        text+="customerId"+this.customerId+"\n";
        text+="amount"+this.amount+"\n";
        text+="orderEmail"+this.orderEmail+"\n";
        text+="status" + this.status +"\n";
        return text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getOrderEmail() {
        return orderEmail;
    }

    public void setOrderEmail(String orderEmail) {
        this.orderEmail = orderEmail;
    }

    public StatusOrder getStatus(){
        return status;
    }

    public void setStatus(StatusOrder status){
        this.status=status;
    }

    public String toSaveOrder(){
        return id+","+customerId+","+amount+","+orderEmail+","+status;
    }

}
