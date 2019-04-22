public class MyHeap{

  private static void pushDown(int[] ary, int size, int index){
    if(index * 2 + 1 > size){
      return;}
    if(index * 2 + 2 > size){
      if(ary[index] < ary[index * 2 + 1]){
        swap(ary, index, index * 2 + 1);}
      return;}
    if(ary[index] > ary[index * 2 + 1] && ary[index] > ary[index * 2 + 2]){
      return;}
    if(ary[index] < ary[index * 2 + 1] && ary[index] < ary[index * 2 + 2]){
      if(ary[index * 2 + 1] > ary[index * 2 + 2]){
        swap(ary, index, index * 2 + 1);
      index = index * 2 + 1;}
      else{
        swap(ary, index, index * 2 + 2);
        index = index * 2 + 2;}}
    pushDown(ary, size, index);}

  private static void swap(int[] ary, int ind1, int ind2){
    int temp = ary[ind2];
    ary[ind2] = ary[ind1];
    ary[ind1] = temp;}

  private static int max(int a, int b){
    if(a < b){
      return b;}
    return a;}

  private static void pushUp(int[] ary, int index){
    if(index == 0 || ary[(index - 1) / 2] > ary[index]){
      return;}
    swap(ary, index, (index - 1) / 2);
    pushUp(ary, (index - 1) / 2);}

  public static void heapify(int[] ary){
    int[] heap = new int[ary.length];
    heap[0] = ary[0];
    int index = 1;
    while((index - 1) * 2 + 1 < ary.length){
      heap[(index - 1) * 2 + 1] = ary[index];
      pushUp(heap, (index - 1) * 2 + 1);
      index ++;
      if((index - 1) * 2 + 2 < ary.length){
        heap[(index - 1) * 2 + 2] = ary[index];
        pushUp(heap, (index - 1) * 2 + 2);
        index ++;
    }}
    for(int i = 0; i < ary.length; i++){
      ary[i] = heap[i];}}

  public static void heapsort(int[] ary){
    heapify(ary);
    int temp = 0;
    int size = ary.length - 1;
    while(size < ary.length){
    temp = ary[0];
    ary[0] = ary[size] - 1;
    pushDown(ary, size, 0);
    ary[size] = temp;
    size --;}}

}
