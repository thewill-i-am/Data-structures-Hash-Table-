package cr.ac.ulead.accesodatos;

import cr.ac.ulead.modelos.Lista;
import cr.ac.ulead.modelos.Nodo;
import cr.ac.ulead.modelos.Producto;

import java.util.Scanner;

public class AccesoProducto extends FileProcessor {

    public AccesoProducto(String fileName) {
        super(fileName);
    }

    @Override
    protected Lista readLines(Scanner reader) {
        Lista result = new Lista();
        boolean skip = true;
        int i = 0;
        while (reader.hasNextLine()) {
                i++;
                String producto = reader.nextLine();
                if (!skip) {
                    Producto currentProducto = getProductDataFromString(producto, i);
                    Nodo nuevoNodo = new Nodo(currentProducto);
                    result.agregar(nuevoNodo);
                } else {
                    skip = false;
                }
        }
        return result;
    }

    private Producto getProductDataFromString(String currentData,int index) {
        Producto newProducto = new Producto();
        String[] data = currentData.split(",");
        newProducto.setIndex(index);
        newProducto.setId(data[0]);
        newProducto.setNombre(data[1]);
        newProducto.setCategoria(data[2]);
        return newProducto;
    }
}
