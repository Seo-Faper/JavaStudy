package ch20.mysql.sec12;

import java.util.Date;
import java.util.Objects;

public class Board {
    private int bno;
    private String btitle;
    private String bcontent;
    private String bwriter;
    private Date bdate;

    public int getBno() {
        return bno;
    }

    @Override
    public String toString() {
        return "Board{" +
                "bno=" + bno +
                ", btitle='" + btitle + '\'' +
                ", bcontent='" + bcontent + '\'' +
                ", bwriter='" + bwriter + '\'' +
                ", bdate=" + bdate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Board board)) return false;
        return bno == board.bno && Objects.equals(btitle, board.btitle) && Objects.equals(bcontent, board.bcontent) && Objects.equals(bwriter, board.bwriter) && Objects.equals(bdate, board.bdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bno, btitle, bcontent, bwriter, bdate);
    }

    public void setBno(int bno) {
        this.bno = bno;
    }

    public String getBtitle() {
        return btitle;
    }

    public void setBtitle(String btitle) {
        this.btitle = btitle;
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

    public Board() {
    }
}
