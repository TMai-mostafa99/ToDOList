package com.example.todolist;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static ToDoListAdapter adapter;
    static public boolean Where=false;
    static public void setWhere(boolean x){
        Where=x;
    }
    static public boolean getWhere(){
        return Where;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create a list of words
        ArrayList<ToDOitem> TodoList = new ArrayList<ToDOitem>();

        TodoList.add(new ToDOitem("wake at 7 am",true));
        TodoList.add(new ToDOitem("wake at 7 am",false));
        TodoList.add(new ToDOitem("wake at 7 am",false));
        TodoList.add(new ToDOitem("wake at 7 am",true));
        TodoList.add(new ToDOitem("wake at 7 am",false));
        TodoList.add(new ToDOitem("wake at 7 am",false));

        adapter= new ToDoListAdapter(TodoList,getApplicationContext());
      // ArrayAdapter<String> ToDOAdapter = new ArrayAdapter<String>(this,R.layout.reminders_row,TodoList);

        ListView todoList = (ListView) findViewById(R.id.list);
        todoList.setAdapter(adapter);

       todoList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               //Toast.makeText(MainActivity.this,"TEST",Toast.LENGTH_SHORT).show();
               showAlertDialog();
           }
       });
    }

    public void showAlertDialog(){
         final String[] options= {"Edit Reminder" , "Delete Reminder"};
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options);

        final AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setAdapter(adapter, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                switch(which){
                    case 0:
                        Where=true;
                        Intent i=new Intent(MainActivity.this,EditReminder.class);
                        startActivity(i);
                        break;
                    case 1:
                        Toast.makeText(MainActivity.this,"DELETE",Toast.LENGTH_SHORT).show();
                        break;
                }

            }
        });
        AlertDialog dialog=builder.create();
        dialog.show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater SideMenu=getMenuInflater();
        SideMenu.inflate(R.menu.todo_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.NewReminder:
                Intent i=new Intent(MainActivity.this,EditReminder.class);
                startActivity(i);
                return true;
            case R.id.exit:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}














