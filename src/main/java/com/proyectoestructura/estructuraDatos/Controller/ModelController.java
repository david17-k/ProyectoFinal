package com.proyectoestructura.estructuraDatos.Controller;


import com.proyectoestructura.estructuraDatos.estructura.Lista;
import com.proyectoestructura.estructuraDatos.model.Deposito;
import com.proyectoestructura.estructuraDatos.model.Monedero;
import com.proyectoestructura.estructuraDatos.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ModelController {



     private Monedero monedero;

    @Autowired
    private ApiController apiController;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();




    public boolean depositar(int deposito) {
        if (deposito > 0) {
            Deposito deposito1 = new Deposito(deposito);

            return true;
        } else {
            return false;
        }
    }

    public void crearCuenta(Usuario usuario) {
        System.out.println("Usuario " + usuario.getNombre() + "Guaradado");
    }




    public void registarTransaccion() {

    }


    public void obtenerUsuario(Usuario usuario){
        monedero.getInicioSeccion().push(usuario);
    }

    public void depositar(Deposito deposito,Monedero monedero){
       monedero.getDeposito().agregarPrimera(deposito);
       monedero.getDeposito().mostrarContenido();
    }

    public double actulizar(){
        return actuliarSaldo(monedero.getDeposito());
    }

    public double actuliarSaldo(Lista<Deposito>actulizar){
        double total=0;
      if(!actulizar.isEmpti()){
          Deposito deposito=actulizar.vaciarLista();
          total+=deposito.getDeposito();
        }
        return total;

    }










}
