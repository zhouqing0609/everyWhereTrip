package com.everywhere.trip.ui.main.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.everywhere.trip.R;
import com.everywhere.trip.bean.MoveBean;
import com.everywhere.trip.util.GlideUtil;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class MoveAdapter extends RecyclerView.Adapter<MoveAdapter.ViewHolder> {
    private ArrayList<MoveBean.ResultBean.ActivitiesBean> list;
    private Context context;

    public MoveAdapter(Context context) {
        this.context = context;
    }

    public void setList(ArrayList<MoveBean.ResultBean.ActivitiesBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MoveAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.item_move, null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MoveAdapter.ViewHolder holder, int position) {
        holder.title.setText("");
        holder.art.setText(list.get(position).getContent());
        holder.data.setText(list.get(position).getDate());
        List<String> images = list.get(position).getImages();
        holder.banner.setImages(images);
        holder.banner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {

                Glide.with(context).load(path).into(imageView);
            }
        }).start();

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView data;
        private  TextView art;
        private Banner banner;

        public ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.move_title);
            art = itemView.findViewById(R.id.move_art);
            data = itemView.findViewById(R.id.move_data);
            banner = itemView.findViewById(R.id.move_img);
        }
    }
}
