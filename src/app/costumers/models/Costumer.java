package app.costumers.models;

public class Costumer {
    private int id;
    private String address;
    private String password;
    private String name;
    private String billingAddress;

    public Costumer(int id, String address, String password, String name, String billingAddress) {
        this.id = id;
        this.address = address;
        this.password = password;
        this.name = name;
        this.billingAddress = billingAddress;
    }

    public Costumer(String address, String password, String name, String billingAddress)
    {
        this.address=address;
        this.password=password;
        this.name=name;
        this.billingAddress=billingAddress;
    }

    public Costumer(String text){
        text.split(",");
        this.id = Integer.parseInt(text.split(",")[0]);
        this.address = text.split(",")[1];
        this.password = text.split(",")[2];
        this.name = text.split(",")[3];
        this.billingAddress = text.split(",")[4];
    }

    public String descriere(){
        String text="";
        text+="id:"+this.id+"\n";
        text+="address:"+this.address+"\n";
        text+="password:"+this.password+"\n";
        text+="name:"+this.name+"\n";
        text+="billingAddress:"+this.billingAddress+"\n";
        return text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String toSaveCostumer(){
        return id+","+address+","+password+","+name+","+billingAddress;
    }
}
