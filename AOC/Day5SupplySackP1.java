package AOC;

import java.util.ArrayList;
import java.util.List;

public class Day5SupplySackP1 {
    public static void main(String[] args) {
        long start = System.nanoTime();

        /////////////////{Setup Start}/////////////////////////////
//        String filePath = "AOC/test.txt";
        String filePath = "AOC/SupplyStack.txt";
        int numOfLines = myMethodTemplates.countLineBufferedReader(filePath);
        String allInput[] = new String[numOfLines];
        myMethodTemplates.readFilesToArray(allInput, filePath);
        /////////////////{Setup End}/////////////////////////////


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
            String instructArr[] = allInput[i].split( " ");
            //Sets instructions
            int nTimes = Integer.parseInt(instructArr[1]);
            int carry = Integer.parseInt(instructArr[3]);
            int drop = Integer.parseInt(instructArr[5]);
            char carried ='a';

            for (int j = 0; j < nTimes; j++) {
                //moves crates
                int arrlistLength =0;
                switch (carry) {
                    case 1:
                        carried = firstCol.get(firstCol.size() -1);
                        firstCol.remove(firstCol.size() -1);
                        break;
                    case 2:
                        carried = secCol.get(secCol.size() -1);
                        secCol.remove(secCol.size() -1);
                        break;
                    case 3:
                        carried = thirdCol.get(thirdCol.size() -1);
                        thirdCol.remove(thirdCol.size() -1);
                        break;
                    case 4:
                        carried = fourthCol.get(fourthCol.size() -1);
                        fourthCol.remove(fourthCol.size() -1);
                        break;
                    case 5:
                        carried = fifthCol.get(fifthCol.size() -1);
                        fifthCol.remove(fifthCol.size() -1);
                        break;
                    case 6:
                        carried = sixCol.get(sixCol.size() -1);
                        sixCol.remove(sixCol.size() -1);
                        break;
                    case 7:
                        carried = sevenCol.get(sevenCol.size() -1);
                        sevenCol.remove(sevenCol.size() -1);
                        break;
                    case 8:
                        carried = eightCol.get(eightCol.size() -1);
                        eightCol.remove(eightCol.size() -1);
                        break;
                    case 9:
                        carried = nineCol.get(nineCol.size() -1);
                        nineCol.remove(nineCol.size() -1);
                        break;
                }



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
