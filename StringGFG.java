import java.util.Arrays;

public class StringGFG {
    public void introduction(){
        char ch[] = {'a','b','c','d'};
        //the strings are immutable
        String str = "abc";
        String str1 = new String("abc");
        //String buffer is used for mutable string for single threaded, it is not thread safe
        StringBuffer str2 = new StringBuffer("abc");
        //String buffer is used for mutable string for multi threaded, it is thread safe
        StringBuilder str3 = new StringBuilder("abc");

        //functions of string are
        str.length();
        str.charAt(3);
        str.substring(2);
        //char at position 5 is not included
        str.substring(2,5);

        String s1 = "abc";
        String s2 = "abc";
        //which means s1 == s2
        String s3 = new String("abc");
        //s1!=s3
        s1.contains(s2);
        s1.equals(s2);
        s1.compareTo(s2);
        //0 same
        //>0 greater
        //<0 smaller
        s1.indexOf(s2);
        //-ve value if it is not present
        //first occurance of the value
        s1.indexOf(s2,1);
        char []strArray = s1.toCharArray();
        //Will check if the word is present from index 1
        //conversion of ascii to string
        String newStr =  Character.toString((char)(23));
    }

    public boolean palindromeNaive(String s){
        StringBuilder str = new StringBuilder(s);
        str.reverse();
        return s.equals(str.toString());
    }

    public boolean palindromeEfficient(String s){
       int begin = 0;
       int end = s.length();
       while(begin<end){
           if(s.charAt(begin)==s.charAt(end)){
               begin++;
               end--;
           }
           else{
               return false;
           }
       }
       return true;
    }

    public boolean checkSubsequence(String s1, String s2){
        int i = 0;
        int j = 0;
       while(i<s1.length() && j<s2.length()){
           if(s1.charAt(i)==s2.charAt(j)){
               i++;
               j++;
           }
           else{
               i++;
           }
       }
       if(j == s2.length()){
           return true;
       }
       else{
           return false;
       }
    }

    public boolean checkanagram(String s1, String s2){
        int count[] = new int[256];
        if(s1.length() != s2.length()){
            return false;
        }
        for(int i = 0; i<s1.length();i++){
            count[s1.charAt(i)]++;
            count[s1.charAt(i)]--;
        }
        for(int i = 0; i<count.length;i++){
            if(count[i]!=0) {
                return false;
            }
        }
        return true;
    }

    public int leftMostRepeating(String s){
        boolean []visited = new boolean[256];
        int res = -1;
        for(int i = s.length()-1;i>=0;i--){
            if(visited[s.charAt(i)]){
                res = i;
            }
            else{
                visited[s.charAt(i)] = false;
            }
        }
        return res;
    }

    public int leftMostNonRepeating(String str){
       int []visited = new int[256];
        Arrays.fill(visited,-1);
        for(int i = 0;i<str.length();i++){
            if(visited[i] == -1){
                visited[str.charAt(i)] = i;
            }
            if(visited[i] != -1) {
                visited[i] = -2;
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0 ; i<256;i++){
            if(visited[i] >= 0){
               res = Math.min(res,visited[i]);
            }
        }
        return res;
    }

    public void reverseString(char []str,int n) {
        int start = 0;
        for (int end = 0; end < str.length; end++) {
            if (str[end] == ' ') {
                reverse(str, start, end - 1);
                start = end + 1;
            }
        }
        reverse(str,0,n-1);
    }

    public void fillLps(String str, int lps[]){
        int i =0 ,len =0;
        int n = str.length();
        while(i<n){
            if(str.charAt(i)==str.charAt(len)){
                ++len;
                lps[i] = len;
                ++len;
            }
            else{
                if(len == 0){
                    lps[i] = 0;
                    i++;
                }
                else{
                    len = lps[len - 1];
                }
            }
        }
    }

    void KMP(String pat, String text){
        int N = pat.length(), M = text.length();
        int lps[] = new int[M];
        fillLps(pat,lps);
        int i = 0, j = 0;
        while(i < N){
            if(pat.charAt(j) == text.charAt(i)){
                i++;
                j++;
            }
            if(j == M){
                System.out.print(i-j+" ");
                j = lps[j-1];
            }
            else if(i < N && pat.charAt(j)!=text.charAt(i)){
                if(j == 0){
                    i++;
                }
                else{
                    j = lps[j-1];
                }
            }
        }
    }

    boolean areRotation(String s1, String s2){
        if(s1.length() != s2.length()){
            return false;
        }
        else{
            return ((s1 + s1).indexOf(s2)>=0);
        }
    }


    public void reverse(char[] str,int start, int end){
        while(start<end){
            swap(str,start,end);
            start++;
            end--;
        }
    }

    public void swap(char arr[], int a, int b){
        char temp = arr[a];
        arr[a] = arr[b];
        arr[b] = arr[a];
    }

    public boolean isAnagram(String txt, String pat){
        int []CT = new int[256];
        int []PT = new int[256];
        for(int i = 0; i< pat.length();i++){
            CT[txt.charAt(i)]++;
            PT[pat.charAt(i)]++;
        }
        for(int i = pat.length();i<txt.length();i++){
            if(isSame(CT,PT)){
                return true;
            }
                CT[txt.charAt(i)]++;
                CT[txt.charAt(i-pat.length())]--;
        }
        return false;
    }

    public boolean isSame(int txt[], int pat[]){
        for(int i = 0; i<txt.length;i++){
            if(pat[i] != txt[i]){
                return false;
            }
        }
        return true;
    }

    public int lexicographicalRank(String str){
        int res = 1;
        int n = str.length();
        int mul = factorial(n);
        int count[] = new int[256];
        for(int i = 0;i<str.length();i++){
            count[str.charAt(i)]++;
        }
        for(int i = 1;i<256;i++){
            count[i] = count[i-1] + 1;
        }
        for(int i = 0; i<str.length();i++){
            mul = mul/(n-i);
            res += mul*count[str.charAt(i)-1];
            for(int j = str.charAt(i);j<256;j++){
                count[j]--;
            }
        }
        return res;
    }

    public int longestDistinctSubstring(String str){
        int n = str.length();
        int []prev = new int[256];
        Arrays.fill(prev,-1);
        int i = 0;
        int res = 0;
        for(int j = 0; j<n;j++){
            i = Math.max(i,prev[str.charAt(j)]+1);
            int maxEnd = j - i + 1;
            res = Math.max(res,maxEnd);
            prev[str.charAt(j)] = j;
        }
      return res;
    }

    int factorial(int n){
        int res = 1;
        for(int i = n;i>=1;i--){
            res *=i;
        }
        return res;
    }


    public static void main(String arg[]){
        StringGFG stringGFG = new StringGFG();
        stringGFG.introduction();
    }


}
