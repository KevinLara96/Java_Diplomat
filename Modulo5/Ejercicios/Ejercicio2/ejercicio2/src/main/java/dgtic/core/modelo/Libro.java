package dgtic.core.modelo;

import java.util.HashSet;
import java.util.Set;

public class Libro {

    private String titulo;
    private String isbn;
    private String editorial;
    private Set<Autor> autores = new HashSet<>();

    public Libro() {

    }

    public Libro(String titulo, String isbn, String editorial, Set<Autor> autores) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.editorial = editorial;
        this.autores = autores;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public Set<Autor> getAutores() {
        return autores;
    }

    public void setAutores(Set<Autor> autores) {
        this.autores = autores;
    }

    @Override
    public String toString() {
        return "Libro " + titulo + ", editorial=" + editorial + ", isbn=" + isbn + ", autores" + autores;
    }

}
