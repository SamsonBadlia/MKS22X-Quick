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

    int pivotIndex = data.length;
    int start = 0;
    int end = data.length - 1; // inclusive

    while(pivotIndex != k){
        pivotIndex = partition(data, start, end);
        if(pivotIndex > k){
            end = pivotIndex - 1;
        }else if(pivotIndex < k){
            // minus one because start is inclusive and we know the pivotIndex is not the solution
            start = pivotIndex + 1;
        }
    }

    return data[pivotIndex];
  }

  public static int partition(int [] data, int start, int end){
        if(end == start) return start;

        int pivotIndex = ((int)(Math.random() * 10) % (end + 1 - start)) + start;
        int pivot = data[pivotIndex];
        int temp = data[pivotIndex];
        data[pivotIndex] = data[start];
        data[start] = temp;
        pivotIndex = start;
        start++;

        while(start != end){
            int current = data[start];
            if(current < pivot){
                start++;
            }else{
                temp = data[start];
                data[start] = data[end];
                data[end] = temp;
                end--;
            }
        }

        if(pivot > data[start]){
          temp = data[pivotIndex];
          data[pivotIndex] = data[start];
          data[start] = temp;
            return start;
        }else{
            temp = data[pivotIndex];
            data[pivotIndex] = data[start-1];
            data[start-1] = temp;
            return start - 1;
        }
    }
}
