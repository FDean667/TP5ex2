package sample.classes;
import sample.interfaces.Hireable;
import sample.interfaces.Payable;
import sample.interfaces.Repair;

import java.util.Random;
public class Worker extends Person implements Repair, Hireable, Payable {
    private boolean paid = true;
    private int price = 15;
    private int salary;
    private int repairation;

    public Worker(){
        Random r = new Random();
        repairation = r.nextInt(5-0+1) + 1;
        salary = r.nextInt(8-5+1) + 1;
    }
    public void repair (Castle c){
        if (paid){
            c.repair(repairation);
        }
    }
    public int getPrice(){
        return price;
    }
    public int getSalary(){
        return salary;
    }
    public void pay(int salary){
        paid = true;
    }
}
