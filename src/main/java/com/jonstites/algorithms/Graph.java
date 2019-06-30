package com.jonstites.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;
import java.util.RandomAccess;
import org.apache.commons.lang3.tuple.Pair;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.NavigableSet;


public class Graph {
    Integer numNodes;
    HashMap<Integer, TreeSet<Integer>> edges;

    public Graph(Integer numNodes, List<Pair<Integer, Integer>> inputEdgeList)  {
        
        this.numNodes = numNodes;

        HashMap<Integer, TreeSet<Integer>> edges = new HashMap<>();
        for (Pair<Integer, Integer> edge: inputEdgeList) {

            TreeSet<Integer> set = edges.get(edge.getLeft());

            if (set == null) {
                edges.put(edge.getLeft(), new TreeSet<>());
                set = edges.get(edge.getLeft());
            }
            set.add(edge.getRight());
        }
        this.edges = edges;
    }

    public ArrayList<Integer> bfs(Integer source, Integer destination) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        HashMap<Integer, Integer> parents = new HashMap<>();
        HashSet<Integer> expanded = new HashSet<>();

        queue.addFirst(source);
        expanded.add(source);

        Integer node;
        while ((node = queue.pollLast()) != null) {

            if (node == destination) {
                return backtrack(node, parents);
            }

            TreeSet<Integer> nodeEdges = edges.get(node);
            if (nodeEdges != null) {
                for (Integer edge: nodeEdges) {
                    if (!expanded.contains(edge)) {
                        queue.addFirst(edge);
                        parents.put(edge, node);
                        expanded.add(edge);
                    }
                }
            }
        }
        return new ArrayList<>();
    }

    public ArrayList<Integer> dfs(Integer source, Integer destination) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        HashMap<Integer, Integer> parents = new HashMap<>();
        HashSet<Integer> expanded = new HashSet<>();

        stack.addLast(source);
        Integer node;
        while ((node = stack.pollLast()) != null) {
            if (node == destination) {
                return backtrack(node, parents);
            }

            expanded.add(node);
            TreeSet<Integer> nodeEdges = edges.get(node);
            if (nodeEdges != null) {
                NavigableSet<Integer> reversedNodeEdges = nodeEdges.descendingSet();
                for (Integer edge : reversedNodeEdges) {
                    if (!expanded.contains(edge)) {
                        stack.addLast(edge);
                        parents.put(edge, node);                        
                    }
                }
            }
        }
        return new ArrayList<>();
    }

    public ArrayList<Integer> backtrack(Integer source, HashMap<Integer, Integer> parents) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(source);

        Integer node = source;

        while (parents.containsKey(node)) {
            Integer parent = parents.get(node);
            result.add(parent);
            node = parent;
        }
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}