package com.truongtd.orderfood.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.truongtd.orderfood.R;
import com.truongtd.orderfood.dto.DinningTableFood;

import java.util.ArrayList;

/**
 * Created by Truong_it on 8/1/2017.
 */

public class TableFoodAdapter extends BaseAdapter {
    private ArrayList<DinningTableFood> arrTableFood;
    private Context context;
    private int layout;

    private ViewholderTableFood viewholderTableFood;
    public TableFoodAdapter(Context context, int layout, ArrayList<DinningTableFood> arrTableFoodDao) {

        this.arrTableFood = arrTableFoodDao;
        this.context = context;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return arrTableFood.size();
    }

    @Override
    public Object getItem(int position) {
        return arrTableFood.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null){

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_table_food, parent, false);
            viewholderTableFood.imvTableFood = (ImageView) convertView.findViewById(R.id.imv_table_food);
            viewholderTableFood.imvOrderFood = (ImageView) convertView.findViewById(R.id.imv_order_food);
            viewholderTableFood.imvThanhToan = (ImageView) convertView.findViewById(R.id.imv_thanh_toan);
            viewholderTableFood.imvDisableButton = (ImageView) convertView.findViewById(R.id.imv_cancel_table_food);
            viewholderTableFood.tvNameTableFood = (TextView) convertView.findViewById(R.id.tv_name_table_food);
            convertView.setTag(viewholderTableFood);
        }else{

            viewholderTableFood = (ViewholderTableFood) convertView.getTag();
        }
        DinningTableFood dinningFood = arrTableFood.get(position);
        viewholderTableFood.tvNameTableFood.setText(dinningFood.getNameDinningTable());
        return convertView;
    }

    public class ViewholderTableFood{

        ImageView imvOrderFood;
        ImageView imvThanhToan;
        ImageView imvDisableButton;
        ImageView imvTableFood;
        TextView tvNameTableFood;

    }
}
