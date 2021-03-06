public class Solution4 {

    // 不使用哨兵的写法

    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        if (rows == 0) {
            return 0;
        }

        int cols = matrix[0].length;
        if (cols == 0) {
            return 0;
        }

        int[][] dp = new int[rows][cols];

        int res = 0;
        // 先填第 1 行
        for (int j = 0; j < cols; j++) {
            if (matrix[0][j] == '1') {
                dp[0][j] = 1;
                res = 1;
            }
        }

        // 再填第 1 列
        for (int i = 1; i < rows; i++) {
            if (matrix[i][0] == '1') {
                dp[i][0] = 1;
                res = 1;
            }
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        // 再把里面的填完
        return res * res;
    }
}
