package AOC;

public class trials {
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
//                System.out.print(mapInt[i][j]);
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

                        switch (i){
                            case 0 -> {
                                for (int xPrime = x-1; xPrime >= xOutOffset[i]; xPrime--) {
                                    if (mapInt[xPrime][y] < mapInt[x][y]){
                                        tempVisTree++;
                                        System.out.print(mapInt[xPrime][y]);
                                        System.out.println("("+mapInt[xPrime][y]+")"+"["+xPrime+","+y+"]"+"{"+mapInt[x][y]+"}"+x+","+y+"-->"+i);

                                    }else {
                                        tempVisTree =0;
                                        System.out.println("("+mapInt[xPrime][y]+")"+"["+xPrime+","+y+"]"+"{"+mapInt[x][y]+"}"+x+","+y+"<<<"+i);


                                        break;
                                    }
                                }
                            }
                            case 1 -> {
                                for (int yPrime = y-1; yPrime >= yOutOffset[i]; yPrime--) {
                                    if (mapInt[x][yPrime] < mapInt[x][y]){
                                        tempVisTree++;
                                        System.out.print(mapInt[x][yPrime]);
                                        System.out.println("("+mapInt[x][yPrime]+")"+"["+x+","+yPrime+"]"+"{"+mapInt[x][y]+"}"+x+","+y+"<--<"+i);

                                    }else {
                                        tempVisTree =0;
                                        System.out.println("("+mapInt[x][yPrime]+")"+"["+x+","+yPrime+"]"+"{"+mapInt[x][y]+"}"+x+","+y+"<<<"+i);

                                        break;
                                    }
                                }
                            }
                            case 2 -> {
                                for (int yPrime = y+1; yPrime <= yOutOffset[i]; yPrime++) {
                                    if (mapInt[x][yPrime] < mapInt[x][y]){
                                        tempVisTree++;
                                        System.out.print(mapInt[x][yPrime]);
                                        System.out.println("("+mapInt[x][yPrime]+")"+"["+x+","+yPrime+"]"+"{"+mapInt[x][y]+"}"+x+","+y+"<-->"+i);

                                    }else {
                                        tempVisTree =0;
                                        System.out.println("("+mapInt[x][yPrime]+")"+"["+x+","+yPrime+"]"+"{"+mapInt[x][y]+"}"+x+","+y+"<<<"+i);

                                        break;
                                    }
                                }
                            }case 3 -> {
                                for (int xPrime = x+1; xPrime <= xOutOffset[i]; xPrime++) {
                                    if (mapInt[xPrime][y] < mapInt[x][y]){
                                        tempVisTree++;
                                        System.out.print(mapInt[xPrime][y]);
                                        System.out.println("("+mapInt[xPrime][y]+")"+"["+xPrime+","+y+"]"+"{"+mapInt[x][y]+"}"+x+","+y+"-->"+i);

                                    }else {
                                        tempVisTree =0;
                                        System.out.println("("+mapInt[xPrime][y]+")"+"["+xPrime+","+y+"]"+"{"+mapInt[x][y]+"}"+x+","+y+"<<<"+i);

                                        break;
                                    }
                                }
                            }

                        }


                        if(tempVisTree > 0){
                            visibleTree++;
                            touched = true;
                            tempVisTree =0;
                        }
                    }
                        System.out.println("");
                }

            }
        }

        System.out.println("");
        System.out.println("No of visible trees are:  "+visibleTree);


//        for (int j = 0; j < 4; j++) {
//            int map = mapInt[xOutOffset[j]][yOutOffset[j]];
//            System.out.println("---------");
//            System.out.println(xOutOffset[j]);
//            System.out.println(yOutOffset[j]);
//            System.out.println("---------");
//            System.out.println(j+""+j+" (()(()(())()() "+ map);
//            System.out.println(map+"  ===============");
//
//        }
//        System.out.println("");
//
//        System.out.println("End");





        ///////////////////{Program End}///////////////////////////

        long end = System.nanoTime();
        System.out.println("Time elapsed: "+(end-start)/1000000 +"ms");

    }
}
