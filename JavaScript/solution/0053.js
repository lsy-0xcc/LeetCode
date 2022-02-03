/**
 * @param {number[]} nums
 * @return {number}
 */
 var maxSubArray = function (nums) {
  let len = nums.length;
  let map = [];
  map[0] = nums[0];
  for (let i = 1; i < len; i++) {
    map[i] = Math.max(nums[i], map[i - 1] + nums[i]);
  }
  let max = map[0];
  for (let e of map) {
    max = Math.max(max, e);
  }
  return max;
};
