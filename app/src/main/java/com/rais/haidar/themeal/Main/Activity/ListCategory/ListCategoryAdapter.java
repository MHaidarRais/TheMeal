package com.rais.haidar.themeal.Main.Activity.ListCategory;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rais.haidar.themeal.Main.Activity.DetailRecipe.ScrollingDetailActivity;
import com.rais.haidar.themeal.Main.Model.ModelListCategory.MealsItem;
import com.rais.haidar.themeal.R;

import java.util.List;

class ListCategoryAdapter extends RecyclerView.Adapter<ListCategoryAdapter.ListViewHolder> {
    Context context;
    List<MealsItem> mealsItems;
    public ListCategoryAdapter(Context context, List<MealsItem> mealsItems) {
        this.context = context;
        this.mealsItems = mealsItems;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_grid,viewGroup,false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder listViewHolder, final int i) {

        listViewHolder.txtKategori.setText(mealsItems.get(i).getStrMeal());

        Glide.with(context)
                .load(mealsItems.get(i).getStrMealThumb())
                .into(listViewHolder.imgKategori);

        listViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context,ScrollingDetailActivity.class);
                intent.putExtra("idMakanan",mealsItems.get(i).getIdMeal());
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return mealsItems.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        TextView txtKategori;
        ImageView imgKategori;
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

            txtKategori = itemView.findViewById(R.id.txtKategori);
            imgKategori = itemView.findViewById(R.id.imgKategori);
        }
    }
}
