//Ivan Yu

import java.util.*;

public class TwoSortedArrays {
    int[] arrayOne, arrayTwo;
    Scanner input = new Scanner(System.in);
    Random rand = new Random();
    
    public TwoSortedArrays() {
        System.out.print("Please enter a size for the first array: ");
        String choice;
        boolean tmp = true;
        while (tmp) {
            choice = input.nextLine();
            try {
                arrayOne = new int[Integer.parseInt(choice)];
                tmp = false;
            } catch (NumberFormatException e) {
                System.out.print("Please re-enter a size number: ");
            }
        }

        System.out.print("Please enter a size for the second array: ");
        tmp = true;
        while (tmp) {
            choice = input.nextLine();
            try {
                arrayTwo = new int[Integer.parseInt(choice)];
                tmp = false;
            } catch (NumberFormatException e) {
                System.out.print("Please re-enter a size number: ");
            }
        }

        for (int i = 0; i < arrayOne.length; i++) {
            arrayOne[i] = rand.nextInt(100);
        }

        for (int i = 0; i < arrayTwo.length; i++) {
            arrayTwo[i] = rand.nextInt(100);
        }

        System.out.println("\nInput:");
        display();

        sortArrayOne();
        sortArrayTwo();
        sortArrays();
        System.out.println("\nOutput:");
        display();

        System.out.println("\nMerged:");
        mergeArrays();        
    }

    public void display() {
        for (int i = 0; i < arrayOne.length; i++) {
            System.out.print(arrayOne[i] + " ");
        }
        System.out.println("");
        for (int i = 0; i < arrayTwo.length; i++) {
            System.out.print(arrayTwo[i] + " ");
        }
        System.out.println("");
    }

    public void sortArrayOne() {
        for (int i = 1; i < arrayOne.length; i++) {
            int markedNum = arrayOne[i];
            int markedIdx = i;

            while (markedIdx > 0 && arrayOne[markedIdx - 1] >= markedNum) {
                arrayOne[markedIdx] = arrayOne[markedIdx - 1];
                markedIdx--;
            }

            arrayOne[markedIdx] = markedNum;
        }
    }

    public void sortArrayTwo() {
        for (int i = 1; i < arrayTwo.length; i++) {
            int markedNum = arrayTwo[i];
            int markedIdx = i;

            while (markedIdx > 0 && arrayTwo[markedIdx - 1] >= markedNum) {
                arrayTwo[markedIdx] = arrayTwo[markedIdx - 1];
                markedIdx--;
            }

            arrayTwo[markedIdx] = markedNum;
        }
    }

    public void sortArrays() {
        for (int i = 0; i < arrayOne.length; i++) {
            for (int j = 0; j < arrayTwo.length; j++) {
                int markedNum = arrayOne[i];
                int markedIdx = i;

                if (arrayTwo[j] < markedNum) {
                    arrayOne[markedIdx] = arrayTwo[j];
                    arrayTwo[j] = markedNum;
                }

                sortArrayTwo();
            }
        }
    }

    public void mergeArrays() {
        int[] mergedArray = new int[arrayOne.length + arrayTwo.length];

        for(int i = 0; i < mergedArray.length; i++) {
            if (i < arrayOne.length) {
                mergedArray[i] = arrayOne[i];
            } else if (i >= arrayOne.length) {
                mergedArray[i] = arrayTwo[i - arrayOne.length];
            }
        }

        for (int i = 0; i < mergedArray.length; i++) {
            System.out.print(mergedArray[i] + " ");
        }
        System.out.println("");
    }

    public static void main(String args[]) {
        TwoSortedArrays tsa = new TwoSortedArrays();
    }
}
