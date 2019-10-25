package array;

public class Solution1 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] res = twoSum(nums, target);
        for (int i=0;i<res.length;i++){
            System.out.println(res[i]);
        }
    }

    public static int[] twoSum(int[] nums, int target){
        int[] result = new int[2];
        for (int i=0;i<nums.length;i++){
            int firstNum = nums[i];
            int j = i+1;
            while (j<nums.length){
                int secondNum = nums[j];
                if (firstNum+secondNum==target){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }else {
                    j++;
                }
            }
        }
        return new int[]{-1,-1};
    }
}
