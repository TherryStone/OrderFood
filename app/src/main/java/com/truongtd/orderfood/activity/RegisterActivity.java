package com.truongtd.orderfood.activity;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.truongtd.orderfood.R;
import com.truongtd.orderfood.dao.EmployeeDAO;
import com.truongtd.orderfood.constraint.*;
import com.truongtd.orderfood.database.Database;
import com.truongtd.orderfood.dto.Employee;
import com.truongtd.orderfood.fragment.FragmentBirthDay;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener, View.OnFocusChangeListener {

    private EditText edtUserName;
    private EditText edtPassword;
    private EditText edtBirthDay;
    private EditText edtIdPassPort;
    private Button btnAccept;
    private Button btnExit;
    private RadioButton rbMale;
    private RadioButton rbFeMale;
    private RadioGroup rgGender;
    String genderEmployee;
    EmployeeDAO employeeDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initComponents();
        initEvent();
        employeeDAO = new EmployeeDAO(this);
    }

    private void initEvent() {

        btnExit.setOnClickListener(this);
        btnAccept.setOnClickListener(this);
        edtBirthDay.setOnFocusChangeListener(this);
    }

    private void initComponents() {

        edtUserName = (EditText) findViewById(R.id.edt_user_name);
        edtPassword = (EditText) findViewById(R.id.edt_pass_word);
        edtBirthDay = (EditText) findViewById(R.id.edt_birth_day);
        edtIdPassPort = (EditText) findViewById(R.id.edt_pass_port);
        btnAccept = (Button) findViewById(R.id.btn_accept);
        btnExit = (Button) findViewById(R.id.btn_exit);
        rbFeMale = (RadioButton) findViewById(R.id.rb_female);
        rbMale = (RadioButton) findViewById(R.id.rb_male);
        rgGender = (RadioGroup) findViewById(R.id.rb_gender);
    }

    @Override
    public void onClick(View v) {
       if(v.getId() == R.id.btn_accept){
           String userName = edtUserName.getText().toString();
           String passWord = edtPassword.getText().toString();
           String birthDay = edtBirthDay.getText().toString();
//           long idPassPort = Long.parseLong(edtIdPassPort.getText().toString().trim());
           if(rgGender.getCheckedRadioButtonId() == R.id.rb_male){
               genderEmployee = "Nam";
           }
            if(rgGender.getCheckedRadioButtonId() == R.id.rb_female){
               genderEmployee = "Nữ";
           }
           if(userName == null || userName.equals("")){
               Toast.makeText(this, getResources().getText(R.string.user_name),Toast.LENGTH_LONG).show();
           }
           if(passWord == null || passWord.equals("")){
               Toast.makeText(this, getResources().getText(R.string.password),Toast.LENGTH_LONG).show();
           }else{
               Employee employee = new Employee();
               employee.setUserName(userName);
               employee.setPassWord(passWord);
               employee.setBirthDay(birthDay);
               employee.setGender(genderEmployee);
               employee.setIdPassport(Integer.parseInt(edtIdPassPort.getText().toString().trim()));
               long isCheckedSuccess = employeeDAO.addEmployee(employee);
               if(isCheckedSuccess != 0 ){
                   Toast.makeText(this, getResources().getText(R.string.add_employee_success),Toast.LENGTH_LONG).show();
               }else{
                   Toast.makeText(this, getResources().getText(R.string.add_employee_fail),Toast.LENGTH_LONG).show();
               }

           }
       }if(v.getId() == R.id.btn_exit){

           finish();
       }
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
       if(v.getId() == R.id.edt_birth_day){
           if(hasFocus){
               FragmentBirthDay fragmentBirthDay = new FragmentBirthDay();
               fragmentBirthDay.show(getSupportFragmentManager(),Constraint.TAG_BIRTHDAY );
           }

       }
    }
}
