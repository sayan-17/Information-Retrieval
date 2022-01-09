/**
 * @author Sayan Paul
 * Connect me on <a href="https://www.linkedin.com/in/sayanpaul17/">Linked In</a>
 * Part of a mini project.
 */

package graph;

import matrix.Matrix;

import java.util.*;

/**
 * Class for implementing a Graph. This Structure uses a HashMap for storing the nodes along with their
 * adjacency lists
 * @param <T>
 */
public class Graph<T> extends HashMap implements Map {
	
	private HashMap<T, GraphNodeList<T>> graph = new HashMap<>();
	private ArrayList<T> nodeList = new ArrayList<>();
	
	/**
	 * Adds a node along with it's adjacency list to the graph structure
	 *  See also {@link graph.Graph#addNode(Object)}, {@link graph.Graph#appendToList(Object, Object)}
	 * @param nodeValue
	 * @param adjacencyList
	 * @throws Exception    if there is any node in the adjacency list, that doesn't exists in the graph.
	 */
	public void addNode(T nodeValue, GraphNodeList<T> adjacencyList) throws Exception {
		for(T ele : adjacencyList){
			if(!graph.containsKey(ele))
				throw new Exception("Node Not Found");
		}
		graph.put(nodeValue, adjacencyList);
		nodeList.add(nodeValue);
	}
	
	/**
	 * Adds only the node with an empty adjacency list to the graph structure.
	 * See also {@link graph.Graph#addNode(Object, GraphNodeList)}, {@link graph.Graph#addList(Object, GraphNodeList)}
	 * @param nodeValue
	 */
	public void addNode(T nodeValue){
		graph.put(nodeValue, new GraphNodeList<>());
		nodeList.add(nodeValue);
	}
	
	/**
	 * Replaces the adjacency list of the node.
	 * @param node
	 * @param list
	 * @throws Exception    if the node whose adjacency list is to be replaced doesn't exists in the graph, or
	 *                      if there is any node in the adjacency list, that doesn't exists in the graph.
	 */
	public void addList(T node, GraphNodeList<T> list) throws Exception {
		if(!graph.containsKey(node))
			throw new Exception("Node not found");
		for(T ele : list){
			if(!graph.containsKey(ele))
				throw new Exception("Node Not Found");
		}
		graph.replace(node, list);
	}
	
	/**
	 * Adds a node at the end of the adjacency list. If the node is already present, it will not be added.
	 * @param node  Graph Node (key) as present in the graph.
	 * @param newNode   Graph Node that has to be added to the adjacency list.
	 * @throws Exception    if either of the nodes passed is not present in the graph.
	 */
	public void appendToList(T node, T newNode) throws Exception {
		if(!graph.containsKey(node) || !graph.containsKey(newNode))
			throw new Exception("Node not found");
		GraphNodeList<T> tempList = graph.get(node);
		if(tempList.contains(newNode))
			return;
		tempList.add(newNode);
		graph.replace(node, tempList);
	}
	
	/**
	 * Returns a list of the nodes that are present in the graph.
	 * @return
	 */
	public List<T> getNodeSet() {
		return this.nodeList;
	}
	
	/**
	 * Returns the Adjacency List of the given node.
	 * @param node
	 * @return
	 */
	public GraphNodeList get(Object node) {
		return graph.get(node);
	}
	
	/**
	 * Returns an Integer Array of the number of out-links from the node.
	 * The node is determined by the index of the element. Use {@link Graph#getNodeSet()} to get a
	 * list of the nodes in the same order.
	 * @return
	 */
	public int[] getNoOfOutLinks(){
		int[] outLinks = new int[this.nodeList.size()];
		int i = 0;
		for(Entry<T, GraphNodeList<T>> node : this.graph.entrySet()){
			outLinks[i++] = node.getValue().size();
		}
		return outLinks;
	}
	
	/**
	 * Returns the Adjacency Matrix for this Graph Structure.
	 * @return
	 */
	public Matrix getAdjacencyMatrix(){
		int size = this.graph.size(), i=0;
		Matrix matrix = new Matrix(size,size);
		for(Object node : nodeList.toArray()){
			for(Object linkedNode : graph.get(node)){
				matrix.set(this.nodeList.indexOf(linkedNode), i,1);
			}
			++i;
		}
		return matrix;
	}
	
	/**
	 * Returns the number of nodes present in the graph.
	 * @return
	 */
	@Override
	public int size() {
		return nodeList.size();
	}
	
	/**
	 * Checks if the graph is empty.
	 * @return
	 */
	@Override
	public boolean isEmpty() {
		return graph.isEmpty();
	}
	
	/**
	 * Checks if the given key (node) is present in the graph.
	 * @param node
	 * @return
	 */
	@Override
	public boolean containsKey(Object node) {
		return graph.containsKey(node);
	}
	
	/**
	 * Removes a graph node.
	 * @param node
	 * @return
	 */
	@Override
	public Object remove(Object node) {
		nodeList.remove(node);
		return graph.remove(node);
	}
	
	/**
	 * Removes all nodes from the graph.
	 */
	@Override
	public void clear() {
		graph.clear();
		nodeList.clear();
	}
	
	/**
	 * Returns the Entry Set.
	 * @return
	 */
	@Override
	public Set<Entry<T,GraphNodeList<T>>> entrySet() {
		return graph.entrySet();
	}
	
	@Override
	public String toString(){
		return "{graph.Graph=" + this.graph.toString() +
				", Nodes=" + this.nodeList.toString() + "}";
	}
}
