package Main;
import Recursos.*;
import Gestores.GestorRecursos;
import Excepciones.*; 
import Interfaces.*;
import java.time.LocalDate;
import java.util.ArrayList;
/*
 * @author Lucila Micaela Suarez
 */
public class Main {

    public static void main(String[] args) {
        // excepcion 
        try {
            // lista de recursos académicos
            ArrayList<RecursoAcademico> recursos = new ArrayList<>();

            // lista de autores
            ArrayList<String> autores = new ArrayList<>();
            autores.add("Autor1");
            autores.add("Autor2");
           
            // instancias de TrabajoInvestigacion, Libro y Articulo
            TrabajoInvestigacion trabajo = new TrabajoInvestigacion(autores, "Historia", "A3", "Nuevos Datos sobre la escritora J.A", LocalDate.of(2021, 5, 10), "Jane Austen");

            Libro libro = new Libro(300, "Editorial ABC", "A1" , "Orgullo y Prejucio", LocalDate.of(2020, 3, 15), "Jane Austen");

            ArrayList<String> palabrasClave = new ArrayList<>();
            palabrasClave.add("Orgullo");
            palabrasClave.add("Jane");

            Articulo articulo = new Articulo(palabrasClave, "Revista ABC", "A2", "Nuevo lanzamiento: Orgullo y Prejucio", LocalDate.of(2019, 7, 20), "Jane Austen");

            // agregar recursosAcademicos a la lista
            recursos.add(trabajo);
            recursos.add(libro);
            recursos.add(articulo);

            // instancia de recursos 
            GestorRecursos gestor = new GestorRecursos(recursos);

            // ordenar los recursos alfabeticamente y mostrarlos
            System.out.println(gestor.ordenarAlfabeticamente());

            // calcular el total de recursos
            System.out.println("Total de recursos: " + gestor.calcularRecursos());

            // transformar los titulos a letras mayusculas
            gestor.transformaciones();
            System.out.println("Titulos transformados:");
            System.out.println(gestor.ordenarAlfabeticamente());

            // probar la evaluación (FiltroRecurso). Interfaz
            System.out.println("Evaluacion de recursos:");
            for (RecursoAcademico recurso : recursos) {
                System.out.println(recurso.getTitulo() + ": " + gestor.evaluar(recurso));
            }

            // mostrar detalles de cada recurso
            System.out.println("\nDetalles de cada recurso:");
            for (RecursoAcademico recurso : recursos) {
                recurso.mostrarDetalles();
            }

            // prueba de interfaces. Libro
            System.out.println("\nPruebas de interfaces:");
            Clasificable clasificable = libro;
            clasificable.asignarCategoria("Categoria C");
            for (String categoria : clasificable.obtenerCategoriasClasificacion()) {
                System.out.println("Categoria disponible: " + categoria);
            }

            Evaluable evaluable = trabajo;
            Evaluador evaluador = new Evaluador("Evaluacion Completa");
            evaluador.mostrarDetalles();
            evaluable.realizarEvaluacion(evaluador);
            System.out.println("Puntaje: " + evaluable.obtenerPuntaje());

            // prueba de excepciones
            System.out.println("\nProbando excepciones:");
            if (recursos.size() > 5) {
                throw new LimiteRecursosException("Limite de recursos permitidos exedido.");
            }

            try {
                clasificable.asignarCategoria("Categoria Inexistente");
            } catch (CategoriaInvalidaException e) {
                System.out.println(e.getMessage());
            }
            
            // buscar recursos por título. Excepcion: RecursoNoEncontrado
            System.out.println("\nBuscando recursos:");
            try {
                RecursoAcademico recursoEncontrado = gestor.buscarRecursoPorTitulo("Orgullo y Prejucio");
                System.out.println("Recurso encontrado: " + recursoEncontrado.getTitulo());
            } catch (RecursoNoEncontradoException e) {
                System.out.println(e.getMessage());
            }

            try {
                RecursoAcademico recursoNoEncontrado = gestor.buscarRecursoPorTitulo("Titulo Inexistente");
                System.out.println("Recurso encontrado: " + recursoNoEncontrado.getTitulo());
            } catch (RecursoNoEncontradoException e) {
                System.out.println(e.getMessage());
            }

        } catch (LimiteRecursosException e) {
            System.out.println("Excepcion: " + e.getMessage());
        } catch (CategoriaInvalidaException e) {
            System.out.println("Excepcion: " + e.getMessage());
        } 
    }   
    
}
