package com.testprojects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private Connection db_connect() {
        Connection con = null;
        try {
            Thread.sleep(30000);
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

        int attempt = 1;

        while(true) {
            try {
                Thread.sleep(5000);
                con = DriverManager.getConnection("jdbc:mysql://db:3306/testdb?useSSL=false&allowPublicKeyRetrieval=true", "root", "root"); // db ka container name database/db
                System.out.println("Successful connected.");
                break;
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Fail to connect, attempt = " + attempt);
                attempt++;
            }
        }

        return con;
    }


    public static void main(String[] args) {

        Main m = new Main();
        Connection con = m.db_connect();
        // statement
        Database_Read dr = new Database_Read(con);
        dr.read();

        try{
            con.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        // connection




        // Resultset 1 ka ny sa tr
        // close



        }
    }
