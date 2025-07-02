package app.users.models;

public class Employee extends User{
    private int badgeNumber;

    public Employee(int id, String adress,String name, String password, String billingAdress, int badgeNumber){
        super(id, adress, password,name, billingAdress,UserTypes.EMPLOYEE);
        this.badgeNumber=badgeNumber;

    }

    public Employee(String text){
        super(text);
        badgeNumber=Integer.parseInt(text.split(",")[6]);
        setType(UserTypes.EMPLOYEE);
    }

    public int getBadgeNumber() {
        return badgeNumber;
    }

    public void setBadgeNumber(int badgeNumber) {
        this.badgeNumber = badgeNumber;
    }
@Override
    public String toString(){
        return super.toString()+","+ this.badgeNumber;
    }


}
