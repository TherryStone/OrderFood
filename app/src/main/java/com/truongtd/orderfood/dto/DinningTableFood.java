package com.truongtd.orderfood.dto;

/**
 * Created by Truong_it on 8/1/2017.
 */

public class DinningTableFood {
    private int idDinningTable;
    private String nameDinningTable;
    private String statusDinningTable;

    public DinningTableFood() {
    }

    public DinningTableFood(int idDinningTable, String nameDinningTable, String statusDinningTable) {
        this.idDinningTable = idDinningTable;
        this.nameDinningTable = nameDinningTable;
        this.statusDinningTable = statusDinningTable;
    }

    public int getIdDinningTable() {
        return idDinningTable;
    }

    public void setIdDinningTable(int idDinningTable) {
        this.idDinningTable = idDinningTable;
    }

    public String getNameDinningTable() {
        return nameDinningTable;
    }

    public void setNameDinningTable(String nameDinningTable) {
        this.nameDinningTable = nameDinningTable;
    }

    public String getStatusDinningTable() {
        return statusDinningTable;
    }

    public void setStatusDinningTable(String statusDinningTable) {
        this.statusDinningTable = statusDinningTable;
    }
}
