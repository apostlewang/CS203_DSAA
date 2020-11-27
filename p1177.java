//Problem1177:
//https://acm.sustech.edu.cn/onlinejudge/problem.php?id=1181
import java.util.*;

class edge{

	int x;

	int y;

	int w;

	edge(int x,int y,int w){

		this.x=x;

		this.y=y;

		this.w=w;

	}

}

//class vertex{

//	int data;

//	ArrayList<vertex> son;

//	int father;

//	vertex(int data){

//		this.data=data;

//		father=data;

//	}

//}

public class Main {   

//	public static int zhaobaba(int[] father,int x) {

//		int baba=x;

//		while(father[baba]!=baba) {

//			baba=father[baba];

//		}

//		return baba;

//	}





	public static void main(String[] args) {

		// TODO Auto-generated method stub

		Scanner in=new Scanner(System.in);

		int T=in.nextInt();

		while(T-->0) {

			int N=in.nextInt();

			int M=in.nextInt();

			edge[] ed=new edge[M+1];

			for(int i=1;i<=M;i++) {

				

				int x=in.nextInt();

				int y=in.nextInt();

				int w=in.nextInt();

				

				ed[i]=new edge(x,y,w);

			}			

			int cost=0;

			int count=0;

			int[] mark=new int[N+1];

			for(int i=1;i<=N;i++) {

				mark[i]=i-1;

			}

//			vertex[] v=new vertex[N+1];

//			for(int i=1;i<=N;i++) {

//				v[i]=new vertex(i);

//			}

			for(int i=1;i<=M-1;i++) {

				for(int j=1;j<=M-i;j++) {

					if(ed[j].w>ed[j+1].w) {

						edge temp=ed[j];

						ed[j]=ed[j+1];

						ed[j+1]=temp;

					}

				}

			}

					

			int i=1;



			while(count<N-1) {

				edge p=ed[i];

				i++;

				if(mark[p.x]!=mark[p.y]) {	

					int max=Math.max(mark[p.x],mark[p.y]);

					int min=Math.min(mark[p.x],mark[p.y]);

					for(int j=1;j<=N;j++) {

						if(mark[j]==max) {

							mark[j]=min;

						}

					}

					cost=cost+p.w;

					count++;

				}							

			}

			System.out.println(cost);	

		}



	}



}
