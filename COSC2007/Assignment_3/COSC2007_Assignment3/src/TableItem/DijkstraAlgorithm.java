package TableItem;

/**
 * Name: Jeel Tikiwala
 * Student ID: 239659420
 * Assignment 3
 * Any and all work in this file is my own.
 * Exercise 2
 */
public class DijkstraAlgorithm {

    private static final int NO_PARENT = -1;

    // Main method(6 vertices)
    public static void main(String[] args) {
        int graph[][] = new int[][]{
        	 {0, 7, 0, 5, 0, 0, 0},
             {7, 0, 8, 9, 7, 0, 0},
             {0, 8, 0, 0, 5, 0, 0},
             {5, 9, 0, 0, 15, 6, 0},
             {0, 7, 5, 15, 0, 8, 9},
             {0, 0, 0, 6, 8, 0, 11},
             {0, 0, 0, 0, 9, 11, 0}
        };

        dijkstraAlgorithm(graph, 0); // 0 is the source vertex
    }

    // Function that implements Dijkstra's algorithm
    // graph[][]: adjacency matrix representation of the graph
    // startVertex: source vertex to find shortest path from
    public static void dijkstraAlgorithm(int[][] graph, int startVertex) {
        int nVertices = graph[0].length;

        // Shortest distances from startVertex to i
        int[] shortestDistances = new int[nVertices];

        // Added[i] will be true if vertex i is included in shortest path
        boolean[] added = new boolean[nVertices];

        // Initialize all distances as INFINITE and added[] as false
        for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++) {
            shortestDistances[vertexIndex] = Integer.MAX_VALUE;
            added[vertexIndex] = false;
        }

        // Distance of source vertex from itself is always 0
        shortestDistances[startVertex] = 0;

        // store shortest path tree
        int[] parents = new int[nVertices];

        // The starting vertex does not have a parent
        parents[startVertex] = NO_PARENT;

        // to get shortest path for all vertices
        for (int i = 1; i < nVertices; i++) {

            // min distance vertex from the set of vertices, not yet processed
            int nearestVertex = -1;
            int shortestDistance = Integer.MAX_VALUE;
            for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++) {
                if (!added[vertexIndex] && shortestDistances[vertexIndex] < shortestDistance) {
                    nearestVertex = vertexIndex;
                    shortestDistance = shortestDistances[vertexIndex];
                }
            }

            
            added[nearestVertex] = true;

            // Update dist value of the adjacent vertices of the picked vertex.
            for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++) {
                int edgeDistance = graph[nearestVertex][vertexIndex];

                if (edgeDistance > 0 && ((shortestDistance + edgeDistance) < shortestDistances[vertexIndex])) {
                    parents[vertexIndex] = nearestVertex;
                    shortestDistances[vertexIndex] = shortestDistance + edgeDistance;
                }
            }
        }

        printSolution(startVertex, shortestDistances, parents);
    }

   
    private static void printSolution(int startVertex, int[] distances, int[] parents) {
        int nVertices = distances.length;
        System.out.print("Vertex\t Distance\tPath");

        for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++) {
            if (vertexIndex != startVertex) {
                System.out.print("\n" + startVertex + " -> ");
                System.out.print(vertexIndex + " \t\t ");
                System.out.print(distances[vertexIndex] + "\t\t");
                printPath(vertexIndex, parents);
            }
        }
    }

    // fn to print shortest path from source to currentVertex using parents array
    private static void printPath(int currentVertex, int[] parents) {
        if (currentVertex == NO_PARENT) {
            return;
        }
        printPath(parents[currentVertex], parents);
        System.out.print(currentVertex + " ");
    }
}
