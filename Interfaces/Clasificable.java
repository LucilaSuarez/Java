package Interfaces; 
import Excepciones.CategoriaInvalidaException;
/*
 * @author Lucila Micaela Suarez
 */

public interface Clasificable {
    String[] obtenerCategoriasClasificacion();
    void asignarCategoria(String categoria) throws CategoriaInvalidaException;
} 