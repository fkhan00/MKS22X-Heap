public class MyHeap
{
  public static void heapsort(int[] ary){
    int size = ary.length;
    // start at bottom and fix parent and two child nodes
    // then go up and fix the next triplet
    for (int i = size / 2 - 1; i >= 0; i--){
      heapify(ary, size, i);}

    for (int i = size-1; i>=0; i--){
      swap(ary, 0, i);
      heapify(ary, i, 0);}}


    public static void swap(int[] ary, int index1, int index2){
      int holder = ary[index1];
      ary[index1] = ary[index2];
      ary[index2] = holder;}

      //recursive O(logn) heapify
      //takes sub branch
    public static void heapify(int arr[], int size, int parent){
      //start at parent node
      int maximum = parent;
      int leftChild = 2 * parent + 1;
      int rightChild = 2 * parent + 2;
      // find maximum between two child nodes and parent node
      if (leftChild < size && arr[leftChild] > arr[maximum])
        maximum = leftChild;

      if (rightChild < size && arr[rightChild] > arr[maximum])
        maximum = rightChild;
      // if maximum isn't parent node, swap maximum node with parent node
      if (maximum != parent){
        swap(arr, parent, maximum);
        // recursive call to go down to next node
        heapify(arr, size, maximum);}}}
