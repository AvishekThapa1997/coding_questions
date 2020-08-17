package array;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        if(nums == null)
            return null;
        List<Integer> numbers = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Arrays.sort(nums);
        int[] res = new int[2];
        int start_point = 0;
        int end_point = nums.length - 1;
        while (start_point < end_point) {
            if (nums[start_point] + nums[end_point] == target) {
                if (nums[start_point] == nums[end_point]) {
                    res[0] = numbers.indexOf(nums[start_point]);
                    res[1] = numbers.lastIndexOf(nums[end_point]);
                }else{
                    res[0] = numbers.indexOf(nums[start_point]);
                    res[1] = numbers.indexOf(nums[end_point]);
                }
                break;
            } else if (nums[start_point] + nums[end_point] < target)
                ++start_point;
            else
                --end_point;
        }

        return res;
    }
    //Optimal approach
//    public int[] twoSum(int[] nums, int target) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            map.put(nums[i], i);
//        }
//        for (int i = 0; i < nums.length; i++) {
//            int complement = target - nums[i];
//            if (map.containsKey(complement) && map.get(complement) != i) {
//                return new int[] { i, map.get(complement) };
//            }
//        }
//        throw new IllegalArgumentException("No two sum solution");
//    }
    public static void main(String[] args) {
        int[] arr = {3,3}; // 1,5
        int target = 6;
        int[] result = twoSum(arr, target);
        System.out.println(result[0] + " " + result[1]);
    }
}
