package com.bawei.guolei.guolei20171219;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RadioButton comebutton;
    private RadioButton addbutton;
    private RadioButton buybutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        comebutton = findViewById(R.id.radio_01);
        addbutton = findViewById(R.id.radio_02);
        buybutton = findViewById(R.id.radio_03);
        comebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);

            }
        });
        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"加入成功",Toast.LENGTH_SHORT).show();

            }
        });



    }
}
