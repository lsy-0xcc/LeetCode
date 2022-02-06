/**
 * @param {number} num
 * @return {number}
 */
 var smallestNumber = function(num) {
  let isMinus = num < 0;
  if (isMinus) {
    num = -num;
  }
  let digitArray = num
    .toString()
    .split("")
    .map((value) => parseInt(value));
  if (!isMinus) {
    digitArray.sort();
    if (digitArray[0] === 0) {
      let firstNotZero = 0;
      for (let i = 0; i < digitArray.length; i++) {
        if (digitArray[i] !== 0) {
          firstNotZero = i;
          break;
        }
      }
      [digitArray[0], digitArray[firstNotZero]] = [
        digitArray[firstNotZero],
        digitArray[0],
      ];
    }
    result = digitArray.join("");
  } else {
    digitArray.sort((a, b) => b - a);
    result = "-" + digitArray.join("");
  }
  return parseInt(result);
};