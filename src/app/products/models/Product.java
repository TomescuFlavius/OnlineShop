package app.products.models;

import app.users.models.User;

public class Product {
    private int id;
    private String name;
    private double price;
    private String create_date;
    private int stock;

    public Product(int id, String name, double price, String create_date, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.create_date = create_date;
        this.stock = stock;
    }

    public Product(String text){
        text.split(",");
        id = Integer.parseInt(text.split(",")[0]);
        name = text.split(",")[1];
        price = Double.parseDouble(text.split(",")[2]);
        create_date = text.split(",")[3];
        stock = Integer.parseInt(text.split(",")[4]);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }



    @Override
    public boolean equals(Object o){
        Product product =(Product) o;
        return  product.getId()==((Product) o).getId() &&
                product.getName().equals(((Product) o).getName());
    }
    @Override
    public String toString(){
        return "id:"+this.id+"\n"+"name:"+this.name+"\n"+"price:"+this.price+"\n"+"create_date:"+this.create_date+"\n"+"stock:"+this.stock+"\n";
    }

}
