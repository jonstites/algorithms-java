package com.jonstites.algorithms;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.ImmutablePair;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.io.IOException;



public class HelloWorld {

    public static void main(String[] args) throws IOException, NumberFormatException {
        if (args[0].equals("graph")) {
            handleGraph(args);
        }
    }

    static void handleGraph(String[] args) throws IOException, NumberFormatException {
        if (args.length != 3) {
            System.err.println("Need search type and input file");
            System.exit(1);
        }

        String search = args[1];
        String filename = args[2];

        List<String> lines = Files.lines(Paths.get(filename)).collect(Collectors.toList());
        if (lines.size() != 4) {
            System.err.println("Malformed file. Expected exactly 4 lines.");
            System.exit(1);
        }

        Integer numNodes = Integer.parseInt(lines.get(0));
        Integer sourceNode = Integer.parseInt(lines.get(2));
        Integer destinationNode = Integer.parseInt(lines.get(3));

        ArrayList<Pair<Integer, Integer>> edges = new ArrayList<>();

        String edgesStr = lines.get(1).replaceAll("\\s+","");
        ArrayList<Integer> edgeValues = new ArrayList<>();
        for (String s: edgesStr.split("[,\\[\\]]")) {
            String edge = s.replaceAll("\\s+","");
            if (!edge.isEmpty()) {
                edgeValues.add(Integer.parseInt(edge));
            }
        }

        if (edgeValues.size() % 2 != 0) {
            System.err.println("Malformed edges.");
            System.exit(1);
        }

        for (int i = 0; i < edgeValues.size(); i = i + 2) {
            Integer left = edgeValues.get(i);
            Integer right = edgeValues.get(i + 1);
            edges.add(new ImmutablePair<>(left, right));
        }
        Graph graph = new Graph(numNodes, edges);
        if (search.equals("bfs")) {
            System.out.println(graph.bfs(sourceNode, destinationNode));
        } else if (search.equals("dfs")) {
            System.out.println(graph.dfs(sourceNode, destinationNode));
        } else {
            System.err.println("Unknown search provided.");
            System.exit(1);
        }
    }
}
