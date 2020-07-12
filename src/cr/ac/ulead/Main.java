package cr.ac.ulead;

import cr.ac.ulead.ui.Ui;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws FileNotFoundException {
        Ui interfaz = new Ui();
        int eleccion;
        do {
            interfaz.menu();
            eleccion = scanner.nextInt();
            interfaz.ejecutar(eleccion);
        }while (eleccion != 3);
    }
}
