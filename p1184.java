//Problem1184:
// https://acm.sustech.edu.cn/onlinejudge/problem.php?id=1184
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {

		Scanner in=new Scanner(System.in);

		int T=in.nextInt();

		while(T-->0) {

			int n=in.nextInt();

			int big=0;

			for(int i=0;i<n;i++) {

				int a=in.nextInt();

				if(a>big) {

					big=a;

				}

			}

			System.out.println(big);			

		}

	}

}
