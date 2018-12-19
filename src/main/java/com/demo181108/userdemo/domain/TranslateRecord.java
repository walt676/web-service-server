package com.demo181108.userdemo.domain;

public class TranslateRecord {
    private int tr_id;
    private String user_id;
    private String tr_original;
    private String tr_result;
    private String tr_time;

    public TranslateRecord() {
    }

    public TranslateRecord(int tr_id, String user_id, String tr_original, String tr_result, String tr_time) {
        this.tr_id = tr_id;
        this.user_id = user_id;
        this.tr_original = tr_original;
        this.tr_result = tr_result;
        this.tr_time = tr_time;
    }

    public TranslateRecord(String user_id, String tr_original, String tr_result, String tr_time) {
        this.user_id = user_id;
        this.tr_original = tr_original;
        this.tr_result = tr_result;
        this.tr_time = tr_time;
    }

    public int getTr_id() {
        return tr_id;
    }

    public void setTr_id(int tr_id) {
        this.tr_id = tr_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getTr_original() {
        return tr_original;
    }

    public void setTr_original(String tr_original) {
        this.tr_original = tr_original;
    }

    public String getTr_result() {
        return tr_result;
    }

    public void setTr_result(String tr_result) {
        this.tr_result = tr_result;
    }

    public String getTr_time() {
        return tr_time;
    }

    public void setTr_time(String tr_time) {
        this.tr_time = tr_time;
    }

    @Override
    public String toString() {
        return "TranslateRecord{" +
                "tr_id=" + tr_id +
                ", user_id='" + user_id + '\'' +
                ", tr_original='" + tr_original + '\'' +
                ", tr_result='" + tr_result + '\'' +
                ", tr_time='" + tr_time + '\'' +
                '}';
    }
}
