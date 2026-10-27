package com.example.quiz;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

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