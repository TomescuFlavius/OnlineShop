import app.costumers.models.Costumer;
import app.costumers.services.CostumerService;

public class Main {
    public static void main(String[] args) {
        CostumerService costumerService=new CostumerService();
        Costumer costumer=new Costumer("510,Str. Cireșilor 8,dragon555,Michael Anderson,Str. Alunișului 6");
        costumerService.addCostumer(costumer);
        costumerService.saveCostumers();


    }
}