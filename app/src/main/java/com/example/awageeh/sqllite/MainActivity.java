package com.example.awageeh.sqllite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    mysqelLiteOpenHelper db =new mysqelLiteOpenHelper(this, context1);

    EditText name,phone;
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.name);
        phone = (EditText) findViewById(R.id.phone);
        list=(ListView) findViewById(R.id.listview);
    }
    public void btn_add_data(View view){
        String Name = name.getText().toString();
        String Phone = name.getText().toString();
        boolean result =db.insertData(Name,Phone);

      if(result==true){
          Toast.makeText(MainActivity.this,"Ok",Toast.LENGTH_LONG).show();
          showData();
      }
      else {
          Toast.makeText(MainActivity.this,"NO",Toast.LENGTH_LONG).show();
      }


    }
    public void showData(){
        ArrayList<String> listData =db.getAllrecorde();
        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_expandable_list_item_1,listData);

        list.setAdapter(arrayAdapter);
    }
    public void btn_delet_data(View view){

    }
    public void btn_update_data(View view){

    }
}
