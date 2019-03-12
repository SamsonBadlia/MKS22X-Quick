import java.util.*;

public class Quick{

  public static void main(String[] args){

    int[]ary = { 2, 10, 15, 23, 0,  5};  //sorted :  {0,2,5,10,15,23}
    System.out.println(quickselect( ary , 0 )); // would return 0
    System.out.println(quickselect( ary , 1 ));  //would return 2
    System.out.println(quickselect( ary , 2 ));  //would return 5
    System.out.println(quickselect( ary , 3 ));  //would return 10
    System.out.println(quickselect( ary , 4 ));  //would return 15
    System.out.println(quickselect( ary , 5 ));  //would return 23

}

  public static int quickselect(int [] data, int k){

    int pivot = data.length;
    int start = 0;
    int end = data.length - 1;

    while(pivot != k){
        pivot = partition(data, start, end);
        if(pivot > k){
          return partition(data,start,pivot-1);
        }else if(pivot < k){
            return partition(data,pivot+1,end);
        }
    }

    return data[pivot];
  }

  public static int partition(int [] data, int start, int end){
        if(end == start) return start;

        int randPivot;
        if (data[start] < data[end] && data[start] > data[data.length / 2]) randPivot = data[start];
        else if (data[start] > data[end] && data[start] < data[data.length / 2]) randPivot = data[start];
        else if (data[end] < data[start] && data[end] > data[data.length / 2]) randPivot = data[end];
        else if (data[end] > data[start] && data[end] < data[data.length / 2]) randPivot = data[end];
        else if (data[data.length / 2] < data[end] && data[data.length / 2] > data[start]) randPivot = data[data.length / 2];
        else randPivot = data[data.length / 2];
        int pivot = data[randPivot];
        int temp = data[pivot];
        data[pivot] = data[start];
        data[start] = temp;
        pivot = start;
        start++;

        while(start != end){
            int current = data[start];
            if(current < pivot){
                start++;
            }
            else{
                temp = data[start];
                data[start] = data[end];
                data[end] = temp;
                end--;
            }
        }

        if(pivot > data[start]){
          temp = data[pivot];
          data[pivot] = data[start];
          data[start] = temp;
            return start;
        }
        else if (pivot == data[start]){
          Random random = new Random();
          int chance = random.nextInt() % 2 ;
          if (chance == 1){
            temp = data[pivot];
            data[pivot] = data[start];
            data[start] = temp;
          }
        }
        else{
            temp = data[pivot];
            data[pivot] = data[start-1];
            data[start-1] = temp;
            return start - 1;
        }
      }
}
