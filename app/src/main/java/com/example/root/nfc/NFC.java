package com.example.root.nfc;

import java.util.Stack;

/**
 * Created by root on 13/4/17.
 */

public class NFC {
    String id;
    String new_name,name,number,date,company_name,company_location;

    public String getNew_name() {
        return new_name;
    }
public NFC()
{

}

    public NFC(String id)
    {
        this.id=id;
    }
    public NFC(String name,String number,String date,String company_name,String company_location,String id){
        this.id=id;
        this.number=number;
        this.name=name;
        this.date=date;
        this.company_name=company_name;
        this.company_location=company_location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NFC(String name,String number, String date, String company_name, String company_location){
        this.number=number;
        this.name=name;
        this.date=date;

        this.company_name=company_name;
        this.company_location=company_location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getCompany_location() {
        return company_location;
    }

    public void setCompany_location(String company_location) {
        this.company_location = company_location;
    }
}
