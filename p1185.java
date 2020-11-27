//Problem1185:
//https://acm.sustech.edu.cn/onlinejudge/problem.php?id=1185
import java.io.*;

import java.util.*;

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

            	int T=in.nextInt();

        		while(T-->0) {

        			int n=in.nextInt();

        			int k=in.nextInt();

        			int[] a=new int[n];

        			for(int i=0;i<n;i++) {

        				a[i]=in.nextInt();

        			}

        			Arrays.sort(a);

        			out.println(a[k-1]);

        		

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
