package sample.classes;

import sample.interfaces.Farming;
import sample.interfaces.Hireable;
import sample.interfaces.Repair;

public class Citizen extends Person implements Farming, Repair, Hireable {
    private int prod = 2;
    private int repairation = 2;
    private int price = 5;

    public void farm(Castle c) {
        c.addGold(prod);
    }
    public void repair(Castle c){
        c.repair(repairation);
    }
    public int getPrice(){
        return price;

    }
}
