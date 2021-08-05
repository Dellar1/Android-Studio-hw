package com.example.practica1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{
    Button btnAC,btnInputDelete,btnComma,btnEqually;
    TextView tvText;

    Double buffer;
    char act;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAC = (Button) findViewById(R.id.btnAC);
        btnInputDelete = (Button) findViewById(R.id.btnInputDelete);
        btnComma = (Button) findViewById(R.id.btnComma);
        btnEqually = (Button) findViewById(R.id.btnEqually);

        tvText = (TextView) findViewById(R.id.tvText);

        tvText.setMovementMethod(new ScrollingMovementMethod());
        btnComma.setOnClickListener(v->{
            String buf = tvText.getText().toString();
            if (buf.contains(".")){

            }
            else {
                tvText.append(".");
            }
        });

        btnAC.setOnClickListener(v -> {
            tvText.setText(null);
        });

        btnInputDelete.setOnClickListener(v -> {
            String str = tvText.getText().toString();
            if(!str.equals(""))
                str = str.substring(0, str.length() - 1);
            tvText.setText(str);
        });


        btnEqually.setOnClickListener(v -> {
            switch (act){
                case '+':
                    buffer += Double.parseDouble(tvText.getText().toString());
                    tvText.setText(String.valueOf(buffer));
                    break;
                case '-':
                    buffer -= Double.parseDouble(tvText.getText().toString());
                    tvText.setText(String.valueOf(buffer));
                    break;
                case '*':
                    buffer *= Double.parseDouble(tvText.getText().toString());
                    tvText.setText(String.valueOf(buffer));
                    break;
                case '/':
                    buffer /= Double.parseDouble(tvText.getText().toString());
                    tvText.setText(String.valueOf(buffer));
                    break;
                case '%':
                    buffer /=100;
                    tvText.setText(String.valueOf(buffer));
                    break;
            }
        });

    }

    public void action(View view){
        buffer = Double.parseDouble(tvText.getText().toString());
        Button b = (Button)view;
        act = b.getText().charAt(0);
        tvText.setText(null);
    }


    public void appendText(View view){
        String temp = tvText.getText().toString();
        if (temp.length()<13) {
            Button b = (Button) view;
            tvText.setText(tvText.getText().toString() + b.getText().toString());
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("tvText", tvText.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        tvText.setText(savedInstanceState.getString("tvText"));
    }
}