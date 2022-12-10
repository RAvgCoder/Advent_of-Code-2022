package AOC;

import java.util.Arrays;

public class Day3RockSackP1 {
    static int score =0;

    public static void main(String[] args) {
        long start = System.nanoTime(); //Start Timer
        String filePath = "AOC/Rucksack-Reorganization.txt";


        //Gets no of lines from file.txt
        int numOfLines = myMethodTemplates.countLineBufferedReader(filePath);

        String []storeRock  = new String[numOfLines];//Initilizes string and length

        //Fills array with values from file path stated
        myMethodTemplates.readFilesToArray(storeRock, filePath);
        System.out.println(Arrays.toString(storeRock));

        //Loops through array and devides each word into 2 and finds the word that repeats
        for (int i =0;  i< numOfLines; i++){
            int  valueAtIlength = storeRock[i].length(); //Gets length of word
            int wordDivision = valueAtIlength/2;
            String valueAtI = storeRock[i]; //Gets word itself

            //Sores divided words into 2 string
            String firstWordPart = valueAtI.substring(0,wordDivision);
            String secondWord = valueAtI.substring(wordDivision);

            stringCompare(firstWordPart, secondWord);

//            System.out.println(firstWordPart);
//            System.out.println(secondWord);

        }

        System.out.println("The score is:__________________ " +score);

        //Ends timer
        long end = System.nanoTime();
        long elapsedTime = end - start;
        System.out.println(elapsedTime/1000000 + "ms");
    }

    /**
     * Compares string and returns one that is common
     * @param firstWordPart First part of a string
     * @param secondWord Second part of a string
     */
    public static void stringCompare(String firstWordPart, String secondWord) {
        char storeCommonLetter ='a';
//            System.out.println(firstWordPart);
//            System.out.println(secondWord);
        //loops through the 2 words like a 2d array and checks what letter is common
        for (int i=0; i < firstWordPart.length(); i++){
            for (int j=0; j < secondWord.length(); j++){
                //checks if equal
                if (firstWordPart.charAt(i) == secondWord.charAt(j)){
                    storeCommonLetter = firstWordPart.charAt(i);
//                    System.out.println(storeCommonLetter);
                }
            }
        }
        scoreCounter(storeCommonLetter);

    }

    /**
     * Increments score for player depending on if char is capital or not
     * @param storeCommonLetter Common char from the two word strings
     */
    public static void scoreCounter(Character storeCommonLetter) {
        int alphabetNum; //Stores alphabet num conversion from ASSCi table

        //Checks of char is upper case or not
        if (Character.isUpperCase(storeCommonLetter)){
             alphabetNum = (storeCommonLetter -65)+27;
            score += alphabetNum;
//             System.out.println(alphabetNum + " ,"+ storeCommonLetter +" ," + score );

        }else {
            alphabetNum = (storeCommonLetter -97)+1;
            score += alphabetNum;
//            System.out.println(alphabetNum + " ,"+ storeCommonLetter +" ," + score );

        }

    }


}
