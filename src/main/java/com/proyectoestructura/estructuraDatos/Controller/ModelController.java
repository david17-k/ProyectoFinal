package com.proyectoestructura.estructuraDatos.Controller;

public class ModelController {

    private static ModelController getInstance;

    private synchronized  static ModelController singleton(){
        if(getInstance==null){
            getInstance=new ModelController();
        }
        return getInstance;
    }



}
