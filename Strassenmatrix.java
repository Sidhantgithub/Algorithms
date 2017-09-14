class Strassenmatrix{
	
	public int[][] multiply (int[][] X, int[][] Y){
		
		int n = X.length;
		
		int[][] Result = new int[n][n];
		
		//Base case
		if(n == 1)
			 Result[0][0] = X[0][0]*Y[0][0];
		
		else {
			
		//Dividing the X matrix into 4 parts
		int[][] X11 = split(X, 0, 0); //Arguments - Actual Matrix, row length start, column length start
		int[][] X12 = split(X, n/2, 0);
		int[][] X21 = split(X, 0, n/2);
		int[][] X22 = split(X, n/2, n/2);
		
		//Dividing the Y matrix into 4 parts
		int[][] Y11 = split(Y, 0, 0);
		int[][] Y12 = split(Y, n/2, 0);
		int[][] Y21 = split(Y, 0, n/2);
		int[][] Y22 = split(Y, n/2, n/2);
		
		//Recourive calls dividing matrix equally in four parts
		int[][] P1 = multiply(X11, subtract(Y12, Y22));
		int[][] P2 = multiply(add(X11, X12), Y22);
		int[][] P3 = multiply(add(X21, X22), Y11);
		int[][] P4 = multiply(X22, subtract(Y21, Y11));
		int[][] P5 = multiply(add(X11, X22), add(Y11, Y22));
		int[][] P6 = multiply(subtract(X12, X22), add(Y21, Y22));
		int[][] P7 = multiply(subtract(X11, X21), add(Y11, Y12));
		
		//Calculating matrices to finally combine them with resultant matrix
		int[][] C11 = subtract(add(add(P4, P5), P6), P2);
		int[][] C12 = add(P1, P2);
		int[][] C21 = add(P3, P4);
		int[][] C22 = subtract(add(P1, P5), add(P3, P7));
		
		combine(C11, Result, 0, 0);
		combine(C12, Result, n/2, 0);
		combine(C21, Result, 0, n/2);
		combine(C22, Result, n/2, n/2);
		}	
		return Result;
	}
	
	//Dividing the matrix int equal parts
	public int[][] split(int[][] actualMatrix, int rowStart, int columnStart){
		
		int n = actualMatrix.length/2;
		int[][] subMatrix = new int[n][n];
		
		for(int i = 0; i < n; i++, rowStart++)
			for(int j = 0; j < n; j++, columnStart++)
				subMatrix[i][j] = actualMatrix[rowStart][columnStart];
			
		return subMatrix;
	}
	
	//Subtracting the matrix 
	public int[][] subtract(int[][] A, int[][] B){
		
		int n = A.length;
		int[][] C = new int[n][n];
		
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				C[i][j] = A[i][j] - B[i][j];
			
		return C;
	}
	
	//Adding the two mtarices
	public int[][] add(int[][] A, int[][] B){
		
		int n = A.length;
		int[][] C = new int[n][n];
		
		for(int i = 0; i < n; i++)
			for(int j = 0; i < n; i++)
				C[i][j] = A[i][j] + B[i][j];
		
		return C;
	}
	
	//Combinig the child matrices to the final Resultant Matrix
	public void combine(int[][] childMatrix, int[][] finalMatrix, int rowStart, int columnStart){
		
		int n = childMatrix.length;
		for(int i = 0; i < n; i++, rowStart++)
			for(int j = 0; j < n; j++, columnStart++)
				finalMatrix[rowStart][columnStart] = childMatrix[i][j];
	}
	
	
	public static void main(String[] args){
		
		Strassenmatrix ob = new Strassenmatrix();
		int[][] Test = {{1, 2}, {3, 4}};
		int[][] R = ob.multiply(Test, Test);
		
		System.out.println("The resultant matrix is");
		for(int i = 0 ; i < R.length; i++){
			for(int j = 0; j < R.length; j++)
				System.out.print(R[i][j]+" ");
			System.out.println();
		}
				
	}
}