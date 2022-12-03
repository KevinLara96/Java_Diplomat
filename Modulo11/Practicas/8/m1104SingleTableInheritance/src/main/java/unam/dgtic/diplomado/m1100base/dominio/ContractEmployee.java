package unam.dgtic.diplomado.m1100base.dominio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class ContractEmployee extends Employee {

    @Column(name = "D_RATE")
    private Integer dailyRate;
    private Integer term;

    public Integer getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(Integer dailyRate) {
        this.dailyRate = dailyRate;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    @Override
    public String toString() {
        return "ContractEmployee [" +
                "Id: " + getId() + ", Name: " + getName() +
                "\nStartDate: " + getStartDate() +
                "\ndailyRate=" + dailyRate + ", term=  + " + term + "]";
    }
}