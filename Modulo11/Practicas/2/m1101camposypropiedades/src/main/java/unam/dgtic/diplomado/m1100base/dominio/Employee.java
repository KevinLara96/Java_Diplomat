package unam.dgtic.diplomado.m1100base.dominio;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Access(AccessType.FIELD)
@Entity
@Table(name = "Employee")
public class Employee {

    private static final String LADA = "(55)";

    @Id
    private Integer id;
    private String name;
    private Long salary;

    @Transient
    private String phoneNum;

    public Employee() {

    }

    public Employee(Integer id) {
        super();
        this.id = id;
    }

    public Employee(Integer id, String name, Long salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    @Access(AccessType.PROPERTY)
    @Column(name = "PHONE")
    public String getPhoneNumLada() {
        if (phoneNum != null && phoneNum.length() > 0) {
            return phoneNum;
        } else {
            return LADA + phoneNum;
        }
    }

    public void setPhoneNumLada(String num) {
        if (num.startsWith(LADA)) {
            phoneNum = num.substring(4);
        } else {
            this.phoneNum = num;
        }
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", salary=" + salary +
                ", phone=" + getPhoneNumLada() + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Employee other = (Employee) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
