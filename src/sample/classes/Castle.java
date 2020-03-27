package sample.classes;

import sample.interfaces.Farming;
import sample.interfaces.Hireable;
import sample.interfaces.Payable;
import sample.interfaces.Repair;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import java.util.ArrayList;
import java.util.Scanner;


public class Castle{
    private int gold;
    private int lp;
    private int maxlp;
    private int difficulty;
    private ArrayList<Person> habitants = new ArrayList<Person>();
    private int day;


    public Castle(int gold, int lp, int difficulty){
        this.gold = gold;
        this.lp = lp;
        this.difficulty = difficulty;
        this.maxlp = lp;
        habitants.add(PersonFactory.getInstance("Ruler"));

    }

    public boolean surviveDay(){
        maxlp = difficulty;
        for (Person p:habitants){
            if (p instanceof Farming){
                ((Farming)p).farm(this);
            }
            if (lp < maxlp){
                ((Repair)p).repair(this);
            }
        }
        for (Person p:habitants){
            int salary = 0;
            if (p instanceof Payable){
                salary = ((Payable)p).getSalary();
                salary = Math.min(salary,gold);
                gold -= salary;
                ((Payable)p).pay(salary);

            }
        }
        lp -= day*difficulty;
        maxlp += difficulty;
        day += 1;
        return lp>0;
    }

    public void hire(){
        Scanner in = new Scanner(System.in);
        boolean stop = false;
        while (!stop){
            System.out.println(("Who do you want to hire, you have " +gold+" gold. Enter stop to quit."));
            String line = in.nextLine();
            String[] words = line.split(" ");
            String order = words[0];
            int price = 0;
            if (order != null){
                if (order.equals("stop")){
                    stop = true;
                }
            }
            else{
                for (int i = 0; i < Integer.parseInt(words[1]); i++) {
                    Hireable newHabitant = PersonFactory.hire(order);
                    if (newHabitant != null){
                        price = newHabitant.getPrice();
                        if (price <= gold){
                            gold -= price;
                            habitants.add((Person)newHabitant);
                        }
                    }

                }


                }
        }

    }
    public void play(){
        hire();
        while(surviveDay()){
            System.out.println(("New day: you got " + gold + " gold." + lp + "/" + maxlp + "lp."));
        }
        System.out.println("loser");
    }


    public void addGold(int d){
        gold += d;
    }

    public void repair(int qty){
        lp = Math.min(lp+qty,maxlp);
    }

}
