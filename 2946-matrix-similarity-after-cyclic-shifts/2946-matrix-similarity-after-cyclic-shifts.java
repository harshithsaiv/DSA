class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        
        int[][] deepCopy = new int[m][];
        for (int i = 0; i <m; i++) {
            deepCopy[i] = mat[i].clone();
        }
        
        for(int q=0;q<k;q++){
            for(int l=0;l<m;l++){
                if(n%2==0){
                    int x[] = leftshift(mat[l]);
                    mat[l]=x;
                }
                else{
                    int x[]=rightshift(mat[l]);
                    mat[l]=x;
                }
        }
            
        }
        
        return Arrays.deepEquals(mat,deepCopy);
    }
    
    public int[] leftshift(int[] mat){
        int n=mat.length;
        int res[] = new int[n];
        res[n-1]=mat[0];
        for(int i=1,j=0;i<n && j<n-1;i++,j++){
            res[j]=mat[i];
        }
        return res;
    }
    
    public int [] rightshift(int [] mat){
        int n=mat.length;
        int res[] = new int[n];
        res[0]=mat[n-1];
        for(int i=1,j=0;i<n && j<n-1;i++,j++){
            res[i]=mat[j];
        }
        return res;
    }
}