package AOC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Day5SupplySackP2 {
    public static void main(String[] args) {
        long start = System.nanoTime();

        /////////////////{Setup Start}/////////////////////////////
//        String filePath = "AOC/test.txt";
        String filePath = "AOC/SupplyStack.txt";
        int numOfLines = myMethodTemplates.countLineBufferedReader(filePath);
        String allInput[] = new String[numOfLines];
        myMethodTemplates.readFilesToArray(allInput, filePath);
        /////////////////{Setup End}/////////////////////////////

        System.out.println(Arrays.toString(allInput));

        int indexCountRow = 0;
        int indexCountCol =0;
        char tempChar = 'a';
        boolean gottenNumIndex = false;

        for (int i=0; i<allInput.length; i++){
            for (int j = 0; j < allInput[i].length(); j++) {
                tempChar = allInput[i].charAt(j); //Holds char for compute
                if (tempChar == 'm'){
                    gottenNumIndex =true;
                }

                //Gets the index of crates in the game
                while (tempChar > 48 && tempChar <=57 && !gottenNumIndex){
                    tempChar = 'b';
                    indexCountRow = i; //Gets the height of the crates
                    indexCountCol++; //Counts how many stacks there are
                }
            }
        }

        System.out.println(indexCountCol +" Col");
        System.out.println(indexCountRow +" Rows");

        //Prints feeds values into string
        String numString ="";
        for (int i = indexCountRow-1; i>=0; i--){
            for (int j= 1; j<allInput[i].length(); j+=4){
                numString += String.valueOf(allInput[i].charAt(j));
            }
        }

        System.out.println(numString);
        System.out.println("");

        List<Character> firstCol = new ArrayList<>();
        List<Character> secCol = new ArrayList<>();
        List<Character> thirdCol = new ArrayList<>();
        List<Character> fourthCol = new ArrayList<>();
        List<Character> fifthCol = new ArrayList<>();
        List<Character> sixCol = new ArrayList<>();
        List<Character> sevenCol = new ArrayList<>();
        List<Character> eightCol = new ArrayList<>();
        List<Character> nineCol = new ArrayList<>();

        //Dumps each row from bottom to top into an arrayList
        for (int i = 0; i < indexCountCol; i++) {
            for (int j = i; j < numString.length(); j+=indexCountCol) {
                System.out.print(numString.charAt(j));
                if(numString.charAt(j) >= 41 && numString.charAt(j) <= 90) {
                    switch (i) {
                        case 0:
                            firstCol.add(numString.charAt(j));
                            break;
                        case 1:
                            secCol.add(numString.charAt(j));
                            break;
                        case 2:
                            thirdCol.add(numString.charAt(j));
                            break;
                        case 3:
                            fourthCol.add(numString.charAt(j));
                            break;
                        case 4:
                            fifthCol.add(numString.charAt(j));
                            break;
                        case 5:
                            sixCol.add(numString.charAt(j));
                            break;
                        case 6:
                            sevenCol.add(numString.charAt(j));
                            break;
                        case 7:
                            eightCol.add(numString.charAt(j));
                            break;
                        case 8:
                            nineCol.add(numString.charAt(j));
                            break;
                    }
                }
            }
            System.out.println("");
        }

        System.out.println("");
        //loop for movement instructions
        for (int i = indexCountRow+2; i < allInput.length; i++) {//Starts from move
            String[] instructArr = allInput[i].split( " ");
            //Sets instructions
            int nTimes = Integer.parseInt(instructArr[1]);
            int carry = Integer.parseInt(instructArr[3]);
            int drop = Integer.parseInt(instructArr[5]);
            char carried ='a';

            //For easily fetching
            HashMap<Integer, Integer> colMap = new HashMap<Integer, Integer>();
            colMap.put(1, firstCol.size());
            colMap.put(2, secCol.size());
            colMap.put(3, thirdCol.size());
            colMap.put(4, fourthCol.size());
            colMap.put(5, fifthCol.size());
            colMap.put(6, sixCol.size());
            colMap.put(7, sevenCol.size());
            colMap.put(8, eightCol.size());
            colMap.put(9, nineCol.size());


            int nBuffer =0;
            int nTimesCheck =0;
            for (int j = 0; j < nTimes; j++) {
                //moves crates
                if(j==0 && nTimes > 1){

                    nTimesCheck = colMap.get(carry);

                    if (nTimesCheck < nTimes && nTimesCheck!=0){
                        nBuffer = nTimesCheck;
                    }else if (nTimesCheck >= nTimes && nTimesCheck!=0){
                        nBuffer = nTimes-1;
                    }
                    else if (nTimesCheck==0) {
                        nBuffer = -1;
                    }
                }

                switch (carry) {
                    case 1 -> {
                        carried = firstCol.get(firstCol.size() - (nBuffer + 1));
                        firstCol.remove(firstCol.size() - (nBuffer + 1));
                    }
                    case 2 -> {
                        carried = secCol.get(secCol.size() - (nBuffer + 1));
                        secCol.remove(secCol.size() - (nBuffer + 1));
                    }
                    case 3 -> {
                        carried = thirdCol.get(thirdCol.size() - (nBuffer + 1));
                        thirdCol.remove(thirdCol.size() - (nBuffer + 1));
                    }
                    case 4 -> {
                        carried = fourthCol.get(fourthCol.size() - (nBuffer + 1));
                        fourthCol.remove(fourthCol.size() - (nBuffer + 1));
                    }
                    case 5 -> {
                        carried = fifthCol.get(fifthCol.size() - (nBuffer + 1));
                        fifthCol.remove(fifthCol.size() - (nBuffer + 1));
                    }
                    case 6 -> {
                        carried = sixCol.get(sixCol.size() - (nBuffer + 1));
                        sixCol.remove(sixCol.size() - (nBuffer + 1));
                    }
                    case 7 -> {
                        carried = sevenCol.get(sevenCol.size() - (nBuffer + 1));
                        sevenCol.remove(sevenCol.size() - (nBuffer + 1));
                    }
                    case 8 -> {
                        carried = eightCol.get(eightCol.size() - (nBuffer + 1));
                        eightCol.remove(eightCol.size() - (nBuffer + 1));
                    }
                    case 9 -> {
                        carried = nineCol.get(nineCol.size() - (nBuffer + 1));
                        nineCol.remove(nineCol.size() - (nBuffer + 1));
                    }
                }

//                System.out.println("Were on col: "+ (i-9));
//                System.out.println(nTimes+" nTimes");
//                System.out.println(carry+" carry");
//                System.out.println(drop+" Drop");
//                System.out.println("");

                //Place crates
                switch (drop) {
                    case 1:
                        firstCol.add(carried);
                        break;
                    case 2:
                        secCol.add(carried);
                        break;
                    case 3:
                        thirdCol.add(carried);
                        break;
                    case 4:
                        fourthCol.add(carried);
                        break;
                    case 5:
                        fifthCol.add(carried);
                        break;
                    case 6:
                        sixCol.add(carried);
                        break;
                    case 7:
                        sevenCol.add(carried);
                        break;
                    case 8:
                        eightCol.add(carried);
                        break;
                    case 9:
                        nineCol.add(carried);
                        break;
                }

                nBuffer--;
            }




        }

        System.out.println("+++++++++++++++++++++++++++++++++++");
        System.out.println(firstCol);
        System.out.println(secCol);
        System.out.println(thirdCol);
        System.out.println(fourthCol);
        System.out.println(fifthCol);
        System.out.println(sixCol);
        System.out.println(sevenCol);
        System.out.println(eightCol);
        System.out.println(nineCol);


        long end = System.nanoTime();
        System.out.println("Time: " + (end-start)/1000000 +"ms");
    }

}
