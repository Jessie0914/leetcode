package ali_leetcode_daily;

/**
 * @ClassName Solution79
 * @Description ��������
 * @Author shishi
 * @Date 2020/6/22 22:10
 **/

/**
 * https://leetcode-cn.com/problems/word-search/
 * ����һ����ά�����һ�����ʣ��ҳ��õ����Ƿ�����������С�
 * ���ʱ��밴����ĸ˳��ͨ�����ڵĵ�Ԫ���ڵ���ĸ���ɣ����С����ڡ���Ԫ������Щˮƽ���ڻ�ֱ���ڵĵ�Ԫ��ͬһ����Ԫ���ڵ���ĸ�������ظ�ʹ�á�
 * <p>
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * ���� word = "ABCCED", ���� true
 * ���� word = "SEE", ���� true
 * ���� word = "ABCB", ���� false
 */
public class Solution79 {
    // ����4�����������
    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};
    int m;
    int n;

    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0 || board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }

        m = board.length;
        n = board[0].length;

        boolean[][] used = new boolean[m][n];

        // ����ÿһ��λ�ã�������һ��
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, used, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    // ����
    private boolean dfs(char[][] board, String word, boolean[][] used, int i, int j, int index) {
        // �ɹ��ı�־
        if (index == word.length() - 1) {
            return board[i][j] == word.charAt(index);
        }

        if (board[i][j] == word.charAt(index)) {
            // �ȱ��
            used[i][j] = true;

            // 4����������
            for (int k = 0; k < 4; k++) {
                // ��ǰ��һ��
                int newX = i + dx[k];
                int newY = j + dy[k];
                if (inArea(newX, newY) && !used[newX][newY]) {
                    if (dfs(board, word, used, newX, newY, index + 1)) {
                        return true;
                    }
                }
            }

            // �˻�
            used[i][j] = false;
        }

        return false;
    }

    private boolean inArea(int i, int j) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }
}