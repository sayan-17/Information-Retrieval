/**
 * @author Sayan Paul
 * Connect me on <a href="https://www.linkedin.com/in/sayanpaul17/">Linked In</a>
 * Part of a mini project.
 */

package matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * This is a Class implementing some matrix functionalities. The Matrix can only hold double type.
 */
public class Matrix {
	
	private int M, N;
	private double[][] matrix;
	
	/**
	 * Creates a matrix of zeroes with dimension M ✕ N.
	 * @param M
	 * @param N
	 */
	public Matrix(int M, int N){
		this.M = M;
		this.N = N;
		matrix = new double[this.M][this.N];
	}
	
	/**
	 * Creates a matrix of the given value with dimension M ✕ N.
	 * @param M
	 * @param N
	 * @param val
	 */
	public Matrix(int M, int N, double val){
		this.M = M;
		this.N = N;
		matrix = new double[this.M][this.N];
		for(int i=0; i<M; ++i){
			for(int j=0; j<N; ++j){
				matrix[i][j] = val;
			}
		}
	}
	
	/**
	 * Creates a matrix from the given 2-D array.
	 * @param rows
	 */
	public Matrix(double[][] rows){
		this.M = rows.length;
		this.N = rows[0].length;
		this.matrix = rows;
	}
	
	/**
	 * Returns the number of rows.
	 * @return
	 */
	public int getNoOfRows() {
		return M;
	}
	
	/**
	 * Returns the number of columns.
	 * @return
	 */
	public int getNoOfColumns(){
		return N;
	}
	
	/**
	 * Returns the element at the given position (i,j).
	 * @param i
	 * @param j
	 * @return
	 */
	public double get(int i, int j){
		return matrix[i][j];
	}
	
	/**
	 * Returns the row at the given index.
	 * @param row
	 * @return
	 */
	public List<Double> getRow(int row){
		List<Double> list = new ArrayList<>();
		for(int i=0; i<this.N; ++i){
			list.add(this.matrix[row][i]);
		}
		return list;
	}
	
	/**
	 * Returns the column at the given index.
	 * @param col
	 * @return
	 */
	public List<Double> getColumn(int col){
		List<Double> list = new ArrayList<>();
		for(int i=0; i<this.M; ++i){
			list.add(this.matrix[i][col]);
		}
		return list;
	}
	
	/**
	 * Sets the value at the given position (i,j) to the given value.
	 * @param i
	 * @param j
	 * @param value
	 */
	public void set(int i, int j, double value){
		matrix[i][j] = value;
	}
	
	/**
	 * Sets the values of all positions to the given value.
	 * @param val
	 */
	public void setAll(double val){
		for(int i=0; i<M; ++i){
			for(int j=0; j<N; ++j){
				matrix[i][j] = val;
			}
		}
	}
	
	/**
	 * Fills the given row, with the value provided.
	 * @param row
	 * @param value
	 * @throws IndexOutOfBoundsException
	 */
	public void fillNumberRow(int row, double value) throws IndexOutOfBoundsException{
		
		if(row > this.M)
			throw new IndexOutOfBoundsException();
		
		for(int i = 0; i< M; ++i){
			matrix[row][i] = value;
		}
	}
	
	/**
	 * Replaces all the non-zero elements of the given row, with the value provided.
	 * @param row
	 * @param value
	 * @throws IndexOutOfBoundsException
	 */
	public void fillNumberRowForNonZero(int row, double value) throws IndexOutOfBoundsException{
		
		if(row > this.M)
			throw new IndexOutOfBoundsException();
		
		for(int i = 0; i< M; ++i){
			if(matrix[row][i] != 0)
				matrix[row][i] = value;
		}
	}
	
	/**
	 * Fills the given column, with the value provided.
	 * @param col
	 * @param value
	 * @throws IndexOutOfBoundsException
	 */
	public void fillNumberColumn(int col, double value) throws IndexOutOfBoundsException{
		
		if(col > this.N)
			throw new IndexOutOfBoundsException();
		
		for(int i = 0; i< N; ++i){
			matrix[i][col] = value;
		}
	}
	
