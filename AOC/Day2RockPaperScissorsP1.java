package AOC;

import java.util.Arrays;

public class Day2RockPaperScissorsP1 {
    public static void main(String[] args) {
        long start = System.nanoTime();//Starts timer

        String filePath = "AOC/inputRockPaperScissors.txt";


        String rockPaperSicorsArr[] = new String[myMethodTemplates.countLineBufferedReader(filePath)];
//        String rockDummy[] = {"A Y", "B X", "C Z"};
        //Fills array with input from text
        myMethodTemplates.readFilesToArray(rockPaperSicorsArr, filePath);

        //Splits each string array into player1 & player2 [C Y] => C{Player1} Y{Player2}
        splitString(rockPaperSicorsArr);

        System.out.println(Arrays.toString(rockPaperSicorsArr));

        //Stops timer and Prints how long it takes
        long end = System.nanoTime();
        long elapsedTime = end - start;
        System.out.println(elapsedTime/1000000 + "ms");
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

    static int yourPoint =0; //Counts your point in the game
    public static int countPoint(String player1, String player2){
        boolean win = false;
        //Game win points
        //A draw
//        if((player1.equals("A") && player2.equals("X")) || (player1.equals("B") && player2.equals("Y")) || (player1.equals("C") && player2.equals("Z"))){
        if (player2.equals("X") && player1.equals("C") ){
            win = true;
        }else if (player2.equals("Y") && player1.equals("A")){
            win =true;
        } else if (player2.equals("Z") && player1.equals("B")) {
            win =true;
        }

        //Free ponits
        if((player1.equals("A") && player2.equals("X")) || (player1.equals("B") && player2.equals("Y")) || (player1.equals("C") && player2.equals("Z"))){
            yourPoint +=3;
        }else if(win){
            yourPoint += 6;
        }


        if(player2.equals("X")){  //player opiton points
            yourPoint += 1;
        } else if (player2.equals("Y")) {
            yourPoint += 2;
        } else if (player2.equals("Z")) {
            yourPoint += 3;
        }

        return yourPoint;
    }

}
