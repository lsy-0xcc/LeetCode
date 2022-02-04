/**
 * @param {number[]} numbers
 * @param {number} target
 * @return {number[]}
 */
 var twoSum = function(numbers, target) {
  let begin = 0;
  let end = numbers.length - 1;
  while (begin < end) {
    let sum = numbers[begin] + numbers[end];
    if (sum === target) {
      return [begin + 1, end + 1];
    } else if (sum < target) {
      begin++;
    } else {
      end--;
    }
  }
};