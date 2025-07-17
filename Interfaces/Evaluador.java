package Interfaces;
/*
 * @author Lucila Micaela Suarez
 */
public class Evaluador {
    private String tipoEvaluacion;

    public Evaluador(String tipoEvaluacion) {
        this.tipoEvaluacion = tipoEvaluacion;
    }

    public String getTipoEvaluacion() {
        return tipoEvaluacion;
    }

    public void setTipoEvaluacion(String tipoEvaluacion) {
        this.tipoEvaluacion = tipoEvaluacion;
    }
    
    public void mostrarDetalles() {
        System.out.println("Tipo de evaluacion: " + tipoEvaluacion);
    }
}
