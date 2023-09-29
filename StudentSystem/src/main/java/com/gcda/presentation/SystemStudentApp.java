
package com.gcda.presentation;

import com.gcda.dao.StudentDao;
import com.gcda.domain.Student;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author SENA
 */
public class SystemStudentApp {
    public static void main(String[] args) {
        Scanner consola = new Scanner(System.in);
        StudentDao studentdao = new StudentDao();
        
        boolean salir = false;
        while(!salir){
            showMenu();
            salir=executeOption();
        }
    }
    public static void showMenu(){
        System.out.println("""
                           Menu de usuario, seleccione una opcion
                           1.Listar estudiantes
                           2.Buscar estudiante
                           3.Agregar estudiante
                           4.Eliminar estudiante
                           5.Modificae estudiante
                           6. Salir
                           """);
    }
    private boolean executeOption(Scanner consola, StudentDao studentdao){
        int option=Integer.parseInt(consola.findInLine());
        
        
        switch(option){
            case 1 ->{
                // LISTAR ESTUDIANTE
                
                System.out.println("Listando estudiantes.");
                List<Student> studentList = studentdao.listar();
                studentList.forEach(System.out::println);
            }
            case 2 ->{
                System.out.println("Buscar estudiante.");
                
                 Student objectStudent = new Student(1);
                System.out.println("objectStudent = " + objectStudent);
                boolean foundObject = studentdao.searchStudentId(objectStudent);
        if(foundObject){
            System.out.println("foundObject = " + foundObject);
        }else{
            System.out.println("no fue encontrado");
        }
            }
        }
        
    }
    public static void addStudent(Scanner consola, StudentDao studentdao){
        System.out.println("Añadir un nuevo estudiante.");
        System.out.println("Ingrese el id de el estudiante.");
        int id_Student = Integer.parseInt(consola.nextLine());
        System.out.println("Por favor ingrrse el nombre de el estudiante,");
        String name = consola.nextLine();
        System.out.println("Por favor inserte el apellido del estudiante.");
        String last_name = consola.nextLine();
        System.out.println("Por favor inserte el numero del estduante.");
        String phone = consola.nextLine();
        System.out.println("Por favor ingrese el email del estudiante.");
        String email = consola.nextLine();
        
        Student objectStudent = new Student(id_Student, name, last_name, phone, email);
        boolean objectUpdate = studentdao.actualizar(objectStudent);
        if(objectUpdate){
            System.out.println("Se añadio el estudiate." + objectStudent);
            
        }else{
            System.out.println("Ocurrio un error en añadir un estudiante.");
        }
        
    }
}
