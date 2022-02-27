/**
 * @param {number[]} nums
 * @return {string}
 */
 var optimalDivision = function(nums) {
  switch (nums.length) {
    case 1:
      return nums[0] + "";
    case 2:
      return nums.join("/");
    default:
      nums[1] = "(" + nums[1];
      return nums.join("/") + ")";
  }
};