package com.dhanush.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultListModel;

public class DBWizard {
    Connection conn;
    Statement statement;

    String url;
    String query;

    public DBWizard() {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        conn = null;
        url = "jdbc:sqlite:college.db";
    }

    public void connect() {
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public DefaultListModel<String> search(String target) {
        query = "SELECT name FROM students WHERE name LIKE '" + target + "%'";
        DefaultListModel<String> listModel = new DefaultListModel<>();

        try {
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next())
                listModel.addElement(resultSet.getString("name"));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listModel;
    }

    public Student select(String target, int index) {
        query = "SELECT * FROM students WHERE name LIKE '" + target + "%' LIMIT 1 OFFSET " + index;
        Student student = null;

        try {
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            resultSet.next();
            student = new Student(
                    resultSet.getString("id"),
                    resultSet.getString("name"),
                    resultSet.getString("phone"),
                    resultSet.getString("email"));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return student;
    }

    public void insert(Student student) {
        query = "INSERT INTO students(name, phone, email) VALUES('" +
                student.getName() + "', '" +
                student.getPhone() + "', '" +
                student.getEmail() +
                "')";
        try {
            statement = conn.createStatement();
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Student student) {
        query = "UPDATE students " +
                "SET name = '" + student.getName() +
                "', phone = '" + student.getPhone() +
                "', email = '" + student.getEmail() +
                "' WHERE id = " + student.getId();
        try {
            statement = conn.createStatement();
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(String id) {
        query = "DELETE FROM students WHERE id = " + id;
        try {
            statement = conn.createStatement();
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}