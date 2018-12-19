package com.demo181108.userdemo.domain;

import java.sql.Date;

public class MessageBoard {
    private int id;
    private String title;
    private String author;
    private String content;
    private String time;

    public MessageBoard() {
    }

    public MessageBoard(String title, String author, String content, String time) {
        this.title = title;
        this.author = author;
        this.content = content;
        this.time = time;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "MessageBoard{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", content='" + content + '\'' +
                ", time=" + time +
                '}';
    }
}
