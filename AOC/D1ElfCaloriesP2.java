package AOC;

import java.util.Arrays;

public class D1ElfCaloriesP2 {
    static int max1 =0;
    static int max2 = 0;
    static int max3 = 0;
    static int[] elfArr = new int[myMethodTemplates.countLineBufferedReader("AOC/elfInput.txt")];

    public static void main(String[] args) {
        long start = System.nanoTime();
        String filePath = "AOC/elfInput.txt";


        myMethodTemplates.readFilesToArray(elfArr,filePath);
        int temporarySum =0; //stores the sums of each player elf
        int[] elfPlayerIndex = new int[elfArr.length];
        int elfPlayerCount =0;

        //loops through the array and sums all the values giving breaks at 0
        //to indicate a start sum for different players
        for (int i =0; i< elfArr.length; i++){
            if (elfArr[i] > 0){
                temporarySum += elfArr[i];
//                System.out.println(temporarySum +"dsdsd" + i);
            }

            if (elfArr[i] == 0 || i == (elfArr.length-1)){

                elfPlayerIndex[elfPlayerCount] = temporarySum;
                elfPlayerCount++;
                temporarySum=0;
            }
        }

        int elfPlayerCalHolder =0; //Player with heighest calories
        for (int i=0; i<3; i++){ //loops 3 times for 3 diff maxes;
            setMax(elfPlayerIndex, i);


        }

        int Sum = max1 + max2 + max3;

//        System.out.println(max1+"ssaasaassas");


        System.out.println("The max  sum of colories is "+ Sum );


        System.out.println(Arrays.toString(elfPlayerIndex));

        //Stops timer and Prints how long it takes
        long end = System.nanoTime();
        long elapsedTime = end - start;
        System.out.println("Time taken is: "+elapsedTime/1000000 + "ms");
    }

    /**
     * Used to check for max in given input and then stores each version of max
     * @param elfPlayerIndex array of elf calories
     * @param loopIteration keeps track of iteration of the loop we are on
     */
    public static void setMax(int[] elfPlayerIndex, int loopIteration){
        int elfPlayerZ =1; //Stops when reached end of num > 0 in an array
        int elfPlayerCount =0;
        int elfPlayerMax =0;
        int elfPlayerCalHolder =0;

        while (elfPlayerZ !=0){
            if (elfPlayerCount ==0){
                elfPlayerMax = elfPlayerIndex[elfPlayerCount];
            }else {
                if(max1 != elfPlayerIndex[elfPlayerCount] && max2 != elfPlayerIndex[elfPlayerCount] && max3 != elfPlayerIndex[elfPlayerCount]){
                    if (elfPlayerMax < elfPlayerIndex[elfPlayerCount]){
                        elfPlayerMax = elfPlayerIndex[elfPlayerCount];
                        elfPlayerCalHolder = elfPlayerCount;
                    }
                }
            }

            elfPlayerZ = elfPlayerIndex[elfPlayerCount];
            elfPlayerCount++;
        }

        //Used store each time there's a new max in an iteration
        if (loopIteration ==0){
            max1 = elfPlayerMax;
//            System.out.println(max1 +"max1");
        } else if (loopIteration == 1){
            max2 = elfPlayerMax;
//            System.out.println(max2 +"max2");

        }else if (loopIteration ==2){
            max3 = elfPlayerMax;
//            System.out.println(max3 +"max3");
        }

    }


}
