//SortingAlg program implemented in java. This project is to test different
//sorting algorithms and their efficency for ordered, reverse ordererd and
//random lists. Using arrays for implementation and static variables
//to count the comperisons and operations done by each sorting algorithm

import java.util.*;
import java.io.*;

public class SortingAlg
{
  public static int comparisons;
  public static int operations;

  public static void main(String[] args) throws IOException
  {
    int[] array1 = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int[] array2 = new int[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    int[] array3 = new int[] {1, 3, 2, 6, 5, 4, 8, 7, 9, 10};

    //scan in txt file consisting of 2000 int in order
    Scanner scan = new Scanner(new File("best.txt"));

    int[] orderedArray = new int[2000];
    for(int i = 0; scan.hasNext(); i++)
    {
      int number = scan.nextInt();
      orderedArray[i] = number;
    }

    //scan in txt file consisting of 2000 int in reverse order
    Scanner scan1 = new Scanner(new File("worst.txt"));

    int[] reversedArray = new int[2000];
    for(int j = 0; scan1.hasNext(); j++)
    {
      int number = scan1.nextInt();
      reversedArray[j] = number;
    }

    //scan in txt file consisting of 2000 int in random order
    Scanner scan2 = new Scanner(new File("average.txt"));

    int[] randomArray = new int[2000];
    for(int k = 0; scan2.hasNext(); k++)
    {
      int number = scan2.nextInt();
      randomArray[k] = number;
    }

    System.out.println (" --- Ordered List (N = 10) ---");
    selectionSort(array1);
    //insertionSort(array1);
    //bubbleSort(array1);
    //quickSort(array1);
    //radixSort(array1);
    System.out.println("Selection Sort: Number of Operations: " + operations);
    System.out.println("Selection Sort: Number of Comparisons: " + comparisons);

    System.out.println (" --- Reversed Ordered List (N = 10) ---");
    selectionSort(array2);
    //insertionSort(array2);
    //bubbleSort(array2);
    //quickSort(array2);
    //radixSort(array2);
    System.out.println("Selection Sort: Number of Operations: " + operations);
    System.out.println("Selection Sort: Number of Comparisons: " + comparisons);

    System.out.println (" --- Random Ordered List (N = 10) ---");
    selectionSort(array3);
    //insertionSort(array3);
    //bubbleSort(array3);
    //quickSort(array3);
    //radixSort(array3);
    System.out.println("Selection Sort: Number of Operations: " + operations);
    System.out.println("Selection Sort: Number of Comparisons: " + comparisons);

    System.out.println (" --- Ordered List (N = 2000) ---");
    selectionSort(orderedArray);
    //insertionSort(orderedArray);
    //bubbleSort(orderedArray);
    //quickSort(orderedArray);
    //radixSort(orderedArray);
    System.out.println("Selection Sort: Number of Operations: " + operations);
    System.out.println("Selection Sort: Number of Comparisons: " + comparisons);

    System.out.println (" --- Reversed Ordered List (N = 2000) ---");
    selectionSort(reversedArray);
    //insertionSort(reversedArray);
    //bubbleSort(reversedArray);
    //quickSort(reversedArray);
    //radixSort(reversedArray);
    System.out.println("Selection Sort: Number of Operations: " + operations);
    System.out.println("Selection Sort: Number of Comparisons: " + comparisons);

    System.out.println (" --- Random Ordered List (N = 2000) ---");
    selectionSort(randomArray);
    //insertionSort(randomArray);
    //bubbleSort(randomArray);
    //quickSort(randomArray);
    //radixSort(randomArray);
    System.out.println("Selection Sort: Number of Operations: " + operations);
    System.out.println("Selection Sort: Number of Comparisons: " + comparisons);
  }

  //selection sort method to sort an array of integers and test
  //efficency by counting comparisons and operations
  public static void selectionSort(int[] array)
  {
    comparisons = 0;
    operations = 0;
    int n = array.length;

        for (int i = 0; i < n-1; i++)
        {
           int min = i;
            for (int j = i+1; j < n; j++){

                if (array[j] < array[min])
                    min = j;
                    comparisons++;
          }
            int temp = array[min];
            array[min] = array[i];
            array[i] = temp;
            operations++;
        }
      }

    //insertion sort method to test insertion sort algorithms
    //efficency using counter variables, comparisons variable
    //incremented twice per loop to get more accurate reading
    public static void insertionSort(int[] array)
    {
      comparisons = 0;
      operations = 0;
      int i, j, target;
      int n = array.length;

      for(i = 1; i < n; i++)
      {
       target = array[i];
       j = i -1;
       comparisons++;

       while(j >= 0 && array[j] > target)
       {
         array[j+1] = array[j];
         j = j - 1;
         operations++;
         comparisons++;
       }
       array[j + 1] = target;
     }
  }

  //bubble sort method to test bubble sort algorithms efficency
  //using counter variables
  public static void bubbleSort(int[] array)
  {
    comparisons = 0;
    operations = 0;
    int n = array.length;
    int i, j = 0;
    boolean cont = true;

    for (i = 0; i < n-1; i++)
    {
      if(cont)
      {
        cont = false;
        for (j = 0; j < n-i-1; j++)
        {

            if (array[j] > array[j+1])
            {
                int temp = array[j];
                array[j] = array[j+1];
                array[j+1] = temp;
                cont = true;
                operations++;
            }
            comparisons++;
          }
        }
        else
          break;
      }
    }

    //radix sort method to test efficency of radix sort using
    //counter variables. Using methods arrayToQue, getPile, getMax,
    //and queueToArray
    public static void radixSort(int[] list)
    {
      comparisons = 0;
      operations = 0;
      final int RADIX = 10;
      int digit = 1;
      int max = getMax(list);
      int item, pile, i, j;

      Queue Q = new Queue();
      Queue[] buckets = new Queue[10];

      arrayToQueue(list, Q);

      while(max/digit > 0)
      {
        for(i = 0; i < RADIX; i++)
        {
          buckets[i] = new Queue();
        }
        while(!Q.empty())
        {
          item = Q.dequeue();
          pile = getPile(item, digit);
          buckets[pile].enqueue(item);
          operations++;
        }
        for(j = 0; j < RADIX; j++)
        {
          while(!buckets[j].empty())
          {
            item = buckets[j].dequeue();
            Q.enqueue(item);
            operations++;
          }
        }
        digit = digit * 10;
      }
      queueToArray(Q, list);
    }

    //queue to array method to parse a queue back into an array
    public static void queueToArray(Queue q, int[] list)
    {
      for(int i = 0; i < list.length; i++)
      {
        if(!q.empty())
        list[i] = q.dequeue();
        else
        list[i] = 0;
      }
    }

    //get pile method to return 1,10,100s place in integer
    public static int getPile(int number, int digit)
    {
        return(number % (10 * digit) / digit);
    }

    //array to queue method to parse an array into a queue
    public static void arrayToQueue(int[] list, Queue Q)
    {
      for(int i = 0; i < list.length; i++)
      {
        Q.enqueue(list[i]);
      }
    }

    //get max method to return highest/maximum integer in an array
    public static int getMax(int[] list)
    {
      int max = list[0];
      for(int i = 1; i < list.length; i++)
      {
        if(max < list[i])
        max = list[i];
      }
      return max;
    }

    //quick sort method to sort an arrau of integers using the
    //quick sort algorithm
    public static void quickSort(int[] list, int lo, int hi)
    {

      int pivot = partition(list, lo, hi);
        if(lo < pivot)
        {
          quickSort(list, lo, pivot - 1);
        }
        if(pivot < hi)
        {
          quickSort(list, pivot + 1, hi);
        }
    }

    //partiotion method to be used in quick sort, variable pivot
    //comparison and operation variables incremented to test efficency
    public static int partition(int[] list, int lo, int hi)
    {
      comparisons = 0;
      operations = 0;
      int pivot = list[lo];

      while(lo < hi)
      {
          while (pivot < list[hi] && lo < hi)
          {
            hi--;
            comparisons++;
          }
          if(hi != lo)
          {
            list[lo] = list[hi];
            operations++;
            lo++;
          }
          while(list[lo] < pivot && lo < hi)
          {
            lo++;
            comparisons++;
          }
          if(hi != lo)
          {
            list[hi] = list[lo];
            operations++;
            hi--;
          }
      } //end of while loop
      list[hi] = pivot;
      return hi;
    }
  }
