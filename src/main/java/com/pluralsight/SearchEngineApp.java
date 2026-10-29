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
        //?Creating my Scanner
        Scanner input = new Scanner(System.in);

        //?Creating date formatter
         DateTimeFormatter dateF = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

         //*Pulling the local date time
         LocalDateTime now = LocalDateTime.now();

         //*System is going to try this if fails it'll catch it 
         try {

             //?Creating buffer to write into my files
             BufferedWriter searchWriter = new BufferedWriter(new FileWriter("logs.txt", true));

             //* Creating launch so to be able to catch when they open the search engine
             String LaunchTerm = String.format(" %s Launch: ", now.format(dateF));

             //*To catch when they open the search engine and paste into the log
             searchWriter.write(LaunchTerm);

             //*Next output will be placed on a new line for file
             searchWriter.newLine();

             //?Creating loop so user is able to search more than once
             boolean appRunning = true;
             while (appRunning) {

                 //*Question for the search engine
                 System.out.println("Enter a search term (X or x to exit):  ");

                 //*Catch user input
                 String search = input.nextLine();

                 //?If statement so user has a way to exit the search and quit the program
                 if (search.equalsIgnoreCase("X")) {

                     //*Exit output that shows when user exit
                     String searchExit = String.format(" %s exit :", now.format(dateF));

                     //*To catch when user exits and paste into the log
                     searchWriter.write(searchExit);

                     //*Next output will be placed on a new line for file
                     searchWriter.newLine();

                     //*Quiting the program
                     appRunning = false;
                 }else {
                     //*Search output that shows users what they searched
                     String searchTerm = String.format(" %s search: %s", now.format(dateF), search);
                     //*To catch when users searches and paste into the log
                     searchWriter.write(searchTerm);
                     searchWriter.newLine();

                 }
             }
             //*To close buffer writer
             searchWriter.close();
             //*To catch user errors
         } catch (Exception e) {
             throw new RuntimeException(e);
         }


    }
}
