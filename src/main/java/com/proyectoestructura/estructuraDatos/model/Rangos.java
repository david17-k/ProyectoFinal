package com.proyectoestructura.estructuraDatos.model;

public enum Rangos {
        BRONCE, PLATA, ORO, PLATINO;
        public static Rangos obtenerRango(int puntos) {
            if (puntos < 500) return BRONCE;
            if (puntos < 1001) return PLATA;
            if (puntos < 5000) return ORO;
            return PLATINO;

    }
}
