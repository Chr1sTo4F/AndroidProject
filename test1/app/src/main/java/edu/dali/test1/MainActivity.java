package edu.dali.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.*;


public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    EditText personName;
    EditText personXuehao;
    EditText personbirthday;

    RadioGroup personsex;
    Button buttonMsg;

    List<String> list=new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /***
         * 获取界面布局中的spinner组件
         */

        spinner=findViewById(R.id.spinner_student_type);
        list.add("昆明");
        list.add("上海");


        personName=findViewById(R.id.PersonName);
        personXuehao=findViewById(R.id.PersonXuehao);
        personbirthday=findViewById(R.id.personbirthday);

        personsex=findViewById(R.id.peronsex);
        buttonMsg=findViewById(R.id.buttonMsg);

        /***
         * 创建ArrayAdapter对象
         */

        ArrayAdapter adapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,list);
        /***
         *  为Spinner设置adapter
         */

        spinner.setAdapter(adapter);

        buttonMsg.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                StringBuffer msg=new StringBuffer();
                msg.append("姓名："+personName.getText().toString()+"\n");
                msg.append("学号："+personXuehao.getText().toString()+"\n");

                /***
                 * 为spinner设置选中事件监听器
                 */

                int k=spinner.getSelectedItemPosition();
                msg.append("籍贯："+list.get(k)+"\n");
                msg.append("出生日期："+personbirthday.getText().toString()+"\n");

                msg.append("性别："+personsex.getCheckedRadioButtonId()+"\n");


                Toast.makeText(MainActivity.this,msg,Toast.LENGTH_LONG).show();

            }
        });

    }
}