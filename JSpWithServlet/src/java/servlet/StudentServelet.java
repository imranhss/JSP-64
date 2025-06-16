/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servlet;

import dao.StudentDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import model.Student;

/**
 *
 * @author Admin
 */

@WebServlet("/studentservlet")
public class StudentServelet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");

        try {
            if ("add".equals(action)) {
                Student s = new Student();
                s.setName(request.getParameter("name"));
                s.setEmail(request.getParameter("email"));
                s.setSubject(request.getParameter("subject"));
                s.setGender(request.getParameter("gender"));
                 s.setContactNo(request.getParameter("contactNo"));  // add this for add
                StudentDao.saveStudent(s);
                response.sendRedirect("index.jsp");
            } else if ("update".equals(action)) {
                Student s = new Student();
                s.setId(Integer.parseInt(request.getParameter("id")));
                s.setName(request.getParameter("name"));
                s.setEmail(request.getParameter("email"));
                s.setSubject(request.getParameter("subject"));
                s.setGender(request.getParameter("gender"));
                 s.setContactNo(request.getParameter("contactNo"));  // add this for add
                StudentDao.updateStudent(s);
                response.sendRedirect("index.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        try {
            if ("delete".equals(action)) {
                int id = Integer.parseInt(request.getParameter("id"));
                StudentDao.deleteStudent(id);
                response.sendRedirect("index.jsp");
            } else if ("edit".equals(action)) {
                int id = Integer.parseInt(request.getParameter("id"));
                Student s = StudentDao.getById(id);
                request.setAttribute("student", s);
                request.getRequestDispatcher("editStudent.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
