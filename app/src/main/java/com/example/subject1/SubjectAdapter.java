package com.example.subject1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SubjectAdapter extends RecyclerView.Adapter<SubjectAdapter.MyViewHolder> {

    List<Subject>list;
    Context context;

    public SubjectAdapter(List<Subject> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public SubjectAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.subjectlayout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SubjectAdapter.MyViewHolder holder, int position) {

        holder.id.setText(list.get(position).getId());
        holder.subjectname.setText(list.get(position).getSubjectName());
        holder.maxmark.setText(list.get(position).getMaxMark());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView id,subjectname,maxmark;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            id=itemView.findViewById(R.id.id);
            subjectname=itemView.findViewById(R.id.SubjectName);
            maxmark=itemView.findViewById(R.id.MaxMark);

        }
    }
}
