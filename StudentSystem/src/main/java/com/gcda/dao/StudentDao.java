
package com.gcda.dao;

import static com.gcda.connection.ConnectionDB.getConnectionDB;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.gcda.domain.Student;

/**
 *
 * @author SENA
 */
public class StudentDao {
    
    public List<Student> listar(){
        List<Student> students = new ArrayList<>();
        
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConnectionDB();
        String sql = "SELECT * FROM student ORDER BY id";
        
        try (con) {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Student student1 = new Student();
                student1.setNombre(rs.getString("firts_name"));
                student1.setApellido(rs.getString("last_name"));
                student1.setTelefono(rs.getString("phone"));
                student1.setEmail(rs.getString("email"));
                student1.setId_Student(rs.getInt("idStudent"));
                students.add(student1);
            }
        } catch (Exception e) {
            System.out.println("Ocurrio un error en la xonsulta: " + e.getMessage());
        }
        
        return students;
    }
    
    public List<Student> buscar(){
        List<Student> students = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConnectionDB();
        String sql = "SELECT * FROM student";
        
        return students;
    }

    public static void main(String[] args) {
        StudentDao studentdao = new StudentDao();
        List<Student> studentList = studentdao.listar();
        studentList.forEach(System.out::println);
    }
}

