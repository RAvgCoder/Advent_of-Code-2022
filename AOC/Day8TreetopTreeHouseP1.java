package AOC;

public class Day8TreetopTreeHouseP1 {
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
                System.out.print(mapInt[i][j]+ " ");
            }
            System.out.println("");
        }

        int visibleTree =0;
        for (int x = 1; x < mapInt.length-1; x++) {
            for (int y = 1; y < mapInt[x].length-1; y++) {
                //top row
                boolean touched = false;
                int []xOffset = {-1,0, 0,1,};
                int []yOffset = {0,-1, 1,0,};
                int xPose =0;
                int yPose = 0;

                if (x==1){

                    for (int i = 0; i < 3; i++) {
                        xPose = x + xOffset[i];
                        yPose = y + yOffset[i];
                        if (mapInt[xPose][yPose] < mapInt[x][y] && !touched){
                            visibleTree++;
                            touched = true;
                        }
                    }

                    //Bottom row
                }
                else if (x == numOfLines-2){
                    for (int i = 1; i < 4; i++) {
                        xPose = x + xOffset[i];
                        yPose = y + yOffset[i];
                        if (mapInt[xPose][yPose] < mapInt[x][y] && !touched) {
                            visibleTree++;
                            touched = true;
                        }
                    }

                    //others
                } else {
                    for (int i = 1; i < 3; i++) {
                        xPose = x + xOffset[i];
                        yPose = y + yOffset[i];
                            if (mapInt[xPose][yPose] < mapInt[x][y] && !touched) {
                                visibleTree++;
                                touched = true;
                            }
                    }
                }

            }
        }
        System.out.println("");
        visibleTree = (mapInt.length*2) + ((numOfLines*2)-4) + visibleTree;
        System.out.println(visibleTree);
        ///////////////////{Program End}///////////////////////////

        long end = System.nanoTime();
        System.out.println("Time elapsed: "+(end-start)/1000000 +"ms");

    }

    public static void countree(int[][] mapInt, int x, int y) {


    }


}
