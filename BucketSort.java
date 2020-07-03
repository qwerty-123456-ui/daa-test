import java.util.ArrayList;
import java.util.Collections;
import java.util.*;

public class BucketSort {
  public void bucketSort(float[] arr, int n) {
    if (n <= 0)
      return;
    @SuppressWarnings("unchecked")
    ArrayList<Float>[] bucket = new ArrayList[n];

    // Create empty buckets
    for (int i = 0; i < n; i++)
      bucket[i] = new ArrayList<Float>();

    // Add elements into the buckets
    for (int i = 0; i < n; i++) {
      int bucketIndex = (int) arr[i] * n;
      bucket[bucketIndex].add(arr[i]);
    }

    // Sort the elements of each bucket
    for (int i = 0; i < n; i++) {
      Collections.sort((bucket[i]));
    }

    // Get the sorted array
    int index = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0, size = bucket[i].size(); j < size; j++) {
        arr[index++] = bucket[i].get(j);
      }
    }
  }
  public static void main(String[] args) {
    BucketSort b = new BucketSort();
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter the size of Array : ");
    int n=sc.nextInt();
    float[] arr = new float[n];
    for (int i=0;i<n;i++)
    {
        System.out.println("Enter the value of element "+( i+1));
        arr[i] = sc.nextFloat();
    }
    sc.close();
    long st=System.nanoTime();
    b.bucketSort(arr, n-1);
    long et=System.nanoTime();
    System.out.println("\nRunning Time : "+(et-st)+" \nSorted Array : ");
    for (float i : arr)
      System.out.print(i + "  ");
  }
}