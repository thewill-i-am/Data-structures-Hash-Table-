package cr.ac.ulead.modelos;

import cr.ac.ulead.modelos.hashtable.HashTable;

public class Lista {
    private Nodo inicio = null;

    public boolean estaVacia() {
        return inicio == null;
    }

    public void agregar(Nodo nuevoNodo) {
        if (inicio == null) {
            inicio = nuevoNodo;
        } else {
            Nodo temp = inicio;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = nuevoNodo;
        }
    }

    public void imprimirListaFiltrado(String filter) {
        Nodo temp = inicio;
        while (temp != null) {
            if (temp.value.getNombre().contains(filter)){
                System.out.println(temp.value.getNombre());
                System.out.println(temp.value.getIndex());
            }
            temp = temp.next;
        }
    }

    public void generarListaAlfaNumericos() {
        Nodo temp = inicio;
        while (temp != null) {
            System.out.println(temp.value.getId()
                            .substring(temp.value.getId().length()-3));
            temp = temp.next;
        }
    }

    public void cargarUltimosDigitos(HashTable hashTable) {
        Nodo temp = inicio;
        while (temp != null) {
            hashTable.put(temp.value.getId().substring(temp.value.getId().length()-3), temp.value);
            temp = temp.next;
        }
    }
}
