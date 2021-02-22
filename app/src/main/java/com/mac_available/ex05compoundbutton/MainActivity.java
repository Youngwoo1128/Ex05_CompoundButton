package com.mac_available.ex05compoundbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    CheckBox cb01, cb02, cb03;
    TextView tv;
    ToggleButton tb;
    //버튼은 onclick되어 있어서 id가 필요없다.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cb01 = findViewById(R.id.cb01);
        cb02 = findViewById(R.id.cb02);
        cb03 = findViewById(R.id.cb03);
        tv = findViewById(R.id.tv);
        tb = findViewById(R.id.tb);

        //CheckBox의 체크 상태가 변경되는 것을 듣는 리스너 객체 생성
        CompoundButton.OnCheckedChangeListener listener = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String s="";

                if(cb01.isChecked()) s += cb01.getText().toString();
                if(cb02.isChecked()) s += cb02.getText().toString();
                if(cb03.isChecked()) s += cb03.getText().toString();

                tv.setText(s);

            }
        };
        cb01.setOnCheckedChangeListener(listener);
        cb02.setOnCheckedChangeListener(listener);
        cb03.setOnCheckedChangeListener(listener);

        //토글버튼이 변경되는 것을 듣는 리스너 생성 및 추가
        tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                tv.setText(isChecked+"");
            }
        });

    }

    //onClick속성이 적용된 뷰를 클릭하면 자동으로 호출되는 콜백 메소드
    public void clickBtn(View view) {
        //선택되어있는 CheckBox의 글씨 얻어오기
        String s = "";

        if(cb01.isChecked()) s += cb01.getText().toString();
        if(cb02.isChecked()) s += cb02.getText().toString();
        if(cb03.isChecked()) s += cb03.getText().toString();

        tv.setText(s);
    }



}