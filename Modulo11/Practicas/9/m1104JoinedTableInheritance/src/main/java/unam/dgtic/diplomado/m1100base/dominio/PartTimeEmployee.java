package unam.dgtic.diplomado.m1100base.dominio;

import jakarta.persistence.AssociationOverride;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "PT_EMP")
@DiscriminatorValue("3")
@AssociationOverride(name = "manager", joinColumns = @JoinColumn(name = "MGR"))
public class PartTimeEmployee extends CompanyEmployee {

    @Column(name = "H_RATE")
    private Float hourlyRate;

    public Float getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(Float hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    public String toString() {
        return "PartTimeEmployee [" + "id: " + getId() + " name: " + getName()
                + ", StartDate: " + getStartDate()
                + ", HourlyRate: " + hourlyRate + ", Vacation: " + getVacation() + "]";
    }
}