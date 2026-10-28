package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SearchEngineApp {

    //!Creating main method
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

         DateTimeFormatter dateF = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

         LocalDateTime now = LocalDateTime.now();

         try {

             BufferedWriter searchWriter = new BufferedWriter(new FileWriter("logs.txt", true));

             String LaunchTerm = String.format(" %s Launch: ", now.format(dateF));

             searchWriter.write(LaunchTerm);
             searchWriter.newLine();
             boolean appRunning = true;
             while (appRunning) {
                 System.out.println("Enter a search term (X or x to exit):  ");
                 String search = input.nextLine();
                 if (search.equalsIgnoreCase("X")) {
                     String searchExit = String.format(" %s exit :", now.format(dateF));
                     searchWriter.write(searchExit);
                     searchWriter.newLine();

                     appRunning = false;
                 }else {

                     System.out.println();

//                BufferedWriter searchWriter = new BufferedWriter(new FileWriter("logs.txt", true));

                     String searchTerm = String.format(" %s search: %s", now.format(dateF), search);

                     searchWriter.write(searchTerm);
                     searchWriter.newLine();

                 }
             }
             searchWriter.close();
         } catch (Exception e) {
             throw new RuntimeException(e);
         }


    }
}
