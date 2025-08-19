package Ejerc4;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/** @author Grupo 6 */

public class Evento {
    private String nombre;
    private LocalDate fecha;
    private String responsable;

    public Evento(String nombre, LocalDate fecha, String responsable) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.responsable = responsable;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }
    
    @Override
    public String toString(){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "Nombre: " + nombre +
                "\nFecha: " + fecha.format(formato) +
                "\nResponsable: " + responsable +
                "\n------------------------------------";
    }
}
