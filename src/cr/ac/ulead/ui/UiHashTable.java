package cr.ac.ulead.ui;

import cr.ac.ulead.accesodatos.AccesoProducto;
import cr.ac.ulead.accesodatos.FileProcessor;
import cr.ac.ulead.logica.GestorProducto;
import cr.ac.ulead.modelos.hashtable.HashTable;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class UiHashTable {
    private PrintStream output = new PrintStream(System.out);
    private FileProcessor oneProcessor = new
            AccesoProducto("src\\cr\\ac\\ulead\\datos\\flipkart_com-ecommerce_sample.csv");
    private GestorProducto gestorProducto;
    private static Scanner scanner = new Scanner(System.in);
    HashTable hashTable;

    public UiHashTable(HashTable hashTable){
        this.hashTable = hashTable;
        this.gestorProducto = new GestorProducto(oneProcessor, this.hashTable);
    }

    public void menuMenuHash(){
        output.print("Bienvenido al Menu del Punto 1 \n");
        output.print("0 para cargar la lista \n");
        output.print("1 para imprimir filtrando segun los indices \n");
        output.print("2 para obtener la cantidad de datos por index \n");
        output.print("3 para salir \n");
    }

    public void ejecutarMenuHash(int opcion) throws FileNotFoundException {
        switch (opcion) {
            case 0:
                if (this.gestorProducto.estaVacia()){
                    this.gestorProducto.cargarLista();
                    this.gestorProducto.cargarUltimosDigitos();
                }else{
                    output.print("Lista llena \n");
                }
                break;
            case 1:
                output.print("Por favor ingrese un index para filtrar : ");
                this.gestorProducto.filtradoProducto(scanner.nextInt());
                break;
            case 2:
                this.gestorProducto.obtenerTodos();
                break;
            case 3:
                output.print("Gracias por usar el sistema");
                break;
        }
    }
}
