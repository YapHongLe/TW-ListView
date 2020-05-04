package com.myapplicationdev.android.tw_listview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class FirstActivity extends AppCompatActivity {

    ListView lv;
    ArrayList<Year> al;
    ArrayAdapter aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView)findViewById(R.id.lvYear);
        //year
        al = new ArrayList<Year>();
        al.add(new Year("Year 1"));
        al.add(new Year("Year 2"));
        al.add(new Year("Year 3"));

        aa = new YearAdapter(this, R.layout.rowyear,al);
        lv.setAdapter(aa);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Year selectedYear = al.get(i);

                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
                intent.putExtra("year",selectedYear.getYear());
                startActivity(intent);
            }
        });


    }
}