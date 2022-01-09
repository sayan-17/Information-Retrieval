import java.util.*;

public class Graph<T> extends HashMap implements Map {
	
	private HashMap<T, GraphNodeList<T>> graph = new HashMap<>();
	private ArrayList<T> nodeList = new ArrayList<>();
	
	
	public void addNode(T nodeValue, GraphNodeList<T> adjacencyList){
		graph.put(nodeValue, adjacencyList);
		nodeList.add(nodeValue);
	}
	
	public void addNode(T nodeValue){
		graph.put(nodeValue, new GraphNodeList<>());
		nodeList.add(nodeValue);
	}
	
	public void addList(T node, GraphNodeList<T> list) throws Exception {
		if(!graph.containsKey(node))
			throw new Exception("Node not found");
		graph.replace(node, list);
	}
	
	public void appendToList(T node, T newNode) throws Exception {
		if(!graph.containsKey(node))
			throw new Exception("Node not found");
		GraphNodeList<T> tempList = graph.get(node);
		if(tempList.contains(newNode))
			return;
		tempList.add(newNode);
		graph.replace(node, tempList);
	}
	
	public void putAll(Graph graph) {
		graph.putAll(graph);
	}
	
	public ArrayList<T> getNodeSet() {
		return this.nodeList;
	}
	
	public GraphNodeList get(Object key) {
		return graph.get(key);
	}
	
	public int[] getNoOfOutLinks(){
		int[] outLinks = new int[this.nodeList.size()];
		int i = 0;
		for(Entry<T, GraphNodeList<T>> node : this.graph.entrySet()){
			outLinks[i++] = node.getValue().size();
		}
		return outLinks;
	}
	
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
	
	@Override
	public int size() {
		return nodeList.size();
	}
	
	@Override
	public boolean isEmpty() {
		return graph.isEmpty();
	}
	
	@Override
	public boolean containsKey(Object key) {
		return graph.containsKey(key);
	}
	
	@Override
	public Object remove(Object key) {
		return graph.remove(key);
	}
	
	@Override
	public void clear() {
		graph.clear();
	}
	
	@Override
	public Set<Entry<T,GraphNodeList<T>>> entrySet() {
		return graph.entrySet();
	}
	
	@Override
	public String toString(){
		return "{Graph=" + this.graph.toString() +
				", Nodes=" + this.nodeList.toString() + "}";
	}
}
