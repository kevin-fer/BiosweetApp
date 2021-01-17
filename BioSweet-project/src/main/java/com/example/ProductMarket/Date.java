package com.example.ProductMarket;
import javax.persistence.*;

@Entity
public class Date {

    protected long id;
    private String begin;
    private String end;

    @Id
    @Column(name = "dateID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    public long getId () {return this.id;}
    public void setId (long id) {this.id = id;}

    public Date (String dateDébut, String dateFin) {
        this.begin = dateDébut;
        this.end= dateFin;
    }

    public Date (Date dates) {
        this.end= dates.end;
        this.begin = dates.begin;
    }

    public void setDate(Date date) {
        this.begin=date.getBegin();
        this.end=date.getEnd();
    }
    public String getBegin() {
        return this.begin;
    }

    public void setBegin(String dateDébut) {
        this.begin = dateDébut;
    }

    public String getEnd() {
        return this.end;
    }

    public void setEnd(String dateFin) {
        this.end = dateFin;
    }

   /* public void setBegin(String dateDébut) {
        this.begin = dateDébut;
    }

    public void setDates(Date dateLocation) {
        this.begin=dateLocation.getBegin();
        this.end=dateLocation.getEnd();
    }

    public String getEnd() {
        return this.end;
    }

    public void setEnd(String dateFin) {
        this.end = dateFin;
    }*/
}
