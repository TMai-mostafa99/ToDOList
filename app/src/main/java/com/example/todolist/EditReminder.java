package com.example.todolist;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextClock;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import static com.example.todolist.MainActivity.getWhere;
import static com.example.todolist.MainActivity.setWhere;

public class EditReminder extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.custom_dialog);

        DisplayMetrics dm= new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width=dm.widthPixels;
        int height=dm.heightPixels;

        getWindow().setLayout((int) (width *.8),(int)(height*.5));

        Button b= findViewById(R.id.cancel);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { finish(); }
        });
        ConstraintLayout background=(ConstraintLayout) findViewById(R.id.background) ;

        TextView Reminder=(TextView) findViewById(R.id.Reminder);

       boolean flag= getWhere();
       if(flag){
           Reminder.setText("Edit Reminder");
           background.setBackgroundColor(Color.rgb(101, 168, 108));
           setWhere(false);
       }

    }

}
