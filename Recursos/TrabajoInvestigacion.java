package Recursos;
import java.time.LocalDate;
import java.util.ArrayList;
import Interfaces.Clasificable;
import Interfaces.Evaluable;
import Interfaces.Evaluador;
/*
 * @author Lucila Micaela Suarez
 */
public class TrabajoInvestigacion extends RecursoAcademico implements Clasificable, Evaluable {
    protected ArrayList<String> autores;
    protected String lineaInvestigacion;

    public TrabajoInvestigacion(ArrayList<String> autores, String lineaInvestigacion, String identificador, String titulo, LocalDate fechaCreacion, String autor) {
        super(identificador, titulo, fechaCreacion, autor);
        this.autores = autores;
        this.lineaInvestigacion = lineaInvestigacion;
    }

    public ArrayList<String> getAutores() {
        return autores;
    }

    public void setAutores(ArrayList<String> autores) {
        this.autores = autores;
    }

    public String getLineaInvestigacion() {
        return lineaInvestigacion;
    }

    public void setLineaInvestigacion(String lineaInvestigacion) {
        this.lineaInvestigacion = lineaInvestigacion;
    }
    
    // metodo especifico 
    public boolean tieneFinanciamiento(){
        // true si lineaInvestigacion no esta vacia and .isEmpty()verifica si una cadena de texto tiene longitud 0
        return lineaInvestigacion != null && !lineaInvestigacion.isEmpty();
    }

    // metodos heredados
    @Override
    public double calcularRelevancia() {
        // calcula relevancia segun candidad de autores
        return autores.size() * 2;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("\nTrabajo de Investigacion:");
        System.out.println("Titulo: " + getTitulo());
        System.out.println("Identificador: " + getIdentificador());
        System.out.println("Fecha de Creacion: " + getFechaCreacion());
        System.out.println("Autor Principal: " + getAutor());
        System.out.println("Linea de Investigacion: " + lineaInvestigacion);
        System.out.println("Autores: " + String.join(", ", autores));
        System.out.println("Tiene financiamiento: " + tieneFinanciamiento());
        System.out.println("Relevancia: " + calcularRelevancia());
    }

    // implementacion de interfaces
    @Override
    public String[] obtenerCategoriasClasificacion() {
        return new String[] {"Categoria A", "Categoria B"};
    }

    @Override
    public void asignarCategoria(String categoria) {
        System.out.println("Categoria: " + categoria);
    }

    // puntaje = relevancia
    @Override
    public double obtenerPuntaje() {
        return calcularRelevancia();
    }

    @Override
    public void realizarEvaluacion(Evaluador evaluador) {
        System.out.println("Trabajo investigado, con un puntaje de: " + obtenerPuntaje());
    }
    
}
