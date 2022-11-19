package unam.dgtic.diplomado.m1100base.dominio;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
// @Table(name = "EMP", schema = "modulo11")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private long salary;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "state", column = @Column(name = "PROVINCIA")),
            @AttributeOverride(name = "zip", column = @Column(name = "POSTAL_CODE")),
    })
    private Address address;

    public Employee() {
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", address=" + address + "]";
    }

}
