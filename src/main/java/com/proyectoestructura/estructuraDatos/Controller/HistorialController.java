package com.proyectoestructura.estructuraDatos.Controller;

import com.proyectoestructura.estructuraDatos.model.Transaccion;
import com.proyectoestructura.estructuraDatos.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.nio.charset.StandardCharsets;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/api/historial")
public class HistorialController {

    // Simulación de historial, tú puedes obtenerlo desde base de datos o estructura
    @GetMapping("/transacciones")
    public List<Transaccion> obtenerHistorial() {
        return List.of(
                new Transaccion(LocalTime.now(), "Depósito", 100.0, "USD", "Saldo inicial"),
                new Transaccion(LocalTime.now(), "Retiro", 50.0, "USD", "Compra online"),
                new Transaccion(LocalTime.now(), "Transferencia", 30.0, "USD", "A Juan Pérez")
        );
    }
    @GetMapping(value = "/descargar", produces = "text/plain")
    public ResponseEntity<byte[]> descargarHistorial() {
        StringBuilder contenido = new StringBuilder("Historial de Transacciones:\n\n");

        List<Transaccion> historial = obtenerHistorial(); // Simula obtenerlo
        for (Transaccion t : historial) {
            contenido.append("Fecha: ").append(t.getFecha())
                    .append(" | Tipo: ").append(t.getTipo())
                    .append(" | Monto: ").append(t.getMonto()).append(" ").append(t.getMoneda())
                    .append(" | Descripción: ").append(t.getDescripcion())
                    .append("\n");
        }

        byte[] archivo = contenido.toString().getBytes(StandardCharsets.UTF_8);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDisposition(ContentDisposition.attachment().filename("historial.txt").build());

        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(archivo.length)
                .contentType(MediaType.TEXT_PLAIN)
                .body(archivo);
    }
}
