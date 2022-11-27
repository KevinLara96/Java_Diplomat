package unam.dgtic.diplomado.m1100base.dominio;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class CompanyEmployee extends Employee {

    private Integer vacation;

    public Integer getVacation() {
        return vacation;
    }

    public void setVacation(Integer vacation) {
        this.vacation = vacation;
    }

}
