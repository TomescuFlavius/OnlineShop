package app.users.services;

import app.users.models.*;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static app.users.models.UserTypes.*;

public class UserService {
    private File usersFile;
    private List<User> users;

    public UserService() {
        this.usersFile = new File("C:\\mycode\\oop\\incapsulare\\OnlineShop\\src\\app\\users\\file\\users.txt");
        this.users = new ArrayList<>();
        this.loadUsers();
    }

    public void loadUsers() {

        try {
            Scanner scanner=new Scanner(usersFile);


            while (scanner.hasNextLine()){
                String line=scanner.nextLine();
                UserTypes types= UserTypes.valueOf(line.split(",")[0]);
                switch (types){
                    case ADMIN -> this.users.add(new Admin(line));
                    case EMPLOYEE -> this.users.add(new Employee(line));
                    case CLIENT -> this.users.add(new Client(line));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Override
    public String toString(){
        StringBuilder text= new StringBuilder();
        int i;
        for(i=0; i< users.size()-1; i++){
            text.append((users.get(i)).toString()+"\n");
        }
        text.append(users.get(i).toString());
        return text.toString();
    }

    public void saveUsers(){
        try{
            FileWriter fileWriter=new FileWriter(usersFile);
            PrintWriter printWriter=new PrintWriter(fileWriter);
            printWriter.println(this);
            printWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showUser(){
        for(User user : users)
            System.out.println(user.toString());
    }

    public void addUser(User user){
        this.users.add(user);

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
