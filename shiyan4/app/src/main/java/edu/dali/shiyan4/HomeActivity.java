package edu.dali.shiyan4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;



public class HomeActivity extends AppCompatActivity {


    Spinner spinner;
    EditText editTextName;
    Button buttonMsg;

    List<String> list=new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        spinner=findViewById(R.id.spinner_student_type);
        editTextName=findViewById(R.id.editTextName );
        buttonMsg=findViewById(R.id.buttonMsg);

        list.add("本科");
        list.add("专科");
        list.add("研究生");

        ArrayAdapter adapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,list);
        spinner.setAdapter(adapter);

        buttonMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuffer msg=new StringBuffer();
                msg.append("姓名："+editTextName.getText().toString());
                int k=spinner.getSelectedItemPosition();
                msg.append("籍贯："+list.get(k));

                Toast.makeText(HomeActivity.this,msg,Toast.LENGTH_LONG).show();
            }
        });
    }
}