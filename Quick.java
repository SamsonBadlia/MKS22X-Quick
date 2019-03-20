import java.util.*;

public class Quick{

  public static void main(String[]args){
    System.out.println("Size\t\tMax pivotue\tquick/builtin ratio ");
    int[]MAX_LIST = {1000000000,500,10};
    for(int MAX : MAX_LIST){
      for(int size = 31250; size < 2000001; size*=2){
        long qtime=0;
        long btime=0;
        //average of 5 sorts.
        for(int trial = 0 ; trial <=5; trial++){
          int []data1 = new int[size];
          int []data2 = new int[size];
          for(int i = 0; i < data1.length; i++){
            data1[i] = (int)(Math.random()*MAX);
            data2[i] = data1[i];
          }
          long t1,t2;
          t1 = System.currentTimeMillis();
          Quick.quicksortDutch(data2);
          t2 = System.currentTimeMillis();
          qtime += t2 - t1;
          t1 = System.currentTimeMillis();
          Arrays.sort(data1);
          t2 = System.currentTimeMillis();
          btime+= t2 - t1;
          if(!Arrays.equals(data1,data2)){
            System.out.println("FAIL TO SORT!");
            System.exit(0);
          }
        }
        System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
      }
      System.out.println();
    }
  }

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
    if (data.length >= 0) quickSortH(data,0,data.length-1 );
    else quickSortH(data,0,0);
  }

  public static void quicksortDutch(int[] data){
    if (data.length >= 0) quickSortD(data,0,data.length-1);
    else quickSortD(data,0,0);
  }

  public static void quickSortD(int[] data, int lo, int hi){
    if (lo >= hi) return;
      else{
        int[] indexes = partitionDutch(data, lo, hi);
        int lowerIndex = indexes[0];
        int higherIndex = indexes[1];
          if(lowerIndex - lo <= 25) {
              insertionSort(data, lo, lowerIndex);
          }else{
              quickSortD(data, lo, lowerIndex);
          }
          if(hi - higherIndex <= 25){
              insertionSort(data, higherIndex, hi);
          }else{
              quickSortD(data, higherIndex, hi);
          }
        }
  }

  public static void quickSortH(int[] data, int lo, int hi){
    if (lo >= hi) return;
    int pivot = partition(data , lo , hi);
    quickSortH(data ,lo , pivot - 1);
    quickSortH(data , pivot + 1 , hi);
  }

  public static void insertionSort(int[] data, int start, int end){
      for (int i = start; i <= end; i++) {
          int current = data[i];
          int c = i;
          while (c > start && data[c - 1] > current) {
              data[c] = data[c - 1];
              c--;
          }
          data[c] = current;
      }
  }

  public static int[] partitionDutch(int[] data, int start, int end) {
      int[] arr = new int[2];
      if (end == start || end <= 0) {
          return new int[]{start, end};
      }
      int pivotIndex;
      int mid = (start + end) / 2;
      if(data[start] > data[mid]){
          if(data[mid] > data[end]){
              pivotIndex = mid;
          }else if(data[start] > data[end]){
               pivotIndex = end;
          }else{
              pivotIndex = start;
          }
      }else{
          if(data[start] > data[end]){
              pivotIndex = start;
          }else if(data[mid] > data[end]){
              pivotIndex = end;
          }else{
              pivotIndex = mid;
          }
      }
      //lIndex and rIndex are the bounds and counter goes through the array
      int pivot = data[pivotIndex];
      int lIndex = start;
      int counter = lIndex;
      int rIndex = end;
      while(counter <= rIndex){
          int current = data[counter];
          //if equal the values stay
          if (current == pivot) counter++;
          //if greater then values swap
          else if (current > pivot) {
            swap(data, counter, rIndex);
            rIndex--;
          } else{
            //if less values swap
              swap(data, lIndex, counter);
              lIndex++;
              counter++;
          }
      }
      arr[0] = lIndex - 1;
      arr[1] = rIndex + 1;
      return arr;
  }

  public static int partition(int [] data, int start, int end){
    if(end == start || end <= 0){
        return start;
    }

    int pivotIndex;

    int mid = (start + end) / 2;

    if(data[start] > data[mid]){
        if(data[mid] > data[end]){
            pivotIndex = mid;
        }else if(data[start] > data[end]){
             pivotIndex = end;
        }else{
            pivotIndex = start;
        }
    }else{
        if(data[start] > data[end]){
            pivotIndex = start;
        }else if(data[mid] > data[end]){
            pivotIndex = end;
        }else{
            pivotIndex = mid;
        }
    }

    int pivot = data[pivotIndex];
    swap(data, pivotIndex, start);
    pivotIndex = start;
    start++;

    while(start != end){
        int current = data[start];
        if(current < pivot){
            start++;
        }else{
            swap(data, start, end);
            end--;
        }
    }

    if(pivot > data[start]){
        swap(data, pivotIndex, start);
        return start;
    } else{
        swap(data, pivotIndex, start - 1);
        return start - 1;

  }
}

    public static void swap(int[] data, int a, int b){
      if ( a < 0 && a > data.length && b < 0 && b > data.length ) return;
      int temp = data[a];
      data[a] = data[b];
      data[b] = temp;
    }


}
