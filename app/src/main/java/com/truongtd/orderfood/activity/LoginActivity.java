package com.truongtd.orderfood.activity;

import android.content.Intent;
import android.os.Binder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.truongtd.orderfood.R;
import com.truongtd.orderfood.constraint.Constraint;
import com.truongtd.orderfood.dao.EmployeeDAO;
import com.truongtd.orderfood.dto.Employee;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

     @BindView(R.id.edt_user_name_login)
    EditText edtUserNameLogin;
     @BindView(R.id.edt_password_login) EditText edtPasswordLogin;
     @BindView(R.id.btn_login)
    Button btnLogin;
     @BindView(R.id.btn_register) Button btnRegister;
    EmployeeDAO employeeDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        initEvents();
        showButtonLoginAndRegister();
    }

    private void initEvents() {

        employeeDAO = new EmployeeDAO(this);
        btnRegister.setVisibility(View.GONE);
        btnLogin.setOnClickListener(this);
        btnRegister.setOnClickListener(this);
    }
    private void showButtonLoginAndRegister(){


        if(employeeDAO.isCheckEmployee()){
            btnRegister.setVisibility(View.GONE);
            btnLogin.setVisibility(View.VISIBLE);
        }else{
            btnRegister.setVisibility(View.VISIBLE);
            btnLogin.setVisibility(View.GONE);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login:
                handleLogin();
                break;
            case R.id.btn_register:
                handleRegister();
                break;
        }
    }

    private void handleRegister() {
        Intent intentRegister = new Intent(this, RegisterActivity.class);
        startActivity(intentRegister);
    }

    private void handleLogin() {
        boolean isCheckedLogin =  employeeDAO.isCheckLogin(edtUserNameLogin.getText().toString(), edtPasswordLogin.getText().toString());

        if(isCheckedLogin){
            Intent intentHome = new Intent(LoginActivity.this, HomeActivity.class);
            intentHome.putExtra(Constraint.PUT_NAME_EMPLOYEE,edtUserNameLogin.getText().toString());
            startActivity(intentHome);
        }else{
            Toast.makeText(this, getResources().getText(R.string.login_fail),Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        showButtonLoginAndRegister();
    }
}
