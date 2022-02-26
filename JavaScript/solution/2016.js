/**
 * @param {number[]} nums
 * @return {number}
 */
 var maximumDifference = function(nums) {
  let min = Number.MAX_SAFE_INTEGER;
  let diff = -1;
  for(let i = 0; i<nums.length - 1; i++){
    min = Math.min(nums[i], min);
    let tempDiff = nums[i+1]-min;
    diff = Math.max(diff, tempDiff>0?tempDiff:-1);
  }
  return diff
};
