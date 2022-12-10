package AOC;

import java.util.Arrays;
import java.util.HashMap;

public class Day2RockPaperScissorsP2 {
    public static void main(String[] args) {
        long start = System.nanoTime(); //Starts timer
        String filePath = "AOC/inputRockPaperScissors.txt";


        //counts amount of lines in the txt file
        String rockPaperSicorsArr[] = new String[myMethodTemplates.countLineBufferedReader(filePath)];
//        String dummyArray[] = {"A Y", "B X", "C Z"};

        //Fills array with input from text
        myMethodTemplates.readFilesToArray(rockPaperSicorsArr, filePath);

        //Splits each string array into player1 & player2 [C Y] => C{Player1} Y{Player2}
        splitString(rockPaperSicorsArr);

        System.out.println(Arrays.toString(rockPaperSicorsArr));

        //Stops timer and Prints how long it takes
        long end = System.nanoTime();
        long elapsedTime = end - start;
        System.out.println("Time taken is: "+elapsedTime/1000000 + "ms");
    }

    /**
     * Splits string at given array index and then sends to a method that compares  string
     * @param rockPaperSicorsArr Filled array with player input
     */
    public static void splitString(String[] rockPaperSicorsArr) {
//        int countIndex =0;
        for (int i =0;  i< rockPaperSicorsArr.length;  i++){
            String []splitArray= rockPaperSicorsArr[i].split(" ");

            int yourPoint = countPoint(splitArray[0], splitArray[1]); // parses in players input {c,y} into the method

//            System.out.println(Arrays.toString(splitArray));
        }

        System.out.println("Your point is "+ yourPoint);
    }

    public static void endGame(String player1, String player2) {
        //HashMap for draw
        HashMap<String, String> draw = new HashMap<String, String>();
        draw.put("A", "X");
        draw.put("B", "Y");
        draw.put("C", "Z");

        HashMap<String, String> looseing = new HashMap<String, String>();
        looseing.put("A", "Z");
        looseing.put("B", "X");
        looseing.put("C", "Y");

        HashMap<String, String> winning = new HashMap<String, String>();
        winning.put("A", "Y");
        winning.put("B", "Z");
        winning.put("C", "X");

        //EndGame Logic
        if (player2.equals("Y")){ //You chose Draw
            endGame = draw.get(player1);
        } else if (player2.equals("X")) { //You loose
            endGame = looseing.get(player1);
        } else if (player2.equals("Z")) { //You win
            endGame = winning.get(player1);
        }
    }

    static String endGame = ""; // Gets the endGame Signal
    static int yourPoint =0; //Counts your point in the game
    public static int countPoint(String player1, String player2){
        endGame(player1, player2);

        //Game win points

        //Free ponits
        if(player2.equals("Y")){
            yourPoint +=3;
        }else if(player2.equals("Z")){
            yourPoint += 6;
        }


        if(endGame.equals("X")){  //player opiton points
            yourPoint += 1;
        } else if (endGame.equals("Y")) {
            yourPoint += 2;
        } else if (endGame.equals("Z")) {
            yourPoint += 3;
        }


        return yourPoint;
    }

}
