package cr.ac.ulead.modelos;

public class Nodo {
    public Nodo next;
    public Producto value;

    public Nodo (Producto value) {
        this.value = value;
    }
}