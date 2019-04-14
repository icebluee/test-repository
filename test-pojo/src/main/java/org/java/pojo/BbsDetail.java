package org.java.pojo;

import java.io.Serializable;
import java.util.Date;

public class BbsDetail implements Serializable{
    private Long id;

    private Long sortid;

    private String title;

    private String detail;

    private String author;

    private Date craetedate;

    private Integer replycount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSortid() {
        return sortid;
    }

    public void setSortid(Long sortid) {
        this.sortid = sortid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public Date getCraetedate() {
        return craetedate;
    }

    public void setCraetedate(Date craetedate) {
        this.craetedate = craetedate;
    }

    public Integer getReplycount() {
        return replycount;
    }

    public void setReplycount(Integer replycount) {
        this.replycount = replycount;
    }
}