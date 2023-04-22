package com.example.shoes;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MainViewHolder> {

    Context context;
    List<ItemModel> itemModels;

    public ItemAdapter(Context context, List<ItemModel> itemModels) {
        this.context = context;
        this.itemModels = itemModels;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MainViewHolder(LayoutInflater.from(context).inflate(R.layout.item_container_grid, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        Glide.with(context).load(itemModels.get(position).getImage()).into(holder.itemImage);
        holder.title.setText(itemModels.get(position).getName());
        holder.category.setText(itemModels.get(position).getCategory());
        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ItemDetails.class);
                intent.putExtra("itemId", itemModels.get(holder.getAdapterPosition()).getId());
                intent.putExtra("imageId", itemModels.get(holder.getAdapterPosition()).getImage());
                intent.putExtra("nameId", itemModels.get(holder.getAdapterPosition()).getName());
                intent.putExtra("categoryId", itemModels.get(holder.getAdapterPosition()).getCategory());
                intent.putExtra("textId", itemModels.get(holder.getAdapterPosition()).getText());
                intent.putExtra("priceId", itemModels.get(holder.getAdapterPosition()).getPrice());

                context.startActivity((intent));

            }
        });

        holder.itemImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ItemDetails.class);
                intent.putExtra("itemId", itemModels.get(holder.getAdapterPosition()).getId());
                intent.putExtra("imageId", itemModels.get(holder.getAdapterPosition()).getImage());
                intent.putExtra("nameId", itemModels.get(holder.getAdapterPosition()).getName());
                intent.putExtra("categoryId", itemModels.get(holder.getAdapterPosition()).getCategory());
                intent.putExtra("textId", itemModels.get(holder.getAdapterPosition()).getText());
                intent.putExtra("priceId", itemModels.get(holder.getAdapterPosition()).getPrice());

                context.startActivity((intent));

            }
        });
    }

    @Override
    public int getItemCount() {
        return itemModels.size();
    }
    public class MainViewHolder extends RecyclerView.ViewHolder{
        ImageView itemImage;
        TextView title, category;

        public MainViewHolder(@NonNull View itemView) {
            super(itemView);

            itemImage = itemView.findViewById(R.id.image_grid);
            title = itemView.findViewById(R.id.title_grid);
            category= itemView.findViewById(R.id.subtitle_grid);
        }
    }
}
