/**
 * @param {number[][]} matrix
 * @return {number[]}
 */
 var luckyNumbers  = function(matrix) {
  let minIndexes = [];
  for (let line of matrix) {
    let min = line[0];
    let minIndex = 0;
    for (let i = 0; i <= line.length; i++) {
      if (line[i] < min) {
        min = line[i];
        minIndex = i;
      }
    }
    minIndexes.push(minIndex);
  }
  let result = [];
  for (let i = 0; i < minIndexes.length; i++) {
    let isMax = true;
    let value = matrix[i][minIndexes[i]];
    for (let j = 0; j < matrix.length; j++) {
      if (value < matrix[j][minIndexes[i]]) {
        isMax = false;
        break;
      }
    }
    if (isMax) {
      result.push(value);
    }
  }
  return result;
};