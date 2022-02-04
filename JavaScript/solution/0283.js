/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
 var moveZeroes = function(nums) {
  let result = nums.filter((value) => value !== 0);
  let count = nums.length - result.length;
  for (let i = 0; i < count; i++) {
    result.push(0);
  }
  for (let i = 0; i < nums.length; i++) {
    nums[i] = result[i];
  }
};