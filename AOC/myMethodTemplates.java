package AOC;

import java.io.*;
import java.util.Scanner;

public class myMethodTemplates {

    /**
     * Prints out a String 2D array to the console
     * @param userArray 2D array of integers
     */
    public static void twoDAraryPrint(String[][] userArray) {
        for (int i = 0; i < userArray.length; i++) {
            for (int j = 0; j < userArray[i].length; j++) {
                System.out.print(userArray[i][j]+" ");
            }
            System.out.println("");
        }
    }

    /**
     * Prints out an Integer 2D array to the console
     * @param userArray 2D array of integers
     */
    public static void twoDAraryPrint(int [][]userArray) {
        for (int i = 0; i < userArray.length; i++) {
            for (int j = 0; j < userArray[i].length; j++) {
                System.out.print(userArray[i][j]+" ");
            }
            System.out.println("");
        }
    }




    /**
     * Takes in an empty array of type int and reads in the whole line
     * and stores in to an index of an array doing that for each line
     * @param userArr Empty array of type string
     * @param filePath User desired file path
     */
    public static void readFilesToArray(String []userArr, String filePath) {
        try {
            Scanner scanner = new Scanner(new File(filePath));

            int count = 0; //Sets counter for placing num in arr
            while (scanner.hasNext()) { //checks if there's a line to read
                String input = scanner.nextLine();

                userArr[count] = input;

                count++;
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Takes in an empty input array of string and file path then reades in
     * the values from that path and stores it into an array type int
     * with the black lines represented as 0
     * @param userArr Empty array of type int
     * @param filePath Your desired txt file
     */
    public static void readFilesToArray(int []userArr, String filePath) {
        try {
            Scanner scanner = new Scanner(new File(filePath));

            int count = 0; //Sets counter for placing num in arr
            while (scanner.hasNext()) { //checks if there's a line to read
                String input = scanner.nextLine();
//                System.out.println(input);
                if (!input.equals("")){ //Guards for empty string
                    userArr[count] = Integer.parseInt(input);
                }else {
                    userArr[count] = 0;
                }
//                    System.out.println(elfArr[count]);
                count++;
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    /**
     *  Counts how many lines are in the file
     * @param fileName Reads whatever file name you may have
     * @return integer
     */
    public static int countLineBufferedReader(String fileName) {

        int lines = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.readLine() != null) lines++;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;

    }
}
