package app.users.models;

public abstract class User {
    private int id;
    private String address;
    private String password;
    private String name;
    private String billingAddress;
    private UserTypes type;

    public User(int id, String address, String password, String name, String billingAddress, UserTypes type) {
        this.id = id;
        this.address = address;
        this.password = password;
        this.name = name;
        this.billingAddress = billingAddress;
        this.type=type;
    }

    public User(String address, String password, String name, String billingAddress,UserTypes type)
    {
        this.address=address;
        this.password=password;
        this.name=name;
        this.billingAddress=billingAddress;
        this.type=type;
    }

    public User(String text){
        text.split(",");
        this.id = Integer.parseInt(text.split(",")[1]);
        this.address = text.split(",")[2];
        this.password = text.split(",")[3];
        this.name = text.split(",")[4];
        this.billingAddress = text.split(",")[5];
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



    public UserTypes getType() {
        return type;
    }

    public void setType(UserTypes type) {
        this.type = type;
    }
    @Override
    public boolean equals(Object o){
        User user=(User) o;
        return  user.getId()==((User) o).getId() &&
                user.getAddress().equals(((User) o).getAddress())&&
                user.getName().equals(((User) o).getName());
    }

    @Override
    public String toString(){
        return this.type+","+this.id+"," +this.address +","+this.password+","+this.name+","+this.billingAddress;
    }

    public abstract UserTypes userTypes();
}
