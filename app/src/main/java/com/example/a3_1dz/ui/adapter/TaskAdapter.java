package com.example.a3_1dz.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a3_1dz.OnItemClick;
import com.example.a3_1dz.databinding.ItemTaskBinding;
import com.example.a3_1dz.model.TaskModel;

import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    public ArrayList<TaskModel> list = new ArrayList<>();
    OnItemClick itemClick;

    public void setOnItemClick(OnItemClick itemClick) {
        this.itemClick = itemClick;
    }

    public void setBooks(ArrayList<TaskModel> animeBooks) {
        list = animeBooks;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TaskViewHolder
                (ItemTaskBinding.inflate
                        (LayoutInflater.from
                                (parent.getContext()),parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class TaskViewHolder extends RecyclerView.ViewHolder {
        ItemTaskBinding binding;

        public TaskViewHolder(@NonNull ItemTaskBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(TaskModel model) {
            binding.tvTitle2.setText(model.getName());
            binding.iv.setImageResource(model.getImage());
            itemView.setOnClickListener(view -> {
                itemClick.onClick(model);
            });
        }
    }
}