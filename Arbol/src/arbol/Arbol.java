package arbol;

import javax.swing.JOptionPane;

public class Arbol {

    public static void main(String[] args) {
        int valor, opc;
        String nombre;

        ArbolBinario arbin = new ArbolBinario();
        

        do {
            try {
                opc = Integer.parseInt(JOptionPane.showInputDialog(null
                        ,"1 Nuevo Nodo\n"
                        +"2 R-I-D Recorrido preOrden\n"
                        +"3 I-R-D Recorrido inOrden\n"
                        +"4 R-D-I Recorrido postOrden\n"
                        +"5 Buscar Nodo\n"
                                 +"6 Eliminar Nodo\n"  
                        +"0 Salir\n"
                        +"Elige Opcion","Arbol Binario",JOptionPane.QUESTION_MESSAGE));
                switch(opc) {
                    case 1:
                        valor = Integer.parseInt(JOptionPane.showInputDialog(null,
                                 "Numero del Nodo",
                                 "Agregando valor del Nodo",
                                 JOptionPane.QUESTION_MESSAGE));
                        nombre = JOptionPane.showInputDialog(null,
                                 "Contenido de Nodo",
                                 "Agregando valor del Nodo",
                                 JOptionPane.QUESTION_MESSAGE);
                        arbin.nuevoNodo(valor, nombre);
                        break;
                    case 2:
                        if (!arbin.nodoVacio()) {
                            arbin.preOrden(arbin.raiz);
                        } else {
                            JOptionPane.showMessageDialog(null,"Arbol vacio");
                        }
                        break;
                    case 3:
                        if(!arbin.nodoVacio()){
                            arbin.inOrden(arbin.raiz);
                        }else{    
                            JOptionPane.showMessageDialog(null,"Arbol vacio");
                        }
                        break;
                    case 4:
                        if(!arbin.nodoVacio()){
                            arbin.postOrden(arbin.raiz);
                        }else{    
                            JOptionPane.showMessageDialog(null,"Arbol vacio");
                        }
                        break;
                    case 5:
                        int valorBuscado = Integer.parseInt(JOptionPane.showInputDialog(null,
                "Ingrese el valor del nodo a buscar",
                "Buscando nodo", JOptionPane.QUESTION_MESSAGE));

        NodoArbol nodoEncontrado = arbin.buscarNodo(valorBuscado);
        if (nodoEncontrado != null) {
            JOptionPane.showMessageDialog(null,
                    "Se encontró el nodo con valor " + nodoEncontrado.contenido);
        } else {
            JOptionPane.showMessageDialog(null,
                    "No se encontró el nodo con valor " + valorBuscado);
        }
                        if (!arbin.nodoVacio()) {
                            valor = Integer.parseInt(JOptionPane.showInputDialog(null,
                                         "Valor del Nodo a buscar",
                                         "Buscando Nodo",
                                         JOptionPane.QUESTION_MESSAGE));
                            nodoEncontrado = arbin.buscarNodo(valor);
                            if (nodoEncontrado != null) {
                                JOptionPane.showMessageDialog(null, "Se encontró el nodo con valor: " + nodoEncontrado.contenido);
                            } else {
                                JOptionPane.showMessageDialog(null, "No se encontró el nodo con valor: " + valor);
                            }
                        } else
{
                            JOptionPane.showMessageDialog(null,"Arbol vacio");
                        }
                        break;
                        case 6:
    if (!arbin.nodoVacio()) {
        valor = Integer.parseInt(JOptionPane.showInputDialog(null,
                     "Valor del Nodo a eliminar",
                     "Eliminando Nodo",
                     JOptionPane.QUESTION_MESSAGE));
        if (arbin.eliminarNodo(valor)) {
            JOptionPane.showMessageDialog(null, "Nodo eliminado exitosamente");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró el nodo a eliminar");
        }
    } else {
        JOptionPane.showMessageDialog(null, "Arbol vacio");
    }
    break;

                    case 0:
                        System.exit(0);
                        break;
                }
            } catch(NumberFormatException n) {
                JOptionPane.showMessageDialog(null, "Error " + n.getMessage());
            }
        } while(true);
    }
}

