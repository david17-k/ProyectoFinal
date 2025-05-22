package com.proyectoestructura.estructuraDatos.Controller;


import com.proyectoestructura.estructuraDatos.model.Cuenta;
import com.proyectoestructura.estructuraDatos.model.Deposito;
import com.proyectoestructura.estructuraDatos.model.Monedero;
import com.proyectoestructura.estructuraDatos.model.Usuario;
import com.proyectoestructura.estructuraDatos.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ModelController {

    private static ModelController getInstance;
    Monedero monedero=new Monedero();

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    Cuenta cuenta=new Cuenta();

    public   synchronized  static ModelController singleton(){
        if(getInstance==null){
            getInstance=new ModelController();
        }
        return getInstance;
    }

    public boolean depositar(int deposito){
        if(deposito>0){
            Deposito deposito1=new Deposito(deposito);

            return true;
        }else{
            return false;
        }
    }

    public void crearCuenta(Usuario usuario){
        monedero.getUsuarioLista().agregarPrimera(usuario);
        monedero.getUsuarioLista().mostrarContenido();
        usuarioRepositorio.save(usuario);
        System.out.println("Usuario"+ usuario.getNombre()+ "Guaradado");
    }


    public boolean verificarInicio(String nombre,String id){
        boolean encontrado=false;
        for(Usuario u: monedero.getUsuarioLista()){
            if(nombre.equals(u.getNombre()) && id.equals(u.getIdCuenta())){
                System.out.println("Registrado");
                encontrado=true;
            }
        }
        return encontrado;
    }

    public void registarTransaccion(){

    }

    public void guardarLog(String usuario){
        monedero.getInicioSeccion().push(usuario);
        monedero.getInicioSeccion().ver();
    }

    public String cuentaUsuario(){
       return monedero.getInicioSeccion().poll();
    }




}
