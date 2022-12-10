//package Tests;
//
//import java.util.HashMap;
//import java.util.Scanner;
//
//public class ProblemFinal {
//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        int board[][] = new int[8][8]; //Creates the array for grid
//
//        int inputCount = input.nextInt(); //Tells how many inputs we have
//
//        //Places the defending player on the grid
//        for (int i = 0; i < inputCount; i++) {
//            String defendingPlayerInput = input.next();
//            char row = defendingPlayerInput.charAt(1);
//            char col = defendingPlayerInput.charAt(0);
//
//            setTarget(board, col, row); //Collects user input
//        }
//
//        //Places the attacking player on the grid
//        String attackingPlayerInput ="";
//        int attack =0;
//        while (!(attackingPlayerInput.equals("-1"))){
//            if (attack>0){
//
//                char row = attackingPlayerInput.charAt(1);
//                char col = attackingPlayerInput.charAt(0);
//                System.out.println("--");
//                System.out.println(row+"row");
//                System.out.println(col+"col");
//                attackGrid(board, row, col);
//            }
//            attack++;
//            attackingPlayerInput = input.next();
//        }
//
//
//        //Creates the final String grid
//        int stringLengthCount = 0; //Counts the length till the end of the loop
//        for (int i=0; i<8; i++){
//            for (int j=0; j<8; j++){
//                System.out.print(getGrid(board).charAt(stringLengthCount));
//                System.out.print(" ");
//                stringLengthCount++;
//            }
//            System.out.println("");
//        }
//
//    }
//
//    public static void attackGrid(int[][] board, char row, char col) {
//        //Creates a mapping  for rows and col to the index
//        HashMap<Character, Integer> colList = new HashMap<Character, Integer>();
//        colList.put('A', 0);
//        colList.put('B', 1);
//        colList.put('C', 2);
//        colList.put('D', 3);
//        colList.put('E', 4);
//        colList.put('F', 5);
//        colList.put('G', 6);
//        colList.put('H', 7);
//
//        HashMap<Character, Integer> rowList = new HashMap<Character, Integer>();
//        rowList.put('1', 0);
//        rowList.put('2', 1);
//        rowList.put('3', 2);
//        rowList.put('4', 3);
//        rowList.put('5', 4);
//        rowList.put('6', 5);
//        rowList.put('7', 6);
//        rowList.put('8', 7);
//
//        //Overwrites the value of the array to reflect hit(3) or miss(4)
//        for (int i=0; i<8; i++){
//            for(int j=0; j<8; j++){
//                if(i==(rowList.get(row)) && j==(colList.get(col))){
//                    if(board[i][j] == 1){
//                        board[i][j] =3;
//                    }else {
//                        board[i][j] =4;
//                    }
//                }
//            }
//        }
//
//        for (int i=0; i<8; i++){
//            for(int j=0; j<8; j++){
//                System.out.print(board[i][j] +" ");
//            }
//            System.out.println("");
//        }
//
//    }
//
//    /**
//     * Takes in an array, the column and row you want to place your target in.
//     *
//     * @param board Takes input of array type int
//     * @param col Takes input of type char
//     * @param row Takes input of type row
//     */
//    public static void setTarget(int[][] board, char col, char row) {
//        //Creates a mapping  for rows and col to the index
//        HashMap<Character, Integer> colList = new HashMap<Character, Integer>();
//        colList.put('A', 0);
//        colList.put('B', 1);
//        colList.put('C', 2);
//        colList.put('D', 3);
//        colList.put('E', 4);
//        colList.put('F', 5);
//        colList.put('G', 6);
//        colList.put('H', 7);
//
//        HashMap<Character, Integer> rowList = new HashMap<Character, Integer>();
//        rowList.put('1', 0);
//        rowList.put('2', 1);
//        rowList.put('3', 2);
//        rowList.put('4', 3);
//        rowList.put('5', 4);
//        rowList.put('6', 5);
//        rowList.put('7', 6);
//        rowList.put('8', 7);
//
//        board[rowList.get(row)][colList.get(col)] = 1;
//
//    }
//
//    /**
//     * Converts the grid to a string from
//     *
//     * @param board This is a complete grid that was played on
//     * @return  The grid in a string form
//     */
//    public static String getGrid(int[][] board) {
//        String boardString = "";
//
//        for (int i = 0; i < 8; i++) {
//            for (int j = 0; j < 8; j++) {
//                if (i == 0 && j == 0) {
//                    if (board[i][j] == 0) {
//                        boardString = "_";
//                    } else {
//                        boardString = "T";
//                    }
//                } else {
//                    if (board[i][j] == 0) {
//                        boardString += "_";
//                    } else {
//                        boardString += "T";
//                    }
//                }
//
//            }
//        }
//
//        for (int i = 0; i < 8; i++) {
//            for (int j = 0; j < 8; j++) {
//                if (i == 0 && j == 0) {
//                    if (board[i][j] == 3) {
//                        boardString = "X";
//                    } else if(board[i][j] == 4){
//                        boardString = "0";
//                    }else {
//                        boardString = "_";
//                    }
//                }
//                else {
//                    if (board[i][j] == 3) {
//                        boardString = "X";
//                    } else if(board[i][j] == 4){
//                        boardString = "0";
//                    }else {
//                        boardString = "_";
//                    }
//                }
//
//            }
//        }
//
//        return boardString;
//
//    }
//
//}
//
//
//
//
//
//
//
//
//
//
////=========
////for (int i = 0; i < 8; i++) {
////            for (int j = 0; j < 8; j++) {
////                if (i == 0 && j == 0) {
////                    if (board[i][j] == 0) {
////                        boardString = "_";
////                    } else {
////                        boardString = "T";
////                    }
////                } else {
////                    if (board[i][j] == 0) {
////                        boardString += "_";
////                    } else {
////                        boardString += "T";
////                    }
////                }
////
////            }
////        }
//
//
////        for (int i = 0; i < 8; i++) {
////            for (int j = 0; j < 8; j++) {
////                if (i == 0 && j == 0) {
////                    if (board[i][j] == 0) {
////                        boardString = "_";
////                    } else if(board[i][j] == 3){
////                        boardString = "X";
////                    }else if (board[i][j] == 4){
////                        boardString ="O";
////                    }
////                } else {
////                    if (board[i][j] == 0) {
////                        boardString += "_";
////                    } else if(board[i][j] == 3){
////                        boardString = "X";
////                    }else if (board[i][j] == 4){
////                        boardString ="O";
////                    }
////                }
////
////            }
////        }
//
//
//
//
