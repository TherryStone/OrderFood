package com.truongtd.orderfood.fragment;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Toast;

import com.truongtd.orderfood.R;
import com.truongtd.orderfood.activity.AddNewTableFoodActivity;
import com.truongtd.orderfood.adapter.TableFoodAdapter;
import com.truongtd.orderfood.constraint.Constraint;
import com.truongtd.orderfood.dao.TableFoodDAO;
import com.truongtd.orderfood.dto.DinningTableFood;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Truong_it on 7/16/2017.
 */

public class ShowTableFoodFragment extends Fragment{
    private static final String TAG = "TestLog" ;
    GridView gvShowDiningTable;
    ArrayList<DinningTableFood> lstDiningTable= new ArrayList<>();
    TableFoodDAO tableFoodDAO;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.activity_show_tabel_food, container, false);
        setHasOptionsMenu(true);
        gvShowDiningTable = (GridView) view.findViewById(R.id.gv_ban_an);
        tableFoodDAO = new TableFoodDAO(getContext());
        lstDiningTable = tableFoodDAO.getAllDinningTable();
        TableFoodAdapter tableFoodAdapter = new TableFoodAdapter(getActivity(), R.layout.activity_show_tabel_food, lstDiningTable);
        gvShowDiningTable.setAdapter(tableFoodAdapter);
        tableFoodAdapter.notifyDataSetChanged();
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        MenuItem itemAddTableFood = menu.add(1,R.id.action_add_table_food,1,R.string.action_add_table_food);
        itemAddTableFood.setIcon(R.drawable.banantrue);
        itemAddTableFood.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_add_table_food:
                Log.d(TAG, "Add sucees");
                Intent intentAddTableFood = new Intent(this.getActivity(), AddNewTableFoodActivity.class);
                this.startActivityForResult(intentAddTableFood,Constraint.REQUEST_CODE );
                break;
        }
        return true;
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == Constraint.REQUEST_CODE){
            if(resultCode == Activity.RESULT_OK){
                Intent intentAddTableFood = data;
                boolean isCheckedAddTableFood = intentAddTableFood.getBooleanExtra(Constraint.RESULT_ADD_TABLE_FOOD, false);
                if(isCheckedAddTableFood){
                    Toast.makeText(getActivity(), "Add table food success !", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getActivity(), "Add table food failed !", Toast.LENGTH_LONG).show();
                }

            }
        }
    }
}
