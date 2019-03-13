import java.util.*;

public class Quick{

  public static int quickselect(int [] data, int k){

    int pivot = data.length;
    int start = 0;
    int end = data.length - 1;

    while(pivot != k){
        pivot = partition(data, start, end);
        if(pivot > k){
            end = pivot - 1;
        }else if(pivot < k){
            start = pivot + 1;
        }
    }

    return data[pivot];
  }

  public static void quicksort(int[] data){
    if (data.length > 0) quickSortH(data,0,data.length);
  }

  public static void quickSortH(int[] data, int lo, int hi){
    if (lo >= hi) return;
    int pivot = partition(data , lo , hi);
    quickSortH(data ,lo , pivot - 1);
    quickSortH(data , pivot + 1 , hi);
  }

  public static int partition(int [] data, int start, int end){
      if (start < 0 && end >= data.length) return start;
      if (start == end) return start;

      int pivot = data[start];
      swap(data,start,pivot);
      pivot = start;

      int s = start + 1;
      int e = end;
      while(s != e){
        if(data[s] > data[pivot]){
          swap(data,s,e);
          e--;
        }else if(data[s] <= data[pivot]){
          s++;
        }
      }

      for(int i = start+1; i < end + 1; i++){
        if(data[i] > data[pivot]){
          swap(data, i-1 , pivot);
          return i - 1;
        }
      }

      swap(data, end, pivot);
      return end;
    }

    public static void swap(int[] data, int a, int b){
      if ( a < 0 && a > data.length && b < 0 && b > data.length ) return;
      int temp = data[a];
      data[a] = data[b];
      data[b] = temp;
    }
  }
