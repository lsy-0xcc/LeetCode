/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
 var search = function (nums, target) {
  let begin = 0;
  let end = nums.length - 1;
  let middle = Math.floor((begin + end) / 2);
  while (end >= begin) {
    if (nums[middle] === target) {
      return middle;
    } else if (nums[middle] < target) {
      begin = middle + 1;
      middle = Math.floor((begin + end) / 2);
    } else if (nums[middle] > target) {
      end = middle - 1;
      middle = Math.floor((begin + end) / 2);
    }
  }
  return -1;
};