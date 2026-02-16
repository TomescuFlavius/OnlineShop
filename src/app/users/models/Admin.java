package app.users.models;

public class Admin extends User{
    private String email;
    public Admin(int id, String adress,String name, String password, String billingAdress, String email){
        super(id,adress,password,name,billingAdress, UserTypes.ADMIN);
        this.email=email;
    }
    public Admin(String text){
        super(text);
        this.email= text.split(",")[6];
        super.setType(UserTypes.ADMIN);
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email=email;
    }
@Override
    public  String toString(){
        return super.toString()+","+ this.email;
    }

    @Override
    public UserTypes userTypes(){
        return UserTypes.ADMIN;
    }


}
