package dgtic.core.springcorerestbd.persistence.dao;

import java.util.List;

import dgtic.core.springcorerestbd.persistence.modelo.Estudiante;

public interface EstudianteDao {
    public List<Estudiante> consulta();

    public Estudiante consultaId(String cuenta);

    public void insertar(Estudiante estudiante);

    public void cambiar(Estudiante estudiante);

    public void borrar(Estudiante estudiante);
}