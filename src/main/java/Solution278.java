/**
 * @ClassName Solution278
 * @Description 278.第一个错误的版本
 * @Author shishi
 * @Date 2019/7/23 14:20
 **/

/**
 * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
 * 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。
 */
public class Solution278 {
    /**
     * The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version);
     */
    public int firstBadVersion(int n) {
        // 不用二分法的话，会超时
        int start = 1;
        int end = n;
        while (start<end){
            int middle = start+(end-start)/2;
            if (isBadVersion(middle)==false){
                start = middle+1;
            }else {
                end = middle;
            }
        }
        return start;
    }

    private boolean isBadVersion(int i) {
        return false;
    }
}
