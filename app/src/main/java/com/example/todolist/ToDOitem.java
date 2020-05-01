package com.example.todolist;

import android.app.Activity;
import android.graphics.Color;
import android.widget.ImageView;
import android.widget.TextView;

public class ToDOitem extends Activity {


    public String todo_item;
    public boolean imagebar;

    public String getTodo_item() {
        return todo_item;
    }

    public void setTodo_item(String todo_item) {
        this.todo_item = todo_item;
    }

    public boolean getImagebar() {
        return imagebar;
    }

    public void setImagebar(boolean imagebar) {
        this.imagebar = imagebar;
    }

    public ToDOitem(String todo_item , boolean imagebar){
        this.imagebar=imagebar;
        this.todo_item=todo_item;


    }

}
