package AOC;

import java.util.Arrays;

public class D1ElfCaloriesP1 {

    static int[] elfArr = new int[myMethodTemplates.countLineBufferedReader("AOC/elfInput.txt")];
    public static void main(String[] args) {
        long start = System.nanoTime();
        String filePath = "AOC/elfInput.txt";


        myMethodTemplates.readFilesToArray(elfArr, filePath);
        int temporarySum =0; //stores the sums of each player elf
        int[] elfPlayerIndex = new int[elfArr.length];
        int elfPlayerCount =0; //

        //loops through the array and sums all the values giving breaks at 0
        //to indicate a start sum for different players
        for (int i =0; i< elfArr.length; i++){
            if (elfArr[i] > 0){
                temporarySum += elfArr[i];
            }

            if (elfArr[i] == 0 || i == (elfArr.length-1)){

                elfPlayerIndex[elfPlayerCount] = temporarySum;
                elfPlayerCount++;
                temporarySum=0;
            }
        }

        int elfPlayerZ =1; //Stops when reached end of num > 0 in an array
        elfPlayerCount =0;
        int elfPlayerMax =0;
        int elfPlayerCalHolder =0;
        int totalMax =0;
        int max1 =0;
        int max2 = 0;
        int max3 = 0;

        while (elfPlayerZ !=0){
            if (elfPlayerCount ==0){
                elfPlayerMax = elfPlayerIndex[elfPlayerCount];
            }else {
                if (elfPlayerMax < elfPlayerIndex[elfPlayerCount]){
                    elfPlayerMax = elfPlayerIndex[elfPlayerCount];
                    elfPlayerCalHolder = elfPlayerCount;
                }
            }

            elfPlayerZ = elfPlayerIndex[elfPlayerCount];
            elfPlayerCount++;
        }

        System.out.println("The max  num of colories is "+ elfPlayerMax + " held by player "+ (elfPlayerCalHolder+1));

        System.out.println();

        System.out.println(Arrays.toString(elfPlayerIndex));

        //Stops timer and Prints how long it takes
        long end = System.nanoTime();
        long elapsedTime = end - start;
        System.out.println("Time taken is: "+elapsedTime/1000000 + "ms");

    }

}
