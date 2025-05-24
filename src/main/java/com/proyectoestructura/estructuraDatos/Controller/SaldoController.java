package com.proyectoestructura.estructuraDatos.Controller;

import com.proyectoestructura.estructuraDatos.Controller.ServicieController.SaldoControllerServicie;

public class SaldoController implements SaldoControllerServicie {

    ModelController modelController;



    @Override
    public boolean actualizarSaldo(int saldo) {
        return modelController.depositar(saldo);
    }
}
