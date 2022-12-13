package net.Panasiuk_WebSite.Sources.Model;

import javax.persistence.*;

@Entity
@Table(name = "marks")
public class Mark{

    @Id
    @Column(name = "student_id")
    private Long id;

    @Column(name = "math")
    private int math;

    @Column(name = "history")
    private int history;

    @Column(name = "biology")
    private int biology;

    @Column(name = "english")
    private int english;

    @Column(name = "geography")
    private int geography;

    @Column(name = "chemistry")
    private int chemistry;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getHistory() {
        return history;
    }

    public void setHistory(int history) {
        this.history = history;
    }

    public int getBiology() {
        return biology;
    }

    public void setBiology(int biology) {
        this.biology = biology;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public int getGeography() {
        return geography;
    }

    public void setGeography(int geography) {
        this.geography = geography;
    }

    public int getChemistry() {
        return chemistry;
    }

    public void setChemistry(int chemistry) {
        this.chemistry = chemistry;
    }

    @Override
    public String toString() {
        return "Marks{" +
                "student_id=" + id +
                ", math=" + math +
                ", history=" + history +
                ", biology=" + biology +
                ", english=" + english +
                ", geography=" + geography +
                ", chemistry=" + chemistry +
                '}';
    }
}
