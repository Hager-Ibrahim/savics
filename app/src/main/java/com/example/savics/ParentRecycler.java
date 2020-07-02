package com.example.savics;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ParentRecycler extends RecyclerView.Adapter<ParentRecycler.ParentHolder> {


    ArrayList<Parent> parents ;

    public ParentRecycler(ArrayList<Parent> parents) {
        this.parents = parents;
    }

    @NonNull
    @Override
    public ParentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_parent,parent,false);

        return new ParentHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ParentHolder holder, int position) {
        holder.textView.setText(parents.get(position).getFullName() + parents.get(position).getAge());
    }

    @Override
    public int getItemCount() {
        return parents.size();
    }

    class ParentHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public ParentHolder(@NonNull View itemView) {

            super(itemView);
            textView = itemView.findViewById(R.id.textView3);

        }
    }
}
