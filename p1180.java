//Problem1180:
//https://acm.sustech.edu.cn/onlinejudge/problem.php?id=1180
import java.util.*;

class hole{

	int data;

	ArrayList<hole> next;

	ArrayList<Double> dist;

	double distance;

	hole(int data){

		this.data=data;

		next=new ArrayList<hole>();

		dist=new ArrayList<Double>();

		distance=Double.MAX_VALUE;

	}

}

public class Main {

	  public static Comparator<hole> disComparator = new Comparator<hole>(){



	        public int compare(hole c1, hole c2) {

	            return (int) (c1.distance - c2.distance);

	        }

	    };



	public static void main(String[] args) {

		// TODO Auto-generated method stub

//		Comparator<hole> order =  new Comparator<hole>(){

//			public int compare(hole o1, hole o2) {

//				double numbera = o1.distance;

//				double numberb = o2.distance;

//				if(numberb > numbera)

//				{

//					return 1;

//				}

//				else if(numberb<numbera)

//				{

//					return -1;

//				}

//				else

//				{

//					return 0;

//				}

//				}

//			};

		Scanner in=new Scanner(System.in);

		int T=in.nextInt();

		while(T-->0) {

			int N=in.nextInt();

			int[] x=new int[N+2];

			int[] y=new int[N+2];

			int[] z=new int[N+2];

			int[] r=new int[N+2];

			for(int i=1;i<=N;i++) {

				x[i]=in.nextInt();

				y[i]=in.nextInt();

				z[i]=in.nextInt();

				r[i]=in.nextInt();

			}

			x[0]=in.nextInt();

			y[0]=in.nextInt();

			z[0]=in.nextInt();

			x[N+1]=in.nextInt();

			y[N+1]=in.nextInt();

			z[N+1]=in.nextInt();

			hole[] points=new hole[N+2];

			for(int i=0;i<N+2;i++) {

				points[i]=new hole(i);

			}

			for(int i=0;i<N+2;i++) {				

				for(int j=0;j<N+2;j++) {

					if(j!=i) {

						points[i].next.add(points[j]);

						double distance=Math.sqrt(Math.pow(x[i]-x[j],2)+Math.pow(y[i]-y[j],2)+Math.pow(z[i]-z[j],2))-r[i]-r[j];

						if(distance>0) {

							points[i].dist.add(distance);

						}

						else {

							points[i].dist.add((double) 0);

						}

						

					}

				} 				

			}

			points[0].distance=0;

			Queue<hole> pq=new PriorityQueue<hole>(99,disComparator);		

			for(int i=0;i<N+2;i++) {

				pq.add(points[i]);

			}			

			while(!pq.isEmpty()) {

				hole p=pq.poll();

				for(int i=0;i<N+1;i++) {

					if(p.next.get(i).distance>p.distance+p.dist.get(i)) {

						p.next.get(i).distance=p.distance+p.dist.get(i);

						if(pq.remove(p.next.get(i))) {

    						pq.add(p.next.get(i));

    					}

					}

				}

			}

			System.out.println(Math.round(points[N+1].distance*100));

			

		}



	}



}
