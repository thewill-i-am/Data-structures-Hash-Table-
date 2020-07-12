package cr.ac.ulead.modelos.hashtable;

import cr.ac.ulead.modelos.Producto;

public class HashTableDto {
    public String key;
    public Producto value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Producto getValue() {
        return this.value;
    }

    public void setValue(Producto value) {
       this.value = value;
    }
}
