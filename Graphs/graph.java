import java.lang.reflect.AnnotatedArrayType;
import java.util.*;
import java.util.function.IntBinaryOperator;

public class graph {
    int v;

   public  ArrayList<edge> graph[];
   public class edge{
        int src ;
        int dest;

        int weight;
        public edge(int src, int dest, int weight){
            this.src = src;
            this.dest= dest;
            this.weight = weight;
        }
    }

    public void bfs(int i, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(i);
        visited[i] = true;

        while (!queue.isEmpty()) {
            int polled = queue.poll();
            System.out.print(polled + " ");

            for (edge e : graph[polled]) {
                int dest = e.dest;
                if (!visited[dest]) {
                    visited[dest] = true;
                    queue.add(dest);
                }
            }
        }
    }

    public void bfs_disconnected(){
        boolean[] visited = new boolean[this.v];
        for(int i=0;i<v;i++){
            if(!visited[i]){

              bfs(i,visited);

            }
        }
    }
    public void dfs_disconnected(){
        boolean[] visited = new boolean[v];
        for(int i=0;i<v;i++){
            if(!visited[i]){
                dfs(visited);
            }
        }


    }
    public void allpaths(int target) {
        boolean[] visited = new boolean[v];
        ArrayList<Integer> path = new ArrayList<>();

        // Start DFS from node 0
        paths(0, target, visited, path);
    }

    public void paths(int curr, int target, boolean visited[], ArrayList<Integer> path) {
        visited[curr] = true;
        path.add(curr);

        if (curr == target) {
            System.out.println(path); // Found a path to the target
        } else {
            for (int i = 0; i < graph[curr].size(); i++) {
                int next = graph[curr].get(i).dest;
                if (!visited[next]) {
                    paths(next, target, visited, path);
                }
            }
        }

        // Backtrack: remove the current node from the path and mark it unvisited
        path.remove(path.size() - 1);
        visited[curr] = false;
    }


    public void dfs(boolean[] visited){


       dfs1(0,visited);

    }
    public void dfs1(int curr, boolean[] visited){

       visited[curr]= true;
        System.out.print(curr+ " ");
       for(int i=0;i<graph[curr].size();i++){
           if(visited[graph[curr].get(i).dest]==false){
               dfs1(graph[curr].get(i).dest,visited);
           }
       }
    }

    // Cycle detection in undirected graph

    public boolean cycledetection_disconnected(){
        boolean visited[] = new boolean[v];

       for(int i=0;i<v;i++){
           if(!visited[i]){
               boolean ans = cycledetection(0,visited);
             if(ans){
                 return true;
             }
           }
       }
       return false;
    }

    public boolean cycledetection(int curr, boolean[] visited){

        boolean recur_stack[] = new boolean[v];
       return cycle(curr,visited,recur_stack);
    }
    public boolean cycle(int curr, boolean visited[], boolean[] recur_stack){
       visited[curr] = true;
       recur_stack[curr] = true;
       for(int i=0;i<graph[curr].size();i++){
           int next = graph[curr].get(i).dest;
           if(recur_stack[next]==true){
               return true;
           }else{
               if(visited[next]!=true){
                   return  cycle(next,visited,recur_stack);
               }
           }
       }
       recur_stack[curr] = false;
       return false;
    }

    // Topological Sorting

    public ArrayList<Integer> topologicalsort(){
       ArrayList<Integer> ans = new ArrayList();
       Stack<Integer> st = new Stack();
       boolean visited[] = new boolean[v];
       for(int i=0;i<v;i++){
           if(!visited[i]){
               sort(visited,st,i);
           }
       }
       while(!st.isEmpty()){
           ans.add(st.pop());
       }
       return ans;

    }

    public void sort(boolean visited[], Stack st, int curr){
       visited[curr] = true;
       for(int i=0;i<graph[curr].size();i++){
           int next = graph[curr].get(i).dest;
           if(!visited[next]){
               sort(visited,st,next);
           }
       }
       st.push(curr);

    }

    //Cycle detection in undirected graph

    public boolean cycledetect_undirected(){
       boolean visited[] = new boolean[v];
//       for(int i=0;i<v;i++){
//           if(!visited[i]){
//               boolean ans = cycle(visited,0,-1);
//               if(ans){
//                   return true;
//               }
//           }
//       }
//       return false;
        return cycle(visited,0,-1);

    }

