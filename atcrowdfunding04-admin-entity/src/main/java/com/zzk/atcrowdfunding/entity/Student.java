package com.zzk.atcrowdfunding.entity;

import java.util.List;
import java.util.Map;

public class Student {

    private Integer sId;
    private String stuName;
    private Address address;
    private List<Subject> subjectList;
    private Map<String, String> map;

    public Student() {
    }

    public Student(Integer sId, String stuName, Address address, List<Subject> subjectList, Map<String, String> map) {
        this.sId = sId;
        this.stuName = stuName;
        this.address = address;
        this.subjectList = subjectList;
        this.map = map;
    }


    @Override
    public String toString() {
        return "Student{" +
                "sId=" + sId +
                ", stuName='" + stuName + '\'' +
                ", address=" + address +
                ", subjectList=" + subjectList +
                ", map=" + map +
                '}';
    }

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }



    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public List<Subject> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<Subject> subjectList) {
        this.subjectList = subjectList;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }
}
