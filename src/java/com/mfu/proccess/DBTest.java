/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mfu.proccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

/**
 *
 * @author Iwill
 */
public class DBTest {

    public static void main(String[] args) {
        String gender = "male";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://192.168.1.122:3306/eyi?zeroDateTimeBehavior=convertToNull", "joey", "9385");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT "+gender+" FROM en15 WHERE age='19'");
            if (rs.next()) {
                float value = rs.getFloat(gender);
                System.out.println(value);
            }
            con.close();
        } catch (Exception e) {
            System.out.println("Error :" + e);
        }
    }
}
