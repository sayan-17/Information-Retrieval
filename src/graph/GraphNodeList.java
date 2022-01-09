/**
 * @author Sayan Paul
 * Connect me on <a href="https://www.linkedin.com/in/sayanpaul17/">Linked In</a>
 * Part of a mini project.
 */

package graph;

import java.util.*;

/**
 * This is a class for the Adjacency List of a Graph Structure (primarily for {@link graph.Graph})
 * @param <T>
 */
public class GraphNodeList<T> implements List<T> {
	
	private final ArrayList<T> nodeList = new ArrayList<>();
	
	/**
	 * Returns a GraphNodeList version of all the passed Arguments
	 * @param nodes     The array by which the list will be backed
	 * @param <T>
	 * @return
	 */
	@SafeVarargs
	public static <T> GraphNodeList<T> asGraphNodeList(T ... nodes){
		GraphNodeList<T> list = new GraphNodeList<>();
		list.addAll(Arrays.asList(nodes));
		return list;
	}
	
	/**
	 * {@inheritDoc}
	 * @return
	 */
	@Override
	public int size() {
		return nodeList.size();
	}
	
	/**
	 * {@inheritDoc}
	 * @return
	 */
	@Override
	public boolean isEmpty() {
		return nodeList.isEmpty();
	}
	
	/**
	 * {@inheritDoc}
	 * @return
	 */
	@Override
	public boolean contains(Object o) {
		return nodeList.contains(o);
	}
	
	/**
	 * {@inheritDoc}
	 * @return
	 */
	@Override
	public Iterator iterator() {
		return nodeList.iterator();
	}
	
	/**
	 * {@inheritDoc}
	 * @return
	 */
	@Override
	public Object[] toArray() {
		return nodeList.toArray();
	}
	
	/**
	 * {@inheritDoc}
	 * @return
	 */
	@Override
	public boolean add(Object o) {
		return nodeList.add((T) o);
	}
	
	/**
	 * {@inheritDoc}
	 * @return
	 */
	@Override
	public boolean remove(Object o) {
		return nodeList.remove(o);
	}
	
	/**
	 * {@inheritDoc}
	 * @return
	 */
	@Override
	public boolean addAll(Collection c) {
		return nodeList.addAll(c);
	}
	
	/**
	 * {@inheritDoc}
	 * @return
	 */
	@Override
	public boolean addAll(int index, Collection c) {
		return nodeList.addAll(index, c);
	}
	
	/**
	 * {@inheritDoc}
	 * @return
	 */
	@Override
	public void clear() {
		nodeList.clear();
	}
	
	/**
	 * {@inheritDoc}
	 * @return
	 */
	@Override
	public T get(int index) {
		return nodeList.get(index);
	}
	
	/**
	 * {@inheritDoc}
	 * @return
	 */
	@Override
	public T set(int index, Object element) {
		if(element == null)
			return null;
		return nodeList.set(index, (T) element);
	}
	
	/**
	 * {@inheritDoc}
	 * @return
	 */
	@Override
	public void add(int index, Object element) {
		nodeList.add(index, (T) element);
	}
	
	/**
	 * {@inheritDoc}
	 * @return
	 */
	@Override
	public T remove(int index) {
		return nodeList.remove(index);
	}
	
	/**
	 * {@inheritDoc}
	 * @return
	 */
	@Override
	public int indexOf(Object o) {
		return nodeList.indexOf(o);
	}
	
	/**
	 * {@inheritDoc}
	 * @return
	 */
	@Override
	public int lastIndexOf(Object o) {
		return nodeList.lastIndexOf(o);
	}
	
	/**
	 * {@inheritDoc}
	 * @return
	 */
	@Override
	public ListIterator<T> listIterator() {
		return nodeList.listIterator();
	}
	
	/**
	 * {@inheritDoc}
	 * @return
	 */
	@Override
	public ListIterator<T> listIterator(int index) {
		return nodeList.listIterator(index);
	}
	
	/**
	 * {@inheritDoc}
	 * @return
	 */
	@Override
	public List<T> subList(int fromIndex, int toIndex) {
		return nodeList.subList(fromIndex,toIndex);
	}
	
	/**
	 * {@inheritDoc}
	 * @return
	 */
	@Override
	public boolean retainAll(Collection c) {
		return nodeList.retainAll(c);
	}
	
	/**
	 * {@inheritDoc}
	 * @return
	 */
	@Override
	public boolean removeAll(Collection c) {
		return nodeList.removeAll(c);
	}
	
	/**
	 * {@inheritDoc}
	 * @return
	 */
	@Override
	public boolean containsAll(Collection c) {
		return nodeList.containsAll(c);
	}
	
	/**
	 * {@inheritDoc}
	 * @return
	 */
	@Override
	public Object[] toArray(Object[] a) {
		return nodeList.toArray(a);
	}
	
	/**
	 * {@inheritDoc}
	 * @return
	 */
	@Override
	public String toString(){
		return this.nodeList.toString();
	}
}
