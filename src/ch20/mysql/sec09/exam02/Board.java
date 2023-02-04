package ch20.mysql.sec09.exam02;

import java.sql.Blob;
import java.util.Date;
import java.util.Objects;

public class Board {
    private int bno;
    private String title;
    private String bcontent;
    private String bwriter;
    private Date bdate;
    private String bfilename;
    private Blob bfiledata;

    @Override
    public String toString() {
        return "Board{" +
                "bno=" + bno +
                ", title='" + title + '\'' +
                ", bcontent='" + bcontent + '\'' +
                ", bwriter='" + bwriter + '\'' +
                ", bdate=" + bdate +
                ", bfilename='" + bfilename + '\'' +
                ", bfiledata=" + bfiledata +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Board board)) return false;
        return bno == board.bno && Objects.equals(title, board.title) && Objects.equals(bcontent, board.bcontent) && Objects.equals(bwriter, board.bwriter) && Objects.equals(bdate, board.bdate) && Objects.equals(bfilename, board.bfilename) && Objects.equals(bfiledata, board.bfiledata);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bno, title, bcontent, bwriter, bdate, bfilename, bfiledata);
    }

    public int getBno() {
        return bno;
    }

    public void setBno(int bno) {
        this.bno = bno;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBcontent() {
        return bcontent;
    }

    public void setBcontent(String bcontent) {
        this.bcontent = bcontent;
    }

    public String getBwriter() {
        return bwriter;
    }

    public void setBwriter(String bwriter) {
        this.bwriter = bwriter;
    }

    public Date getBdate() {
        return bdate;
    }

    public void setBdate(Date bdate) {
        this.bdate = bdate;
    }

    public String getBfilename() {
        return bfilename;
    }

    public void setBfilename(String bfilename) {
        this.bfilename = bfilename;
    }

    public Blob getBfiledata() {
        return bfiledata;
    }

    public void setBfiledata(Blob bfiledata) {
        this.bfiledata = bfiledata;
    }

    public Board() {
    }
}
