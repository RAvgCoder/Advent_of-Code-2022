package AOC;

public class Day8TreetopTreeHouseP1 {
    public static void main(String[] args) {
        long start = System.nanoTime();

        /////////////////{Setup Start}/////////////////////////////
//        String filePath = "AOC/test.txt";
        String filePath = "AOC/TreetopTreeHouse.txt";
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
//                System.out.print(mapInt[i][j]+ " ");
            }
//            System.out.println("");
        }

        int visibleTree =0;
        for (int x = 1; x < mapInt.length-1; x++) {
            for (int y = 1; y < mapInt[x].length-1; y++) {
                //top row
                boolean touched = false;
                int tempVisTree = 0;
                int []xInnerOffset = {-1,0, 0,1,};
                int []yInnerOffset = {0,-1, 1,0,};
                int xInPose =0;
                int yInPose = 0;
                int []xOutOffset = {0,  x,   x,                numOfLines-1,};
                int []yOutOffset = {y,  0,  mapInt.length-1,    y,};

                //Searches the nearest adjacent neighbours
                for (int i = 0; i < 4; i++) {
                    xInPose = x + xInnerOffset[i];
                    yInPose = y + yInnerOffset[i];
                    if (mapInt[xInPose][yInPose] <= mapInt[x][y] && !touched){
                        int map = mapInt[xOutOffset[i]][yOutOffset[i]];
                        if (mapInt[xOutOffset[i]][yOutOffset[i]] <= mapInt[x][y]) {
                            System.out.println(map+"  =============== "+ mapInt[xInPose][yInPose]);
                            System.out.println(x+","+y+", {"+mapInt[x][y]+"}");
                            visibleTree++;
                            touched = true;
                        }
                    }
                }

            }
        }

        System.out.println("");
        visibleTree = (mapInt.length*2) + ((numOfLines*2)-4) + visibleTree;
        System.out.println("Trees visible: "+ visibleTree);
        ///////////////////{Program End}///////////////////////////

        long end = System.nanoTime();
        System.out.println("Time elapsed: "+(end-start)/1000000 +"ms");

    }

    public static void countree(int[][] mapInt, int x, int y) {


    }


}
