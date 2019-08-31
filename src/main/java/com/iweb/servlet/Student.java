package com.iweb.servlet;

public class Student {
    private int sno;
    private String sname;
    private String spwd;
    private int sage;
    private String scountry;
    private String ssex;
//    以下为set方法
    public void setAll(int sno,String sname,int sage,String ssex,String scountry,String spwd)
    {
        this.sno = sno;
        this.sname = sname;
        this.spwd = spwd;
        this.sage = sage;
        this.scountry = scountry;
        this.ssex = ssex;
    }
    public void setSno(int i) {
        this.sno = i;
    }
    public void setScountry(String country)
    {
        this.scountry = country;
    }
    public void setSname(String stuname) {
        this.sname = stuname;
    }
    public void setSpwd(String stupwd) {
        this.spwd = stupwd;
    }

    public void setSage(int sage) {
        this.sage = sage;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    public int getSno() {
        return sno;
    }
//    以下为get方法
    public String getScountry(){
        return  this.scountry;
    }
    public String getSname() {
        return sname;
    }
    public String getSpwd() {
        return spwd;
    }
    public int getSage() {
        return sage;
    }
    public String getSsex() {
        return ssex;
    }
}
