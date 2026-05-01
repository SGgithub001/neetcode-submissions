class Solution{
    public int countComponents(int n,int[][] edges){
        ArrayList<Integer>[] graph=new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }
        for(int[] e:edges){
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        boolean[] visited=new boolean[n];
        int count=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(graph,i,visited);
                count++;
            }
        }

        return count;
    }

    public void dfs(ArrayList<Integer>[] graph,int src,boolean[] visited){
        visited[src]=true;
        for(int nbr:graph[src]){
            if(!visited[nbr]){
                dfs(graph,nbr,visited);
            }
        }
    }
}