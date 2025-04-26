package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
//
//        0 <= a, b, c, d < n
//a、b、c 和 d 互不相同
//        nums[a] + nums[b] + nums[c] + nums[d] == target
//        你可以按 任意顺序 返回答案 。
//
//
//
//        示例 1：
//
//        输入：nums = [1,0,-1,0,-2,2], target = 0
//        输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
//        示例 2：
//
//        输入：nums = [2,2,2,2,2], target = 8
//        输出：[[2,2,2,2]]
//
//
//        提示：
//
//        1 <= nums.length <= 200
//        -109 <= nums[i] <= 109
//        -109 <= target <= 109

public class LC_18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        //使用滑动窗口解决该问题，所以需要先对数组排序（按自然顺序）
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len - 3; i++) {
            if (nums[i] > 0 && nums[i] >= target) {
                //第一个正整数已经大于目标值，后续的就不需要比较了
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                //数值重复，向后走一位
                continue;
            }
            //获取第二个数字下标
            for (int j = i + 1; j < len - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    //数值重复，向后走一位
                    continue;
                }
                //获取第三个数下标
                int left = j + 1;
                //获取第四个数下标
                int right = len - 1;
                //窗口找值
                while (left < right) {
                    //考虑到 10^9会整数溢出，所以用long接收
                    long sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        //找到目标值相等的四个数字
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        //去重
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    }
                }
            }
        }
        return result;
    }
}
