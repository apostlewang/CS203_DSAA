//Problem1178:
//https://acm.sustech.edu.cn/onlinejudge/problem.php?id=1178
import java.util.*;

class edge implements Comparable<edge>{

	int x;

	int y;

	int w;

	

	edge(int x,int y,int w){

		this.x=x;

		this.y=y;

		this.w=w;

	}

    public int compareTo(edge compareEdge) 

    { 

        return this.w-compareEdge.w; 

    } 

};

public class Main {

	public static void main(String[] args) {

		// TODO Auto-generated method stub

		Scanner in=new Scanner(System.in);

		int T=in.nextInt();

		while(T-->0) {

			int N=in.nextInt();

			int M=in.nextInt();

			edge[] ed=new edge[M];

			for(int i=0;i<=M-1;i++) {

				int x=in.nextInt();

				int y=in.nextInt();

				int w=in.nextInt();

				ed[i]=new edge(x,y,w);

			}			

			Arrays.sort(ed);

			int cost=0;

			int k=0;

			for(;k<=M-N;k++) {

				cost=0;

				int count=0;

				int i=M-N-k+1;

				int[] mark=new int[N+1];

				for(int j=1;j<=N;j++) {

					mark[j]=j-1;

				}

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

					if(i==M) {

						break;

					}

				}

				if(count==N-1) {

					break;

				}

			}

			int maxmin=ed[M-N-k+1].w;

			int minindex=M-N-k+1;

			while(ed[minindex].w==maxmin) {

				minindex--;

			}

			minindex++;

			int count=0;

			cost=0;

			int[] mark=new int[N+1];

			for(int j=1;j<=N;j++) {

				mark[j]=j-1;

			}

			while(count<N-1) {

				edge p=ed[minindex];

				minindex++;

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
