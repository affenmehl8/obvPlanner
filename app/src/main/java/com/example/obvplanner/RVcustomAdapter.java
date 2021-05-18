package com.example.obvplanner;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RVcustomAdapter extends RecyclerView.Adapter<RVcustomAdapter.RVcustomViewHolder> {

    private ArrayList<Quest> questList;

    public static  class RVcustomViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        TextView tvDate;

        public RVcustomViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDate = itemView.findViewById(R.id.tvDate);
        }
    }

    public RVcustomAdapter(ArrayList<Quest> questList) {
        this.questList = questList;
    }
    @NonNull
    @Override
    public RVcustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.quest_card_element,parent,false);
        return new RVcustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RVcustomViewHolder holder, int position) {
        Quest currentQuest = questList.get(position);
        holder.tvTitle.setText(currentQuest.title);
        //TODO: holder.tvDate.set...
    }

    @Override
    public int getItemCount() {
        Log.e("itemcount","Questlist size:"+questList.size());
        return questList.size();

    }
}
