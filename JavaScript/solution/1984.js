/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
 var minimumDifference = function (nums, k) {
  nums.sort((a, b) => a - b);
  if (k === 1) {
    return 0;
  }
  // other
  let min = Number.MAX_SAFE_INTEGER;
  for (let i = 0; i < nums.length - k + 1; i++) {
    let diff = nums[i + k - 1] - nums[i];
    min = Math.min(min, diff);
  }
  return min;
};