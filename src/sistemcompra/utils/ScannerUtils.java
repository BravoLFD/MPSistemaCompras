package sistemcompra.utils;

import java.util.Locale;
import java.util.Scanner;

public class ScannerUtils {

    public static final Scanner SC = new Scanner(System.in).useLocale(Locale.US);

    public static String capturarTexto(String mensaje) {
        System.out.println(mensaje + ": ");
        return SC.nextLine();
    }

    public static int capturarNum(String mensaje) {
        System.out.println(mensaje + ": ");
        while (!SC.hasNextInt()) {
            System.out.println("Dato no aceptado. " + mensaje + ": ");
            SC.next();
        }
        int dato = SC.nextInt();
        SC.nextLine();
        return dato;
    }

    public static double capturarDecimal(String mensaje) {
        System.out.println(mensaje + ": ");
        while (!SC.hasNextDouble()) {
            System.out.println("Dato no aceptado. " + mensaje + ": ");
            SC.next();
        }
        double dato = SC.nextDouble();
        SC.nextLine();
        return dato;
    }
}
