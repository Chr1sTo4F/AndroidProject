package edu.dali.app43;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    List<Map<String,Object>> list;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.listViewFoods);

        InitData();

        SimpleAdapter adapter=new SimpleAdapter(this,list,R.layout.foods_item,
                new String[]{"title","ImgId"},
                new int[]{R.id.textViewTitle,R.id.imageView}
        );

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Map<String,Object> map=list.get(i);
                Toast.makeText(MainActivity.this,map.get("title").toString(),Toast.LENGTH_LONG).show();
            }
        });
    }
    private void InitData(){
        list=new ArrayList<>();
        for (int i=0;i<10;i++)
        {
        Map<String,Object> map =new HashMap<String,Object>();
        map.put("title","美食"+(i+1));        //desc

        map.put("ImgId",R.drawable.jubao);
        map.put("ImgId",R.drawable.qrcode);
        }
    }
}