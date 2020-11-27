package algorithm;

public class Two_Sum {
    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        int len = nums.length;

        for (int left_idx = 0; left_idx < len; left_idx++) {
            for (int right_idx = left_idx + 1; right_idx < len; right_idx++) {
                int sum = nums[left_idx] + nums[right_idx];

                if (sum == target) {
                    answer[0] = left_idx;
                    answer[1] = right_idx;
                }
            }
        }
        return answer;
    }
}
