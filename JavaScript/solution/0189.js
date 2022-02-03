/**
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */
 var rotate = function (nums, k) {
  let step = (k % nums.length) - 1;
  myReverse(nums, 0, nums.length - 1);
  myReverse(nums, 0, step);
  myReverse(nums, step + 1, nums.length - 1);
};

var myReverse = function (nums, begin, end) {
  let i = begin;
  let j = end;
  while (i < j) {
    [nums[i], nums[j]] = [nums[j], nums[i]];
    i++;
    j--;
  }
};