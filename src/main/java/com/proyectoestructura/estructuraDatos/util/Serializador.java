package com.proyectoestructura.estructuraDatos.util;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.proyectoestructura.estructuraDatos.estructura.Cola;
import com.proyectoestructura.estructuraDatos.estructura.Lista;
import com.proyectoestructura.estructuraDatos.model.Deposito;

import com.proyectoestructura.estructuraDatos.model.Usuario;

import java.util.List;

public class Serializador {


    private static final ObjectMapper objectMapper = new ObjectMapper();
    public static <T>String serializar(Lista<T>lista) throws JsonProcessingException {
        return objectMapper.writeValueAsString(lista.toList());
    }

    public static Lista<Usuario> deserializarUsuarios(String json) throws Exception {
        Lista<Usuario> lista = new Lista<>();
        java.util.List<Usuario> usuarios = objectMapper.readValue(json, new TypeReference<List<Usuario>>() {});
        for (Usuario u : usuarios) {
            lista.agregarPrimera(u);
        }
        return lista;
    }
    private static final ObjectMapper mapper = new ObjectMapper();

    public static <T> String serializar(Object estructura) throws Exception {
        return mapper.writeValueAsString(((Iterable<T>) estructura).iterator());
    }

    public static Lista<Usuario> deserializarListaUsuario(String json) throws Exception {
        List<Usuario> data = mapper.readValue(json, new TypeReference<>() {});
        Lista<Usuario> lista = new Lista<>();
        data.forEach(lista::agregarPrimera);
        return lista;
    }

    public static Lista<Deposito> deserializarListaDeposito(String json) throws Exception {
        List<Deposito> data = mapper.readValue(json, new TypeReference<>() {});
        Lista<Deposito> lista = new Lista<>();
        data.forEach(lista::agregarPrimera);
        return lista;
    }

    public static Cola<Usuario> deserializarColaUsuario(String json) throws Exception {
        List<Usuario> data = mapper.readValue(json, new TypeReference<>() {});
        Cola<Usuario> cola = new Cola<>();
        data.forEach(cola::push);
        return cola;
    }

    
}
