import java.util.Scanner;

public class Solution {

	public static int knapsack(int[] weight,int value[],int n,int maxWeight){
		// int n = weight.length;
		int[][] storage = new int[n+1][maxWeight+1];

		for(int i=1;i<=n;i++) {
			for(int j=1;j<=maxWeight;j++) {
				if( weight[i-1] > j) {
					storage[i][j] = storage[i-1][j];
				}
				else {
					storage[i][j] = Math.max( storage[i-1][j], storage[i-1][ j - weight[i-1] ] + value[i-1] );
				}
			}
		}
		return storage[n][maxWeight];

	}
	
	
	public static int knapsackBetter(int[] weight,int value[],int n, int maxWeight){
		// int n = weight.length;
		
		int[] storagePrev = new int[maxWeight+1];
		int[] storageCurr = new int[maxWeight+1];
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=maxWeight;j++) {
				if(weight[i-1] > j) {
					storageCurr[j] = storagePrev[j];
				}
				else {
					storageCurr[j] = Math.max( storagePrev[j] , storagePrev[j-weight[i-1]] + value[i-1] );
				}
			}
			storagePrev = storageCurr;
			storageCurr = new int[maxWeight+1];
		}
		return storagePrev[maxWeight];

	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int weight[] = new int[n];
		for(int i = 0 ; i < n; i++){
			weight[i] = s.nextInt();
		}
		int value[] = new int[n];
		for(int i = 0 ; i < n; i++){
			value[i] = s.nextInt();
		}
		int maxWeight = s.nextInt();
		System.out.println(knapsack(weight, value, maxWeight,n));

	}

}
