package practica2;
import java.util.Scanner;

public class notas {
    double notaUnidadFormativa1;
    double notaUnidadFormativa2;
    double notaUnidadFormativa3;
    double acumuladoUnidadFormativa1;
    double acumuladoUnidadFormativa2;
    double acumuladoUnidadFormativa3;
    double notaDefinitiva;
    Scanner entrada = new Scanner(System.in);

    public void ingresarNotas() {
        System.out.println("Ingrese las notas del estudiante");
        notaUnidadFormativa1 = solicitarNota("1");
        notaUnidadFormativa2 = solicitarNota("2");
        notaUnidadFormativa3 = solicitarNota("3");
    }

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

    public void calcularNotas() {
        acumuladoUnidadFormativa1 = notaUnidadFormativa1 * 0.35;
        acumuladoUnidadFormativa2 = notaUnidadFormativa2 * 0.35;
        acumuladoUnidadFormativa3 = notaUnidadFormativa3 * 0.30;
        notaDefinitiva = acumuladoUnidadFormativa1 + acumuladoUnidadFormativa2 + acumuladoUnidadFormativa3;
    }

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

    public void determinarAprobacion() {
        if(notaDefinitiva < 5 && notaDefinitiva >= 0) {
            System.out.println("El estudiante ha suspendido");
        } else if (notaDefinitiva >= 5 && notaDefinitiva <= 10 ) {
            System.out.println("El estudiante ha aprobado");
        } else {
            System.out.println("Error en las notas");
        }
    }

    public static void main(String[] args) {
        notas notas = new notas();
        notas.ingresarNotas();
        notas.calcularNotas();
        notas.mostrarNotas();
        notas.determinarAprobacion();
    }
}