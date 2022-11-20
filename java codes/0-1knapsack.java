public class Knapsack {
	public static int max(int a, int b) {
		if(a>b) {
			return a;
		}
		else {
			return b;
		}
	}

	public static void main(String[] args) {
		int capacity=10;
		int items=4;
		int price[]= {0,3,7,2,9};
		int weight[]={0,2,2,3,5};
		
		int dp[][]=new int[items+1][capacity+1];
		
		for (int i = 0; i <=items; i++) {
			for (int j = 0; j <= capacity; j++) {
				if(i==0 || j==0) {
					dp[i][j]=0;
				}
				else if(weight[i]<=j) {
					dp[i][j]=max(dp[i-1][j], price[i]+dp[i][j-weight[i]]);
				}
				else {
					dp[i][j]=dp[i-1][j];
				}
			}
		}
		System.out.println(dp[items][capacity]);
		
	}

}
