package arbol;

public class NodoArbol {
    int contenido;
    String nombre;
    NodoArbol hijoIzquierdo, hijoDerecho;
    public NodoArbol(int d, String nom) {
        this.contenido = d;
        this.nombre = nom;
        this.hijoDerecho = null;
        this.hijoIzquierdo = null;
    }
    public String toString() {
        return nombre + " Contenido es " + contenido;
    }
    public NodoArbol buscarNodo(int valor) {
        NodoArbol actual = this;
        while (actual != null && actual.contenido != valor) {
            if (valor < actual.contenido) {
                actual = actual.hijoIzquierdo;
            } else {
                actual = actual.hijoDerecho;
            }
        }
        return actual;
    }
}