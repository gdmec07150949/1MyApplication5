package com.example.administrator.myapplication;
/**
 * Created by yusiqing on 2016/10/25.
 */
public class Uesr {
    public final static String NAME="name";
    public final static String MOBILE="mobile";
    public final static String DANWEI="danwei";
    public final static String QQ="qq";
    public final static String ADDRESS="address";

    private String name;
    private String mobile;
    private String danwei;
    private String qq;
    private String address;
    private int id_DB= -1;


    public  String getMOBILE() {
        return mobile;
    }

    public  String getNAME() {
        return name;
    }

    public  String getDANWEI() {
        return danwei;
    }

    public  String getQQ() {
        return qq;
    }

    public  String getADDRESS() {
        return address;
    }

    public int getId_DB(){ return id_DB;}

    public void setName(String name) {
        this.name = name;
    }

    public void setADDRESS(String address) {
        this.address = address;
    }

    public void setDANWEI(String danwei) {
        this.danwei = danwei;
    }

    public void setMOBILE(String mobile) {
        this.mobile = mobile;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public void setID_DB(int ID_DB) {
        this.id_DB = ID_DB;
    }


}
