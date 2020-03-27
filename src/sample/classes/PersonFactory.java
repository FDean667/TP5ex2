package sample.classes;

import javafx.css.Rule;
import sample.interfaces.Hireable;

import java.util.Random;

public class PersonFactory{
    public Person getInstance(String type){
        Person res = null;
        switch(type.toLowerCase()){
            case "farmer": res = new Farmer();break;
            case "worker": res = new Worker();break;
            case "citizen": res = new Citizen();break;
            case "ruler": res = new Ruler();break;
            default: System.out.println("erreur connard");
        }
        return res;
    }
    public Hireable hire(String type){
        Hireable res = null;
        if (!type.equals("Ruler")){
            res = (Hireable) getInstance(type);

        }
        return res;
    }
}

