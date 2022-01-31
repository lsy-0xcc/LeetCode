/**
 * @param {number[]} candidates
 * @param {number} target
 * @return {number[][]}
 */
var combinationSum = function (candidates, target) {
  candidates.sort();
  let record = [];
  for (let i = 0; i <= target; i++) {
    record[i] = [];
  }
  for (let i of candidates) {
    record[i] = [[i]];
  }
  // 循环到target
  for (let i = 0; i <= target; i++) {
    // record[i+j] 添加 record[i]中所有的数组展开并push j
    for (let j of candidates) {
      if (i + j <= target) {
        for (let k of record[i]) {
          let temp = [...k, j].sort();
          // 不重复再加
          let add = true;
          for (let l of record[i + j]) {
            let same = true;
            for (let m in temp) {
              same = same && l[m] && l[m] === temp[m];
            }
            add = add && !same;
          }
          if (add) {
            record[i + j].push(temp);
          }
        }
      }
    }
  }

  return record[target];
};
