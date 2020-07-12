package cr.ac.ulead.modelos.hashtable;

import cr.ac.ulead.modelos.Producto;
import java.util.ArrayList;

public class HashTable {
    private final int tamanio = 4096;
    private ArrayList<Producto>[] linkeadoProducto = new ArrayList[tamanio];

    private ArrayList<Producto> getObj(int Posicion) {
        if(Posicion >  tamanio)
            return null;
        ArrayList<Producto> items = linkeadoProducto[Math.abs(Posicion)];
        return items;
    }

    public ArrayList<Producto> get(int Posicion) {
        ArrayList<Producto> item = getObj(Posicion);
        if(item == null)
            return null;
        else
            return item;
    }

    public ArrayList<Producto>[] getAll() {
        return linkeadoProducto;
    }

    public void put(String key, Producto value) {
        int index=Integer.parseInt(key,16);
        ArrayList<Producto> itemsProducto = linkeadoProducto[Math.abs(index)];
        if(itemsProducto == null) {
            itemsProducto = new ArrayList<Producto>();
            itemsProducto.add(value);
            linkeadoProducto[Math.abs(index)] = itemsProducto;
        }
        else {
            for(Producto item : itemsProducto) {
                if(item.getId().substring(item.getId().length()-3).equals(key)) {
                    itemsProducto.add(value);
                    return;
                }
            }
            itemsProducto.add(value);
        }
    }
}

