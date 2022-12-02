package unam.dgtic.diplomado.m1100base.modelo;

import java.util.Collection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import unam.dgtic.diplomado.m1100base.dominio.Employee;
import unam.dgtic.diplomado.m1100base.dominio.ParkingSpace;

public class ParkingSpaceService {

    protected EntityManager em;

    public ParkingSpaceService(EntityManager em) {
        this.em = em;
    }

    public ParkingSpace findParkingSpace(Integer id) {
        return em.find(ParkingSpace.class, id);
    }

    @SuppressWarnings("unchecked")
    public Collection<ParkingSpace> findAllParkingSpace() {
        Query query = em.createQuery("SELECT p FROM ParkingSpace p");
        return (Collection<ParkingSpace>) query.getResultList();
    }

    public ParkingSpace createParkingSpace(Employee employee, Integer lot, String location) {
        ParkingSpace parkingSpace = new ParkingSpace();
        parkingSpace.setId(employee.getId());
        parkingSpace.setLot(lot);
        parkingSpace.setLocation(location);

        employee.setParkingSpace(parkingSpace);
        parkingSpace.setEmployee(employee);

        em.getTransaction().begin();
        em.persist(parkingSpace);
        em.getTransaction().commit();

        return parkingSpace;
    }

    public Long countParkingSpaces() {
        Query query = em.createQuery("SELECT COUNT(p) from ParkingSpace p");
        return (Long) query.getSingleResult();
    }
}
