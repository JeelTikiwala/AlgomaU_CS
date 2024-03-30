import java.util.*;
/**
 * Author: Jeel Tikiwala
 * Student Id: 239659420
 * Lab 10
 * Any and All work in this file is my own.
 */
public class JeelTikiwala_Lab10 {
    public static void main(String[] args) {
        // Undirected Graph with 9 vertices
        System.out.println("Undirected Graph:");

        Graph undirectedGraph = new Graph(9, false); // undirected graph with 9 vertices
        undirectedGraph.addEdge(0, 1);
        undirectedGraph.addEdge(0, 2);
        undirectedGraph.addEdge(1, 4);
        undirectedGraph.addEdge(2, 3);
        undirectedGraph.addEdge(3, 6);
        undirectedGraph.addEdge(3, 7);
        undirectedGraph.addEdge(4, 5);
        undirectedGraph.addEdge(4, 6);
        undirectedGraph.addEdge(6, 8);
        undirectedGraph.addEdge(7, 8);

        undirectedGraph.printAdjacencyMatrix();
        undirectedGraph.printAdjacencyList();

        
        System.out.println("\nDirected Graph:");
     
        Graph directedGraph = new Graph(11, true); // directed graph with 11 vertices
        directedGraph.addEdge(4, 10);
        directedGraph.addEdge(4, 1);
        directedGraph.addEdge(10, 1);
        directedGraph.addEdge(6, 7);
        directedGraph.addEdge(6, 10);
        directedGraph.addEdge(7, 8);
        directedGraph.addEdge(2, 7);
        directedGraph.addEdge(2, 9);
        directedGraph.addEdge(8, 9);
        directedGraph.addEdge(2, 9);
        
        directedGraph.printAdjacencyMatrix();
        directedGraph.printAdjacencyList();

    }

    static class Graph {
        private final int[][] adjacencyMatrix;
        private final List<List<Integer>> adjacencyList;
        private final boolean isDirected;

        public Graph(int numberOfVertices, boolean isDirected) {
            this.isDirected = isDirected;
            adjacencyMatrix = new int[numberOfVertices][numberOfVertices];
            adjacencyList = new ArrayList<>();

            for (int i = 0; i < numberOfVertices; i++) {
                adjacencyList.add(new ArrayList<>());
            }
        }

        public void addEdge(int u, int v) {
            // Adjusting for zero-based indexing
            adjacencyMatrix[u][v] = 1;
            adjacencyList.get(u).add(v);

            if (!isDirected) {
                adjacencyMatrix[v][u] = 1;
                adjacencyList.get(v).add(u);
            }
        }

        public void printAdjacencyMatrix() {
            System.out.println("Adjacency Matrix:");
            for (int i = 0; i < adjacencyMatrix.length; i++) {
                for (int j = 0; j < adjacencyMatrix.length; j++) {
                    System.out.print(adjacencyMatrix[i][j] + " ");
                }
                System.out.println();
            }
        }

        public void printAdjacencyList() {
            System.out.println("Adjacency List:");
            for (int i = 0; i < adjacencyList.size(); i++) {
                System.out.print(i + ": ");
                for (int j = 0; j < adjacencyList.get(i).size(); j++) {
                    System.out.print(adjacencyList.get(i).get(j));
                    if (j < adjacencyList.get(i).size() - 1) {
                        System.out.print(" -> ");
                    }
                }
                System.out.println();
            }
        }
    }
}
