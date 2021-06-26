import java.util.*;

public class Sorting {


    public void swap(int arr[], int p1, int p2) {
        int temp = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = temp;
    }

    public void bubbleSort(int arr[], int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public void selectionSort(int arr[], int n) {
        for (int i = 0; i < n - 1; i++) {
            int min_index = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_index]) {
                    min_index = j;
                }
            }
            swap(arr, min_index, i);
        }
    }

    //insertion sort
    public void insertionSort(int arr[], int n) {
        for (int i = 0; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                --j;
            }
            arr[j + 1] = key;
        }
    }

    //merge function time: O(n) space: O(n)
    public void merge(int arr[], int low, int mid, int high) {
        int n = arr.length;
        int n1 = mid - low + 1;
        int n2 = high - mid;
        int left[] = new int[n1];
        int right[] = new int[n2];
        for (int i = 0; i < n1; i++) {
            left[i] = arr[low + i];
        }
        for (int i = 0; i < n2; i++) {
            right[i] = arr[mid + i + 1];
        }
        int k[] = new int[n];
        int a = 0;
        int b = 0;
        int c = 0;

        while (a < n1 && b < n2) {
            if (left[a] <= right[b]) {
                k[c] = left[a];
                a++;
                c++;
            } else {
                k[c] = right[b];
                b++;
                c++;
            }
        }
        while (a < n1) {
            k[c] = left[a];
            a++;
            c++;
        }
        while (b < n2) {
            k[c] = right[b];
            b++;
            c++;
        }
        for (int i = 0; i < n; i++) {
            arr[i] = k[i];
        }
    }
    //merge sort
    public void mergeSort(int arr[], int l, int r){
        int m = l + (r-l)/2; // to prevent overflow
        if(r>l){
            mergeSort(arr,l,m);
            mergeSort(arr,m,r);
            merge(arr,l,m,r);
        }
    }

    //intersection of two arrays O(m + n)
//    a =[10,20,20,40,60]
//    b =[2,20,20,20]
//    ans : 20
    public void intersection(int a[], int b[], int m, int n){
        int i = 0,j = 0;
        while(i<m && j <n){
           if(i > 0  && a[i]==a[i-1]){
            i++;
            continue;
           }
           if(a[i] < b[j]){
               i++;
           }
           else if(a[i] >b[j]){
               j++;
           }
           else if(a[i] == b[j]){
               System.out.print(a[i]+" ");
               i++;
               j++;
           }
        }
    }


