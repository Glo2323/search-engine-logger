package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class SearchEngineApp {

    //!Creating main method
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        LocalDateTime now = LocalDateTime.now();

        System.out.println("Enter a search term (X or x to exit):  ");
        String search = input.nextLine();

        try {


            BufferedWriter searchWriter = new BufferedWriter(new FileWriter("logs.txt", true));

            String searchTerm = String.format(" %s search:  %s",now , search);

            searchWriter.write(searchTerm);

            searchWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }
}
