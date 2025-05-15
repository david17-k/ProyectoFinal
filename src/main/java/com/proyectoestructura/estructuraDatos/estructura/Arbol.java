package com.proyectoestructura.estructuraDatos.estructura;

import java.util.LinkedList;
import java.util.Queue;

public class Arbol {


        private NodoArbol arbol;
        private int tamaño;



        public void agregarDato(int numero) {// 30 45 20 50
            NodoArbol aux = new NodoArbol(numero);
            if (isVerificar()) {
                arbol = aux;
            } else {
                NodoArbol n = arbol;
                NodoArbol padre = null;
                while (n != null) {
                    padre = n;
                    if (numero > n.getDato()) {
                        n = n.getDerecha();
                    } else {
                        n = n.getIzquierda();
                    }
                }
                if (numero < padre.getDato()) {
                    padre.setIzquierda(aux);
                } else {
                    padre.setDerecha(aux);
                }
            }
        }

        public StringBuilder mostrarPostOrden() {
            StringBuilder sd = new StringBuilder();
            sd = recorrerPostOrden(arbol, sd);
            System.out.println(sd);
            return new StringBuilder(sd.toString());
        }

        public StringBuilder mostrarInorden() {
            StringBuilder sd = new StringBuilder();
            sd = recorrerInorden(arbol, sd);
            System.out.println(sd);
            return new StringBuilder(sd.toString());
        }

        public StringBuilder mostrarPreOrden() {
            StringBuilder sd = new StringBuilder();
            sd = recorrerPreOrden(arbol, sd);
            System.out.println(sd);
            return new StringBuilder(sd.toString());
        }

        public StringBuilder recorrerInorden(NodoArbol n, StringBuilder mensaje) {
            if (n != null) {
                recorrerInorden(n.getIzquierda(), mensaje);
                mensaje.append(n.getDato());
                recorrerInorden(n.getDerecha(), mensaje);
            }
            return mensaje;

        }

        public StringBuilder recorrerPreOrden(NodoArbol n, StringBuilder mensaje) {
            if (n != null) {
                mensaje.append(n.getDato());
                recorrerPreOrden(n.getIzquierda(), mensaje);
                recorrerPreOrden(n.getDerecha(), mensaje);
            }
            return mensaje;
        }

        public StringBuilder recorrerPostOrden(NodoArbol n, StringBuilder mensaje) {// 7, 5 , 10 ,8 ,12
            if (n != null) {
                recorrerPostOrden(n.getIzquierda(), mensaje);
                recorrerPostOrden(n.getDerecha(), mensaje);
                mensaje.append(n.getDato());
            }
            return mensaje;
        }

        public boolean isEmpty() {
            return arbol == null;
        }

        public String verificar(int buscar) {
            if (buscarNumero(buscar, arbol)) {
                return "Si esta";
            } else {
                return "No esta";
            }
        }

        public boolean buscarNumero(int buscar, NodoArbol aux) {
            if (aux != null) {
                if (buscar == aux.getDato()) {
                    return true;
                }
                if (buscar > aux.getDato()) {
                    return buscarNumero(buscar, aux.getDerecha());
                } else {
                    return buscarNumero(buscar, aux.getIzquierda());
                }
            } else {
                return false;
            }

        }

        public StringBuilder altura() {
            StringBuilder sd = new StringBuilder();
            sd.append(obtenerAltura(arbol));
            return sd;
        }

        public int obtenerAltura(NodoArbol n) {
            if (n == null) {
                return 0;
            }
            int alturaIzquierda = obtenerAltura(n.getIzquierda());
            System.out.println(alturaIzquierda);
            int alturaDerecha = obtenerAltura(n.getDerecha());
            System.out.println(alturaDerecha);
            return Math.max(alturaIzquierda, alturaDerecha) + 1;
        }

        public StringBuilder hojas() {
            StringBuilder sv = new StringBuilder();
            sv.append(contarHojas(arbol));
            return sv;
        }

