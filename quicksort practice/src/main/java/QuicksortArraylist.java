import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class QuicksortArraylist {

    public static void main(String[] args){
        Random random = new Random();
        ArrayList<Integer> array = new ArrayList<>();
        int arrayListLength = 10;

        for (int i = 0; i<arrayListLength; i++){
            array.add(i,random.nextInt(100));
        }
        System.out.println("Before:");
        printArrayList(array);

        quicksort(array, 0, array.size()-1);
        System.out.println("\nafter:");
        printArrayList(array);
    }

    private static void quicksort(ArrayList<Integer> array, int lowIndex, int highIndex) {
        if (lowIndex>=highIndex) return;
        int pivotIndex = new Random().nextInt(highIndex - lowIndex) +lowIndex;
        int pivot = array.get(pivotIndex);
        Collections.swap(array,pivotIndex,highIndex);
        int leftPointer = partition(array, lowIndex, highIndex, pivot);
        quicksort(array, lowIndex, leftPointer -1);
        quicksort(array, leftPointer+1, highIndex);
    }

    private static int partition(ArrayList<Integer> array, int lowIndex, int highIndex, int pivot) {
        int leftPointer = lowIndex;
        int rightPointer = highIndex;
        while (leftPointer<rightPointer){
            while (array.get(leftPointer) <= pivot && leftPointer < rightPointer) leftPointer++;
            while (array.get(rightPointer) >= pivot && leftPointer < rightPointer) rightPointer--;
            Collections.swap(array, leftPointer, rightPointer);
        }
        Collections.swap(array, leftPointer, highIndex);
        return leftPointer;
    }

    private static void printArrayList(ArrayList<Integer> array) {
        System.out.println(array.toString());
    }

}
