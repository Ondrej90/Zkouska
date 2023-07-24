package cz.itnetwork;

import java.util.ArrayList;
import java.util.List;
//evidence do které se přidávají všichni pojjištění
public class Evidence {
    private List<Pojisteny> seznamPojistenych;
    //vytvoření seznamuu

    public Evidence(){
        seznamPojistenych = new ArrayList<>();
    }
    // přidání pojištěného do seznamu
    public void pridatPojisteneho(Pojisteny pojisteny){
        seznamPojistenych.add(pojisteny);
    }
    // zonrazení celého seznamu
    public List<Pojisteny> getSeznamPojistenych(){
        return seznamPojistenych;
    }
    // hledání pojištěného podle jména
    public Pojisteny najdiPojisteneho(String jmeno, String prijimeni){
        // průchod celým seznamem
        for(Pojisteny p : seznamPojistenych){
            //pokud najde pojištěného který má stejné jméno/přijímení, tak hoé vypíše
            if(p.getJmeno().equalsIgnoreCase(jmeno) && p.getPrijimeni().equalsIgnoreCase(prijimeni)){
                return p;
            }
            //když pojištěného nenajde, tak nic nevrátí
        }
        return null;
    }

}