        public int contarHojas(NodoArbol n) {
            if (n == null) {
                return 0;
            }
            if (n.getIzquierda() == null && n.getDerecha() == null) {
                return 1;
            } else {
                int izqui = contarHojas(n.getIzquierda());
                int derec = contarHojas(n.getDerecha());
                return izqui + derec;
            }
        }

        public void borrarArbol() {
            arbol = null;
        }



        public void borrarDato(int valor) {
            arbol = borrar(arbol, valor);
        }


        private NodoArbol borrar(NodoArbol nodo, int valor) {
            if (nodo == null) {
                return null;
            }
            if (valor < nodo.getDato()) {
                nodo.setIzquierda(borrar(nodo.getIzquierda(), valor));
            } else if (valor > nodo.getDato()) {
                nodo.setDerecha(borrar(nodo.getDerecha(), valor));
            } else {
                if (nodo.getIzquierda() == null) {
                    return nodo.getDerecha();
                }
                if (nodo.getDerecha() == null) {
                    return nodo.getIzquierda();
                }
                NodoArbol sucesor = encontrarMinimo(nodo.getDerecha());
                nodo.setDato(sucesor.getDato());
                nodo.setDerecha(borrar(nodo.getDerecha(), sucesor.getDato()));
            }
            return nodo;
        }

        private NodoArbol encontrarMinimo(NodoArbol nodo) {
            while (nodo.getIzquierda() != null) {
                nodo = nodo.getIzquierda();
            }
            return nodo;
        }

        private int obtenerPeso(NodoArbol n){
            if(n==null){
                return 0;
            }
            int pesoIzq=obtenerPeso(n.getIzquierda());
            int pesoDere=obtenerPeso(n.getDerecha());
            return 1+pesoIzq+pesoDere;
        }

        public StringBuilder peso(){
            StringBuilder sx=new StringBuilder();
            sx.append(obtenerPeso(arbol));
            return sx;
        }

        private int obtenerNivel(NodoArbol nodo, int valor, int nivel) {
            if (nodo == null) {
                return 0;
            }
            if (nodo.getDato() == valor) {
                return nivel;
            }
            int nivelIzq = obtenerNivel(nodo.getIzquierda(), valor, nivel + 1);
            if (nivelIzq != 0) {
                return nivelIzq;
            }
            return obtenerNivel(nodo.getDerecha(), valor, nivel + 1);
        }

        public StringBuilder nivel(int valor){
            StringBuilder sd=new StringBuilder();
            sd.append(obtenerNivel(arbol,valor,0));
            return sd;

        }

        public StringBuilder amplitud(){
            StringBuilder sz=new StringBuilder();
            imprimirAmplitud(arbol,sz);
            return sz;
        }



        private StringBuilder imprimirAmplitud(NodoArbol n,StringBuilder sx) {
            if (n == null) {
                return null;
            }

            Queue<NodoArbol> cola = new LinkedList<>();
            cola.add(n);

            while (!cola.isEmpty()) {
                NodoArbol actual = cola.poll();
                sx.append(actual.getDato());

                if (actual.getIzquierda() != null) {
                    cola.add(actual.getIzquierda());
                }
                if (actual.getDerecha() != null) {
                    cola.add(actual.getDerecha());
                }
            }

            return sx;
        }

        public StringBuilder mayor(){
            StringBuilder sa=new StringBuilder();
            sa.append(obtenerMayor(arbol,0));
            return sa;
        }

        public StringBuilder menor(){
            StringBuilder sw=new StringBuilder();
            sw.append(obtenerMenor(arbol,arbol.getDato()));
            return sw;
        }

        private int obtenerMayor(NodoArbol n,int mayor) {
            if (n == null) {
                return 0;
            }
            if (n.getDato() > mayor) {
                mayor = n.getDato();
            }
            int i=obtenerMayor(n.getDerecha(),mayor);
            return Math.max(mayor,i);
        }

        private int obtenerMenor(NodoArbol n,int menor){
            if (n == null) {
                return 0;
            }
            if(n.getIzquierda()==null){
                return n.getDato();
            }
            int i=obtenerMenor(n.getIzquierda(),menor);

            return Math.min(i,menor);
        }

        private boolean isVerificar() {
            return arbol==null;
        }
}
