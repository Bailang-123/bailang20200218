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

public class ShouyeAdapter extends RecyclerView.Adapter<ShouyeAdapter.ShouyeHodler> {
    List<GsonBean.OrderListBean> listBeans;

    public ShouyeAdapter(List<GsonBean.OrderListBean> listBeans) {
        this.listBeans = listBeans;
    }

    @NonNull
    @Override
    public ShouyeHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_name01, parent, false);
        return new ShouyeHodler(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ShouyeHodler holder, int position) {
        GsonBean.OrderListBean.DetailListBean detailListBean = listBeans.get(position).getDetailList().get(position);
        holder.shouyeName.setText(detailListBean.getCommodityName());
        String[] split = detailListBean.getCommodityPic().split(",");
        NetUtils.getInstance().getPhone(split[0],holder.shouyeImage);
        holder.shouyePrice.setText("￥  "+detailListBean.getCommodityPrice()+".00");
    }

    @Override
    public int getItemCount() {
        return listBeans.size();
    }

    class ShouyeHodler extends RecyclerView.ViewHolder {
        @BindView(R.id.shouye_name)
        TextView shouyeName;
        @BindView(R.id.shouye_image)
        ImageView shouyeImage;
        @BindView(R.id.shouye_price)
        TextView shouyePrice;
        public ShouyeHodler(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
