package sample.classes;

import sample.interfaces.Farming;
import sample.interfaces.Hireable;
import sample.interfaces.Payable;
import sample.interfaces.Repair;

import java.util.Random;

public class Farmer extends Person implements Farming, Hireable, Payable {
    private int prod;
    private boolean paid = true;
    private int salary;
    private int price;

    public Farmer() {
        Random r = new Random();
        prod = r.nextInt(6) + 1;
        salary = r.nextInt(4 - 2 + 1) + 1;
    }
    public void farm(Castle c){
        if (paid){
        c.addGold(prod);
    }
        paid = false;
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
