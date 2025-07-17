package Recursos;
import java.time.LocalDate;
import Interfaces.Clasificable;
import Interfaces.Evaluable;
import Interfaces.Evaluador;
import Excepciones.CategoriaInvalidaException;
/*
 * @author Lucila Micaela Suarez
 */
public class Libro extends RecursoAcademico implements Clasificable, Evaluable {
    protected int numeroPaginas;
    protected String editorial;
    // excepcion :( 
    private String categoria;

    public Libro(int numeroPaginas, String editorial, String identificador, String titulo, LocalDate fechaCreacion, String autor) {
        super(identificador, titulo, fechaCreacion, autor);
        this.numeroPaginas = numeroPaginas;
        this.editorial = editorial;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    // metodo especifico
    public boolean esLibroDigital(){
        // true si tiene 0 paginas
        return this.numeroPaginas == 0;
    }
    
    // metodos heredados
    @Override
    public double calcularRelevancia() {
        // calcula relevancia segun cantidad de paginas
        return numeroPaginas * 2;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("\nLibro: ");
        System.out.println("Titulo: " + getTitulo());
        System.out.println("Identificador: " + getIdentificador());
        System.out.println("Fecha de Creacion: " + getFechaCreacion());
        System.out.println("Autor Principal: " + getAutor());
        System.out.println("Numero de paginas: " + getNumeroPaginas());
        System.out.println("Editorial" + getEditorial());
        System.out.println("Libro digital: " + esLibroDigital());
        System.out.println("Relevancia: " + calcularRelevancia());
        
    }
    
    // implementacion de interfaces
    @Override
    public String[] obtenerCategoriasClasificacion() {
        return new String[] {"Categoria A", "Categoria B"};
    }

    public String getCategoria() {
        return categoria; // Método getter
    }
    
    @Override
    public void asignarCategoria(String categoria) throws CategoriaInvalidaException {
    if (!categoria.equals("Categoria A") && !categoria.equals("Categoria B")) {
        throw new CategoriaInvalidaException("Categoria no valida.");
    }
    this.categoria = categoria;
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

