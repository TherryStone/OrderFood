package com.truongtd.orderfood.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.truongtd.orderfood.R;
import com.truongtd.orderfood.constraint.Constraint;
import com.truongtd.orderfood.dao.TableFoodDAO;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddNewTableFoodActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.btn_add_table_food)
    Button btnAddTableFood;
    @BindView(R.id.edt_name_table_food)
    EditText edtNameTableFood;
    TableFoodDAO tableFoodDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_table_food);
        tableFoodDAO = new TableFoodDAO(this);
        ButterKnife.bind(this);
        addEvents();
    }

    private void addEvents() {

        btnAddTableFood.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String nameTableFood = edtNameTableFood.getText().toString();
        if(nameTableFood != null ){
            boolean isAddTableFood = tableFoodDAO.addTableFood(nameTableFood);
            Intent intentAddTableFood = new Intent();
            intentAddTableFood.putExtra(Constraint.RESULT_ADD_TABLE_FOOD,isAddTableFood);
            setResult(Activity.RESULT_OK, intentAddTableFood);
            finish();
        }
    }
}
