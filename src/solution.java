import java.util.Scanner;

public class solution {

	public int numDecodings(String args[]) {
		Scanner a=new Scanner(System.in);
		String s=a.next();
        return helper(s, 0, new Integer[s.length()]);
    }

    private int helper(String s, int i, Integer[] dp) {
        if (i >= s.length())
            return 1;
        if (s.charAt(i) == '0')
            return 0;
        if (dp[i] != null){
            return dp[i];
      //  System.out.println(dp[i]);
        }
        System.out.println(dp[i]);
        int ways = helper(s, i + 1, dp);
        System.out.println("ways1:"+ways);
        if (i + 2 <= s.length() && Integer.parseInt(s.substring(i, i + 2)) <= 26){
            ways += helper(s, i + 2, dp);
        System.out.println("ways"+ways);}
        return dp[i] = ways;
      // System.out.println(dp[i]);
    }
    
}
