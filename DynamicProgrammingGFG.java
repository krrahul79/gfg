import java.util.Arrays;

public class DynamicProgrammingGFG {

    public static int memo[];

    public int fibanocci(int n){
        memo = new int[n+1];
        Arrays.fill(memo,-1);
        int res = -1;
        if(memo[n] == -1){
            if(n == 0||n ==1){
                res = n;
            }
            else{
                res = fibanocci(n-1) + fibanocci(n-2);
            }
            memo[n] = res;
        }
        return memo[n];
    }

    public int fibtabulation(int n ){
        int fib[] = new int[n+1];
        fib[0] = 0;
        fib[1] = 1;
        for(int i = 2 ;i<=n;i++){
            fib[i] = fib[i-1] + fib[i-2];
        }
        return fib[n];
    }
}
