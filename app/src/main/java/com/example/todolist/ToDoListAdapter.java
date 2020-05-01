package com.example.todolist;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class ToDoListAdapter extends ArrayAdapter<ToDOitem> {


    private ArrayList<ToDOitem> dataSet;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {
        TextView txtName;
        TextView info;
    }

    public ToDoListAdapter(ArrayList<ToDOitem> data, Context context) {
        super(context, R.layout.reminders_row, data);
        this.dataSet = data;
        this.mContext=context;

    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        ToDOitem dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.reminders_row, parent, false);
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.todo_item);
            viewHolder.info = (TextView) convertView.findViewById(R.id.importance);


            result=convertView;
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }
        lastPosition = position;
        viewHolder.txtName.setText(dataModel.getTodo_item());
        viewHolder.info.setTag(position);
        if(dataModel.getImagebar()){;
        viewHolder.info.setBackgroundColor(Color.rgb(245, 12, 12));
        }


        // Return the completed view to render on screen
        return convertView;
    }
}


