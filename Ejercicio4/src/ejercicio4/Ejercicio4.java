/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio4;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author Grupo 6
 */
public class Ejercicio4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Evento> eventos = new ArrayList<>();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        int opcion;
        
        do{
            
            System.out.println("----- MENU -----");
            System.out.println("1. Cargar Evento");
            System.out.println("2. Mostrar Eventos");
            System.out.println("3. Ordenar Eventos por Fecha");
            System.out.println("4. Ordenar Eventos por Nombre");
            System.out.println("5. Salir");
            
            opcion = sc.nextInt();
            sc.nextLine();
            
            switch (opcion){
                case 1:
                    try {
                        System.out.println("Nombre del Evento: ");
                        String nombre = sc.nextLine();
                        System.out.println("Fecha (dd/MM/yyyy): ");
                        String fechaStr = sc.nextLine();
                        LocalDate fecha = LocalDate.parse(fechaStr, formato);
                        System.out.println("Responsable: ");
                        String responsable = sc.nextLine();
                        
                        eventos.add(new Evento(nombre, fecha, responsable));
                        System.out.println("Se agrego correctamente");
                    } catch (DateTimeParseException e){
                        
                        System.out.println("ERROR: formato de fecha incorrecto");
                        
                    }
                    break;
                case 2:
                    System.out.println("Lista de Eventos");
                    System.out.println("----------------------");
                    if(eventos.isEmpty()){
                        System.out.println("No hay eventos registrados");
                    } else {
                        for(Evento e : eventos){
                            System.out.println(e);
                        }
                    }
                    break;
                case 3:
                    Comparator<Evento> comparadorFecha = new Comparator<Evento>(){
                        @Override
                        public int compare(Evento e1, Evento e2) {
                            return e1.getFecha().compareTo(e2.getFecha());
                        }
                    };
                    eventos.sort(comparadorFecha);
                    System.out.println("Eventos ordenados por fecha");
                    break;
                case 4:
                    Comparator<Evento> comparadorNombre = new Comparator<Evento>() {
                      @Override
                      public int compare(Evento e1, Evento e2){
                          return e1.getNombre().compareToIgnoreCase(e2.getNombre());
                      }
                    };
                    eventos.sort(comparadorNombre);
                    System.out.println("Eventos ordenados por Nombre");
                    break;
                case 5:
                    break;
            }
            
        } while (opcion != 5);
        
    }
    
}
