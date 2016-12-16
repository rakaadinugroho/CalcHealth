package com.rakaadinugroho.kalkulatorkesehatan.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.rakaadinugroho.kalkulatorkesehatan.MainActivity;
import com.rakaadinugroho.kalkulatorkesehatan.R;
import com.rakaadinugroho.kalkulatorkesehatan.model.ObjectMenu;

import java.util.List;

/**
 * Created by Raka Adi Nugroho on 12/15/16.
 *
 * @Github github.com/rakaadinugroho
 * @Contact nugrohoraka@gmail.com
 */

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MyViewHolder>{
    private Context context;
    private List<ObjectMenu> menuList;
    private RecyclerViewItemClickListener recyclerViewItemClickListener;

    public MenuAdapter(Context context, List<ObjectMenu> menuList){
        this.context    = context;
        this.menuList   = menuList;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view   = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_menu_item, parent, false);
        final MyViewHolder myViewHolder = new MyViewHolder(view);
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int clickposition   = myViewHolder.getAdapterPosition();
                if (clickposition != RecyclerView.NO_POSITION){
                    if (recyclerViewItemClickListener != null){
                        recyclerViewItemClickListener.onItemClick(clickposition, myViewHolder.itemView);
                    }
                }
            }
        });
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ObjectMenu menu = menuList.get(position);
        holder.menu_label.setText(menu.getTitle());
        Glide.with(context)
                .load(menu.getImg())
                .into(holder.menu_icon);
    }

    @Override
    public int getItemCount() {
        return menuList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView menu_label;
        public ImageView menu_icon;

        public MyViewHolder(View itemView) {
            super(itemView);
            menu_label  = (TextView)itemView.findViewById(R.id.menu_label);
            menu_icon   = (ImageView)itemView.findViewById(R.id.menu_icon);
        }
    }
    public void setRecyclerViewItemClickListener(RecyclerViewItemClickListener recyclerViewItemClickListener){
        this.recyclerViewItemClickListener  = recyclerViewItemClickListener;
    }
    public interface RecyclerViewItemClickListener{
        void onItemClick(int position, View view);
    }
}
