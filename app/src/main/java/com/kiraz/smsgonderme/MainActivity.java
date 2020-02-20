package com.kiraz.smsgonderme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Model> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListeDoldur();
        tanimla();
    }


    public void ListeDoldur(){
        list=new ArrayList<>();
        Model m1 = new Model("Murat","05466894553");
        Model m2 = new Model("Osman","11111111111");
        Model m3 = new Model("Kiraz","22222222222");
        Model m4 = new Model("Annem","33333333333");
        Model m5 = new Model("Babam","44444444444");
        list.add(m1);
        list.add(m2);
        list.add(m3);
        list.add(m4);
        list.add(m5);
    }
    public void tanimla(){
        ListView listview=(ListView) findViewById(R.id.mesajList);
        Adapter adp=new Adapter(list,this,this);
        listview.setAdapter(adp);
    }
}
