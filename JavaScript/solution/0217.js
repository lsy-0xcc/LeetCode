/**
 * @param {number[]} nums
 * @return {boolean}
 */
 var containsDuplicate = function (nums) {
  let numberSet = new Set();
  for (let num of nums) {
    if (numberSet.has(num)) {
      return true;
    } else {
      numberSet.add(num);
    }
  }
  return false;
};