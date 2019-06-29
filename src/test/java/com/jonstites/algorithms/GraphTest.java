package com.jonstites.algorithms;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.ImmutablePair;

import java.util.ArrayList;
import java.util.List;


public class GraphTest {

    @Test
    public void bfsSmallTest() {
        ArrayList<Pair<Integer, Integer>> edges = new ArrayList<>();
        edges.addAll(List.of(
            new ImmutablePair<>(0, 1),
            new ImmutablePair<>(1, 2),
            new ImmutablePair<>(2, 4),
            new ImmutablePair<>(3, 4))
        );


        Graph graph = new Graph(5, edges);
        ArrayList<Integer> expected = new ArrayList<>();
        expected.addAll(List.of(
            0, 1, 2, 4
        ));
        assertEquals(expected, graph.bfs(0, 4));
    }

    @Test
    public void bfsMediumTest() {

    ArrayList<Pair<Integer, Integer>> edges = new ArrayList<>();
    edges.addAll(List.of(
        new ImmutablePair<>(0, 1),
        new ImmutablePair<>(1, 2),
        new ImmutablePair<>(2, 3),
        new ImmutablePair<>(3, 4),
        new ImmutablePair<>(0, 5),
        new ImmutablePair<>(5, 6),
        new ImmutablePair<>(6, 4),
        new ImmutablePair<>(0, 7),
        new ImmutablePair<>(7, 4),
        new ImmutablePair<>(5, 8),
        new ImmutablePair<>(9, 6),
        new ImmutablePair<>(0, 10),
        new ImmutablePair<>(10, 11),
        new ImmutablePair<>(11, 4)
        )
    );


    Graph graph = new Graph(12, edges);
    ArrayList<Integer> expected = new ArrayList<>();
    expected.addAll(List.of(
        0, 7, 4
    ));
    assertEquals(expected, graph.bfs(0, 4));
    }

    @Test
    public void dfsMediumTest() {

    ArrayList<Pair<Integer, Integer>> edges = new ArrayList<>();
    edges.addAll(List.of(
        new ImmutablePair<>(0, 1),
        new ImmutablePair<>(1, 2),
        new ImmutablePair<>(2, 3),
        new ImmutablePair<>(3, 4),
        new ImmutablePair<>(0, 5),
        new ImmutablePair<>(5, 6),
        new ImmutablePair<>(6, 4),
        new ImmutablePair<>(0, 7),
        new ImmutablePair<>(7, 4),
        new ImmutablePair<>(5, 8),
        new ImmutablePair<>(9, 6),
        new ImmutablePair<>(0, 10),
        new ImmutablePair<>(10, 11),
        new ImmutablePair<>(11, 4)
        )
    );


    Graph graph = new Graph(12, edges);
    ArrayList<Integer> expected = new ArrayList<>();
    expected.addAll(List.of(
        0, 1, 2, 3, 4
    ));
    assertEquals(expected, graph.dfs(0, 4));
    }
}