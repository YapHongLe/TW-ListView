package com.myapplicationdev.android.tw_listview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    ListView lv;
    TextView tvYear;
    ArrayList<Module> modules;
    ArrayAdapter aa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        lv = (ListView) this.findViewById(R.id.lvModules);
        tvYear = (TextView) findViewById(R.id.tvYear);
        Intent i = getIntent();
        String year = i.getStringExtra("year");
        tvYear.setText(year);
        modules = new ArrayList<>();
        if(year.equals("Year 1")){
            modules.add(new Module("Year 1","C201"));
            modules.add(new Module("Year 1","C202"));
            modules.add(new Module("Year 1","C213"));
        }
        else if(year.equals("Year 2")) {
            modules.add(new Module("Year 2", "C208"));
            modules.add(new Module("Year 2", "C200"));
            modules.add(new Module("Year 3", "C346"));
        }else if(year.equals("Year 3")){
            modules.add(new Module("Year 3","C301"));
            modules.add(new Module("Year 3","C302"));
            modules.add(new Module("Year 3","C303"));
        }
        aa = new ModuleAdapter(this,R.layout.row,modules);
        lv.setAdapter(aa);
    }

}
