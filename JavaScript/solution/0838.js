/**
 * @param {string} dominoes
 * @return {string}
 */
 var pushDominoes = function(dominoes) {
  let stack = [];
  // 找到相邻的RL
  let lastRIndex = null;
  for (let i = 0; i <= dominoes.length; i++) {
    if (dominoes[i] === "R") {
      lastRIndex = i;
    } else if (dominoes[i] === "L" && lastRIndex !== null) {
      stack.push([lastRIndex, i]);
      lastRIndex = null;
    }
  }
  let result = dominoes.split("");
  let stackIndex = 0;
  // 推倒向右的骨牌
  let rFlag = false;
  for (let i = 0; i < result.length; i++) {
    // 遇到R或点推 遇到RL不推
    if (dominoes[i] === "R") {
      if (stackIndex < stack.length && i === stack[stackIndex][0]) {
        rFlag = false;
        stackIndex++;
      } else {
        result[i] = "R";
        rFlag = true;
      }
    } else if (dominoes[i] === ".") {
      if (rFlag) {
        result[i] = "R";
      }
    } else if (dominoes[i] === "L") {
      rFlag = false;
    }
  }
  // 推倒向左的骨牌
  let lFlag = false;
  stackIndex = stack.length - 1;
  for (let i = result.length - 1; i >= 0; i--) {
    if (dominoes[i] === "L") {
      if (stackIndex >= 0 && i === stack[stackIndex][1]) {
        lFlag = false;
        stackIndex--;
      } else {
        result[i] = "L";
        lFlag = true;
      }
    } else if (dominoes[i] === ".") {
      if (lFlag) {
        result[i] = "L";
      }
    } else if (dominoes[i] === "R") {
      lFlag = false;
    }
  }

  // 推倒相对的
  for (let pair of stack) {
    let [i, j] = [...pair];
    while (i < j) {
      result[i] = "R";
      result[j] = "L";
      i++;
      j--;
    }
  }
  return result.join("");
};