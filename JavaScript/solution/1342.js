/**
 * @param {number} num
 * @return {number}
 */
 var numberOfSteps = function(num) {
  let count = 0;
  let rest = num;
  while (rest !== 0) {
    if (rest % 2 === 0) {
      rest = rest / 2;
    } else {
      rest = rest - 1;
    }
    count++;
  }
  return count;
};