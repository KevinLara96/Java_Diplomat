package unam.dgtic.diplomado.m1100base.dominio;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "FT_EMP")
@DiscriminatorValue("2")
public class FullTimeEmployee extends CompanyEmployee {

    private Long salary;
    private Long pension;

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public Long getPension() {
        return pension;
    }

    public void setPension(Long pension) {
        this.pension = pension;
    }

    @Override
    public String toString() {
        return "FullTimeEmployee [" +
                "Id: " + getId() + ", Name: " + getName() +
                "StartDate: " + getStartDate() +
                "Vacation: " + getVacation() +
                "salary: " + salary + ", pension: " + pension + "]";
    }
}
