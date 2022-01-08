import java.util.*;

public class GraphNodeList<T> implements List<T> {
	
	private final ArrayList<T> nodeList = new ArrayList<>();
	
	@SafeVarargs
	public static <T> GraphNodeList<T> asGraphNodeList(T ... nodes){
		GraphNodeList<T> list = new GraphNodeList<>();
		list.addAll(Arrays.asList(nodes));
		return list;
	}
	
	@Override
	public int size() {
		return nodeList.size();
	}
	
	@Override
	public boolean isEmpty() {
		return nodeList.isEmpty();
	}
	
	@Override
	public boolean contains(Object o) {
		return nodeList.contains(o);
	}
	
	@Override
	public Iterator iterator() {
		return nodeList.iterator();
	}
	
	@Override
	public Object[] toArray() {
		return nodeList.toArray();
	}
	
	@Override
	public boolean add(Object o) {
		return nodeList.add((T) o);
	}
	
	@Override
	public boolean remove(Object o) {
		return nodeList.remove(o);
	}
	
	@Override
	public boolean addAll(Collection c) {
		return nodeList.addAll(c);
	}
	
	@Override
	public boolean addAll(int index, Collection c) {
		return nodeList.addAll(index, c);
	}
	
	@Override
	public void clear() {
		nodeList.clear();
	}
	
	@Override
	public T get(int index) {
		return nodeList.get(index);
	}
	
	@Override
	public T set(int index, Object element) {
		if(element == null)
			return null;
		return nodeList.set(index, (T) element);
	}
	
	@Override
	public void add(int index, Object element) {
		nodeList.add(index, (T) element);
	}
	
	@Override
	public T remove(int index) {
		return nodeList.remove(index);
	}
	
	@Override
	public int indexOf(Object o) {
		return nodeList.indexOf(o);
	}
	
	@Override
	public int lastIndexOf(Object o) {
		return nodeList.lastIndexOf(o);
	}
	
	@Override
	public ListIterator<T> listIterator() {
		return nodeList.listIterator();
	}
	
	@Override
	public ListIterator<T> listIterator(int index) {
		return nodeList.listIterator(index);
	}
	
	@Override
	public List<T> subList(int fromIndex, int toIndex) {
		return nodeList.subList(fromIndex,toIndex);
	}
	
	@Override
	public boolean retainAll(Collection c) {
		return nodeList.retainAll(c);
	}
	
	@Override
	public boolean removeAll(Collection c) {
		return nodeList.removeAll(c);
	}
	
	@Override
	public boolean containsAll(Collection c) {
		return nodeList.containsAll(c);
	}
	
	@Override
	public Object[] toArray(Object[] a) {
		return nodeList.toArray(a);
	}
	
	@Override
	public String toString(){
		return this.nodeList.toString();
	}
}
