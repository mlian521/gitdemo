package com.abc.dao.entity;

import java.math.BigDecimal;

public class Score {
    private int scid;
    private BigDecimal score;
    private int sid;
    private int cid;

    private Course course;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Score{" +
                "scid=" + scid +
                ", score=" + score +
                ", sid=" + sid +
                ", cid=" + cid +
                '}';
    }

    public int getScid() {
        return scid;
    }

    public void setScid(int scid) {
        this.scid = scid;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }
}
