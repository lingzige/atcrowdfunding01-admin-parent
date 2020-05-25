package com.zzk.atcrowdfunding.entity;

public class Subject {

    private String subjectName;
    private Integer subjectScore;

    @Override
    public String toString() {
        return "Subject{" +
                "subjectName='" + subjectName + '\'' +
                ", subjectScore=" + subjectScore +
                '}';
    }

    public Subject(String subjectName, Integer subjectScore) {
        this.subjectName = subjectName;
        this.subjectScore = subjectScore;
    }

    public Subject() {
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Integer getSubjectScore() {
        return subjectScore;
    }

    public void setSubjectScore(Integer subjectScore) {
        this.subjectScore = subjectScore;
    }
}
