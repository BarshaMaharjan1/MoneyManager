package com.example.moneymanager;

import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moneymanager.pojos.Manager;

import java.lang.reflect.Field;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private final List<Manager> managers;

    LayoutInflater inflater;


    public RecyclerViewAdapter(Context ctx, List<Manager> managers) {
        this.managers = managers;
        this.inflater = LayoutInflater.from(ctx);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.imageview, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if(position != managers.size()-1) {
            Manager manager = managers.get(position);
            holder.imageView.setImageBitmap(Converter.getImageFromBase64Blob(manager.getImage()));
            holder.titles.setText(manager.getTitle());

        }else{
            holder.imageView.setImageResource(R.drawable.add);
            holder.titles.setText("add");
            //managers.get(0).getType()

//            Intent intent = new Intent(RecyclerViewAdapter.this, Categories.class);

        }
    }


    @Override
    public int getItemCount() {
        return managers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView titles;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            titles = itemView.findViewById(R.id.txt);
            imageView = itemView.findViewById(R.id.imageview);
        }
    }


}
