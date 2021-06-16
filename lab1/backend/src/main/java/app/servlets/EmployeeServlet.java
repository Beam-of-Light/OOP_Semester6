package app.servlets;


import app.DAO.EmployeeDAO;
import app.DAO.EmployeeFlightDAO;
import app.entities.Employee;
import app.entities.EmployeeFlight;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.List;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/employees")

public class EmployeeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String flightParam = req.getParameter("flight");
        List<Employee> employees;
        if (flightParam == null) {
            employees = EmployeeDAO.getAllEmployees();
        } else {
            int flight_id = Integer.parseInt(flightParam);
            employees = EmployeeDAO.getEmployeeForFlight(flight_id);
        }
        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        String employeesJson = new Gson().toJson(employees);
        out.println(employeesJson);
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String flightParam = req.getParameter("flight");
        if (flightParam == null) {
            StringBuffer jb = new StringBuffer();
            String line = null;
            try {
                BufferedReader reader = req.getReader();
                while ((line = reader.readLine()) != null)
                    jb.append(line);
            } catch (Exception e) {
                e.printStackTrace();
            }

            Gson gson = new Gson();
            Employee employee = gson.fromJson(jb.toString(), Employee.class);
            EmployeeDAO.addEmployee(employee);
        } else {
            StringBuffer jb = new StringBuffer();
            String line = null;
            try {
                BufferedReader reader = req.getReader();
                while ((line = reader.readLine()) != null)
                    jb.append(line);
            } catch (Exception e) {
                e.printStackTrace();
            }

            Gson gson = new Gson();
            EmployeeFlight employee = gson.fromJson(jb.toString(), EmployeeFlight.class);
            EmployeeFlightDAO.addEmployeeToFlight(employee);
        }

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        StringBuffer jb = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = req.getReader();
            while ((line = reader.readLine()) != null)
                jb.append(line);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Gson gson = new Gson();
        Employee employee = gson.fromJson(jb.toString(), Employee.class);
        EmployeeDAO.updateEmployee(employee);

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String flightParam = req.getParameter("flight");
        if (flightParam == null) {
            String employeeId = req.getParameter("id");
            if (employeeId != null) {
                int id = Integer.parseInt(employeeId);
                EmployeeDAO.deleteEmployee(id);
            }

        } else {
            StringBuffer jb = new StringBuffer();
            String line = null;
            try {
                BufferedReader reader = req.getReader();
                while ((line = reader.readLine()) != null)
                    jb.append(line);
            } catch (Exception e) {
                e.printStackTrace();
            }

            Gson gson = new Gson();
            EmployeeFlight employee = gson.fromJson(jb.toString(), EmployeeFlight.class);
            EmployeeFlightDAO.deleteEmployeeFromFlight(employee);
        }

    }

}