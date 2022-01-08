import sun.security.util.math.IntegerModuloP;

import java.util.List;

public class PageRank {
	
	private static double dampingFactor = 1;
	private static double alpha = 0;
	
	private static Matrix getTransportMatrix(Matrix adjacencyMatrix, int[] noOfOutLinks){
		Matrix transportMatrix = adjacencyMatrix;
		for(int i=0; i<noOfOutLinks.length; ++i){
			adjacencyMatrix.fillNumberColumnForNonZero(i, (1 - alpha)/noOfOutLinks[i]);
		}
		return transportMatrix;
	}
	
	private static Matrix getTransportMatrix(Matrix adjacencyMatrix, int[] noOfOutLinks, double alpha){
		Matrix transportMatrix = adjacencyMatrix;
		for(int i=0; i<noOfOutLinks.length; ++i){
			adjacencyMatrix.fillNumberColumnForNonZero(i, (1 - alpha)/noOfOutLinks[i]);
		}
		return transportMatrix;
	}
	
	private static List<Double> MarkovChain(Matrix googleMatrix, Matrix rankVector, int noOfIterations) throws Exception {
		while(noOfIterations-- > 0){
			rankVector = googleMatrix.multiply(rankVector);
			System.out.println(rankVector.toString());
		}
		System.out.println(rankVector.toString());
		return rankVector.getColumn(0);
	}
	
	public static void setDampingFactor(double val){
		PageRank.dampingFactor = val;
	}
	
	public static void setAlpha(double val){
		PageRank.alpha = val;
	}
	
	public static void setTeleportationProbability(int val){
		PageRank.alpha = val;
	}
	
	public static List<Double> pageRank(Graph graph, int noOfIterations) throws Exception {
		Matrix transport = getTransportMatrix(graph.getAdjacencyMatrix(), graph.getNoOfOutLinks()),
				teleport = new Matrix(graph.size(), graph.size(), alpha/graph.size());
		return MarkovChain(transport.add(teleport),
				new Matrix(graph.size(),1,1.0/ graph.size()),
				noOfIterations);
	}
	
	public static List<Double> pageRank(Graph graph, int noOfIterations, double alpha, double dampingFactor) throws Exception {
		Matrix transport = getTransportMatrix(graph.getAdjacencyMatrix(), graph.getNoOfOutLinks(), alpha),
				teleport = new Matrix(graph.size(), graph.size(), alpha/graph.size());
		return MarkovChain(transport.add(teleport),
				new Matrix(graph.size(),1,1.0/ graph.size()),
				noOfIterations);
	}
	
}
