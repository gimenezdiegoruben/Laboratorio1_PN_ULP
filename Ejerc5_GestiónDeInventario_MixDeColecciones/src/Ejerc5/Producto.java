package Ejerc5;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/** @author Grupo 6 */

public class Producto {
    private String codigo;
    private String nombre;
    private double precio;
    private LocalDate fechaDeIngreso;

    public Producto(String codigo, String nombre, double precio, LocalDate fechaDeIngreso) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.fechaDeIngreso = fechaDeIngreso;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public LocalDate getFechaDeIngreso() {
        return fechaDeIngreso;
    }

    public void setFechaDeIngreso(LocalDate fechaDeIngreso) {
        this.fechaDeIngreso = fechaDeIngreso;
    }
    
    @Override
    public String toString(){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "Codigo: " + codigo + 
                "\nNombre: " + nombre + 
                "\nPrecio: $" + precio + 
                "\nFecha de Ingreso: " + fechaDeIngreso.format(formato) +
                "\n--------------------------------------";
    }
}
