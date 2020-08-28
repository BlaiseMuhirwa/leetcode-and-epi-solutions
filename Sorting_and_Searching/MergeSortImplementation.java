package Sorting_and_Searching;
import java.util.*;

public class MergeSortImplementation {
    public static void main(String[] args) {
        int[] testArrayOne = {4, 5, 1, -3, 0, 10, 2, 1000, 3};
        int[] testArrayTwo = {1,2,3,4,5,5,6,7,8};

        printArray(mergeSort(testArrayOne));
        printArray(mergeSort(testArrayTwo));
    }

    public static int[] mergeSort(int[] array) {
        if (array == null) return array;
        if (array.length <= 1) return array;

        int mid = array.length/2;
        int[] leftArray = mergeSort(Arrays.copyOfRange(array, 0, mid));
        int[] rightArray = mergeSort(Arrays.copyOfRange(array, mid, array.length));

        return merge(leftArray, rightArray);
    }

    public static int[] merge(int[] leftArray, int[] rightArray) {
        int[] output = new int[leftArray.length + rightArray.length];
        int left_cursor = 0;
        int right_cursor = 0;
        int output_cursor = 0;

        while (left_cursor < leftArray.length && right_cursor < rightArray.length) {
            if (leftArray[left_cursor] <= rightArray[right_cursor]) {
                output[output_cursor] = leftArray[left_cursor];
                output_cursor++;
                left_cursor++;
            }
            else if (rightArray[right_cursor] < leftArray[left_cursor]) {
                output[output_cursor] = rightArray[right_cursor];
                output_cursor++;
                right_cursor++;
            }
        }

        while (left_cursor < leftArray.length) {
            output[output_cursor] = leftArray[left_cursor];
            output_cursor++;
            left_cursor++;
        }
        while (right_cursor < rightArray.length) {
            output[output_cursor] = rightArray[right_cursor];
            output_cursor++;
            right_cursor++;
        }
        return output;
    }

    private static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println("");
    }
}