    public boolean cycle(boolean[] visited, int curr, int parent){
       visited[curr] = true;

       for(int i=0;i<graph[curr].size();i++){
           int next = graph[curr].get(i).dest;
           if(!visited[next]){
               if(cycle(visited,next,curr)) {
                   return true;
               }
           }else if(visited[next] && next!=parent){

                   return true;

           }

       }
       return false;
    }



    //Dijskras Algorithm Time complexity O(V + ElogV)

    public int[]  dijsktra(int start){
       boolean visited[] = new boolean[v];
       int[] dist = new int[v];
       Arrays.fill(dist,Integer.MAX_VALUE);
       dist[start] = 0;
       PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->dist[a]-dist[b]);
       queue.add(start);
       while(!queue.isEmpty()){
           int first = queue.poll();


           visited[first] = true;


           for(int i=0;i<graph[first].size();i++){
               int next = graph[first].get(i).dest;
               if(!visited[next]) {
                   if (dist[first] + graph[first].get(i).weight < dist[next]) {
                       dist[next] = dist[first] + graph[first].get(i).weight;


                   }
                   queue.add(next);

               }
           }
       }
       return dist;

    }


    //Bellman Ford Algorithm Time Complexity O(V*E)

    public int[] bellmanford(int start){
       int[] dist = new int[v];
       for(int i=0;i<dist.length;i++){
           dist[i] = Integer.MAX_VALUE;
       }

       dist[start] = 0;
       for(int k=0;k<v-1;k++) {
           for (int i = 0; i < v; i++) {
               for (int j = 0; j < graph[i].size(); j++) {
                   edge e = graph[i].get(j);
                   if (dist[e.src]!=Integer.MAX_VALUE && dist[e.src] + e.weight < dist[e.dest]) {
                       dist[e.dest] = dist[e.src] + e.weight;
                   }
               }
           }
       }
       return dist;
    }

    //Prims Algorithm O(ElogE)

    class pair{
       int node;
       int cost;
       public pair(int node, int cost){
           this.node = node;
           this.cost = cost;
       }
    }
    public int prims(){
        int cost = 0;
        boolean visited[] = new boolean[v];
        PriorityQueue<pair> pq = new PriorityQueue<>((a,b)->a.cost-b.cost);
        pq.add(new pair(0,0));
        while(!pq.isEmpty()) {

            pair polled = pq.poll();
            if (!visited[polled.node]) {


                cost += polled.cost;

                visited[polled.node] = true;
                for (int i = 0; i < graph[polled.node].size(); i++) {
                    int next = graph[polled.node].get(i).dest;
                    if (!visited[next]) {
                        pq.add(new pair(next, graph[polled.node].get(i).weight));

                    }
                }
            }
        }
        return cost;

    }

    //Strongly Connected component Kosaraju,s algorithm

    public ArrayList<ArrayList<Integer>> kosaraju_algo(){
       Stack<Integer> st = new Stack();
       boolean[] visited = new boolean[v];
        for(int i=0;i<v;i++){
            if(!visited[i]){
                sort(visited,st,i);
            }
        }

       ArrayList<edge>[] transpose =  new ArrayList[v];
       for(int i=0;i<transpose.length;i++){
           transpose[i] = new ArrayList<>();

       }
       for(int i=0;i<graph.length;i++){
           for(int j=0;j<graph[i].size();j++){
               int src = graph[i].get(j).src;
               int dest = graph[i].get(j).dest;
               int weight = graph[i].get(j).weight;
               transpose[dest].add(new edge(dest,src,weight));


           }
       }

       return transpose_dfs(transpose,st);


    }
    public ArrayList<ArrayList<Integer>> transpose_dfs(ArrayList<edge>[] transpose,Stack<Integer> st){
        boolean[] visited = new boolean[v];
       ArrayList<ArrayList<Integer>> finallist = new ArrayList<>();
       return helper(transpose,finallist,st,visited);

    }

    public ArrayList<ArrayList<Integer>> helper(ArrayList<edge>[] transpose, ArrayList<ArrayList<Integer>> finallist, Stack<Integer> st, boolean[] visited) {
        while (!st.isEmpty()) {
            int curr = st.pop();
            if (!visited[curr]) {
                ArrayList<Integer> list = new ArrayList<>();
                helper1(transpose, list, curr, visited);

                finallist.add(list);
            }
        }
        return finallist;
    }

    public void helper1(ArrayList<edge>[] transpose, ArrayList<Integer> list, int curr, boolean[] visited) {
        visited[curr] = true;
        list.add(curr);

        for (int i = 0; i < transpose[curr].size(); i++) {
            int next = transpose[curr].get(i).dest;
            if (!visited[next]) {
                helper1(transpose, list, next, visited);
            }
        }
    }


    // To find the  Bridge in a graph Time Complexity O(V+E)
    public void bridge(){
       boolean[] visited = new boolean[v];
       int[] dt = new int[v];
       int[] lowdt = new int[v];
       for(int i=0;i<v;i++){
           if(!visited[i]){
               tarjans(i,-1,0,dt,lowdt,visited);
           }
       }
    }
    public void tarjans(int curr, int parent, int time, int[] dt, int[] lowdt, boolean visited[]){
       visited[curr] = true;
       dt[curr] = lowdt[curr] = ++time;
       for(int i=0;i<graph[curr].size();i++){
           int next = graph[curr].get(i).dest;
           if(parent==next){
               continue;
           }else if(!visited[next]){
                   tarjans(next,curr,time,dt,lowdt,visited);
                   lowdt[curr] = Math.min(lowdt[curr],lowdt[next]);
                   if(dt[curr]<lowdt[next]){
                       System.out.println("The edge " + curr + " ---- " + next);
                   }
               }else{
               lowdt[curr] = Math.min(lowdt[curr],dt[next]);
           }

       }

    }
    //To find the articulation points Time Complexity O(V+E)

    public void getarticulationpoints(){
       boolean visited[] = new boolean[v];
       int[] dt = new int[v];
       int[] lowdt = new int[v];
       boolean[] ap = new boolean[v];
       int time =0;
       for(int i=0;i<v;i++){
           if(!visited[i]){
            gethelper(i,-1,dt,lowdt,visited,ap,time);
           }
       }

       for(int i=0;i<v;i++){
           if(ap[i]){
               System.out.print(i+"  ");
           }
       }
    }

    public void gethelper(int curr, int parent, int[] dt, int[] lowdt, boolean[] visited, boolean[] ap, int time){
       visited[curr] = true;
       dt[curr]=lowdt[curr] = ++time;
       int children =0;

       for(int i=0;i<graph[curr].size();i++){
           int next = graph[curr].get(i).dest;
           if(next==parent){
               continue;
           }
           if(visited[next]){
               lowdt[curr] = Math.min(lowdt[curr],dt[next]);
           }else{
               gethelper(next,curr, dt, lowdt,visited,ap,time);
               lowdt[curr] = Math.min(lowdt[curr],lowdt[next]);
               if(dt[curr]<=lowdt[next] && parent!=-1){
                   ap[curr] = true;
               }
               children++;
           }
       }
       if(parent==-1 && children >1){
           ap[curr] = true;
       }
     }





    public graph(int v1){
       this.v = v1;
        this.graph = new ArrayList[v];
        for(int i=0;i<v;i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new edge(0,2,15));
        graph[0].add(new edge(0,1,15));
        graph[0].add(new edge(0,3,5));
//        graph[0].add(new edge(0,1,10));
//        graph[0].add(new edge(0,3,30));

//        graph[1].add(new edge(1,3,7));
        graph[1].add(new edge(1,0,10));
        graph[1].add(new edge(1,2,10));
//        graph[1].add(new edge(1,3,40));
        graph[2].add(new edge(2,1,50));
        graph[2].add(new edge(2,0,50));
//        graph[2].add(new edge(2,0,15));
//        graph[2].add(new edge(2,0,5));

//        graph[3].add(new edge(3,4,2));
        graph[3].add(new edge(3,4,30));
        graph[3].add(new edge(3,0,30));
        graph[4].add(new edge(4,3,30));
//        graph[3].add(new edge(3,1,40));
//        graph[3].add(new edge(3,2,50));
//        graph[4].add(new edge(4,1,-1));
//        graph[4].add(new edge(4,5,5));
//        graph[4].add(new edge(4,3,2));









    }




}
