package mawashi.alex.observerpattern;

import android.widget.Toast;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by alessandro.argentier on 30/09/2016.
 */
public class ObserverClass implements Observer {
    private ObservableClass osservato;
    private String identificativo;

    //costruttore: l'osservatore ha senso se osserva qualcosa; pertando si inserisce nel costruttore
    public ObserverClass(ObservableClass oc, String identificativo){
        this.osservato = oc;
        this.identificativo = identificativo;
    }

    public String getIdentificativo(){
        return identificativo;
    }

    //ovverride dell'interfaccia implementata dall'osservatore
    @Override
    public void update(Observable observable, Object object){
        if(observable == osservato){
            Toast.makeText(ApplicationClass.getContext(),"Notifica nuovo stato da " + identificativo + ": " + osservato.getState(), Toast.LENGTH_LONG).show();
        }

    }
}
