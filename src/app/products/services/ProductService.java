package app.products.services;

import app.products.models.Product;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ProductService {
    private File file;
    private List<Product> products;

    public ProductService() {
        this.products = new ArrayList<Product>();
        this.file = new File("C:\\mycode\\oop\\OnlineShop\\src\\app\\products\\file\\products.txt");
        this.loadProducts();
    }

    public void loadProducts() {
        try{
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Product product = new Product(line);
                this.products.add(product);
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveProducts() {
        try{
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(toSaveProducts());
            printWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String toSaveProducts(){
        String output = "";
        int i;
        for(i=0;i<this.products.size()-1;i++){
            output+=this.products.get(i).toSaveProduct()+"\n";
        }
        return output+this.products.get(i).toSaveProduct();
    }

    public void showProducts(){
        for(Product product : products){
            System.out.println(product.descriere());
        }
    }

    public Product getProductById(int id){
        for(Product product : products){
            if(product.getId() == id){
                return product;
            }
        }
        return null;
    }

    private int generateId() {
        Random random = new Random();
        int randomId = random.nextInt(1000) + 1;
        while (this.getProductById(randomId) != null) {
            randomId = random.nextInt(1000) + 1;
        }
        return randomId;
    }

    public Product getProductByName(String name){
        for(Product product:products){
            if (product.getName().equals(name))
            {
                return product;
            }
        }
        return null;
    }




}
