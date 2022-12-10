package AOC;

import java.util.Arrays;

public class Day4CampCleanupP1 {
    public static void main(String[] args) {
        long start = System.nanoTime(); //Starts timer
        String filePath = "AOC/CampCleanup.txt";

        // ---------------Starts Program

        //Gets no of lines from file.txt
        int numOfLinese = myMethodTemplates.countLineBufferedReader(filePath);

        //Initializes new array with length of file
        String []p1P2TotalRange = new String[numOfLinese];

        //Fills array with each line content from textfile
        myMethodTemplates.readFilesToArray(p1P2TotalRange, filePath);
        System.out.println(Arrays.toString(p1P2TotalRange));

        int pairs = 0;
        for (int i =0; i< p1P2TotalRange.length; i++){
            String []p1P2Split = p1P2TotalRange[i].split(","); //3-94{,}3-96
            String []p1Split = p1P2Split[0].split("-"); //3{-}94
            String []p2Split = p1P2Split[1].split("-"); //3{-}96

            //"3" to 3 int and "94" to 94 int
            int p1SplitAt0 = Integer.parseInt(p1Split[0]);
            int p1SplitAt1 = Integer.parseInt(p1Split[1]);

            //"3" to 3 int and "96" to 96 int
            int p2SplitAt0 = Integer.parseInt(p2Split[0]);
            int p2SplitAt1 = Integer.parseInt(p2Split[1]);


            if (p1SplitAt0 <= p2SplitAt0 && p1SplitAt1 >= p2SplitAt1){
                pairs++;
//                System.out.println("-------+++++-----");
//                System.out.println(p1SplitAt0+" "+p1SplitAt1+" "+p2SplitAt0+" "+p2SplitAt1);
//                System.out.println("-------+++++-----");

            } else if (p2SplitAt0 <= p1SplitAt0 && p2SplitAt1 >= p1SplitAt1 ) {
                pairs++;
//                System.out.println("------------");
//                System.out.println(p1SplitAt0+" "+p1SplitAt1+" "+p2SplitAt0+" "+p2SplitAt1);
//                System.out.println("------------");


            }
//            System.out.println(p2SplitAt1);

        }

        System.out.println("================================="+pairs);



         // ---------------Ends Program

        long end = System.nanoTime();
        System.out.println("Time elapsed: "+(end-start)/1000000 +"ms");
    }
}
