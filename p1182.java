//Problem1182:
//https://acm.sustech.edu.cn/onlinejudge/problem.php?id=1182
import java.util.*;

class cun{

	ArrayList<cun> next;

	int data;

	cun(int data){

		this.data=data;

		next=new ArrayList<cun>();

	}

}

public class Main {

	public static void main(String[] args) {

		Scanner in=new Scanner(System.in);

		int T=in.nextInt();

		while(T-->0) {

			int N=in.nextInt();

			int[] point=new int[N+1];

			int[] type=new int[N+1];

			cun[] node=new cun[N+1];

			Queue<Integer> set=new LinkedList<Integer>();

			for(int i=1;i<=N;i++) {

				node[i]=new cun(i);

			}

			for(int i=1;i<=N;i++) {

				int pointto=in.nextInt();

				point[i]=pointto;

				if(in.next().equals("werewolf")) {

					type[i]=1;

				}

				else {

					type[i]=2;

					node[pointto].next.add(node[i]);

				}

				set.add(i);

			}

			//开始做DFS找到所有环

			int[] visit=new int[N+1];

			int count=0;

			int[] pushtime=new int[N+1];

			int[] pulltime=new int[N+1];

			Stack<Integer> stack = new Stack<>();

			while(!set.isEmpty()) {				

				int p=set.poll();

				if(visit[p]!=1) {

					visit[p]=1;					

					stack.push(p);

					count++;

					pushtime[p]=count;

					while(visit[point[stack.peek()]]!=1) {

						visit[point[stack.peek()]]=1;

						stack.push(point[stack.peek()]);						

						count++;

						pushtime[stack.peek()]=count;

					}

					while(!stack.isEmpty()) {

						count++;

						pulltime[stack.pop()]=count;

					}					

				}

			}

			//然后对所有边进行check,找出逆边

			//注意有可能狼人自爆

			Queue<Integer> nibian=new LinkedList<Integer>();

			for(int i=1;i<=N;i++) {

				if(pushtime[i]>=pushtime[point[i]]&&pulltime[i]<=pulltime[point[i]]) {

					nibian.add(i);

				}

			}

			int wolf=0;

			Queue<Integer> wolfs=new LinkedList<Integer>();

			while(!nibian.isEmpty()) {

				int p=nibian.poll();

				int now=p;

				int wolfedge=0;

				int zhixiangwolf=0;

				while(point[now]!=p) {

					if(type[now]==1) {

						wolfedge++;

						zhixiangwolf=now;

					}				

					now=point[now];

				}

				if(type[now]==1) {

					wolfedge++;

					zhixiangwolf=now;

				}

				if(wolfedge==1) {

					wolf++;

					int wolfindex=point[zhixiangwolf];

					wolfs.add(wolfindex);

					//找到了所有铁定是狼的点

//					for(int i=1;i<=N;i++) {

//						if(point[i]==wolfindex&&type[i]==2) {

//							wolf++;

//							

//					}

//					}

				}

			}

			Queue<Integer> queue=new LinkedList<Integer>();

			while(!wolfs.isEmpty()) {

				int p=wolfs.poll();

				queue.add(p);

				while(!queue.isEmpty()) {

					int q=queue.poll();

					for(int i=0;i<node[q].next.size();i++) {

						queue.add(node[q].next.get(i).data);

						wolf++;

					}
				}				

			}

			System.out.println(wolf);										

		}



	}



}
