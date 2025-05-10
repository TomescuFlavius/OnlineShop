package app.costumers.services;

import app.costumers.models.Costumer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CostumerService {
    private File costumerFile;
    private List<Costumer> costumers;

    public CostumerService() {
        this.costumerFile = new File("C:\\mycode\\oop\\OnlineShop\\src\\app\\costumers\\file\\costumers.txt");
        this.costumers = new ArrayList<>();
        this.loadCostumers();
    }

    public void loadCostumers() {

        try {
            Scanner scanner=new Scanner(costumerFile);
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                Costumer costumer=new Costumer(line);
                costumers.add(costumer);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public String toSaveCostumers(){
        String text="";
        int i;
        for(i=0;i<costumers.size()-1;i++){
            text+=costumers.get(i).toSaveCostumer()+"\n";
        }
        return text+costumers.get(i).toSaveCostumer();
    }

    public void saveCostumers(){
        try{
            FileWriter fileWriter=new FileWriter(costumerFile);
            PrintWriter printWriter=new PrintWriter(fileWriter);
            printWriter.println(toSaveCostumers());
            printWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showCostumer(){
        for(Costumer costumer:costumers)
            System.out.println(costumer.descriere());
    }

    public void addCostumer(Costumer costumer){
        costumers.add(costumer);
        saveCostumers();
    }

    public Costumer getCostumerByNameAndPassword(String name, String password)
    {
        for(Costumer costumer:costumers){
            if(costumer.getName().equals(name)&& costumer.getPassword().equals(password))
                return costumer;
        }
        return null;
    }
    public Costumer getCostumerById(int id) {
        for (Costumer costumer : costumers){
            if(costumer.getId()==id)
                return costumer;
        }
        return null;
    }

    public int generateId() {
        Random random = new Random();
        int randomId = random.nextInt(1000) + 1;
        while (this.getCostumerById(randomId) != null) {
            randomId = random.nextInt(1000) + 1;
        }
        return randomId;
    }





}
