package AOC;

public class trials {
    public static void main(String[] args) {
        long start = System.nanoTime();

        /////////////////{Setup Start}/////////////////////////////
        String filePath = "AOC/test.txt";
//        String filePath = "AOC/TreetopTreeHouse.txt";
        int numOfLines = myMethodTemplates.countLineBufferedReader(filePath);
        String inputString[] = new String[numOfLines];
        myMethodTemplates.readFilesToArray(inputString, filePath);
        /////////////////{Setup End}/////////////////////////////

        ///////////////////{Program Start}///////////////////////////
        //Parses the 1D to 2D array

        int [][]mapInt = new int[inputString.length][numOfLines];
        for (int i = 0; i < numOfLines; i++) {
            for (int j = 0; j < inputString[1].length(); j++) {
                mapInt[i][j] = Integer.parseInt(String.valueOf(inputString[i].charAt(j)));
//                System.out.print(mapInt[i][j]);
            }
//            System.out.println("");
        }

        int []xOffset = {-1,0, 0,1,};
        int []yOffset = {0,-1, 1,0,};
        int xPose =0;
        int yPose = 0;
        int visibleTree =0;
        int tempNum = 0;
        //Loops through the map
        for (int i = 0; i < mapInt.length; i++) {
            for (int j = 0; j < mapInt[i].length; j++) {
                //Guards for edges
                if ((i!=0) && (j!=0) && (j!= mapInt[i].length-1) && (i!= mapInt.length-1)){
                    System.out.println(mapInt[i][j]);
                    System.out.println("---------------"+tempNum);

                    if (i == 1 && j == 1){
                        xPose = i + xOffset[0];
                        yPose = j + yOffset[0];
                        tempNum = mapInt[xPose][yPose];
                        if (mapInt[i][j] > tempNum ){
                            visibleTree++;
                        }
                        System.out.println("---------------"+tempNum);

                        xPose = i + xOffset[1];
                        yPose = j + yOffset[1];
                        tempNum = mapInt[xPose][yPose];
                        if (mapInt[i][j] > tempNum ){
                            visibleTree++;
                        }

                    }else if (i == 1 && j == mapInt[i].length-2){
                        xPose = i + xOffset[0];
                        yPose = j + yOffset[0];
                        tempNum = mapInt[xPose][yPose];
                        if (mapInt[i][j] > tempNum ){
                            visibleTree++;
                        }
                        System.out.println("---------------"+tempNum);

                        xPose = i + xOffset[2];
                        yPose = j + yOffset[2];
                        tempNum = mapInt[xPose][yPose];
                        if (mapInt[i][j] > tempNum ){
                            visibleTree++;
                        }
                    } else if (i == mapInt.length-2 && j == 1) {
                        xPose = i + xOffset[1];
                        yPose = j + yOffset[1];
                        tempNum = mapInt[xPose][yPose];
                        if (mapInt[i][j] > tempNum ){
                            visibleTree++;
                        }
                        System.out.println("---------------"+tempNum);

                        xPose = i + xOffset[3];
                        yPose = j + yOffset[3];
                        tempNum = mapInt[xPose][yPose];
                        if (mapInt[i][j] > tempNum ){
                            visibleTree++;
                        }
                    } else if (i == mapInt.length-2 && j == mapInt[i].length-2) {
                        xPose = i + xOffset[2];
                        yPose = j + yOffset[2];
                        tempNum = mapInt[xPose][yPose];
                        if (mapInt[i][j] > tempNum ){
                            visibleTree++;
                        }
                        System.out.println("---------------"+tempNum);

                        xPose = i + xOffset[3];
                        yPose = j + yOffset[3];
                        tempNum = mapInt[xPose][yPose];
                        if (mapInt[i][j] > tempNum ){
                            visibleTree++;
                        }
                    }else {
                        xPose = i + xOffset[2];
                        yPose = j + yOffset[2];
                        tempNum = mapInt[xPose][yPose];
                        if (mapInt[i][j] > tempNum ){
                            visibleTree++;
                        }
                        System.out.println("---------------"+tempNum);

                        xPose = i + xOffset[1];
                        yPose = j + yOffset[1];
                        tempNum = mapInt[xPose][yPose];
                        if (mapInt[i][j] > tempNum ){
                            visibleTree++;
                        }
                    }

                }

            }
            System.out.println("");
        }

        System.out.println("");
        System.out.println("No of visible trees are:  "+visibleTree);






        ///////////////////{Program End}///////////////////////////

        long end = System.nanoTime();
        System.out.println("Time elapsed: "+(end-start)/1000000 +"ms");

    }
}
