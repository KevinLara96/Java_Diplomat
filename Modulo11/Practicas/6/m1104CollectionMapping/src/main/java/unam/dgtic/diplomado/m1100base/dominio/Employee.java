package unam.dgtic.diplomado.m1100base.dominio;

import java.util.Collection;
import java.util.Set;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
// @Table(name = "EMP", schema = "modulo11")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private long salary;

    @OneToMany
    @ElementCollection(targetClass = VacationEntry.class)
    @CollectionTable(name = "Employee_VACATION", joinColumns = @JoinColumn(name = "EMPLOYEE_ID"))
    @AttributeOverride(name = "daysTaken", column = @Column(name = "DAYS_ABS"))
    private Collection<VacationEntry> vacationBookings;

    @ElementCollection
    @Column(name = "NICKNAMES")
    @CollectionTable(name = "Employee_NICKNAMES", joinColumns = @JoinColumn(name = "Employee_ID"))
    private Set<String> nickNames;

    public Employee() {
    }

    public Employee(Integer id) {
        this.id = id;
    }

    public Employee(String name, long salary) {
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public Collection<VacationEntry> getVacationBookings() {
        return vacationBookings;
    }

    public void setVacationBookings(Collection<VacationEntry> vacationBookings) {
        this.vacationBookings = vacationBookings;
    }

    public Set<String> getNickNames() {
        return nickNames;
    }

    public void setNickNames(Set<String> nickNames) {
        this.nickNames = nickNames;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "\n, vacationBookings= "
                + vacationBookings
                + "\n, nickNames=" + nickNames + "]\n";
    }

}
