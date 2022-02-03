/**
 * @param {number[]} nums
 * @return {number[]}
 */
 var sortedSquares = function (nums) {
  let negetive = [];
  let positive = [];
  for (let i = 0; i < nums.length; i++) {
    if (nums[i] >= 0) {
      positive.push(nums[i] ** 2);
    } else {
      negetive.push(nums[i] ** 2);
    }
  }

  negetive.reverse();
  if (negetive.length === 0) {
    return positive;
  } else if (positive.length === 0) {
    return negetive;
  }
  let i = 0;
  let j = 0;
  let result = [];
  while (i < positive.length || j < negetive.length) {
    if (j === negetive.length || positive[i] < negetive[j]) {
      result.push(positive[i]);
      i++;
    } else {
      result.push(negetive[j]);
      j++;
    }
  }
  return result;
};