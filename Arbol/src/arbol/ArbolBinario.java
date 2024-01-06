package arbol;

public class ArbolBinario {
    NodoArbol raiz;

    public ArbolBinario() {
        raiz = null;
    }

    public void nuevoNodo(int d, String nom) {
        NodoArbol nuevo = new NodoArbol(d, nom);
        if (raiz == null) {
            raiz = nuevo;
        } else {
            NodoArbol auxiliar = raiz;
            NodoArbol padre;
            while (true) {
                padre = auxiliar;
                if (d < auxiliar.contenido) {
                    auxiliar = auxiliar.hijoIzquierdo;
                    if (auxiliar == null) {
                        padre.hijoIzquierdo = nuevo;
                        return;
                    }
                } else {
                    auxiliar = auxiliar.hijoDerecho;
                    if (auxiliar == null) {
                        padre.hijoDerecho = nuevo;
                        return;
                    }
                }
            }
        }
    }

    public boolean nodoVacio() {
        return raiz == null;
    }

    public void inOrden(NodoArbol rz) {
        if (rz != null) {
            inOrden(rz.hijoIzquierdo);
            System.out.println(rz.contenido);
            inOrden(rz.hijoDerecho);
        }
    }

    public void preOrden(NodoArbol rz) {
        if (rz != null) {
            System.out.println(rz.contenido);
            preOrden(rz.hijoIzquierdo);
            preOrden(rz.hijoDerecho);
        }
    }

    public void postOrden(NodoArbol rz) {
        if (rz != null) {
            postOrden(rz.hijoIzquierdo);
            postOrden(rz.hijoDerecho);
            System.out.println(rz.contenido);
        }
    }

    public NodoArbol buscarNodo(int valorBuscado) {
        return buscarNodoRecursivo(raiz, valorBuscado);
    }

    private NodoArbol buscarNodoRecursivo(NodoArbol nodo, int valorBuscado) {
        if (nodo == null) {
            return null;
        }
        if (valorBuscado == nodo.contenido) {
            return nodo;
        }
        if (valorBuscado < nodo.contenido) {
            return buscarNodoRecursivo(nodo.hijoIzquierdo, valorBuscado);
        }
        return buscarNodoRecursivo(nodo.hijoDerecho, valorBuscado);
    }

    public boolean eliminarNodo(int valor) {
        NodoArbol actual = raiz;
        NodoArbol padre = raiz;
        boolean esHijoIzquierdo = true;

        while (actual.contenido != valor) {
            padre = actual;
            if (valor < actual.contenido) {
                esHijoIzquierdo = true;
                actual = actual.hijoIzquierdo;
            } else {
                esHijoIzquierdo = false;
                actual = actual.hijoDerecho;
            }
            if (actual == null) {
                return false; // No se encontró el nodo a eliminar
            }
        }

        // Caso 1: El nodo a eliminar es una hoja (no tiene hijos)
        if (actual.hijoIzquierdo == null && actual.hijoDerecho == null) {
            if (actual == raiz) {
                raiz = null;
            } else if (esHijoIzquierdo) {
                padre.hijoIzquierdo = null;
            } else {
                padre.hijoDerecho = null;
            }
        }
        // Caso 2: El nodo a eliminar tiene un solo hijo
        else if (actual.hijoDerecho == null) {
            if (actual == raiz) {
                raiz = actual.hijoIzquierdo;
            } else if (esHijoIzquierdo) {
                padre.hijoIzquierdo = actual.hijoIzquierdo;
            } else {
                padre.hijoDerecho = actual.hijoIzquierdo;
            }
        } else if (actual.hijoIzquierdo == null) {
            if (actual == raiz) {
                raiz = actual.hijoDerecho;
            } else if (esHijoIzquierdo) {
                padre.hijoIzquierdo = actual.hijoDerecho;
            } else {
                padre.hijoDerecho = actual.hijoDerecho;
            }
        }
        // Caso 3: El nodo a eliminar tiene dos hijos
        else {
            NodoArbol sucesor = obtenerSucesor(actual);
            if (actual == raiz) {
                raiz = sucesor;
            } else if (esHijoIzquierdo) {
                padre.hijoIzquierdo = sucesor;
            } else {
                padre.hijoDerecho = sucesor;
            }
            sucesor.hijoIzquierdo = actual.hijoIzquierdo;
        }

        return true;
    }

    private NodoArbol obtenerSucesor(NodoArbol nodo) {
        NodoArbol sucesorPadre = nodo;
        NodoArbol sucesor = nodo;
        NodoArbol actual = nodo.hijoDerecho;

        while (actual != null) {
            sucesorPadre = sucesor;
            sucesor = actual;
            actual = actual.hijoIzquierdo;
        }

        if (sucesor != nodo.hijoDerecho) {
            sucesorPadre.hijoIzquierdo = sucesor.hijoDerecho;
            sucesor.hijoDerecho = nodo.hijoDerecho;
        }

        return sucesor;
    }
}
