package unam.dgtic.diplomado.m1100base.modelo;

import java.util.Collection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import unam.dgtic.diplomado.m1100base.dominio.Project;

public class ProjectService {

    protected EntityManager em;

    public ProjectService(EntityManager em) {
        this.em = em;
    }

    public Project findProject(Integer idProject) {
        return em.find(Project.class, idProject);
    }

    @SuppressWarnings("unchecked")
    public Collection<Project> findProjects() {

        Query query = em.createQuery("SELECT p FROM Project p");
        return (Collection<Project>) query.getResultList();
    }

    public Project createProject(String name) {
        Project project = new Project();
        project.setName(name);

        em.getTransaction().begin();
        em.persist(project);
        em.getTransaction().commit();

        return project;
    }
}
