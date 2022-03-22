package sn.maliki.projetvente;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class EDIT_ELEVE extends AppCompatActivity {

    public static final int EDIT_OK = 0;
    public static final int EDIT_CANCELLED = 1;
    private EditText prenomEditext;
    private EditText nomEditext;
    private Button saveButton;
    private Button cancel_register;
    public static final String TAG = "DIC2_MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v(TAG, "Démarrage de MainActivity");

        setContentView(R.layout.activity_main);

        prenomEditext = findViewById(R.id.prenomEditText);
        prenomEditext.setText("Kalidou");
        nomEditext = findViewById(R.id.nomEditText);
        nomEditext.setText("DIA");



        saveButton = findViewById(R.id.saveButton);
        cancel_register = findViewById(R.id.cancelButton);

        saveButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String prenom = "" + prenomEditext.getText();
                String nom = "" + nomEditext.getText();
                Eleve e = new Eleve(prenom, nom);
                Log.v(TAG, "Enregistrement ok de " + prenom + " " + nom);

                Intent register_eleve = new Intent();

                register_eleve.putExtra("eleve", e);
//                register_eleve.putExtra("prenom", prenom);
//                register_eleve.putExtra("nom", nom);

                setResult(EDIT_OK, register_eleve);
                finish();
            }
        });
        cancel_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();

                setResult(EDIT_CANCELLED);
                finish();
            }
        });

    }
}