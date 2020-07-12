package cr.ac.ulead.modelos.hashtable;

import cr.ac.ulead.modelos.Producto;

import java.util.ArrayList;

public class HashTable {
    private final int tamanio = 4096;
    private ArrayList<HashTableDto>[] linkeado = new ArrayList[tamanio];

    private ArrayList<HashTableDto> getObj(int Posicion) {
        if(Posicion >  tamanio)
            return null;
        ArrayList<HashTableDto> items = linkeado[Math.abs(Posicion)];
        return items;
    }

    public ArrayList<HashTableDto> get(int Posicion) {
        ArrayList<HashTableDto> item = getObj(Posicion);
        if(item == null)
            return null;
        else
            return item;
    }

    public ArrayList<HashTableDto>[] getAll() {
        return linkeado;
    }

    public void put(String key, Producto value) {
        int index=Integer.parseInt(key,16);
        ArrayList<HashTableDto> items = linkeado[Math.abs(index)];
        if(items == null) {
            items = new ArrayList<HashTableDto>();
            HashTableDto item = new HashTableDto();
            item.setKey(key);
            item.setValue(value) ;
            items.add(item);
            linkeado[Math.abs(index)] = items;
        }
        else {
            HashTableDto Newitem = new HashTableDto();
            Newitem.setKey(key);
            Newitem.setValue(value);
            for(HashTableDto item : items) {
                if(item.getKey().equals(key)) {
                    items.add(Newitem);
                    return;
                }
            }
            HashTableDto item = new HashTableDto();
            item.setKey(key);
            item.setValue(value);
            items.add(item);
        }
    }
}