//    Union of two arrays
//    a = [2, 10, 20, 20]
//    b= [3. 20, 40]
//    ans: [2,3,10,20,40]
    //O(m+n)
    public void union(int a[], int b[], int m, int n) {
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (i > 0 && a[i] == a[i - 1]) {
                i++;
                continue;
            }
            if (j > 0 && b[j] == b[j - 1]) {
                j++;
                continue;
            }
            if (a[i] < b[j]) {
                System.out.print(a[i] + " ");
                i++;
            } else if (a[i] > b[j]) {
                System.out.print(b[j] + " ");
                j++;
            } else {
                System.out.print(a[i] + " ");
                i++;
                j++;
            }
        }
        while(i< m){
            if(i > 0 && a[i]!=a[i-1]){
                System.out.print(a[i] + " ");
                i++;
            }
        }
        while(j< n){
            if(j > 0 && b[j]!=b[j-1]){
                System.out.print(b[j] + " ");
                j++;
            }
        }
    }

    //Count inversion is an array
   //O(nlogn) time
    public int inversion(int arr[], int l, int r){
       int res = 0;
        int m = l + (r-l)/2; // to prevent overflow
        if(r>l){
            res +=   inversion(arr,l,m);
            res +=   inversion(arr,m,r);
            res +=   countAndMerge(arr,l,m,r);
        }
        return res;
    }

    public int countAndMerge(int arr[], int low, int mid, int high) {
        int n = arr.length;
        int n1 = mid - low + 1;
        int n2 = high - mid;
        int left[] = new int[n1];
        int right[] = new int[n2];
        for (int i = 0; i < n1; i++) {
            left[i] = arr[low + i];
        }
        for (int i = 0; i < n2; i++) {
            right[i] = arr[mid + i + 1];
        }
        int a = 0, res = 0;
        int b = 0;
        int c = low;
        while (a < n1 && b < n2) {
            if (left[a] <= right[b]) {
                arr[c] = left[a];
                a++;
            } else {
                arr[c] = right[b];
                b++;
                res = res + (n1 - a); //we do this because the element will be inverted for all the rest of the elemets in the left array
            }
            c++;
        }
        while (a < n1) {
            arr[c] = left[a];
            a++;
            c++;
        }
        while (b < n2) {
            arr[c] = right[b];
            b++;
            c++;
        }
     return res;
    }

    //Partition of a given array naive method
    //O(n) extra space and O(n) time
    void naivepartition(int arr[], int l, int h,int p){
        int temp[] = new int[h-l+1];
        int index =0;
        for(int i = 0; i< h;i++) {
            if (arr[i] <= arr[p]) {
                temp[index] = arr[i];
                index++;
            }
        }
            for(int i = 0; i< h;i++) {
                if (arr[i] > arr[p]) {
                    temp[index] = arr[i];
                    index++;
                }
            }
            for(int i = l;i<=h;i++){
                arr[i] = temp[i-l];
            }
        }

        //lomuto partition
    int lomutoPartition(int arr[], int l, int h){
        int pivot = arr[h];
        int i = l-1;
        for(int j = l; j<=h-1;j++){
           if(arr[j]<pivot){
               i++;
               swap(arr,i,j);
           }
        }
        swap(arr,i+1,h);
        return i+1;
    }

    int hoarePartition(int arr[], int l, int h){
        int pivot = arr[l];
        int i = l - 1, j = h +1;
        while(true){
            do{
                ++i;
            }while(arr[i]<pivot);
            do{
               --j;
            }while(arr[j]>pivot);
            if(i>=j){
                return j;
            }
            swap(arr,i,j);
        }
    }

    //quick sort using lomuto partition
    void lomutoQuickSort(int arr[], int l, int h){
        if(l < h){
            int p = lomutoPartition(arr, l , h);
            lomutoQuickSort(arr, l, p-1);
            lomutoQuickSort(arr, p + 1, h);
        }
    }

    void hoareQuickSort(int arr[], int l, int h){
       if(l < h){
           int p = hoarePartition(arr, l , h);
           hoareQuickSort(arr, l, p);
           hoareQuickSort(arr,p+1,h);
       }
    }

    //tail call elmimination
    // goto can be implemented for c++ language
    void hoareQuickSortTailCall(int arr[], int l, int h){
        Begin:
        if(l<h){
            int p = hoarePartition(arr, l , h);
            hoareQuickSortTailCall(arr,l,p);
            l = p + 1;
            //goto Begin;
        }
    }
    //finding the kth smallest element in the array
    // average case assumption is based on assigning the random partition
    //Quick select solution
    int findkthsmallest(int arr[], int l, int h, int k){
        while(l<=h){
            int p = lomutoPartition(arr, l, h);
            if(p == k -1){
                return p;
            }
           if(p > k-1){
               h = p - 1;
           }
           else{
               l = p + 1;
           }
        }
      return -1;
    }
   //minDiffChocolate
    int minDiffChocolate(int arr[], int m , int n){
        Arrays.sort(arr);
        if(m>n) return -1;
        int res = arr[m-1] - arr[0];
        for(int i = 1; (i+m-1)<n;i++){
            res = Math.min(res,(arr[i+m-1]-arr[i]));
        }
        return res;
    }

    //segreate positive and negative numbers in an array
    //using hoare's partiton we can also use lomuto partition

    void segregateHoare(int arr[], int n){
        int i = -1;
        int j = n;
        while(true) {
            do {
                i++;
            } while (arr[i] < 0);
            do {
                --j;
            } while (arr[j] >= 0);
        if(i>=j){
            return;
        }
        swap(arr,i,j);
        }
    }

    //dutch flag algorithm
    void dutchFlagAlgorithm(int arr[], int n){
        int l = 0, mid = 0, h = n -1;
        while(mid<=h){
            if(arr[mid]==0){
                swap(arr,mid,l);
                l++;
                mid++;
            }
            else if(arr[mid]==1){
                mid++;
            }
            else{
                swap(arr,mid,h);
                l--;
            }
        }
    }

    //min difference
    int minDifference(int arr[], int n){
        Arrays.sort(arr);
        int res = Integer.MAX_VALUE;
        for(int i = 1; i < n ;i++){
            res = Math.min(res,arr[i]-arr[i-1]);
        }
        return res;
    }
    
     public class MyComp implements Comparator<int[]>{
       public int compare(int[] arr1, int[] arr2){
           return arr1[0] - arr2[0];
        }
    }

    public static void main(String args[]) {
        //String a = "abc";
//       String a[] = {"abc","2","10","0"};
  //   ArrayList a1 =  Arrays.asList("Hello","World");
//        List<Integer> al =
//                new ArrayList<String>(Arrays.asList(a));
//        System.out.println(a.getClass().getName());
//        }

//        LinkedList<Integer> list = new LinkedList<>();
//        list.add(5);
//        list.add(10);
//
//
//        System.out.println(list);

//        (a)->false;
//        (String a )->false;
        //sorting.maxGuests();
    }
    public void callFunction(String string){
        int [][]arr = {{5,10},{3,15},{16,30},{2,7}};
        Arrays.sort(arr,new MyComp());

        int rows = arr.length;
        int cols = arr[0].length;
        for(int i = 0 ;i<rows;i++)
        {
            for(int j = 0; j<cols; j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

    void mergeIntervals(){
        int [][]arr = {{5,10},{3,15},{16,30},{2,7}};
        Arrays.sort(arr,new MyComp());
        int rows = arr.length;
        //int cols = arr[0].length;
        int res = 0;
        for(int i = 1; i < rows; i++){
            if(arr[i][0]<=arr[res][1]){
                arr[res][0] = Math.min(arr[i][0],arr[res][0]);
                arr[res][1] = Math.max(arr[i][1],arr[res][1]);
             }
            else{
                res++;
                arr[res][0] = arr[i][0];
                arr[res][1] = arr[i][1];
            }
        }
        for(int i = 0;i<=res;i++){
            System.out.print(arr[i][0]+" - "+ arr[i][1]);
            System.out.println();
        }
    }

    int maxGuests(int arr[], int dep[], int n){
        //int [][]arr = {{900,1000},{600,800},{700,730}};
        Arrays.sort(arr);
        Arrays.sort(dep);
        int res = 0;
        int curr = 0;
        int i = 0;
        int j = 0;
        while(i< n && j <n){
            if(arr[i]<=dep[j]){
              curr++;
              i++;
            }
            else{
                curr--;
                j--;
            }
            res = Math.max(res,curr);
        }
       return res;
    }
    
}
