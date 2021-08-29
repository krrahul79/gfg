import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class hashing {

    void hashSetBasicFunctions(){
        HashSet<Integer>hset = new HashSet<>();
        hset.add(1);
        hset.add(2);
        hset.add(3);
        boolean containsOrNot = hset.contains(1);
        Iterator<Integer> i = hset.iterator();
        while(i.hasNext()){
            System.out.println(i.next());
        }
        hset.size(); //to get the size of the set
        hset.remove(2); //to remove a particular value
        hset.isEmpty(); // to check it the hset is empty
        hset.clear(); // to clear the hash set

        //another way of traversing through hash set it
       //map.putIfAbsent(A[i] + A[j], new ArrayList<>());
        for(Integer values : hset){
            System.out.println(values);
        }
    }

    void hashMapBasicFunctions(){
        HashMap<String,Integer> hmap = new HashMap<>();
        hmap.put("a",1);
        hmap.put("b",2);
        hmap.put("c",3);
        hmap.size();
        //iterating through the hashmap
        for(Map.Entry<String,Integer> e : hmap.entrySet()){
            e.getKey();
            e.getValue();
        }
        hmap.containsKey("a");
        hmap.remove("a");
        hmap.containsValue("1");
        hmap.get("a");
    }

    boolean subarrayWithZeroSum(int arr[]){
        int n = arr.length;
        HashSet<Integer>hset = new HashSet<>();
        int prefixSum = 0;
        for(int i = 0; i<n;i++){
            prefixSum += arr[i];
            if(hset.contains(prefixSum)) {
                return true;
            }
            if(prefixSum == 0){
                //to handle cases like -3, 1, 2, 4
                return true;
            }
            else{
                hset.add(prefixSum);
            }
        }
        return false;
    }

    boolean subarrayWithGivenSum(int arr[], int sum){
        int n = arr.length;
        HashSet<Integer>hset = new HashSet<>();
        int prefixSum = 0;
        for(int i = 0; i<n;i++){
            prefixSum += arr[i];
            if(prefixSum == sum){
                return true;
            }
            if(hset.contains(prefixSum - sum)) {
                return true;
            }
            else{
                hset.add(prefixSum);
            }
        }
        return false;
    }


    int longestSubArrayWithPrefixSum(int arr[], int sum){
        int n = arr.length;
        HashMap<Integer,Integer>hmap = new HashMap<>();
        int prefixSum = 0;
        int res = 0;
        for(int i = 0; i<n;i++){
            prefixSum += arr[i];
            if(prefixSum == sum){
                res = Math.max(res,i + 1);
            }
            if(hmap.containsKey(prefixSum) == false){
                hmap.put(prefixSum,i);
            }
            if(hmap.containsKey(prefixSum - sum)) {
                res = Math.max(res,i-hmap.get(prefixSum - sum));
            }
        }
        return -1;
    }

    int longestSubArrayWithEqual0And1(int arr[]){
        int n = arr.length;
        for(int i = 0; i<n ;i++){
            if(arr[i]==0)
                arr[i] = -1;
        }
        HashMap<Integer,Integer>hmap = new HashMap<>();
        int prefixSum = 0;
        int res = 0;
        for(int i = 0; i<n;i++){
            prefixSum += arr[i];
            if(prefixSum == 0){
                res = Math.max(res,i + 1);
            }
            if(hmap.containsKey(prefixSum) == false){
                hmap.put(prefixSum,i);
            }
            if(hmap.containsKey(prefixSum)) {
                res = Math.max(res,i-hmap.get(prefixSum));
            }
        }
        return -1;
    }

    int longestCommonSpanwithsamesum(int arr1[], int arr2[]){
        int n = arr1.length;
        int temp[] = new int[n];
        for(int i = 0; i<n ;i++){
            temp[i] = arr1[i] - arr2[i];
        }
        HashMap<Integer,Integer>hmap = new HashMap<>();
        int prefixSum = 0;
        int res = 0;
        for(int i = 0; i<n;i++){
            prefixSum += temp[i];
            if(prefixSum == 0){
                res = Math.max(res,i + 1);
            }
            if(hmap.containsKey(prefixSum) == false){
                hmap.put(prefixSum,i);
            }
            if(hmap.containsKey(prefixSum)) {
                res = Math.max(res,i-hmap.get(prefixSum));
            }
        }
        return -1;
    }

    int longsetConsecutiveSubSequence(int arr[]){
        int n = arr.length;
        HashSet<Integer> hset = new HashSet<>();
        for(int i =0 ;i< n;i++){
            hset.add(arr[i]);
        }
        int curr = 0;
        int res = 0;
        for(Integer i : hset){
            if(hset.contains(i-1)==false){
                curr = 1;
                while(hset.contains(i + curr)){
                    ++curr;
            }
            res = Math.max(res,curr);
        }
        return res;
    }

    void countDistinctiveElementsInWindow(int arr[], int k){
        int n = arr.length;
        HashMap<Integer,Integer> hmap = new HashMap<>();
        for(int i = 0; i<k;i++){
//            if(hmap.containsKey(arr[i])){
//                hmap.put(arr[i],hmap.get(arr[i])+1);
//            }
//            else{
//                hmap.put(arr[i],1);
//            }
            hmap.put(arr[i],hmap.getOrDefault(arr[i],0)+1);
        }
        System.out.print(hmap.size()+" ");
        for(int i = k;i<n-k; i = i + k){
            if(hmap.get(arr[i])>0){
                hmap.put(arr[i],hmap.get(arr[i])-1);
            }
            for(int j = i; j<i+k; j++){
                hmap.put(arr[i],hmap.getOrDefault(arr[i],0)+1);
                }
            }
            System.out.print(hmap.size()+" ");
        }

        void elementPresentMoreThannbykTimes(int arr[],int k){
        int n =arr.length;
        HashMap<Integer,Integer> hmap = new HashMap<>();
        for(int a : arr){
            hmap.put(a, hmap.getOrDefault(a,0)+1);
        }
        for(Map.Entry<Integer,Integer>e : hmap.entrySet()){
            if(e.getKey() > n/k){
              System.out.print(e.getKey()+" ");
            }
        }
        }

    void elementMoreThannbykTimesnksolution(int arr[],int k){
        int n =arr.length;
        HashMap<Integer,Integer> hmap = new HashMap<>();
        for(int a : arr){
            if(hmap.size()>k-1){
                for(Map.Entry<Integer,Integer>e: hmap.entrySet()){
                    if(e.getValue()==1){
                        hmap.remove(e.getKey());
                    }
                    else{
                        hmap.put(e.getKey(),e.getValue()-1);
                    }
                }
            }else{
                hmap.put(a, hmap.getOrDefault(a,0)+1);
            }
        }
        for(Map.Entry<Integer,Integer>e : hmap.entrySet()){
            if(e.getKey() > n/k){
                System.out.print(e.getKey()+" ");
            }
        }
    }


}
