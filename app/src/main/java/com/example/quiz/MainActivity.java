package com.example.quiz;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Pytanie> pytania;

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
    }

    private void dodajPytania(){
        pytania = new ArrayList<>();
        pytania.add(new Pytanie("CZy tygrys wystepuje w afryce", true, R.drawable.zwierze1 ));
        pytania.add(new Pytanie("Czy leniwiec nie spi", false, R.drawable.zwierze2 ));
        pytania.add(new Pytanie("CZy panda je bambusy", true, R.drawable.zwierze3 ));
        pytania.add(new Pytanie("CZy panda jest madra", false, R.drawable.zwierze4 ));
    }
}