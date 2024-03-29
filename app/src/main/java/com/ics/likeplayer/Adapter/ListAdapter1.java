package com.ics.likeplayer.Adapter;

import android.content.Context;
import android.graphics.Color;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.ics.likeplayer.Model.PojoClass;
import com.ics.likeplayer.Model.PojoClass1;
import com.ics.likeplayer.R;


import java.util.ArrayList;


/**
 * Created by kuldeep on 13/02/18.
 */

public class ListAdapter1 extends RecyclerView.Adapter<ListAdapter1.ViewHolder> {
    private Context context;
    private ArrayList<PojoClass> pojoClassArrayList1;
    private int pos = -1;


    public ListAdapter1(Context context, ArrayList<PojoClass> pojoClassArrayList) {
        this.context = context;
        this.pojoClassArrayList1 = pojoClassArrayList;
    }
    @Override
    public ListAdapter1.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.song_list1, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ListAdapter1.ViewHolder holder, final int position) {
        Log.e("we got" ,""+pojoClassArrayList1.get(position).getSinger_name());
        holder.songsinger_name.setText(pojoClassArrayList1.get(position).getSinger_name());
        holder.song_type.setText(pojoClassArrayList1.get(position).getSinger_name());
//        holder.logo.setImageResource(pojoClassArrayList1.get(position).getLogo());


        if(pos == position)
        {
            holder.ll.setBackgroundColor(Color.parseColor("#f4f4f4"));

        }
        else {

            holder.ll.setBackgroundColor(Color.parseColor("#ffffff"));
        }




    }

    @Override
    public int getItemCount()   {
        return pojoClassArrayList1.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView songsinger_name,song_type;
        ImageView logo;
        LinearLayout ll;

        public ViewHolder(View view) {
            super(view);

            songsinger_name =  view.findViewById(R.id.songsinger_name);
            song_type =  view.findViewById(R.id.song_type);
            logo = view.findViewById(R.id.logo);
            ll = view.findViewById(R.id.ll);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            pos = getLayoutPosition();
            notifyDataSetChanged();
        }
    }
    }

