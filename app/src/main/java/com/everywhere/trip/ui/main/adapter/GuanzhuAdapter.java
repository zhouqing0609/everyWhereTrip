package com.everywhere.trip.ui.main.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.everywhere.trip.R;
import com.everywhere.trip.bean.Banmi;
import com.everywhere.trip.bean.FollowedBanmi;
import com.everywhere.trip.util.GlideUtil;

import java.util.ArrayList;

public class GuanzhuAdapter extends RecyclerView.Adapter<GuanzhuAdapter.ViewHolder> {

    private Context context;
    private ArrayList<FollowedBanmi.ResultBean.BanmiBean> list;
    public GuanzhuAdapter(Context context) {
        this.context = context;
        list = new ArrayList<>();
    }

    public void setList(ArrayList<FollowedBanmi.ResultBean.BanmiBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public GuanzhuAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.layout_guanzhu, null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull GuanzhuAdapter.ViewHolder holder, int position) {
        FollowedBanmi.ResultBean.BanmiBean banmiBean = list.get(position);

        GlideUtil.loadUrlRoundImg(10,R.mipmap.zhanweitu_home_kapian,banmiBean.getPhoto(),holder.head,context);
        holder.name.setText(banmiBean.getName());
        holder.location.setText(banmiBean.getLocation());
        holder.authher.setText(banmiBean.getOccupation());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView head;
        private TextView name;

        private TextView location;
        private TextView authher;
        public ViewHolder(View itemView) {
            super(itemView); head = itemView.findViewById(R.id.guanzhu_head);
            name = itemView.findViewById(R.id.guanzhu_name);

            location = itemView.findViewById(R.id.guanzhu_location);
            authher = itemView.findViewById(R.id.guanzhu_info);

        }
    }
}
