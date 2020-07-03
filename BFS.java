import java.util.*;

public class BFS
{       static int storeQueue[]=new int[100];
        static int pos=0;
        static int pop=0;
        static void addToList(int m,int n,int adj[][])
        {
                adj[m][n]=1;
                adj[n][m]=1;
        }
        static void print(int adj[][],int n)
        {
                for(int i=0;i<n;i++)
                {
                        for(int j=0;j<n;j++)
                                System.out.print(adj[i][j]+"\t");
                        System.out.println("\n");
                }
        }
        static void bfs(int adj[][],int marked[],int v,int n)
        {
                marked[v]=1;
                int y;
                storeQueue[pos]=v;
                pos++;
                System.out.println("BFS Order : ");
                System.out.print((v+1)+"\t");
                while(pos!=pop)
                {
                        y=storeQueue[pop];
                        marked[y]=1;
                        pop++;
                        for(int i=0;i<n;i++)
                        {
                                if(adj[y][i]==1 && marked[i]==0)
                                {
                                        storeQueue[pos]=i;
                                        pos++;
                                        System.out.print((i+1)+"\t");
                                        marked[i]=1;                  
                                }

                        }
                }
                System.out.println();
                // for(int i=0;i<n;i++)
                        // System.out.print(marked[i]+"\t");


        }
        public static void main(String args[])
        {       Scanner sc = new Scanner(System.in);
                int n,e,v1,v2;
                System.out.println("Enter the number of vertices");
                n=sc.nextInt();
                int[][] adj=new int[n][n];
                int marked[]=new int[n];
                System.out.println("Enter the number of edges");
                e=sc.nextInt();
                for(int i=0;i<e;i++)
                {       System.out.println("Enter the vertices for edge "+(i+1));
                        v1=sc.nextInt();
                        v2=sc.nextInt();
                        addToList(v1-1,v2-1,adj);
                }
                // print(adj,n);
                System.out.println("Enter the starting vertex");
                v1=sc.nextInt();
                bfs(adj,marked,v1-1,n);
                sc.close();
        }
}
