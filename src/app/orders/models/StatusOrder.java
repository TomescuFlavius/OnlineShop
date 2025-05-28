package app.orders.models;

public enum StatusOrder {

    CANCELED("CANCELED"),
    ONGOING("ONGOING"),
    FINISHED("FINISHED");
    private final String status;
    private StatusOrder(String status){
        this.status=status;
    }
}
