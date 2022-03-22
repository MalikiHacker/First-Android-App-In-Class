package sn.maliki.projetvente;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListeEleves extends AppCompatActivity {

    private static final String TAG = "DIC2_GIT_LISTEELEVES";
    private static final int REQUEST_EDIT = 2;
    private Button add_eleve;
    private List<Eleve> eleves;
    private ListView elevesListView;
    private EleveDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_eleves);

        db = DBConnection.getDbInstance(getApplicationContext()).db;

        eleves = new ArrayList<>();

        elevesListView = findViewById(R.id.liste_eleves);
        elevesListView.setAdapter(new EleveAdapter(eleves, getApplicationContext()));


        add_eleve = findViewById(R.id.button_add_eleve);
        // Intent intent = new Intent(this, MainActivity.this);

        new Thread(new Runnable() {
            @Override
            public void run() {
                eleves = db.getEleveDao().getAll();
                elevesListView.post(new Runnable() {
                    @Override
                    public void run() {
                        EleveAdapter adapter = (EleveAdapter) elevesListView.getAdapter();
                        adapter.setEleves(eleves);
                    }
                });
            }
        }).start();
        add_eleve.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListeEleves.this, EDIT_ELEVE.class);
//                startActivity(intent);
                startActivityForResult(intent, REQUEST_EDIT);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_EDIT) {
            if (resultCode == EDIT_ELEVE.EDIT_OK) {
                Eleve e = (Eleve) data.getSerializableExtra("eleve");

//                String prenom = data.getStringExtra("prenom");
//                String nom = data.getStringExtra("nom");
                eleves.add(e);
//                listElevesTextView.setText(""+ eleves);
                EleveAdapter adapter = (EleveAdapter) elevesListView.getAdapter();
                adapter.notifyDataSetChanged();

                String message = "Ajout dans la liste des eleves "+ e + " .";
                Log.i(EDIT_ELEVE.TAG, message);

                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
            }
            else if (resultCode == EDIT_ELEVE.EDIT_CANCELLED){
                Log.i(TAG, "Edit cancelled");
            }else {
                Log.i(TAG, "Code Incompris");
            }

        }

    }
}