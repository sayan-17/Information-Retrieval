/**
 * @author Sayan Paul
 * Connect me on <a href="https://www.linkedin.com/in/sayanpaul17/">Linked In</a>
 * Part of a mini project.
 */

import graph.Graph;
import matrix.Matrix;

import java.util.List;

/**
 * Class for the Page Rank Algorithm based on the Random Surfer Model.
 */
public class PageRank {
	
	private static double dampingFactor = 1;
	private static double alpha = 0;
	
	/**
	 * Creates the Transport Matrix for the Given Graph and it's Adjacency Matrix.
	 * @param adjacencyMatrix
	 * @param noOfOutLinks
	 * @return
	 */
	private static Matrix getTransportMatrix(Matrix adjacencyMatrix, int[] noOfOutLinks){
		Matrix transportMatrix = adjacencyMatrix;
		for(int i=0; i<noOfOutLinks.length; ++i){
			adjacencyMatrix.fillNumberColumnForNonZero(i, (1 - alpha)/noOfOutLinks[i]);
		}
		return transportMatrix;
	}
	
	/**
	 * Creates the Transport Matrix for the Given Graph and it's Adjacency Matrix.
	 * @param adjacencyMatrix
	 * @param noOfOutLinks
	 * @param alpha The Probability of teleportation to any random node.
	 * @return
	 */
	private static Matrix getTransportMatrix(Matrix adjacencyMatrix, int[] noOfOutLinks, double alpha){
		Matrix transportMatrix = adjacencyMatrix;
		for(int i=0; i<noOfOutLinks.length; ++i){
			adjacencyMatrix.fillNumberColumnForNonZero(i, (1 - alpha)/noOfOutLinks[i]);
		}
		return transportMatrix;
	}
	
	
	/**
	 * Iterative method for the formula : R = M.R where R -> is the Rank Vector with dimension (n ✖ 1),
	 *  M is the Google Matrix (Transport Matrix + Teleport Matrix)
	 * @param googleMatrix  Google matrix
	 * @param rankVector    Initial Rank Vector, usually set to 1/(no of nodes)
	 * @param noOfIterations    No. of iterations to run.
	 * @return  The final Rank vector after all the iterations.
	 * @throws Exception    if the Google Matrix and Rank Vector dimensions are incompatible for matrix
	 *                      multiplication.
	 */
	private static List<Double> MarkovChain(Matrix googleMatrix, Matrix rankVector, int noOfIterations) throws Exception {
		while(noOfIterations-- > 0){
			rankVector = googleMatrix.multiply(rankVector);
		}
		return rankVector.getColumn(0);
	}
	
	/**
	 * @param val
	 */
	public static void setDampingFactor(double val){
		PageRank.dampingFactor = val;
	}
	
	/**
	 * Alpha is the Teleportation Probability.
	 * @param val
	 */
	public static void setAlpha(double val){
		PageRank.alpha = val;
	}
	
	/**
	 * @param val
	 */
	public static void setTeleportationProbability(int val){
		PageRank.alpha = val;
	}
	
	/**
	 * Implements the Page Rank Algorithm. (Based off the Random Surfer Model).
	 * @param graph     Directed Graph representing a cluster of webpages or others.
	 * @param noOfIterations
	 * @return      List of Page Ranks after all the iterations in the order of storage of the
	 *              nodes as in the Graph.
	 * @throws Exception    if there is an error in matrix dimensions (adjacency matrix made from the graph).
	 */
	public static List<Double> pageRank(Graph graph, int noOfIterations) throws Exception {
		Matrix transport = getTransportMatrix(graph.getAdjacencyMatrix(), graph.getNoOfOutLinks()),
				teleport = new Matrix(graph.size(), graph.size(), alpha/graph.size());
		return MarkovChain(transport.add(teleport),
				new Matrix(graph.size(),1,1.0/ graph.size()),
				noOfIterations);
	}
	
	/**
	 * Implements the Page Rank Algorithm. (Based off the Random Surfer Model).
	 * @param graph     Directed Graph representing a cluster of webpages or others.
	 * @param noOfIterations
	 * @param alpha     The Probability of teleportation to any random node.
	 * @return      List of Page Ranks after all the iterations in the order of storage of the
	 *              nodes as in the Graph.
	 * @throws Exception    if there is an error in matrix dimensions (adjacency matrix made from the graph).
	 */
	public static List<Double> pageRank(Graph graph, int noOfIterations, double alpha) throws Exception {
		Matrix transport = getTransportMatrix(graph.getAdjacencyMatrix(), graph.getNoOfOutLinks(), alpha),
				teleport = new Matrix(graph.size(), graph.size(), alpha/graph.size());
		return MarkovChain(transport.add(teleport),
				new Matrix(graph.size(),1,1.0/ graph.size()),
				noOfIterations);
	}
	
}
