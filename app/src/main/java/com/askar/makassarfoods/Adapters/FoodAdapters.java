package com.askar.makassarfoods.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.askar.makassarfoods.Models.Food;
import com.askar.makassarfoods.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FoodAdapters extends RecyclerView.Adapter<FoodAdapters.MyViewHolder> {

    private List<Food> foodList;
    private LayoutInflater mInflater;
    private ViewPager2 viewPager2;

    public FoodAdapters(List<Food> foodList) {
        this.foodList = foodList;
    }

    public FoodAdapters(List<Food> foodList, Context context, ViewPager2 viewPager2) {
        this.foodList = foodList;
        this.mInflater = LayoutInflater.from(context);
        this.viewPager2 = viewPager2;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_foods, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Food food = foodList.get(position);
        holder.textViewNama.setText(food.getNama());
        holder.textViewJenis.setText(food.getJenis());
        Picasso.get().load(food.getPhoto())
                .placeholder(R.drawable.maskot)
                .into(holder.imgView);
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imgView;
        TextView textViewNama,
                textViewJenis;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imgView = itemView.findViewById(R.id.img_list);
            textViewNama = itemView.findViewById(R.id.nama_list);
            textViewJenis = itemView.findViewById(R.id.jenis_list);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onClickListener.onClick(view, getAdapterPosition());
                }
            });
        }
    }

    private OnClickListener onClickListener;

    public interface OnClickListener{
        void onClick(View view, int position);
    }

    public void setListener(OnClickListener onClickListener){
        this.onClickListener = onClickListener;
    }


}
