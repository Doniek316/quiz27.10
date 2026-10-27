package com.example.quiz;

import static android.view.View.INVISIBLE;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Pytanie> pytania;
    private TextView textView;
    private ImageView imageView;
    private Button buttonTak, buttonNie, buttonDalej;
    private int aktualne = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        dodajPytania();
        textView = findViewById(R.id.textViewPytania);
        buttonTak = findViewById(R.id.button3);
        buttonNie = findViewById(R.id.button4);
        buttonDalej = findViewById(R.id.button5);
        imageView = findViewById(R.id.imageView);
        wypiszPytanie(0);

        buttonNie.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        sprawdzanieOdp(false);
                    }
                }
        );

        buttonTak.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        sprawdzanieOdp(true);
                    }
                }
        );

        buttonDalej.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        aktualne++;
                        if (aktualne == pytania.size()) {
                            buttonDalej.setVisibility(INVISIBLE);
                            //todo: wypisywanie wyniuku
                        } else {
                            wypiszPytanie(aktualne);
                        }
                        wypiszPytanie(aktualne);
                    }
                }
        );

    }



    private void sprawdzanieOdp(boolean odp) {
        if (pytania.get(aktualne).isPoprawnaOdpowiedz() == odp) {
            pytania.get(aktualne).setCzyPoprawnie(true);
            Toast.makeText(this, "poprawna odpowiedz",
                    Toast.LENGTH_SHORT).show();
        } else {
            pytania.get(aktualne).setCzyPoprawnie(false);
            Toast.makeText(this, "bledna odpowiedz",
                    Toast.LENGTH_SHORT).show();
        }
    }


    private void wypiszPytanie(int ktore){
        Pytanie pytanie = pytania.get(ktore);
        textView.setText(pytanie.getTrescPytania());
        imageView.setImageResource((int)(pytanie.getIdZdjecia()));

    }
    private void dodajPytania(){
        pytania = new ArrayList<>();
        pytania.add(new Pytanie("CZy tygrys wystepuje w afryce", true, R.drawable.zwierze1 ));
        pytania.add(new Pytanie("Czy leniwiec nie spi", false, R.drawable.zwierze2 ));
        pytania.add(new Pytanie("CZy panda je bambusy", true, R.drawable.zwierze3 ));
        pytania.add(new Pytanie("CZy panda jest madra", false, R.drawable.zwierze4 ));
    }
}