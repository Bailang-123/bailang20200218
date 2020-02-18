package com.example.myapplication2.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication2.R;
import com.example.myapplication2.bean.GsonBean;
import com.example.myapplication2.utils.NetUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GsonAdapter extends RecyclerView.Adapter<GsonAdapter.MyHodler> {
    List<GsonBean.OrderListBean.DetailListBean> listBeans;

    public GsonAdapter(List<GsonBean.OrderListBean.DetailListBean> listBeans) {
        this.listBeans = listBeans;
    }

    @NonNull
    @Override
    public MyHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_name2, parent, false);
        return new MyHodler(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHodler holder, int position) {
        GsonBean.OrderListBean.DetailListBean detailListBean = listBeans.get(position);
        holder.textName01.setText(detailListBean.getCommodityName());
        String[] split = detailListBean.getCommodityPic().split(",");
        NetUtils.getInstance().getPhone(split[0],holder.imageName);
    }

    @Override
    public int getItemCount() {
        return listBeans.size();
    }

    class MyHodler extends RecyclerView.ViewHolder {
        @BindView(R.id.text_name01)
        TextView textName01;
        @BindView(R.id.image_name)
        ImageView imageName;
        public MyHodler(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
