package com.bawei.bailang20200218.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.bailang20200218.R;
import com.bawei.bailang20200218.bean.GsonBean;
import com.bawei.bailang20200218.util.NetUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GsonAdapter extends RecyclerView.Adapter<GsonAdapter.GsonHodler> {
    List<GsonBean.OrderListBean.DetailListBean> listBeans;

    public GsonAdapter(List<GsonBean.OrderListBean.DetailListBean> listBeans) {
        this.listBeans = listBeans;
    }

    @NonNull
    @Override
    public GsonHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_name03, parent, false);
        return new GsonHodler(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull GsonHodler holder, int position) {
        GsonBean.OrderListBean.DetailListBean detailListBean = listBeans.get(position);
        holder.textName.setText(detailListBean.getCommodityName());
        holder.textPrice.setText(detailListBean.getCommodityPrice());
        String[] split = detailListBean.getCommodityPic().split(",");
        NetUtils.getInstance().getPhone(split[0],holder.imagePic);
    }

    @Override
    public int getItemCount() {
        return listBeans.size();
    }

    class GsonHodler extends RecyclerView.ViewHolder {
        @BindView(R.id.text_name)
        TextView textName;
        @BindView(R.id.image_pic)
        ImageView imagePic;
        @BindView(R.id.text_price)
        TextView textPrice;
        public GsonHodler(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
