import java.util.*;
class node
{
    int vertex;
    node link;
}
public class depthFirstSearch
{
        static int visited[]=new int[20];
        static node g[]=new node[20];
        static int n;
        static Scanner in=new Scanner(System.in);
        static void insert(int vi,int vj)
        {
                node temp,trav;
                temp=new node();
                temp.vertex=vj;
                temp.link=null;
                if(g[vi]==null)
                {
                        g[vi]=temp;
                }
                else
                {
                        for(trav=g[vi];trav.link!=null;trav=trav.link);
                        trav.link=temp;
                }
        }
        static void creategraph()
        {
                int i,vi,vj,n;
                System.out.println(" Enter number of vertices: ");
                n=in.nextInt();
                for(i=0;i<n;i++)
                {
                        g[i]=null;
                }
                System.out.println(" Enter Number of edges: ");
                n=in.nextInt();
                for(i=0;i<n;i++)
                {
                        System.out.println(" Enter an edge(a,b): ");
                        vi=in.nextInt();
                        vj=in.nextInt();
                        insert(vi,vj);
                }
        }
        static void dfs(int v)
        {
                node t;
                visited[v]=1;
                System.out.println(v);
                for(t=g[v];t!=null;t=t.link)
               {
                    if(visited[t.vertex]==0)
                    {
                        dfs(t.vertex);
                    }
                }
        }
        public static void main(String args[])
        {
                int i;
                for(i=0;i<20;i++)
                {
                        visited[i]=0;
                }
                creategraph();
                System.out.println("Enter source vertex: ");
                int source=in.nextInt();
                System.out.println("Nodes visited in DFS order are: ");
                dfs(source);
                System.out.println();
        }

}