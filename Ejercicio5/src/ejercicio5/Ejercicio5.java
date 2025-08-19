/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio5;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Grupo 6
 */
public class Ejercicio5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Producto> productos = new ArrayList<>();
        HashMap<String, Integer> stock = new HashMap<>();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        int opcion;
        
        do{
            System.out.println("----- MENU -----");
            System.out.println("1. Agregar producto y stock inicial");
            System.out.println("2. Actualizar stock");
            System.out.println("3. Eliminar producto");
            System.out.println("4. Mostrar productos por precio (mayor a menor)");
            System.out.println("5. Mostrar productos por fecha de ingreso (mas reciente primero");
            System.out.println("6. Salir");
            opcion = sc.nextInt();
            sc.nextLine();
            
            switch (opcion){
                case 1:
                    try{
                        
                        System.out.println("Codigo: ");
                        String codigo = sc.nextLine();
                        
                        boolean existe = false;
                        
                        for(Producto p : productos){
                            if(p.getCodigo().equals(codigo)){
                                existe = true;
                                break;
                            }
                        }
                        
                        if(existe){
                            System.out.println("Ya existe un producto con este codigo");
                            break;
                        }
                        
                        System.out.println("Nombre: ");
                        String nombre = sc.nextLine();
                        System.out.println("Precio: ");
                        double precio = sc.nextDouble();
                        sc.nextLine();
                        System.out.println("Fecha de ingreso (dd/MM/yyyy)");
                        String fechaStr = sc.nextLine();
                        LocalDate fechaIngreso = LocalDate.parse(fechaStr, formato);
                        System.out.println("Stock inicial: ");
                        int cantidad = sc.nextInt();
                        sc.nextLine();
                        
                        Producto nuevo = new Producto(codigo, nombre, precio, fechaIngreso);
                        productos.add(nuevo);
                        stock.put(codigo, cantidad);
                        
                        System.out.println("Producto agregado correctamente");
                        
                    } catch (DateTimeParseException e){
                        
                        System.out.println("Formato de fecha incorrecto");
                        
                    }
                    
                    break;
                case 2:
                    System.out.println("Codigo del producto: ");
                    String codigo = sc.nextLine();
                    if(!stock.containsKey(codigo)){
                        System.out.println("No existe un producto con ese codigo");
                        break;
                    }
                    
                    System.out.println("Nuevo stock: ");
                    int cantidad = sc.nextInt();
                    sc.nextLine();
                    stock.put(codigo, cantidad);
                    System.out.println("Stock actualizado");
                    break;
                case 3:
                    System.out.println("Codigo del producto a eliminar");
                    codigo = sc.nextLine();
                    boolean eliminado = false;
                    for(Producto p : productos){
                        if(p.getCodigo().equals(codigo)){
                            productos.remove(p);
                            stock.remove(codigo);
                            eliminado = true;
                            break;
                        }
                    }
                    if(eliminado) {
                        System.out.println("Producto eliminado");
                    } else {
                        System.out.println("No se encontro el producto");
                    }
                    break;
                case 4:
                    Comparator<Producto> comparadorPrecio = new Comparator <>(){
                        @Override
                        public int compare(Producto p1, Producto p2){
                            return Double.compare(p2.getPrecio(), p1.getPrecio());
                        }
                    };
                    productos.sort(comparadorPrecio);
                    System.out.println("Productos ordenado por precio de mayoor a menor: ");
                    for(Producto p : productos){
                        System.out.println(p + " | Stock: " + stock.get(p.getCodigo()));
                    }
                    break;
                case 5:
                    Comparator<Producto> comparadorFecha = new Comparator <>(){
                        @Override
                        public int compare(Producto p1, Producto p2){
                            return p2.getFechaDeIngreso().compareTo(p1.getFechaDeIngreso());
                        }
                    };
                    productos.sort(comparadorFecha);
                    System.out.println("Productos ordenado por fecha mas reciente");
                    for(Producto p : productos){
                        System.out.println(p + " | Stock: " + stock.get(p.getCodigo()));
                    }
                    break;
                case 6:
                    break;
            }
        } while (opcion != 6);
    }
    
}
