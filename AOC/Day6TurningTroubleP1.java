package AOC;

public class Day6TurningTroubleP1 {
    public static void main(String[] args) {
        long start = System.nanoTime(); //Starts timer

        /////////////////{Setup Start}/////////////////////////////
//        String filePath = "AOC/test.txt";
        String filePath = "AOC/TurningTrouble.txt";
        int numOfLines = myMethodTemplates.countLineBufferedReader(filePath);
        String lineINp[] = new String[numOfLines];
        myMethodTemplates.readFilesToArray(lineINp, filePath);
        /////////////////{Setup End}/////////////////////////////


        String concat = "";

        for (int i = 0; i < lineINp.length; i++) {
            concat += lineINp[i];
        }

        int a=4; //Substring End
        int count =0;
        int index =0; //Substring Start
        int countLock =0;

        int ans1 =0;
        int ans2 =0;
        String ans3 ="";

        for (int i = index; i < a; index++) {

            String newStr = concat.substring(index, a);

            //loops through the newStr and checks if all 4 char have any similar char
            for (int j = 0; j < newStr.length(); j++) {
                for (int k = 0; k < newStr.length(); k++) {

                    if (newStr.charAt(j) == newStr.charAt(k) && j!=k){ //Checks other char other than its  self
                        count++;
                    }
                }
            }

            //Condition to make it print once and store the str that's not similar
            if (count == 0 && countLock != 1){
                        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
                System.out.println(index + "Start");
                System.out.println(a + "last");
                System.out.println(newStr +" Substring");
                        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
                countLock = 1;
            }
            count =0;

            a++;

            //Guard to make it not crash
            if (a == concat.length()+1){
                break;
            }
        }

        System.out.println();

        long end = System.nanoTime();
        System.out.println("Time elapsed: "+(end-start)/1000000 +"ms");

    }
}
