//Problem1176:
//https://acm.sustech.edu.cn/onlinejudge/problem.php?id=1176
import java.util.*;

public class Main {

	public static void main(String[] args) {

		// TODO Auto-generated method stub

		Scanner in=new Scanner(System.in);

		int T=in.nextInt();

    	while(T-->0) {

    		int n=in.nextInt();

    		int[] x=new int[n+1];

    		int[] y=new int[n+1];

    		for(int i=1;i<=n;i++) {

    			x[i]=in.nextInt();

    			y[i]=in.nextInt();

    		}

    		int q=in.nextInt();

    		for(int i=1;i<=q;i++) {

    			int a=in.nextInt();

    			int b=in.nextInt();

    			int dis=Math.abs(x[a]-x[b])+Math.abs(y[a]-y[b]);

    			System.out.println(dis);

    		}

    	}

	}

}
