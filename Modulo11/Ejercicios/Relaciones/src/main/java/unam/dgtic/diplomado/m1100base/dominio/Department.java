package unam.dgtic.diplomado.m1100base.dominio;

import java.util.Collection;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    // @OneToMany(mappedBy = "department")
    private Collection<Employee> employees;

    public Department() {
    }

    public Department(String name) {
        this.name = name;
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

    public Collection<Employee> getEmployees() {
        return employees;
    }

    @Override
    public String toString() {
        return "Department [id=" + id + ", name=" + name + "]";
    }

}
