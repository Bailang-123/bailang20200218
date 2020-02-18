package com.example.myapplication2.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication2.R;
import com.example.myapplication2.bean.GsonBean;

import java.text.SimpleDateFormat;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.myHodler> {
    List<GsonBean.OrderListBean> listBeans;

    public MyAdapter(List<GsonBean.OrderListBean> listBeans) {
        this.listBeans = listBeans;
    }

    @NonNull
    @Override
    public myHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_name01, parent, false);
        return new myHodler(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull myHodler holder, int position) {
        GsonBean.OrderListBean orderListBean = listBeans.get(position);
        holder.textId.setText("订单号：" + orderListBean.getOrderId());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(orderListBean.getOrderTime());
        holder.textTime.setText(format);
        int orderStatus = orderListBean.getOrderStatus();
        if (orderStatus == 1) {
            holder.textName.setText("待支付");
        } else if (orderStatus == 2) {
            holder.textName.setText("待发货");
        } else if (orderStatus == 3) {
            holder.textName.setText("待收货");
        } else if (orderStatus == 9) {
            holder.textName.setText(View.GONE);
        }

        holder.recyvlerView01.setLayoutManager(new LinearLayoutManager(holder.itemView.getContext()));
        holder.recyvlerView01.setAdapter(new GsonAdapter(orderListBean.getDetailList()));
    }

    @Override
    public int getItemCount() {
        return listBeans.size();
    }

    class myHodler extends RecyclerView.ViewHolder {
        @BindView(R.id.text_id)
        TextView textId;
        @BindView(R.id.text_time)
        TextView textTime;
        @BindView(R.id.text_name)
        TextView textName;
        @BindView(R.id.recyvler_View01)
        RecyclerView recyvlerView01;

        public myHodler(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
