package com.example.quess;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quess.databinding.ItemLevelBinding;

import java.util.ArrayList;
import java.util.Queue;

public class LevelAdapter extends RecyclerView.Adapter<LevelAdapter.LevelViewHolder> {
    ArrayList<GameModel> list;
    ItemClickListener listener;

    public LevelAdapter(ArrayList<GameModel> list, ItemClickListener listener) {
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public LevelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemLevelBinding binding = ItemLevelBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new LevelViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull LevelViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class LevelViewHolder extends RecyclerView.ViewHolder {
        ItemLevelBinding binding;
        public LevelViewHolder(ItemLevelBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(GameModel model) {
            binding.levelBtn.setText(model.level);
            binding.levelBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.itemClick(model);
                }
            });
        }
    }
}
