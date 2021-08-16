package com.huaziran.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
public class Graph {
    private ArrayList<String> vertexList;//存储顶点集合
    private int[][] edges;//存储图对应的领结矩阵
    private int numOfEdges;//表示边的数目
    //定义数组，记录是否被访问
    private boolean[] isVisited;//

    public static void main(String[] args) {
        //测试图
        int n = 5;//节点的个数
        String[] vertices = {"A", "B", "C", "D", "E"};
        //
        Graph graph = new Graph(n);
        //添加顶点
        for (String vertex : vertices) {
            graph.insertVertex(vertex);
        }
        //添加边
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);
        //显示矩阵
        graph.showGraph();

        //测试深度遍历
        System.out.println("深度遍历：");
        graph.dfs();
        System.out.println();
        System.out.println("广度优先：");
        graph.bfs();
    }

    //构造器
    public Graph(int n) { //n:顶点数
        edges = new int[n][n];
        vertexList = new ArrayList<String>(n);  //建立数组
        numOfEdges = 0;
    }

    //得到第一个临界节点的下标

    /**
     * @param index 给定一个节点的下标
     * @return 返回给定这个节点是否有领结节点，有则返回，五则返回-1
     */
    public int getFirstNeighbor(int index) {
        for (int j = 0; j < vertexList.size(); j++) {
            if (edges[index][j] > 0) {//相当于有临界节点
                return j;
            }
        }
        return -1;
    }

    //根据前一个临界节点的下标来取一下临界节点
    public int getNextNeighbor(int v1, int v2) {
        for (int j = v2 + 1; j < vertexList.size(); j++) {
            if (edges[v1][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    //深度有限遍历算法
    public void dfs(boolean[] isVisited, int i) {
        //访问该节点
        System.out.print(getValueByIndex(i) + "->");
//        设置该节点已访问过
        isVisited[i] = true;
        //查找节点i的第一个临界节点
        int w = getFirstNeighbor(i);
        while (w != -1) {//说明有下一个节点
            if (!isVisited[w]) {
                dfs(isVisited, w);
            }
            //如果该节点被访问过
            w = getNextNeighbor(i, w);
        }
    }

    //对dfs进行重载，，遍历所有的节点
    private void dfs() {
        isVisited = new boolean[5];
        //遍历所有的节点，进行dfs
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
    }

    //对一个节点广度优先遍历
    private void bfs(boolean[] isVisited, int i) {
        int u;
        int w;

        LinkedList queue = new LinkedList();

        System.out.print(getValueByIndex(i) + "->");
        isVisited[i] = true;
        queue.add(i);

        while (!queue.isEmpty()) {
            //取出队列的头节点下标
            u = (Integer) queue.removeFirst();
            //得到第一个临界节点的下标w
            w = getFirstNeighbor(u);
            while (w != -1) {//找到
                //是否访问过
                if (!isVisited[w]) {
                    System.out.print(getValueByIndex(w) + "->");
                    //标记已访问
                    isVisited[w] = true;
                    //入队
                    queue.addLast(w);
                }
                //以u为前驱节点，找w后面的下一个临界节点
                w = getNextNeighbor(u, w);//体现广度优先
            }
        }
    }
    //遍历所有节点进行广度优先遍历
    public void bfs(){
        isVisited = new boolean[5];
        for (int i = 0; i <getNumOfVertex();i++){
            if (!isVisited[i]){
                bfs(isVisited,i);
            }
        }
    }

    //    常用的方法
    //显示矩阵
    public void showGraph() {
        for (int[] link : edges) {
            System.out.println(Arrays.toString(link));
        }
    }

    //返回节点的个数
    public int getNumOfVertex() {
        return vertexList.size();
    }

    //得到边的数目
    public int getNumOfEdges() {
        return numOfEdges;
    }

    //返回节点i（下标）对应的值
    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    //返回v1，v2的权值
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    //插入节点
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

//    添加边

    /**
     * @param v1     第一个表示顶点下标
     * @param v2     第二个表示顶点下标
     * @param weight 用来表示顶点关联
     */
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }
}
