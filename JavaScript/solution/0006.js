/**
 * @param {string} s
 * @param {number} numRows
 * @return {string}
 */
var convert = function (s, numRows) {
  if (numRows <= 1) {
    return s;
  }
  let index = [];
  let result = [];
  for (let i = 0; i < numRows; i++) {
    result.push([]);
  }
  for (let i = 0; i < numRows - 1; i++) {
    index.push(i);
  }
  for (let i = numRows - 1; i >= 1; i--) {
    index.push(i);
  }
  let position = 0;
  let indexLen = index.length;
  for (let char of s.split("")) {
    result[index[position]].push(char);
    position++;
    if (position >= indexLen) {
      position = 0;
    }
  }
  return result.map((e) => e.join("")).join("");
};
