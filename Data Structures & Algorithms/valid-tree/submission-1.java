class Solution {
    public boolean validTree(int n,int[][] edges){
        if(edges.length!=n-1) return false;
        ArrayList<Integer>[] graph=new ArrayList[n];
        for(int i=0;i<n;i++) graph[i]=new ArrayList<>();
        for(int[] e:edges){
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        boolean[] visited=new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                if(hasCycle(graph,i,-1,visited)) return false;
            }
        }
        return true;
    }

    public boolean hasCycle(ArrayList<Integer>[] graph,int src,int parent,boolean[] visited){
        visited[src]=true;
        for(int nbr:graph[src]){
            if(!visited[nbr]){
                if(hasCycle(graph,nbr,src,visited)) return true;
            }
            else if(nbr!=parent){
                return true;
            }
        }
        return false;
    }
}