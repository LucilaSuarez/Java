package Recursos;
import java.time.LocalDate;
import java.util.ArrayList;
import Interfaces.Clasificable;
import Interfaces.Evaluable;
import Interfaces.Evaluador;
/*
 * @author Lucila Micaela Suarez
 */
public class Articulo extends RecursoAcademico implements Clasificable, Evaluable {
    protected ArrayList<String> palabrasClave;
    protected String revista;

    public Articulo(ArrayList<String> palabrasClave, String revista, String identificador, String titulo, LocalDate fechaCreacion, String autor) {
        super(identificador, titulo, fechaCreacion, autor);
        this.palabrasClave = palabrasClave;
        this.revista = revista;
    }

    public ArrayList<String> getPalabrasClave() {
        return palabrasClave;
    }

    public void setPalabrasClave(ArrayList<String> palabrasClave) {
        this.palabrasClave = palabrasClave;
    }

    public String getRevista() {
        return revista;
    }

    public void setRevista(String revista) {
        this.revista = revista;
    }

    // metodo especifico
    public int contarPalabrasClaves(){
        return palabrasClave.size();
    }
    
    // metodos heredados
    @Override
    public double calcularRelevancia() {
        // calcula relevancia segun cantidad de palabras claves
        return palabrasClave.size() * 2;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("\nArticulo: ");
        System.out.println("Titulo: " + getTitulo());
        System.out.println("Identificador: " + getIdentificador());
        System.out.println("Fecha de Creacion: " + getFechaCreacion());
        System.out.println("Autor Principal: " + getAutor());
        System.out.println("Revista: " + getRevista());
        System.out.println("Palabras Clave: " + getPalabrasClave());
        System.out.println("Cantidad de palabras claves: " + contarPalabrasClaves());
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
