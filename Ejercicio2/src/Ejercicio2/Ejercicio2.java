/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package Ejercicio2;

import java.util.HashMap;
import java.util.Scanner;
/**
 *
 * @author Grupo 6
 */
public class Ejercicio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        HashMap<String, Estudiante> estudiantes = new HashMap<>();
        int opcion;
        
        do{
            
            System.out.println("----- MENU -----");
            System.out.println("1. Agregar Estudiante");
            System.out.println("2. Modificar Promedio");
            System.out.println("3. Eliminar Estudiante");
            System.out.println("4. Mostrar Estudiantes");
            System.out.println("5. Salir");
            opcion = sc.nextInt();
            sc.nextLine();
            
            try {
                
                switch (opcion) {
                    case 1:
                        System.out.println("DNI: ");
                        String dni = sc.nextLine();
                        
                        if(estudiantes.containsKey(dni)){
                            System.out.println("Ya existe un estudiante con ese DNI");
                            break;
                        }
                        
                        System.out.println("Nombre: ");
                        String nombre = sc.nextLine();
                        System.out.println("Apellido: ");
                        String apellido = sc.nextLine();
                        System.out.println("Promedio: ");
                        double promedio = sc.nextDouble();
                        sc.nextLine();
                        
                        estudiantes.put(dni, new Estudiante(nombre, apellido, promedio));
                        System.out.println("Estudiante agregado correctamente");
                        break;
                    case 2:
                        System.out.println("DNI del estudiante");
                        dni = sc.nextLine();
                        if(!estudiantes.containsKey(dni)){
                            System.out.println("No existe un estudiante con ese DNI");
                            break;
                        }
                        System.out.println("Nuevo promedio:");
                        double nuevoPromedio = sc.nextDouble();
                        sc.nextLine();
                        
                        estudiantes.get(dni).setPromedio(nuevoPromedio);
                        System.out.println("Promedio actualizado");
                        break;
                    case 3:
                        System.out.println("DNI del estudiante a eliminar:");
                        dni = sc.nextLine();
                        if(!estudiantes.containsKey(dni)){
                            System.out.println("No existe un estudiante con ese DNI");
                            break;
                        }
                        estudiantes.remove(dni);
                        System.out.println("Estudiante eliminado");
                        break;
                    case 4:
                        System.out.println("Lista de Estudiantes:");
                        System.out.println("-------------------------------");
                        for(HashMap.Entry<String, Estudiante> entry : estudiantes.entrySet()){
                            dni = entry.getKey();
                            Estudiante e = entry.getValue();
                            System.out.println("DNI: " + dni + "|" + e);
                        }
                        break;
                    case 5:
                        break;
                }
                
            } catch (Exception e){
                
                System.out.println("ERROR: " + e.getMessage());
                
            }
            
        } while( opcion != 5 );
    }
    
}
