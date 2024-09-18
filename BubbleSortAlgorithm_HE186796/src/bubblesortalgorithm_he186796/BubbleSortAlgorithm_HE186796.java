/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bubblesortalgorithm_he186796;

import java.util.Random;
import ultils.Validation;

/**
 *
 * @author quyetdx16
 */
public class BubbleSortAlgorithm_HE186796 {

//    function: random number from 0 to number-1
    private static int randomInterger(int number) {
        Random ran = new Random();
        return ran.nextInt(number);
    }

//    function: print array format
    private static void printArray(int[] array, int size) {
        System.out.print("[");
        for (int i = 0; i < size - 1; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println(array[size - 1] + "]");
    }

//    funtion :sort array by bubbleSort
    private static void sortArrayByBubbleSort(int[] array, int size) {
        for (int i = 1; i < size; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            System.out.println("Enter number of Array:");
            int numberOfArray = Validation.InputPositiveIntergerValidation();

//            init array 
            int[] array = new int[numberOfArray];
            for (int i = 0; i < numberOfArray; i++) {
                array[i] = randomInterger(numberOfArray);
            }

            System.out.print("unsorted array: ");
            printArray(array, numberOfArray);
            sortArrayByBubbleSort(array, numberOfArray);
            System.out.print("Sorted array: ");
            printArray(array, numberOfArray);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
