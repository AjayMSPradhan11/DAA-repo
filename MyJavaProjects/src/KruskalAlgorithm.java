import java.util.Arrays;

class KruskalsAlgorithm {
    static class Edge implements Comparable<Edge> {
        int src, dest, weight;

        @Override
        public int compareTo(Edge compareEdge) {
            return this.weight - compareEdge.weight;
        }
    }

    static class Subset {
        int parent, rank;
    }

    private int V, E;
    private Edge[] edges;

    KruskalsAlgorithm(int v, int e) {
        V = v;
        E = e;
        edges = new Edge[E];
        for (int i = 0; i < e; ++i) {
            edges[i] = new Edge();
        }
    }

    int find(Subset subsets[], int i) {
        if (subsets[i].parent != i) {
            subsets[i].parent = find(subsets, subsets[i].parent);
        }
        return subsets[i].parent;
    }

    void union(Subset subsets[], int x, int y) {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        if (subsets[xroot].rank < subsets[yroot].rank) {
            subsets[xroot].parent = yroot;
        } else if (subsets[xroot].rank > subsets[yroot].rank) {
            subsets[yroot].parent = xroot;
        } else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }

    void kruskalMST() {
        Edge result[] = new Edge[V];
        int e = 0;
        int i = 0;
        for (i = 0; i < V; ++i)
            result[i] = new Edge();

        Arrays.sort(edges);

        Subset subsets[] = new Subset[V];
        for (i = 0; i < V; ++i) {
            subsets[i] = new Subset();
            subsets[i].parent = i;
            subsets[i].rank = 0;
        }

        i = 0;

        while (e < V - 1) {
            Edge nextEdge = edges[i++];

            int x = find(subsets, nextEdge.src);
            int y = find(subsets, nextEdge.dest);

            if (x != y) {
                result[e++] = nextEdge;
                union(subsets, x, y);
            }
        }

        System.out.println("Minimum Spanning Tree using Kruskal's Algorithm:");
        for (i = 0; i < e; ++i) {
            System.out.println(result[i].src + " - " + result[i].dest + ": " + result[i].weight);
        }
    }

    public static void main(String[] args) {
        int V = 5; // Number of vertices in the graph
        int E = 7; // Number of edges in the graph

        KruskalsAlgorithm graph = new KruskalsAlgorithm(V, E);

        // Assigning values to the edges
        graph.edges[0].src = 0;
        graph.edges[0].dest = 1;
        graph.edges[0].weight = 2;

        graph.edges[1].src = 0;
        graph.edges[1].dest = 3;
        graph.edges[1].weight = 6;

        graph.edges[2].src = 1;
        graph.edges[2].dest = 2;
        graph.edges[2].weight = 3;

        graph.edges[3].src = 1;
        graph.edges[3].dest = 4;
        graph.edges[3].weight = 5;

        graph.edges[4].src = 2;
        graph.edges[4].dest = 4;
        graph.edges[4].weight = 7;

        graph.edges[5].src = 2;
        graph.edges[5].dest = 3;
        graph.edges[5].weight = 0;

        graph.edges[6].src = 3;
        graph.edges[6].dest = 4;
        graph.edges[6].weight = 9;

        graph.kruskalMST();
    }
}
