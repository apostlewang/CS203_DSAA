//Problem1175:
//https://acm.sustech.edu.cn/onlinejudge/problem.php?id=1175
import java.io.*;

import java.util.StringTokenizer;

class Stack{

	int size;

	int a[];

	int top=-1;

	Stack(int n) {

		size=n;

		a=new int[size];

	}

	void pop ( ) {

		if(top>=0) {

			top--;

		}

	}

	void push (int n) {

		if(top<size-1) {

			top++;

			a[top]=n;			

		}		

	}

	int top() {

		return a[top];

	}

	boolean isEmpty() {

		if(top==-1) {

			return true;

		}

		else {

			return false;

		}

	}

	boolean inStack(int n) {

		boolean in=false;

		for(int i=0;i<=top;i++) {

			if(a[i]==n) {

				in=true;

			}

		}

		return in;

	}

}

public class Main {

	public static void main(String[] args){

        InputStream inputStream = System.in;

        OutputStream outputStream = System.out;

        InputReader in = new InputReader(inputStream);

        PrintWriter out = new PrintWriter(outputStream);

        Task solver = new Task();

        solver.solve(in, out);

        out.close();

    }

    static class Task {

        public void solve(InputReader in, PrintWriter out) {

            while (in.hasNext()) {         	

            	int t=in.nextInt();

        		while(t-->0) {

        			int n=in.nextInt();

        			int array[]=new int[n];

        			for(int i=0;i<n;i++) {

        				array[i]=in.nextInt();

        			}

        			Stack slot=new Stack(n);

        			int disnum=0;

        			int[] discard=new int[n];

        			int index=0;      			

        			int[] min=new int[n+1];

        			min[n]=2000000000;

        			min[n-1]=array[n-1];

        			for(int i=0;i<n-1;i++) {      				

        				if(array[n-i-2]<min[n-i-1]) {

        					min[n-i-2]=array[n-i-2];

        				}

        				else {

        					min[n-i-2]=min[n-i-1];

        				}

        			}

        			while(disnum<n)	{         				

        				if(slot.isEmpty()) {

        					slot.push(array[index]);

        					index++;

        				}        				

        				else {

        					if(slot.top()>min[index]) {

            					slot.push(array[index]);

            					index++;

            				}

            				else {

            					discard[disnum]=slot.top();

            					disnum++;

            					slot.pop();

            				}

        				}      				

        			}      			

        			for(int i=0;i<n;i++) {

        				out.print(discard[i]+" ");

        			}

        			out.println();		

        		}             

            }

        }

        

    }



    static class InputReader {

        public BufferedReader reader;

        public StringTokenizer tokenizer;



        public InputReader(InputStream stream) {

            reader = new BufferedReader(new InputStreamReader(stream), 32768);

            tokenizer = null;

        }



        public String next() {

            while (tokenizer == null || !tokenizer.hasMoreTokens()) {

                try {

                    tokenizer = new StringTokenizer(reader.readLine());

                } catch (IOException e) {

                    throw new RuntimeException(e);

                }

            }

            return tokenizer.nextToken();

        }



        public int nextInt() {

            return Integer.parseInt(next());

        }



        public boolean hasNext() {

            try {

                String string = reader.readLine();

                if (string == null) {

                    return false;

                }

                tokenizer = new StringTokenizer(string);

                return tokenizer.hasMoreTokens();

            } catch(IOException e) {

                return false;

            }

        } 

    }

}
