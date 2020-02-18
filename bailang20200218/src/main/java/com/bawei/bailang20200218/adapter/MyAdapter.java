package com.bawei.bailang20200218.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.bailang20200218.R;
import com.bawei.bailang20200218.bean.GsonBean;

import java.text.SimpleDateFormat;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHodler> {
    List<GsonBean.OrderListBean> listBeans;

    public MyAdapter(List<GsonBean.OrderListBean> listBeans) {
        this.listBeans = listBeans;
    }

    @NonNull
    @Override
    public MyHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_name02, parent, false);
        return new MyHodler(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHodler holder, int position) {
        GsonBean.OrderListBean orderListBean = listBeans.get(position);
        holder.textId.setText("订单号：" + orderListBean.getOrderId());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(orderListBean.getOrderTime());
        holder.textTime.setText(format);
        int orderStatus = orderListBean.getOrderStatus();
        if (orderStatus == 1) {
            holder.buttonType.setText("待支付");
        } else if (orderStatus == 2) {
            holder.buttonType.setText("待发货");
        } else if (orderStatus == 3) {
            holder.buttonType.setText("待评价");
        } else if (orderStatus == 9) {
            holder.buttonType.setText(View.GONE);
        }
        holder.myRecyclerview.setLayoutManager(new LinearLayoutManager(holder.itemView.getContext()));
        List<GsonBean.OrderListBean.DetailListBean> detailList = orderListBean.getDetailList();
        holder.myRecyclerview.setAdapter(new GsonAdapter(detailList));
    }


    @Override
    public int getItemCount() {
        return listBeans.size();
    }

    class MyHodler extends RecyclerView.ViewHolder {
        @BindView(R.id.text_id)
        TextView textId;
        @BindView(R.id.text_time)
        TextView textTime;
        @BindView(R.id.button_type)
        Button buttonType;
        @BindView(R.id.my_recyclerview)
        RecyclerView myRecyclerview;
        public MyHodler(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
