package cr.ac.ulead;

import cr.ac.ulead.modelos.hashtable.HashTable;
import cr.ac.ulead.ui.UiHashTable;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainHashTable {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws FileNotFoundException {
        HashTable hashTable = new HashTable();
        UiHashTable interfaz = new UiHashTable(hashTable);
        int eleccion;
        do {
            interfaz.menuMenuHash();
            eleccion = scanner.nextInt();
            interfaz.ejecutarMenuHash(eleccion);
        }while (eleccion != 3);
    }
}
