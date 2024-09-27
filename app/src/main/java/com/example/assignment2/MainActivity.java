package com.example.assignment2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button statusBar,checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_main);

        statusBar=(Button) findViewById(R.id.btn_status_bar);
        checkBox=(Button) findViewById(R.id.btn_check_box);


       checkBox.setOnClickListener(v ->{


            Intent intent=new Intent(MainActivity.this,CheckBoxActivity.class);
            startActivity(intent);
           Toast.makeText(MainActivity.this,"welcome to checkbox for shopping",Toast.LENGTH_SHORT).show();


        });
statusBar.setOnClickListener(v->{

    Intent intent=new Intent(MainActivity.this,StatusBarActivity.class);
    startActivity(intent);
    Toast.makeText(MainActivity.this,"Welcome to Status Bar",Toast.LENGTH_SHORT).show();


});



    }
}