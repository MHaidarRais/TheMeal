package com.rais.haidar.themeal.Main.Activity.Main;

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
import com.rais.haidar.themeal.Main.Activity.ListCategory.ListCategoryActivity;
import com.rais.haidar.themeal.Main.Model.ModelCategory.CategoriesItem;
import com.rais.haidar.themeal.R;

import java.util.List;

class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyViewHolder> {
    Context context;
    List<CategoriesItem> categoriesItems;

    public MainAdapter(Context context, List<CategoriesItem> data) {
        this.context = context;
        this.categoriesItems = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_category,viewGroup,false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        myViewHolder.txtNamaKategori.setText(categoriesItems.get(i).getStrCategory());
        myViewHolder.txtPenjelasanKategori.setText(categoriesItems.get(i).getStrCategoryDescription());
        Glide.with(context)
                .load(categoriesItems.get(i).getStrCategoryThumb())
                .into(myViewHolder.imgListCategory);

        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context,ListCategoryActivity.class);
                intent.putExtra("stringKategori",categoriesItems.get(i).getStrCategory());
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return categoriesItems.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtNamaKategori,txtPenjelasanKategori;
        ImageView imgListCategory;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            txtNamaKategori = itemView.findViewById(R.id.txtNamaKategori);
            txtPenjelasanKategori = itemView.findViewById(R.id.txtPenjelasanKategori);
            imgListCategory = itemView.findViewById(R.id.imgListCategory);

        }
    }
}
