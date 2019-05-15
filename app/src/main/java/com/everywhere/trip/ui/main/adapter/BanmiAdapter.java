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
import com.everywhere.trip.bean.Banmi;
import com.everywhere.trip.util.GlideUtil;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class BanmiAdapter extends RecyclerView.Adapter<BanmiAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Banmi.ResultBean.BanmiBean> list;
    public BanmiAdapter(Context context) {
        this.context = context;
    }

    public void setList(ArrayList<Banmi.ResultBean.BanmiBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BanmiAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.layout_second, null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final BanmiAdapter.ViewHolder holder, final int position) {
        Banmi.ResultBean.BanmiBean banmiBean = list.get(position);

        GlideUtil.loadUrlRoundImg(10,R.mipmap.zhanweitu_home_kapian,banmiBean.getPhoto(),holder.head,context);
        holder.name.setText(banmiBean.getName());
        holder.location.setText(banmiBean.getLocation());
        holder.authher.setText(banmiBean.getOccupation());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click.setClick(v,position);

            }
        });

        holder.heart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (list.get(position)!=null){

                if (list.get(position).isIsFollowed()){
                    like.remove(list.get(position).getId());
                    Glide.with(context)
                            .load(R.mipmap.follow_unselected)
                            .into(holder.heart);
                    list.get(position).setIsFollowed(false);

                }else {
                    like.setLike(list.get(position).getId());
                    Glide.with(context)
                            .load(R.mipmap.follow)
                            .into(holder.heart);
                    list.get(position).setIsFollowed(true);
                }

            }
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView head;
        private TextView name;
        private TextView guanzhu;
        private TextView location;
        private TextView authher;
        private ImageView heart;

        public ViewHolder(View itemView) {
            super(itemView);
            head = itemView.findViewById(R.id.second_head);
            name = itemView.findViewById(R.id.second_name);
            guanzhu = itemView.findViewById(R.id.second_guanzhu);
            location = itemView.findViewById(R.id.second_location);
            authher = itemView.findViewById(R.id.second_info);
            heart = itemView.findViewById(R.id.heart);

        }
    }

    public  setClickLike like;
    public  setOnClick click;

    public  interface setOnClick{
        void setClick(View v,int position);
    }

    public void setClick(setOnClick click) {
        this.click = click;
    }

    public  interface setClickLike{
        void setLike(int position);
        void remove(int id);

    }

    public void setLike(setClickLike like) {
        this.like = like;
    }
}
