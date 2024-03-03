package sample;

public final class Matrix extends ArrayPI{

    public boolean cheak(int[][] mat_1, int[][] mat_2){
        if (mat_1[0].length != mat_2.length) {
            return true;
        }else{
            return false;
        }
    }
    public int[][] multiplication(int[][] mat_1, int[][] mat_2) {
        int[][] res = new int[0][];

        res = new int[mat_1.length][mat_2[0].length];
        for (int i = 0; i < mat_1.length; i++) {
            for (int k = 0; k < mat_2[0].length; k++) {
                int sum = 0;
                for (int j = 0; j < mat_1[0].length; j++) {
                    sum += mat_1[i][j] * mat_2[j][k];
                }
                res[i][k] = sum;
            }
        }
    return res;
    }
}
