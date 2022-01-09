import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Matrix {
	
	private int M, N;
	private double[][] matrix;
	
	public Matrix(int M, int N){
		this.M = M;
		this.N = N;
		matrix = new double[this.M][this.N];
	}
	
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
	
	public Matrix(double[][] rows){
		this.M = rows.length;
		this.N = rows[0].length;
		this.matrix = rows;
	}
	
	public int getNoOfRows() {
		return M;
	}
	
	public int getNoOfColumns(){
		return N;
	}
	
	public double get(int i, int j){
		return matrix[i][j];
	}
	
	public List<Double> getRow(int row){
		List<Double> list = new ArrayList<>();
		for(int i=0; i<this.N; ++i){
			list.add(this.matrix[row][i]);
		}
		return list;
	}
	
	public List<Double> getColumn(int col){
		List<Double> list = new ArrayList<>();
		for(int i=0; i<this.M; ++i){
			list.add(this.matrix[i][col]);
		}
		return list;
	}
	
	public void set(int i, int j, double value){
		matrix[i][j] = value;
	}
	
	public void setAll(double val){
		for(int i=0; i<M; ++i){
			for(int j=0; j<N; ++j){
				matrix[i][j] = val;
			}
		}
	}
	
	public void fillNumberRow(int row, double num) throws IndexOutOfBoundsException{
		
		if(row > this.M)
			throw new IndexOutOfBoundsException();
		
		for(int i = 0; i< M; ++i){
			matrix[row][i] = num;
		}
	}
	
	public void fillNumberRowForNonZero(int row, double num) throws IndexOutOfBoundsException{
		
		if(row > this.M)
			throw new IndexOutOfBoundsException();
		
		for(int i = 0; i< M; ++i){
			if(matrix[row][i] != 0)
				matrix[row][i] = num;
		}
	}
	
	public void fillNumberColumn(int col, double num) throws IndexOutOfBoundsException{
		
		if(col > this.N)
			throw new IndexOutOfBoundsException();
		
		for(int i = 0; i< N; ++i){
			matrix[i][col] = num;
		}
	}
	
	public void fillNumberColumnForNonZero(int col, double num) throws IndexOutOfBoundsException{
		
		if(col > this.N)
			throw new IndexOutOfBoundsException();
		
		for(int i = 0; i< N; ++i){
			if(matrix[i][col] != 0)
				matrix[i][col] = num;
		}
	}
	
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
	
	public Matrix multiply(double num){
		Matrix result = this;
		for(int i=0; i<result.M; ++i) {
			for (int j = 0; j < result.N; ++j) {
				result.matrix[i][j] *= num;
			}
		}
		return result;
	}
	
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
