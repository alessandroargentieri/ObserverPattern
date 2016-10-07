package mawashi.alex.observerpattern;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ObservableClass osservato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //inizializziamo l'oggetto da osservare affidandogli uno stato iniziale
        osservato = new ObservableClass("Ciao");
    }


    public void Submit(View v){
        EditText edit = (EditText) findViewById(R.id.edit);
        String newState = edit.getText().toString();
        //aggiorniamo lo stato interno dell'oggetto osservato: dovrebbe far scaturire delle notifiche agli osservatori
        osservato.setState(newState);
    }

    public void CreateObserver(View v){
        //metodo della classe Observable (non compare perchè non c'è override)
        int index = osservato.countObservers()+1;
        //si crea il nuovo osservatore indicandogli l'oggetto da osservare
        //parimenti all'oggetto osservato viene aggiunto l'osservatore: una sorta di cross linking
        ObserverClass newObserver = new ObserverClass(osservato, "Observer"+index);
        osservato.addObserver(newObserver);

        Toast.makeText(this, "Observer"+index+" created!", Toast.LENGTH_LONG).show();
    }

    public void DeleteObservers(View v){
        //metodo della classe Observable (non compare nella sua estensione perchè non c'è override)
        osservato.deleteObservers();
        Toast.makeText(this, "All Observers deleted!", Toast.LENGTH_LONG).show();
    }
}
