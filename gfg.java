import java.util.Arrays;
import java.util.Comparator;

public class gfg {
    //Move zeros to the end
    public void moveZeroes(int arr[], int n){
         int count  = 0;
         for(int i = 0; i<n;i++){
             if(arr[i]!=0){
                 swap(arr[i], arr[count]);
                 count++;
             }
         }
     }

     public void swap(int a, int b){
         int temp = a;
         a = b;
         b = temp;
     }

    //Print leaders in an array
    public void printLeader(int arr[], int n){
        int curr_leader = arr[n-1];
        System.out.println(curr_leader);
        for(int i = n - 2; i>=0;i--){
            if(curr_leader<arr[i]){
                curr_leader = arr[i];
                System.out.println(curr_leader);
            }
        }
    }

    //Maximum difference
    public int maximumDifference(int arr[], int n){
        int res = arr[1] - arr[0];
        int minVal = arr[0];
        for(int j = 1; j<n; j++){
            res = Math.max(res,arr[j]-minVal);
            minVal = Math.min(minVal,arr[j]);
        }
        return res;
    }

    //Stock buy and cell
    public int maxProfit(int price[], int n){
        int profit = 0;
        for(int i = 1;i<n;i++){
            if(price[i]>price[i-1]){
                profit += price[i];
            }
        }
        return profit;
    }

    //Maximum sum subarray
    public int maxSumSubarray(int arr[], int n){
        int maxSum = arr[0];
        int preSum = arr[0];
        for(int i = 1; i<n;i++){
            if(arr[i]>arr[i] + preSum){
                preSum = arr[i];
            }
            else{
                preSum = arr[i] + preSum;
            }
            if(preSum > maxSum){
                maxSum = preSum;
            }
        }
        return maxSum;
    }

    //Rearrange an array with O(1) extra space
    static void arrange(long arr[], int n)
    {

        for(int i = 0; i<n; i++){
            arr[i] += (arr[(int)arr[i]] % n) * n;
        }
        for(int i = 0; i<n; i++) {
            arr[i] = arr[i] / n;
        }
    }

   // Minimum Number in a sorted rotated array
    static int minNumber(int arr[], int low, int high)
    {
        int mid = (low + high)/2;

        if(mid == 0 || (mid == high)
                ||((arr[mid - 1]>arr[mid]) && (arr[mid + 1] > arr[mid]))){
            return arr[mid];
        }
        else{
            if(arr[high]< arr[mid]){
                low = mid + 1;
            }
            else{
                high = mid;
            }
            //System.out.println("mid"+mid);
            return minNumber(arr, low, high);

        }      // Your code here
    }

    //Maximum Index: Given an array A[] of N positive integers. The task is to find the maximum of j - i subjected to the constraint of A[i] <= A[j]
    static int maxIndexDiff(int arr[], int n) {
        int rmax[] = new int[n];
        int lmin[] = new int[n];
        rmax[n-1] = arr[n-1];
        for(int i = n - 2; i >= 0; i--){
            rmax[i] = Math.max(arr[i],rmax[i+1]);

        }
        lmin[0] =arr[0];
        for(int i = 1; i < n ;i++){
            lmin[i] = Math.min(arr[i],lmin[i-1]);

        }
        int i = 0;
        int j = 0;
        int maxdiff = -1;
        while(i < n && j < n){
            if(lmin[i] <= rmax[j]){
                maxdiff = Math.max(maxdiff, j - i);
                ++j;
            }
            else{
                ++i;
            }
        }
        // Your code here
        return maxdiff;
    }



    class Point implements Comparable<Point>{
     int x, y;
     Point(int x, int y){
         this.x = x;
         this.y = y;
     }
     public int compareTo(Point P){
       return this.x - P.x;
     }
    }

    class MyComp implements Comparator<Point>{
        public int compare(Point p1, Point p2){
            return p1.x - p2.x;
        }
    }

    class Test{
        public void main(String args[]){
            Point arr[] = {new Point(1,2),new Point(1,2),new Point(1,2)};
            Arrays.sort(arr);
            Arrays.sort(arr, new MyComp());
        }
    }
}
