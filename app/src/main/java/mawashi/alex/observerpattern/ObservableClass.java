package mawashi.alex.observerpattern;

import java.util.Observable;

/**
 * Created by alessandro.argentier on 30/09/2016.
 * Fondamentalmente è una classe bean ordinaria, con la sola differenza di estendere la classe Observable e richiamare le due operazioni
 */
public class ObservableClass extends Observable {
    private String internal_state;

    //costruttore: inizializziamo con lo stato iniziale
    public ObservableClass(String initial_state){
        this.internal_state = initial_state;
    }

    public void setState(String state){
        this.internal_state = state;
        //due operazioni tipiche per il pattern
        setChanged();  //flegga lo stato come modificato e degno di essere osservato
        notifyObservers(); //controllo la modifica e notifica a tutti gli osservatori
    }

    public String getState(){
        return this.internal_state;
    }
}
