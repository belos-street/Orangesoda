package com.example.orangesoda.Db;

import org.litepal.crud.DataSupport;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2018/4/11.
 */

public class NoteBook extends DataSupport implements Serializable{
    private String title;
    private String content;
    private Date date;
    private int id;
    private Boolean finish;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean getFinish() {
        return finish;
    }

    public void setFinish(Boolean finish) {
        this.finish = finish;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


}
