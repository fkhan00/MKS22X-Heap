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
// heapify works
  public static void heapify(int[] ary){
    int[] heap = new int[ary.length];
    heap[0] = ary[0];
    int index = 1;
    int indexA = 1;
    while((indexA - 1) * 2 + 1 < ary.length){
      // while you're not at the end
      indexA = (indexA - 1) * 2 + 1;
      heap[indexA] = ary[index];
      // put the index as a child
      pushUp(heap, indexA);
      //push the child up until it's in the right position
      index ++;
      //
      if(indexA + 1 < ary.length){
        indexA ++;
        heap[indexA] = ary[index];
        pushUp(heap, indexA);
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
