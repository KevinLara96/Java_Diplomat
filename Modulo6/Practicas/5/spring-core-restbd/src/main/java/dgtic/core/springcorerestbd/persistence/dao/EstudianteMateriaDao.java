package dgtic.core.springcorerestbd.persistence.dao;

import java.util.List;

import dgtic.core.springcorerestbd.persistence.modelo.EstudianteMateria;

public interface EstudianteMateriaDao {
    public List<EstudianteMateria> consulta();

    public void insertar(EstudianteMateria estudianteMateria);

    public void cambiar(EstudianteMateria viejoEstudianteMateria,
            EstudianteMateria nuevoEstudianteMateria);

    public void borrar(EstudianteMateria estudianteMateria);
}