//Problem1179:
//https://acm.sustech.edu.cn/onlinejudge/problem.php?id=1179
import java.io.*;

import java.util.*;

class vertex{

	int data;

	int distance;

	ArrayList<vertex> next;

	ArrayList<Integer> weight;

	vertex(int data){

		this.data=data;

		next=new ArrayList<vertex>();

		weight=new ArrayList<Integer>();

		distance=Integer.MAX_VALUE;

	}

}

public class Main {

	  public static Comparator<vertex> disComparator = new Comparator<vertex>(){



	        public int compare(vertex c1, vertex c2) {

	            return (int) (c1.distance - c2.distance);

	        }

	    };



	public static void main(String[] args) throws IOException {

		// TODO Auto-generated method stub

		Reader in=new Reader( );

		int T=in.nextInt();

    	while(T-->0) {

    		int n=in.nextInt();

    		int m=in.nextInt();

    		int k=in.nextInt();

    		vertex[] v=new vertex[n+1];

    		for(int i=1;i<=n;i++) {

    			v[i]=new vertex(i);

    		}

    		for(int i=1;i<=m;i++) {

    			int ui=in.nextInt();

    			int vi=in.nextInt();

    			int wi=in.nextInt();

    			v[ui].next.add(v[vi]);

    			v[ui].weight.add(wi);

    			v[vi].next.add(v[ui]);

    			v[vi].weight.add(wi);

    		}

    		int[] mustgo=new int[k+1];

    		for(int i=1;i<=k;i++) {

    			mustgo[i]=in.nextInt();

    		} 

    		int[][] dist=new int[k+1][n+1];

    		Queue<vertex> pq=new PriorityQueue<vertex>(99,disComparator);

    		for(int i=1;i<=k;i++) {

    			v[mustgo[i]].distance=0;

    			for(int j=1;j<=n;j++) {

        			pq.add(v[j]);

        		}

    			while(!pq.isEmpty()) {

        			vertex p=pq.poll();

        			for(int j=0;j<p.next.size();j++) {

        				if(p.next.get(j).distance>p.distance+p.weight.get(j)) {

        					p.next.get(j).distance=p.distance+p.weight.get(j);

        					if(pq.remove(p.next.get(j))) {

        						pq.add(p.next.get(j));

        					}

        				}      

        			}         			

        		}

    			for(int j=1;j<=n;j++) {

    				dist[i][j]=v[j].distance;

    				v[j].distance=Integer.MAX_VALUE;

    			}

    			    			

    		}

    		int mindist=Integer.MAX_VALUE;

    		if(k==1) {

    			mindist=dist[1][1]+dist[1][n];

    		}

    		if(k==2) {

    			mindist=Math.max(dist[1][1]+dist[1][mustgo[2]]+dist[2][n],dist[2][1]+dist[2][mustgo[1]]+dist[1][n]);

    		}

    		if(k==3) {

    			for(int i1=1;i1<=3;i1++) {

    				for(int i2=1;i2<=3;i2++) {

        				if(i2!=i1) {

        					for(int i3=1;i3<=3;i3++) {

        						if(i3!=i2&&i3!=i1) {

        							int temp=dist[i1][1]+dist[i1][mustgo[i2]]+dist[i2][mustgo[i3]]+dist[i3][n];

        							if(temp<mindist) {

        								mindist=temp;

        							}

        						}

        					}

        				}

        			}

    			}

    		}

    		if(k==4) {

    			for(int i1=1;i1<=4;i1++) {

    				for(int i2=1;i2<=4;i2++) {

        				if(i2!=i1) {

        					for(int i3=1;i3<=4;i3++) {

        						if(i3!=i2&&i3!=i1) {

        							for(int i4=1;i4<=4;i4++) {

        								if(i4!=i2&&i4!=i3&&i4!=i1) {

        							           int temp=dist[i1][1]+dist[i1][mustgo[i2]]+dist[i2][mustgo[i3]]+dist[i3][mustgo[i4]]+dist[i4][n];

                							if(temp<mindist) {

                								mindist=temp;

                							}

        								}
                        
        							}					

        						}

        					}

        				}

        			}

    			}

    		}

    		if(k==5) {

    			for(int i1=1;i1<=5;i1++) {

    				for(int i2=1;i2<=5;i2++) {

        				if(i2!=i1) {

        					for(int i3=1;i3<=5;i3++) {

        						if(i3!=i2&&i3!=i1) {

        							for(int i4=1;i4<=5;i4++) {

        								if(i4!=i2&&i4!=i3&&i4!=i1) {

        									for(int i5=1;i5<=5;i5++) {

        										if(i5!=i4&&i5!=i3&&i5!=i2&&i5!=i1) {

        									int temp=dist[i1][1]+dist[i1][mustgo[i2]]+dist[i2][mustgo[i3]]+dist[i3][mustgo[i4]]+dist[i4][mustgo[i5]]+dist[i5][n];

                        							if(temp<mindist) {

                        								mindist=temp;

                        							}

        										}

        									}

        								

        								}

        							

        							}

        						

        						}

        					}

        				}

        			}

    			}

    		}

    		System.out.println(mindist);

    		

    	

    	}



	}

