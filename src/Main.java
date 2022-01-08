import java.util.Arrays;
import java.util.List;

public class Main {
	
	public static void main(String[] args){
		Graph<Character> g = new Graph<>();

		g.addNode('A', GraphNodeList.asGraphNodeList('B','C'));
		g.addNode('B', GraphNodeList.asGraphNodeList('C'));
		g.addNode('C', GraphNodeList.asGraphNodeList('A'));

		System.out.println(g);
		System.out.println(g.getAdjacencyMatrix().toString());
		System.out.println(Arrays.toString(g.getNoOfOutLinks()));
		try {
			PageRank.setDampingFactor(0.8);
			PageRank.setAlpha(0.2);
			List<Double> pageRanks = PageRank.pageRank(g,12);
			System.out.println(Arrays.toString(pageRanks.toArray()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
