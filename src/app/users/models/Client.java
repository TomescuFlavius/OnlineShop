package app.users.models;

public class Client extends User{
    private String phoneNumber;

    public Client(int id, String adress,String name, String password, String billingAdress, String phoneNumber){
        super(id, adress, name, password, billingAdress,UserTypes.CLIENT);
        this.phoneNumber=phoneNumber;
    }

    public Client(String text){
        super(text);
        this.phoneNumber=text.split(",")[6];
        super.setType(UserTypes.CLIENT);
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }
    public void setPhoneNumber(){
        this.phoneNumber=phoneNumber;
    }
@Override
    public String toString(){
        return super.toString()+","+this.phoneNumber;
    }



}
