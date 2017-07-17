package com.truongtd.orderfood.dto;

/**
 * Created by Truong_it on 7/7/2017.
 */

public class Employee {
    private int idEmployee;
    private String userName;
    private String passWord;
    private String gender;
    private String birthDay;
    private int idPassport;

    public Employee() {
    }

    public Employee(int idEmployee, String userName, String passWord, String gender, String birthDay, int idPassport) {
        this.idEmployee = idEmployee;
        this.userName = userName;
        this.passWord = passWord;
        this.gender = gender;
        this.birthDay = birthDay;
        this.idPassport = idPassport;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public int getIdPassport() {
        return idPassport;
    }

    public void setIdPassport(int idPassport) {
        this.idPassport = idPassport;
    }
}