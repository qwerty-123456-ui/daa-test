import java.util.Scanner;
public class DFS
{
    static int storeStack[] = new int[100];
    static int pos=0;
    static int pop=0;
    static void addToList(int m,int n,int adj[][])
    {
        adj[m][n] =1;
        adj[n][m]=1;

    }
    static void print(int adj[][], int n)
    {
        for (int i=0;i<n;i++)
        {
            for (int j=0;j<n;j++)
                System.out.println(adj[i][j]+"\t");
            System.out.println("\n");
        }
    }
    static void dfs(int adj[][],int marked[],int v, int n)
    {
        marked[v]=1;
        storeStack[pos]=v+1;
        pos++;
        for (int u=0;u<n;u++)
        {
            if (adj[u][v] == 1)
            {
                if (marked[u] == 0 )
                {
                    dfs(adj,marked,u,n);
                }
            }
        }
    }

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n,e,v1,v2;
        System.out.println("Enter the number of vertices : ");
        n=sc.nextInt();
        int[][] adj=new int[n][n];
        int marked[]=new int[n];
        System.out.println("Enter the number of edges: ");
        e=sc.nextInt();
        for (int i=0;i<e;i++)
        {
            System.out.println("Enter the vertices for edge "+(i+1));
            v1=sc.nextInt();
            v2=sc.nextInt();
            addToList(v1-1, v2-1, adj);
        }
        // print(adj,n);
        System.out.println("Enter the starting vertex : ");
        v1=sc.nextInt();
        dfs(adj, marked, v1-1, n);
        sc.close();

        System.out.println("DFS Order is :");
        for (int i=0;i<n;i++)
        {
            System.out.println(storeStack[i]+"\t");
        }
    }
}