package com.example.myapplication.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.bean.JsonBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyAdapter extends BaseExpandableListAdapter {
    private List<JsonBean.ResultBean> list;

    public MyAdapter(List<JsonBean.ResultBean> list) {
        this.list = list;
    }

    @Override
    public int getGroupCount() {
        return list.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return list.get(groupPosition).getShoppingCartList().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return null;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return null;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        OneHodler oneHodler;
        if (convertView == null) {
            convertView = View.inflate(parent.getContext(), R.layout.activity_one, null);
            oneHodler = new OneHodler(convertView);
            convertView.setTag(oneHodler);
        } else {
            oneHodler = (OneHodler) convertView.getTag();
        }
        oneHodler.textView01.setText(list.get(groupPosition).getCategoryName());
        JsonBean.ResultBean resultBean = list.get(groupPosition);
        boolean isChecked = true;
        List<JsonBean.ResultBean.ShoppingCartListBean> shoppingCartList = resultBean.getShoppingCartList();
        for (int i = 0; i < shoppingCartList.size(); i++) {
            if (shoppingCartList.get(i).isChecked() == false) {
                isChecked = false;
                break;
            }
        }
        oneHodler.checkbox01.setChecked(isChecked);
        boolean fileisChecked = isChecked;
        oneHodler.checkbox01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean ch = fileisChecked;
                ch = !ch;
                for (int i = 0; i < shoppingCartList.size(); i++) {
                    shoppingCartList.get(i).setChecked(ch);
                }
                notifyDataSetChanged();
                if(onClickLisnner!=null){
                    onClickLisnner.onClick();
                }
            }
        });
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        TwoHodler twoHodler;
        if (convertView == null) {
            convertView = View.inflate(parent.getContext(), R.layout.activity_two, null);
            twoHodler = new TwoHodler(convertView);
            convertView.setTag(twoHodler);
        } else {
            twoHodler = (TwoHodler) convertView.getTag();
        }
        twoHodler.textView02.setText(list.get(groupPosition).getShoppingCartList().get(childPosition).getCommodityName());
        twoHodler.textView03.setText("￥" + list.get(groupPosition).getShoppingCartList().get(childPosition).getPrice() + "");
        Glide.with(twoHodler.imageView01).load(list.get(groupPosition).getShoppingCartList().get(childPosition).getPic())
                .into(twoHodler.imageView01);
        JsonBean.ResultBean.ShoppingCartListBean shoppingCartListBean = list.get(groupPosition).getShoppingCartList().get(childPosition);
        twoHodler.checkbox02.setChecked(shoppingCartListBean.isChecked());
        twoHodler.checkbox02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shoppingCartListBean.setChecked(!shoppingCartListBean.isChecked());

                notifyDataSetChanged();
                if(onClickLisnner!=null){
                    onClickLisnner.onClick();
                }

            }
        });
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    static
    class OneHodler {
        @BindView(R.id.checkbox_01)
        CheckBox checkbox01;
        @BindView(R.id.text_view01)
        TextView textView01;

        OneHodler(View view) {
            ButterKnife.bind(this, view);
        }
    }

    static
    class TwoHodler {
        @BindView(R.id.checkbox_02)
        CheckBox checkbox02;
        @BindView(R.id.image_view02)
        ImageView imageView01;
        @BindView(R.id.text_view02)
        TextView textView02;
        @BindView(R.id.text_view03)
        TextView textView03;

        TwoHodler(View view) {
            ButterKnife.bind(this, view);
        }
    }
    public float getSumprice(){
        float sum = 0;
        for (int i = 0; i <list.size() ; i++) {
            List<JsonBean.ResultBean.ShoppingCartListBean> shoppingCartList = list.get(i).getShoppingCartList();
            for (int j = 0; j <shoppingCartList.size() ; j++) {
                JsonBean.ResultBean.ShoppingCartListBean shoppingCartListBean = shoppingCartList.get(j);
                if(shoppingCartListBean.isChecked()){
                    sum+=shoppingCartListBean.getPrice()*shoppingCartListBean.getCount();
                }
            }
        }
        return sum ;
    }
    public int numbean(){
        int sum = 0;
        for (int i = 0; i <list.size() ; i++) {
            List<JsonBean.ResultBean.ShoppingCartListBean> shoppingCartList = list.get(i).getShoppingCartList();
            for (int j = 0; j <shoppingCartList.size() ; j++) {
                JsonBean.ResultBean.ShoppingCartListBean shoppingCartListBean = shoppingCartList.get(j);
                if(shoppingCartListBean.isChecked()){
                    sum+=shoppingCartListBean.getCount();
                }
            }
        }
        return sum;
    }
    public boolean getAllCheck(){
        boolean a = true;
        for (int i = 0; i <list.size() ; i++) {
            List<JsonBean.ResultBean.ShoppingCartListBean> shoppingCartList = list.get(i).getShoppingCartList();
            for (int j = 0; j <shoppingCartList.size() ; j++) {
                JsonBean.ResultBean.ShoppingCartListBean shoppingCartListBean = shoppingCartList.get(j);
                if(shoppingCartListBean.isChecked()==false){
                    a=false;
                    break;
                }
            }
        }
        return a;
    }

    public void getChangeAllCheck(boolean b){
        for (int i = 0; i <list.size() ; i++) {
            List<JsonBean.ResultBean.ShoppingCartListBean> shoppingCartList = list.get(i).getShoppingCartList();
            for (int j = 0; j <shoppingCartList.size() ; j++) {
                JsonBean.ResultBean.ShoppingCartListBean shoppingCartListBean = shoppingCartList.get(j);
                shoppingCartListBean.setChecked(b);
            }
            notifyDataSetChanged();
        }
    }



    OnClickLisnner onClickLisnner;

    public void setOnClickLisnner(OnClickLisnner onClickLisnner) {
        this.onClickLisnner = onClickLisnner;
    }

    public interface OnClickLisnner{
        void onClick();
    }
}
