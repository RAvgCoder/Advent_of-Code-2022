package AOC;

public class Day9ropeBridgeP1 {
    public static void main(String[] args) {
        long start = System.nanoTime();

        /////////////////{Setup Start}/////////////////////////////
        String filePath = "AOC/test.txt";
//        String filePath = "AOC/TreetopTreeHouse.txt";
        int numOfLines = myMethodTemplates.countLineBufferedReader(filePath);
        String inputString[] = new String[numOfLines];
        myMethodTemplates.readFilesToArray(inputString, filePath);
        /////////////////{Setup End}/////////////////////////////

        //Fiils game with dots
        String [][]gameboard = new String[5][6];
        for (int i = 0; i < gameboard.length; i++) {
            for (int j = 0; j < gameboard[i].length; j++) {
                    gameboard[i][j] = ".";
            }
        }





//        myMethodTemplates.twoDAraryPrint(gameboard);




        long end = System.nanoTime();
        System.out.println("Time: " + (end-start)/1000000 +"ms");

    }
}
