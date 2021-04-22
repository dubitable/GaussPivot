import java.util.ArrayList;

public class Utilities {
    public static void printArray(Double[] arr){
        System.out.print("[ ");
        for (Double elem : arr){
            System.out.print(elem + " ");
        }  
        System.out.println("]");
    }
    public static void printArray(Double[][] arr){
        for (Double[] eq : arr){
            printArray(eq);
        }
    }
    public static void printArray(ArrayList<Double>[] arr){
        for (ArrayList<Double> list : arr){
            System.out.println(list);
        }
    }
    public static ArrayList<Double>[] reverseArray(ArrayList<Double>[] arr){
        ArrayList<Double>[] output = (ArrayList<Double>[]) new ArrayList[arr.length];
        for (int i = 0; i < arr.length; i++){
            output[arr.length - (i + 1)] = arr[i];
        }
        return output;
    }
}