	static class Reader

    {

        final private int BUFFER_SIZE = 1 << 16;

        private DataInputStream din;

        private byte[] buffer;

        private int bufferPointer, bytesRead;

 

        public Reader()

        {

            din = new DataInputStream(System.in);

            buffer = new byte[BUFFER_SIZE];

            bufferPointer = bytesRead = 0;

        }

 

        public Reader(String file_name) throws IOException

        {

            din = new DataInputStream(new FileInputStream(file_name));

            buffer = new byte[BUFFER_SIZE];

            bufferPointer = bytesRead = 0;

        }

 

        public String readLine() throws IOException

        {

            byte[] buf = new byte[64]; // line length

            int cnt = 0, c;

            while ((c = read()) != -1)

            {

                if (c == '\n')

                    break;

                buf[cnt++] = (byte) c;

            }

            return new String(buf, 0, cnt);

        }

 

        public int nextInt() throws IOException

        {

            int ret = 0;

            byte c = read();

            while (c <= ' ')

                c = read();

            boolean neg = (c == '-');

            if (neg)

                c = read();

            do

            {

                ret = ret * 10 + c - '0';

            }  while ((c = read()) >= '0' && c <= '9');

 

            if (neg)

                return -ret;

            return ret;

        }

 

        public long nextLong() throws IOException

        {

            long ret = 0;

            byte c = read();

            while (c <= ' ')

                c = read();

            boolean neg = (c == '-');

            if (neg)

                c = read();

            do {

                ret = ret * 10 + c - '0';

            }

            while ((c = read()) >= '0' && c <= '9');

            if (neg)

                return -ret;

            return ret;

        }

 

        public double nextDouble() throws IOException

        {

            double ret = 0, div = 1;

            byte c = read();

            while (c <= ' ')

                c = read();

            boolean neg = (c == '-');

            if (neg)

                c = read();

 

            do {

                ret = ret * 10 + c - '0';

            }

            while ((c = read()) >= '0' && c <= '9');

 

            if (c == '.')

            {

                while ((c = read()) >= '0' && c <= '9')

                {

                    ret += (c - '0') / (div *= 10);

                }

            }

 

            if (neg)

                return -ret;

            return ret;

        }

 

        private void fillBuffer() throws IOException

        {

            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);

            if (bytesRead == -1)

                buffer[0] = -1;

        }

 

        private byte read() throws IOException

        {

            if (bufferPointer == bytesRead)

                fillBuffer();

            return buffer[bufferPointer++];

        }

 

        public void close() throws IOException

        {

            if (din == null)

                return;

            din.close();

        }

    }





}
