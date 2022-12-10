package AOC;

import java.util.Arrays;

public class Day7NoSpaceLeftP1 {
    public static void main(String[] args) {
        long start = System.nanoTime();

        /////////////////{Setup Start}/////////////////////////////
        String filePath = "AOC/test.txt";
//        String filePath = "AOC/NoSpaceLeft.txt";
        int numOfLines = myMethodTemplates.countLineBufferedReader(filePath);
        String allInput[] = new String[numOfLines];
        myMethodTemplates.readFilesToArray(allInput, filePath);
        /////////////////{Setup End}/////////////////////////////

        System.out.println(Arrays.toString(allInput));

        int fileSize =0;
        //Gets its array value and splits it to know the begining of its content
        for (int i = 0; i < allInput.length; i++) {
            String []arrSplit = allInput[i].split(" ");
            //Filters out non files
            if (!(arrSplit[0].equals("$") || arrSplit[0].equals("dir") || arrSplit[0].equals("$"))){
                //Adds up file sizes if size is <= 100000
                if (Integer.parseInt(arrSplit[0]) <= 100000){
                    System.out.println(arrSplit[0]);
                    fileSize += Integer.parseInt(arrSplit[0]);
                }
            }


        }
        System.out.println("");
        System.out.println("Total file size: "+ fileSize);





        long end = System.nanoTime();
        System.out.println("Time: " + (end-start)/1000000 +"ms");
    }
}
