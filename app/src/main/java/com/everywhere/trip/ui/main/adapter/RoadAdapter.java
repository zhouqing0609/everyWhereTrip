package com.everywhere.trip.ui.main.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.everywhere.trip.R;
import com.everywhere.trip.model.MainDataBean;

import java.util.ArrayList;

public class RoadAdapter extends RecyclerView.Adapter<RoadAdapter.ViewHolder> {
    private ArrayList<MainDataBean.ResultEntity.RoutesEntity> list;
    private Context context;

    public RoadAdapter(Context context) {
        this.context = context;
    }

    public void setList(ArrayList<MainDataBean.ResultEntity.RoutesEntity> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RoadAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.item_routes, null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RoadAdapter.ViewHolder holder, int position) {
        MainDataBean.ResultEntity.RoutesEntity entity = list.get(position);
        holder.purchasedTimes.setText(entity.getPurchasedTimes() + "人购买");
        holder.intro.setText(entity.getIntro());
        if (entity.isIsPurchased()) {
            holder.btnPay.setBackgroundColor(context.getResources().getColor(R.color.c_cecece));
            holder.btnPay.setText("已购买");

            holder.city.setText(entity.getCity());
            holder.title.setText(entity.getTitle());
            RequestOptions options = new RequestOptions()
                    .placeholder(R.mipmap.zhanweitu_home_kapian)
                    .error(R.mipmap.zhanweitu_home_kapian);
            Glide.with(context)
                    .load(entity.getCardURL())
                    .apply(options)
                    .into(holder.bigImg);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView bigImg;
        TextView title;
        TextView city;
        Button btnPay;
        TextView intro;
        TextView purchasedTimes;
        public ViewHolder(View itemView) {
            super(itemView);
            bigImg = itemView.findViewById(R.id.bg_img);
            title = itemView.findViewById(R.id.title);
            city = itemView.findViewById(R.id.city);
            btnPay = itemView.findViewById(R.id.btn_pay);
            intro = itemView.findViewById(R.id.intro);
            purchasedTimes = itemView.findViewById(R.id.purchasedTimes);
        }
    }
}
