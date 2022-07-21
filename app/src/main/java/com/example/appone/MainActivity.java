package com.example.appone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private LinearLayout layout1;
    private LinearLayout layout2;
    private boolean exit = false;
    private Button button1;
    private int counter = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout1 = findViewById(R.id.Green);
        layout2 = findViewById(R.id.Red);
        button1 = findViewById(R.id.button);

    }

    //нажати кнопки
    public void onClickStart(View view) {
        button1.setText("Stop");
        if (!exit) {
            exit = true;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (exit) {
counter++;
switch (counter){
    case 1:
        layout1.setBackgroundColor(getResources().getColor(R.color.green));
        layout1.setBackgroundColor(getResources().getColor(R.color.default_grey));
        break;
    case 2:
        layout2.setBackgroundColor(getResources().getColor(R.color.red));
        layout2.setBackgroundColor(getResources().getColor(R.color.default_grey));
        counter = 1;
        break;
}
                        try {
                            Thread.sleep(300);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }
            }).start();
        } else {
            exit = false;
            button1.setText("B");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        exit = false;
    }
}