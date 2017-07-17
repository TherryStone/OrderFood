package com.truongtd.orderfood.fragment;

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

import com.truongtd.orderfood.R;
import com.truongtd.orderfood.activity.AddNewTableFoodActivity;
import com.truongtd.orderfood.constraint.Constraint;

/**
 * Created by Truong_it on 7/16/2017.
 */

public class ShowTableFoodFragment extends Fragment{
    private static final String TAG = "TestLog" ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.activity_show_tabel_food, container, false);
        setHasOptionsMenu(true);
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        MenuItem itemAddTableFood = menu.add(1,R.menu.home,1,R.string.action_add_table_food);
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
    }
}
