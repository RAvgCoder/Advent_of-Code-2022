package AOC;

import java.util.Arrays;

public class Day3RockSackP2 {
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

        //Groups Strings into 3 atores them into one part of an array and clones it
        String groupedArray[] = groupString(storeRock);



        //Loops through array and splits each word into 3 and finds the word that repeats
        for (int i =0;  i< groupedArray.length; i++){

            //Split array by space into a new array
            String []splitArray = groupedArray[i].split(" ");
//            System.out.println(Arrays.toString(splitArray));

            //puts splitArray values into sting
            String firstWord = splitArray[0];
            String secondWord = splitArray[1];
            String thirdWord = splitArray[2];

            stringCompare(firstWord, secondWord, thirdWord);

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
     * Loops through given array and sets them into new grouped into 3 array
     * @param storeRock given array input
     * @return grouped array
     */
    public static String[] groupString(String [] storeRock) {
        //Loops through length of given string
        String temporaryConcatination ="";
        String []groupedArray = new String[storeRock.length/3];
        int groupedArrayCounter =0;
        int count =1; //Helps to devide it into 3 groups

        for (int i =0; i< storeRock.length; i++ ){
            temporaryConcatination += storeRock[i] +" ";
            if(count%3==0){ //Groups string into array
                groupedArray[groupedArrayCounter] = temporaryConcatination;
                groupedArrayCounter++;
                temporaryConcatination =""; //resets String
            }
            count++;
        }


        return groupedArray;
    }


    /**
     * Compares string and returns one that is common
     * @param firstWord First part of a string
     * @param secondWord Second part of a string
     */
    public static void stringCompare(String firstWord, String secondWord, String thirdWord) {
        char storeCommonLetter ='a';
//        System.out.println(firstWord);
//        System.out.println(secondWord);
//        System.out.println(thirdWord);

        //loops through the 3 words like a 3d array and checks what letter is common to all
        for (int i=0; i < firstWord.length(); i++){
            for (int j=0; j < secondWord.length(); j++){
                for (int z=0; z<thirdWord.length(); z++){

                    //checks if char equal
                    if (firstWord.charAt(i) == secondWord.charAt(j)){
                        if (secondWord.charAt(j) == thirdWord.charAt(z)){

                            storeCommonLetter = firstWord.charAt(i);
//                            System.out.println("------------------------------------------------------------------------"+storeCommonLetter);
                        }
                    }
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
//            System.out.println(alphabetNum + " ,"+ storeCommonLetter +" ," + score );

        }else {
            alphabetNum = (storeCommonLetter -97)+1;
            score += alphabetNum;
//            System.out.println(alphabetNum + " ,"+ storeCommonLetter +" ," + score );

        }

    }


}
