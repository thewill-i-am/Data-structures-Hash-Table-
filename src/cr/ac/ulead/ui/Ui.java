package cr.ac.ulead.ui;

import cr.ac.ulead.accesodatos.AccesoProducto;
import cr.ac.ulead.accesodatos.FileProcessor;
import cr.ac.ulead.logica.GestorProducto;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Ui {
    private Scanner scanner = new Scanner(System.in);
    private PrintStream output = new PrintStream(System.out);
    private FileProcessor oneProcessor = new
            AccesoProducto("src\\cr\\ac\\ulead\\datos\\flipkart_com-ecommerce_sample.csv");
    private GestorProducto gestorProducto = new GestorProducto(oneProcessor);

    public void menu(){
        output.print("Bienvenido al Menu del Punto 1 \n");
        output.print("0 para cargar la lista \n");
        output.print("1 para imprimir filtrando los resultados \n");
        output.print("2 para imprimir los datos alfanumericos \n");
        output.print("3 para salir \n");
    }

    public void ejecutar(int opcion) throws FileNotFoundException {
        switch (opcion){
            case 0 :
                if (this.gestorProducto.estaVacia()){
                    gestorProducto.cargarLista();
                }else{
                    output.print("Lista ya estaba cargada \n");
                }
                break;
            case 1 :
                System.out.println("Por favor ingrese un string para filtrar : ");
                gestorProducto.imprimirFiltrado(scanner.nextLine());
                break;
            case 2 :
                gestorProducto.generarListaAlfaNumericos();
                break;
            case 3 :
                output.print("Gracias por usar el sistema");
                break;
        }
    }
}
