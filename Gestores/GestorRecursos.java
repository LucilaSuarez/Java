package Gestores;
import Interfaces.FiltroRecurso;
import Recursos.RecursoAcademico;
import Excepciones.RecursoNoEncontradoException;
import java.util.ArrayList;
/*
 * @author Lucila Micaela Suarez
 */
public class GestorRecursos implements FiltroRecurso{
    private ArrayList<RecursoAcademico> recursos;

    public GestorRecursos(ArrayList<RecursoAcademico> recursos) {
        this.recursos = recursos;
    }
    
    // metodos especificos
    public String ordenarAlfabeticamente(){
        // ordena alfabeticamente los recursos por su titulo
        // Lambda (recurso1, recurso2) -> recurso1.getTitulo().compareTo(recurso2.getTitulo())
        recursos.sort((recurso1, recurso2) -> recurso1.getTitulo().compareTo(recurso2.getTitulo()));
        // crea una nueva cadena con los titulos de los recursos ordenados
        StringBuilder recursosOrdenados = new StringBuilder("Recursos ordenados alfabeticamente: \n");
        // recorrer la lista y agregar los titulos al StringBuilder
        recursos.forEach(recurso -> recursosOrdenados.append(recurso.getTitulo()).append("\n"));
        return recursosOrdenados.toString();
    }
    
    /* Una interfaz funcional es aquella que tiene un unico metodo abstracto 
       Las funciones lambda eliminan la necesidad de escribir clases anonimas o 
       metodos adicionales cuando el codigo es simple y directo.
    */

    public int calcularRecursos(){
        return recursos.size();
    }
    
    public void transformaciones(){
        // recorro la lista recursos, tomo el titulo y lo transformo con letras mayusculas
        recursos.forEach(recurso -> recurso.setTitulo(recurso.getTitulo().toUpperCase()));
        /* forEach recorre cada elemento de la lista y aplicar una operación a cada uno.
           la función lambda aplica una transformación a cada elemento de la lista recursos.
        */
    }
    
    // implementacion de interfaces
    @Override
    public boolean evaluar(RecursoAcademico recurso) {
        // true si recurso es un RecursoAcademico
        return recurso instanceof RecursoAcademico;
    }
    
    // implementacion de exception  
    public RecursoAcademico buscarRecursoPorTitulo(String titulo) throws RecursoNoEncontradoException {
        for (RecursoAcademico recurso : recursos) {
            if (recurso.getTitulo().equalsIgnoreCase(titulo)) {
                return recurso;
            }
        }
        throw new RecursoNoEncontradoException("Recurso " + titulo + " no encontrado.");
    }  
}
