//Problem1187:
//https://acm.sustech.edu.cn/onlinejudge/problem.php?id=1187
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// TODO Auto-generated method stub

		Scanner in=new Scanner(System.in);

    	int t=in.nextInt();

    	while(t-->0) {

    		int n=in.nextInt();

    		int[]a=new int[n];

    		for(int i=0;i<n;i++) {

    			a[i]=in.nextInt();

    		}

    		int i=0;

    		for(;i<n-1;i++) {

    			if(a[i]>a[i+1]) {

    				break;

    			}

    		}

    		int big=a[i];

    		int count=0;

    		for(;i<n;i++) {

    			if(a[i]<big) {

    				count++;

    			}

    		}

    		

    		if(count==mergeSort(a)) {

    			System.out.println("Y");

    		}

    		else {

    			System.out.println("N");

    		}

    		

    	

    	

    	}



	}

	static int mergeSort(int a[]) {

		if(a.length<=1) {

			return 0;

		}

		int count=0;

		int n=a.length;

		int b[]=new int[n/2];

		System.arraycopy(a, 0, b, 0, n/2);

		int c[]=new int[n-n/2];

		System.arraycopy(a, n/2, c, 0, n-n/2);

		count=mergeSort(b)+count;

		count=mergeSort(c)+count;

		count=merge(b,c,a)+count;

		return count;

	}

	static int merge(int[]b,int c[],int a[]) {

		int count=0;

		int i=0,j=0,k=0;

		while(i<b.length&&j<c.length) {

			if(b[i]<=c[j]) {

				a[k]=b[i];

				i++;

			}

			else {

				a[k]=c[j];

				j++;

				count=count+b.length-i;//b这个数列中所剩的元素个数

			}

			k++;

		}

		if(i==b.length) {

			for(;j<c.length;j++,k++) {

				a[k]=c[j];

			}

		}

		else if(j==c.length){

			for(;i<b.length;i++,k++) {

				a[k]=b[i];

			}

		}	

		return count;	

	}

}
