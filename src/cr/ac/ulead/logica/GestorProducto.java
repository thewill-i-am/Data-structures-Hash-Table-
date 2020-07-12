package cr.ac.ulead.logica;

import cr.ac.ulead.accesodatos.FileProcessor;
import cr.ac.ulead.modelos.hashtable.HashTable;
import cr.ac.ulead.modelos.Lista;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class GestorProducto {
    FileProcessor processor;
    Lista productos = new Lista();
    HashTable hashTable;

    public GestorProducto(FileProcessor oneProcessor, HashTable hashTable) {
        this.processor = oneProcessor;
        this.hashTable = hashTable;
    }

    public GestorProducto(FileProcessor oneProcessor) {
        this.processor = oneProcessor;
    }

    public boolean estaVacia(){
        return this.productos.estaVacia();
    }

    public void cargarLista() throws FileNotFoundException {
        if (this.productos.estaVacia()){
            this.productos = this.processor.processFile();
            System.out.println("Lista Cargada");
        }else{
            System.out.println("Lista Llena");
        }
    }

    public void generarListaAlfaNumericos(){
        this.productos.generarListaAlfaNumericos();
    }

    public void imprimirFiltrado(String filter) {
        this.productos.imprimirListaFiltrado(filter);
    }

    public void cargarUltimosDigitos() {
        this.productos.cargarUltimosDigitos(this.hashTable);
    }

    public void filtradoProducto(int index){
        for (int i = 0; i < hashTable.get(index).size() ; i++) {
            System.out.println("Producto");
            System.out.println(hashTable.get(index).get(i).getIndex());
            System.out.println(hashTable.get(index).get(i).getId());
            System.out.println(hashTable.get(index).get(i).getNombre());
            System.out.println(hashTable.get(index).get(i).getCategoria());
            System.out.println("\n");
        }
    }

    public void obtenerTodos() {
        for (int i = 0; i < hashTable.getAll().length ; i++) {
            System.out.println(i + "<- poscision");
            System.out.println("Cantidad de elementos " +
                    (hashTable.get(i) != null ? hashTable.get(i).size() : 0 ));
        }
    }
}
