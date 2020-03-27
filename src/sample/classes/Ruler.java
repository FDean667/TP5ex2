package sample.classes;

import sample.interfaces.Farming;
import sample.interfaces.Repair;

public class Ruler extends Person implements Repair, Farming {
    public void repair(Castle c){
        c.repair(15);
    }
    public void farm(Castle c){
        c.addGold(15);
    }
}
