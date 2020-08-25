package com.eggip.ren.graph;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.function.Consumer;

public interface Graph {
    Set<Vertex> getVertexSet();

    Set<Edge> getEdgeSet(Vertex vertex);

    default void bfs(Vertex v, Consumer<Vertex> discoverAction, Consumer<Vertex> visitAction, Consumer<Vertex> finishAction) {
        Queue<Vertex> queue = new ArrayDeque<>();
        Set<Vertex> discovered = new HashSet<>();
        Vertex currentDiscover = v;
        queue.offer(currentDiscover);
        discovered.add(currentDiscover);
        discoverAction.accept(currentDiscover);
        while (!queue.isEmpty()) {
            Vertex currentVisit = queue.poll();
            visitAction.accept(currentVisit);
            for (Edge edge : getEdgeSet(currentVisit)) {
                if (discovered.contains(edge.to())) continue;
                currentDiscover = edge.to();
                queue.offer(currentDiscover);
                discovered.add(currentDiscover);
                discoverAction.accept(currentDiscover);
            }
            finishAction.accept(currentVisit);
        }
    }

    default void dfs() {

    }

}