	/**
	 * Replaces all the non-zero elements of the given column, with the value provided.
	 * @param col
	 * @param value
	 * @throws IndexOutOfBoundsException
	 */
	public void fillNumberColumnForNonZero(int col, double value) throws IndexOutOfBoundsException{
		
		if(col > this.N)
			throw new IndexOutOfBoundsException();
		
		for(int i = 0; i< N; ++i){
			if(matrix[i][col] != 0)
				matrix[i][col] = value;
		}
	}
	
	/**
	 * Adds with this matrix object and returns the matrix.
	 * @param M     Matrix to be added to this Matrix Object.
	 * @return
	 * @throws Exception    if the matrix dimensions are incompatible for addition.
	 */
	public Matrix add(Matrix M) throws Exception {
		
		if(this.M != M.M || this.N != M.N)
			throw new Exception("Dimensions of matrices passed are not equal");
		
		Matrix result = new Matrix(this.M, this.N);
		
		for(int i = 0; i<this.M; ++i){
			for(int j = 0; j<this.N; ++j){
				result.set(i,j, this.get(i,j) + M.get(i,j));
			}
		}
		
		return result;
	}
	
	/**
	 * Multiplies with this matrix object and returns the matrix.
	 * @param M     Matrix to be multiplied to this Matrix Object.
	 * @return
	 * @throws Exception    if the matrix dimensions are incompatible for multiplication.
	 */
	public Matrix multiply(Matrix M) throws Exception {
		
		if(this.N != M.M)
			throw new Exception("Dimensions of matrices not compatible for matrix multiplication");
		
		Matrix result = new Matrix(this.M, M.N);
		
		for(int i=0; i<result.M; ++i){
			for(int j=0; j<result.N; ++j){
				result.matrix[i][j] = 0;
				for(int k=0; k<result.M; ++k){
					result.matrix[i][j] += this.get(i,k) * M.get(k,j);
				}
			}
		}
		return result;
	}
	
	/**
	 * Multiplies the matrix with the given constant.
	 * @param num
	 * @return
	 */
	public Matrix multiply(double num){
		Matrix result = this;
		for(int i=0; i<result.M; ++i) {
			for (int j = 0; j < result.N; ++j) {
				result.matrix[i][j] *= num;
			}
		}
		return result;
	}
	
	/**
	 * Adds the two matrices.
	 * @param M1
	 * @param M2
	 * @return
	 * @throws Exception    if the matrix dimensions are incompatible for addition.
	 */
	public static Matrix add(Matrix M1, Matrix M2) throws Exception {
		
		if(M1.M != M2.M || M1.N != M2.N)
			throw new Exception("Dimensions of matrices passed are not equal");
		
		Matrix result = new Matrix(M1.M, M1.N);
		
		for(int i = 0; i<result.M; ++i){
			for(int j = 0; j<result.N; ++j){
				result.set(i,j, M1.get(i,j) + M2.get(i,j));
			}
		}
		
		return result;
	}
	
	/**
	 * Multiplies the two matrices
	 * @param M1
	 * @param M2
	 * @return
	 * @throws Exception    if the matrix dimensions are incompatible for multiplication.
	 */
	public static Matrix multiply(Matrix M1, Matrix M2) throws Exception {
		
		if(M1.N != M2.M)
			throw new Exception("Dimensions of matrices not compatible for matrix multiplication");
		
		Matrix result = new Matrix(M1.M, M2.N);
		
		for(int i=0; i<result.M; ++i){
			for(int j=0; j<result.N; ++j){
				result.matrix[i][j] = 0;
				for(int k=0; k<result.M; ++k){
					result.matrix[i][j] += M1.get(i,k) * M2.get(k,j);
				}
			}
		}
		
		return result;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder("{\n");
		for(int i=0; i<M; ++i){
			for(int j=0; j<N; ++j){
				sb.append(this.matrix[i][j] + ",\t");
			}
			sb.append("\n");
		}
		sb.append("}");
		return sb.toString();
	}
}
