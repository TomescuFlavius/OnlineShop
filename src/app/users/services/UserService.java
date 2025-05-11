package app.users.services;

import app.users.models.User;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class UserService {
    private File usersFile;
    private List<User> users;

    public UserService() {
        this.usersFile = new File("C:\\mycode\\oop\\OnlineShop\\src\\app\\users\\file\\users.txt");
        this.users = new ArrayList<>();
        this.loadUsers();
    }

    public void loadUsers() {

        try {
            Scanner scanner=new Scanner(usersFile);
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                User user =new User(line);
                users.add(user);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public String toSaveUsers(){
        String text="";
        int i;
        for(i=0; i< users.size()-1; i++){
            text+= users.get(i).toSaveCostumer()+"\n";
        }
        return text+ users.get(i).toSaveCostumer();
    }

    public void saveUsers(){
        try{
            FileWriter fileWriter=new FileWriter(usersFile);
            PrintWriter printWriter=new PrintWriter(fileWriter);
            printWriter.println(toSaveUsers());
            printWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showUser(){
        for(User user : users)
            System.out.println(user.descriere());
    }

    public void addUser(User user){
        users.add(user);
        saveUsers();
    }

    public User getUserByNameAndPassword(String name, String password)
    {
        for(User user : users){
            if(user.getName().equals(name)&& user.getPassword().equals(password))
                return user;
        }
        return null;
    }
    public User getUserById(int id) {
        for (User user : users){
            if(user.getId()==id)
                return user;
        }
        return null;
    }

    public int generateId() {
        Random random = new Random();
        int randomId = random.nextInt(1000) + 1;
        while (this.getUserById(randomId) != null) {
            randomId = random.nextInt(1000) + 1;
        }
        return randomId;
    }





}
