/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mfu.proccess;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static jdk.nashorn.internal.objects.NativeMath.round;

/**
 *
 * @author Iwill
 */
@WebServlet("/Analysis")
public class Analysis extends HttpServlet {

    static double valueSaving6;
    static double valueSaving12;
    static double valueEn15;
    static double valueEn20;
    static int resultEn15, resultEn20;
    static int resultEn16, resultEn21;
    static int resultSaving6, resultSaving12;
    static int resultSaving6A, resultSaving6B,resultSaving6C,resultSaving6D;
    static int resultSaving12A;
    static double resultChip;
    static int resultAge, resultAgeB;
    
    
    

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String gender = request.getParameter("gender");
        String firstObjective = request.getParameter("firstObjective");
        String secondObjective = request.getParameter("secondObjective");
        //int chip  = Integer.parseInt(request.getParameter("chip"));
        Double chip = Double.parseDouble(request.getParameter("chip"));
        String insurance = null;
        String dOB = request.getParameter("dateOfBrith");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date dateOfBrith = null;

        try {
            dateOfBrith = df.parse(dOB);
        } catch (ParseException ex) {
            Logger.getLogger(Analysis.class.getName()).log(Level.SEVERE, null, ex);
        }
        int age = AgeCalculator.calculateAge(dateOfBrith);

//        response.sendRedirect("Result.html?"+gender+age+"fist"+firstObjective);
        if ("death".equals(firstObjective)) {
            insurance = "lifetime";
        } else if ("saving".equals(firstObjective) || "scholarship".equals(firstObjective)) {
            insurance = "saving";
        } else if ("retirement".equals(firstObjective)) {
            insurance = "pension";
        } else if ("health".equals(firstObjective) && "death".equals(secondObjective)) {
            insurance = "lifetime";
        } else if ("health".equals(firstObjective) && "saving".equals(secondObjective)) {
            insurance = "saving";
        } else if ("health".equals(firstObjective) && "retirement".equals(secondObjective)) {
            insurance = "pension";
        } else if ("taxes".equals(firstObjective) && "death".equals(secondObjective)) {
            insurance = "lifetime";
        } else if ("taxes".equals(firstObjective) && "saving".equals(secondObjective)) {
            insurance = "saving";
        } else if ("taxes".equals(firstObjective) && "retirement".equals(secondObjective)) {
            insurance = "pension";
        } else {
            response.sendRedirect("Analysis.jsp?conditionerror");
        }
//
        if (insurance.equals("lifetime")) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eyi?zeroDateTimeBehavior=convertToNull", "root", "root");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT " + gender + " FROM en15 WHERE AGE='" + age + "'");
                if (rs.next()) {
                    valueEn15 = rs.getDouble(gender);
                }
                con.close();
            } catch (Exception e) {
                System.out.println("Error en15 :" + e);
            }
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eyi?zeroDateTimeBehavior=convertToNull", "root", "root");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT " + gender + " FROM en20 WHERE AGE='" + age + "'");
                if (rs.next()) {
                    valueEn20 = rs.getDouble(gender);
                }
                con.close();
            } catch (Exception e) {
                System.out.println("Error ne20 :" + e);
            }
            resultAge = age;
            double invest = 1000;
            resultChip = chip;
            resultEn15 = (int) ((invest * chip) / valueEn15);
            resultEn20 = (int) ((invest * chip) / valueEn20);

            if (resultEn15 > 6000000) {
                resultEn16 = (int) ((invest * chip) / (valueEn15 - 2.5));
            } else if (resultEn15 > 3000000) {
                resultEn16 = (int) ((invest * chip) / (valueEn15 - 2));
            } else if (resultEn15 > 500000) {
                resultEn16 = (int) ((invest * chip) / (valueEn15 - 1));
            } else {
                resultEn16 = (int) ((invest * chip) / (valueEn15 - 0.5));
            }

            if (resultEn20 > 6000000) {
                resultEn21 = (int) ((invest * chip) / (valueEn20 - 2.5));
            } else if (resultEn20 > 3000000) {
                resultEn21 = (int) ((invest * chip) / (valueEn20 - 2));
            } else if (resultEn20 > 500000) {
                resultEn21 = (int) ((invest * chip) / (valueEn20 - 1));
            } else {
                resultEn21 = (int) ((invest * chip) / (valueEn20 - 0.5));
            }
            
            String aresultEn16 = NumberFormat.getIntegerInstance().format(resultEn16);
            String aresultEn21 = NumberFormat.getIntegerInstance().format(resultEn21);
            String aresultEnChip = NumberFormat.getIntegerInstance().format(resultChip);

            response.sendRedirect("Result.jsp?resultEn15=" + aresultEn16 + "&resultEn20=" + aresultEn21 + "&resultChip=" + aresultEnChip);

        } else if (insurance.equals("saving")) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eyi?zeroDateTimeBehavior=convertToNull", "root", "root");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT " + gender + " FROM saving6 WHERE AGE='" + age + "'");
                if (rs.next()) {
                    valueSaving6 = rs.getDouble(gender);
                }
                con.close();
            } catch (Exception e) {
                System.out.println("Error en15 :" + e);
            }
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eyi?zeroDateTimeBehavior=convertToNull", "root", "root");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT " + gender + " FROM saving12 WHERE AGE='" + age + "'");
                if (rs.next()) {
                   valueSaving12 = rs.getDouble(gender);

                }
                con.close();
            } catch (Exception e) {
                System.out.println("Error ne20 :" + e);
            }
            double invest = 1000;
            resultChip = chip;
            resultSaving6 = (int) ((invest * chip) / valueSaving6);
            resultSaving12 = (int) ((invest * chip) /valueSaving12);
            
            //คำนวณเงินคืนสิ้นปี
            resultSaving6A = (int)((resultSaving6)*0.1);
            //คำนวณเงินคืนสิ้นปี 1-17 ปี
            resultSaving6B = (int)((resultSaving6A)*17);
            //คำนวณครบสัญญารับเงินคืน 118% ของทุนประกัน
            resultSaving6C = (int)((resultSaving6)*1.18);
            //เงินคืนสิ้นกรมธรณ์
            resultSaving6D = (int)((resultSaving6B)+(resultSaving6C));
            //คำนวณครบสัญญารับเงินคืน 140% ของทุนประทุน
            resultSaving12A = (int) ((resultSaving12) * 1.4);
            

            String aresultSaving6  = NumberFormat.getIntegerInstance().format(resultSaving6);
            String aresultSaving6A = NumberFormat.getIntegerInstance().format(resultSaving6A);
            String aresultSaving6B = NumberFormat.getIntegerInstance().format(resultSaving6B);
            String aresultSaving6C = NumberFormat.getIntegerInstance().format(resultSaving6C);
            String aresultSaving6D = NumberFormat.getIntegerInstance().format(resultSaving6D);
            String aresultSaving12 = NumberFormat.getIntegerInstance().format(resultSaving12);
            String aresultSaving12A = NumberFormat.getIntegerInstance().format(resultSaving12A);
            String aresultSavingChip = NumberFormat.getIntegerInstance().format(resultChip);
            

            response.sendRedirect("Result2.jsp?resultSaving6=" + aresultSaving6 + "&resultSaving12=" + aresultSaving12 
                    + "&resultChip=" + aresultSavingChip +"&resultSaving6D=" + aresultSaving6D +"&resultSaving6A=" + aresultSaving6A 
                    + "&resultSaving6B=" + aresultSaving6B +"&resultSaving6C=" + aresultSaving6C +"&resultSaving12A=" + aresultSaving12A  );
        }
    }
}
