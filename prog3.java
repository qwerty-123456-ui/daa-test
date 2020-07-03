import java.util.Random;
import java.util.*;


public class prog3

{

    static float[] sort(float[] sequence, float maxValue)

    {

        // Bucket Sort

        float[] Bucket = new float[(int)(maxValue*1000000) + 1];

        float[] sorted_sequence = new float[sequence.length];

        long st = System.nanoTime();

        for (int i = 0; i < sequence.length; i++)

            Bucket[(int)(sequence[i]*1000000)]++;



        int outPos = 0;

        for (int i = 0; i < Bucket.length; i++)

            for (int j = 0; j < Bucket[i]; j++)

                sorted_sequence[outPos++] = i;

        long et = System.nanoTime();
        System.out.println("\nRunning Time: "+(et-st));
        return sorted_sequence;
    }
    static float maxValue(float[] sequence)

    {

        float maxValue = 0;

        for (int i = 0; i < sequence.length; i++)

            if (sequence[i] > maxValue)

                maxValue = sequence[i];

        return maxValue;

    }
    public static void main(String a[])
  {
    System.out.println("\nenter size: ");
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    Random r = new Random();
    float arr[] = new float[n];
    System.out.print("\nUnsorted Array :");
    for(int i = 0; i < n ; i++)
    { 
      arr[i] = r.nextFloat();
      System.out.print(arr[i]+"\t");
    }
    System.out.println();
    s.close();
    // long st = System.nanoTime();
    arr = sort(arr,maxValue(arr));
    // long et = System.nanoTime();
    // System.out.print("\nRunning Time : "+(et-st)+"\n\nSorted Array   :");
    System.out.println("\nSorted Array : ");
        for(int i = 0; i < n ; i++)
    {
      System.out.print(arr[i]/1000000+"\t\t");
    }
  }
}