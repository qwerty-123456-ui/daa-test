// import java.io.*;
import java.util.*;
// import java.text.*;
// import java.math.*;
// import java.util.regex.*;
public class CountingInversions {
    private static long countInversions(int[] arr) {
        int[] aux = arr.clone();
        return countInversions(arr, 0, arr.length - 1, aux);
    }
    private static long countInversions(int[] arr, int lo, int hi, int[] aux) {
        if (lo >= hi) return 0;
        int mid = lo + (hi - lo) / 2;
        long count = 0;
        count += countInversions(aux, lo, mid, arr);
        count += countInversions(aux, mid + 1, hi, arr);
        count += merge1(arr, lo, mid, hi, aux);
        return count;
    }
    void printArray(int arr[])
    {   int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    private static long merge1(int[] arr, int lo, int mid, int hi, int[] aux) {
        long count = 0;
        int i = lo, j = mid + 1, k = lo;
        while (i <= mid || j <= hi) {
            if (i > mid) {
                arr[k++] = aux[j++];
            } else if (j > hi) {
                arr[k++] = aux[i++];
            } else if (aux[i] <= aux[j]) {
                arr[k++] = aux[i++];
            } else {
                arr[k++] = aux[j++];
                count += mid + 1 - i;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountingInversions ob = new CountingInversions();
        System.out.println("Enter the size ");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        Random r=new Random();
        for (int i=0;i<n;i++)
               arr[i] = r.nextInt(1000);
        System.out.println("Original array");
        ob.printArray(arr);
        sc.close();
        System.out.println("no. of inversions "+ countInversions(arr));
}

}