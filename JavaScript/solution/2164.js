/**
 * @param {number[]} nums
 * @return {number[]}
 */
 var sortEvenOdd = function(nums) {
  let odd = [];
  let even = [];
  let isEven = true;
  for (let num of nums) {
    if (isEven) {
      even.push(num);
    } else {
      odd.push(num);
    }
    isEven = !isEven;
  }
  odd.sort((a, b) => b - a);
  even.sort((a, b) => a - b);
  let index = 0;
  let result = [];
  for (; index < odd.length; index++) {
    result.push(even[index]);
    result.push(odd[index]);
  }
  if (index < even.length) {
    result.push(even[index]);
  }
  return result;
};