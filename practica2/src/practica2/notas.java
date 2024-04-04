package practica2;
import java.util.Scanner;

/**
 * Clase Notas
 * <p>
 * Esta clase se utiliza para ingresar y calcular las notas de un estudiante.
 * </p>
 * 
 * @author Carlos Vallés
 * @version 1.0
 * @since 2024
 */
public class notas {
    /**
     * Nota de la primera unidad formativa.
     */
    double notaUnidadFormativa1;

    /**
     * Nota de la segunda unidad formativa.
     */
    double notaUnidadFormativa2;

    /**
     * Nota de la tercera unidad formativa.
     */
    double notaUnidadFormativa3;

    /**
     * Acumulado de la primera unidad formativa.
     */
    double acumuladoUnidadFormativa1;

    /**
     * Acumulado de la segunda unidad formativa.
     */
    double acumuladoUnidadFormativa2;

    /**
     * Acumulado de la tercera unidad formativa.
     */
    double acumuladoUnidadFormativa3;

    /**
     * Nota definitiva del estudiante.
     */
    double notaDefinitiva;

    /**
     * Scanner para leer las notas ingresadas por el usuario.
     */
    Scanner entrada = new Scanner(System.in);

    /**
     * Método para ingresar las notas del estudiante.
     * <p>
     * Este método solicita al usuario que ingrese las notas de las tres unidades formativas.
     * </p>
     */
    public void ingresarNotas() {
        System.out.println("Ingrese las notas del estudiante");
        notaUnidadFormativa1 = solicitarNota("1");
        notaUnidadFormativa2 = solicitarNota("2");
        notaUnidadFormativa3 = solicitarNota("3");
    }

    /**
     * Método para solicitar una nota al usuario.
     * <p>
     * Este método solicita al usuario que ingrese una nota y verifica que esté en el rango correcto (0-10).
     * </p>
     * 
     * @param notaNumero El número de la nota a solicitar.
     * @return La nota ingresada por el usuario.
     */
    private double solicitarNota(String notaNumero) {
        double nota;
        do {
            System.out.print("Ingrese nota " + notaNumero + ": ");
            nota = entrada.nextDouble();
            if (nota < 0 || nota > 10) {
                System.out.println("Nota " + notaNumero + " mal introducida. Debe estar entre 0 y 10.");
            }
        } while (nota < 0 || nota > 10);
        return nota;
    }

    /**
     * Método para calcular la nota definitiva.
     * <p>
     * Este método calcula la nota definitiva del estudiante basándose en las notas de las unidades formativas y los valores correspondientes.
     * </p>
     */
    public void calcularNotas() {
        acumuladoUnidadFormativa1 = notaUnidadFormativa1 * 0.35;
        acumuladoUnidadFormativa2 = notaUnidadFormativa2 * 0.35;
        acumuladoUnidadFormativa3 = notaUnidadFormativa3 * 0.30;
        notaDefinitiva = acumuladoUnidadFormativa1 + acumuladoUnidadFormativa2 + acumuladoUnidadFormativa3;
    }

    /**
     * Método para mostrar las notas y la nota definitiva.
     * <p>
     * Este método muestra las notas ingresadas, los acumulados y la nota definitiva.
     * </p>
     */
    public void mostrarNotas() {
        System.out.println("Las notas introducidas son:");
        System.out.println("Nota 1 = " + notaUnidadFormativa1);
        System.out.println("Nota 2 = " + notaUnidadFormativa2);
        System.out.println("Nota 3 = " + notaUnidadFormativa3);
        System.out.println("Acumulado 1 = "+ acumuladoUnidadFormativa1);
        System.out.println("Acumulado 2 = "+ acumuladoUnidadFormativa2);
        System.out.println("Acumulado 3 = "+ acumuladoUnidadFormativa3);
        System.out.println("La nota definitiva es = "+ notaDefinitiva);
    }

    /**
     * Método para determinar si el estudiante aprobó o no.
     * <p>
     * Este método verifica si la nota definitiva es mayor o igual a 5 para determinar si el estudiante aprobó.
     * Si la nota definitiva es menor a 5, se muestra un mensaje indicando que el estudiante suspendió.
     * </p>
     */
    public void determinarAprobacion() {
        if(notaDefinitiva < 5 && notaDefinitiva >= 0) {
            System.out.println("El estudiante ha suspendido");
        } else if (notaDefinitiva >= 5 && notaDefinitiva <= 10 ) {
            System.out.println("El estudiante ha aprobado");
        } else {
            System.out.println("Error en las notas");
        }
    }

    /**
     * Método principal.
     * <p>
     * Este método crea una instancia de la clase Notas y llama a los métodos para ingresar las notas, comprobarlas, calcular la nota definitiva, mostrar las notas y determinar si el estudiante aprobó.
     * </p>
     * 
     * @param args Argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        notas notas = new notas();
        notas.ingresarNotas();
        notas.calcularNotas();
        notas.mostrarNotas();
        notas.determinarAprobacion();
    }
}