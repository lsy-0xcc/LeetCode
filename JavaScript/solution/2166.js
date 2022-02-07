/**
 * @param {number} a
 * @param {number} b
 * @param {number} c
 * @return {string}
 */
 var longestDiverseString = function(a, b, c) {
  let count = { a, b, c };
let result = [];
let lastAdd;
let isContinue = true;
while (isContinue) {
  let maxKey;
  let maxCount = 0;
  // 找剩下的数量最多的字母 上次选出来的不行
  for (let key in count) {
    if (count[key] > maxCount && lastAdd !== key) {
      maxCount = count[key];
      maxKey = key;
    }
  }
  // 找不到结束循环
  if (maxCount === 0) {
    isContinue = false;
  } else {
    // 找和其他字符数量的差距
    let minDiff = Number.MAX_SAFE_INTEGER;
    for (let key in count) {
      if (key !== maxKey) {
        let diff = count[maxKey] - count[key];
        minDiff = Math.min(minDiff, diff);
      }
    }
    // 多一个以下拿走一个 两个以上拿走两个
    if (minDiff <= 1) {
      count[maxKey]--;
      result.push(maxKey);
    } else {
      count[maxKey] -= 2;
      result.push(maxKey, maxKey);
    }
    lastAdd = maxKey;
  }
}
return result.join("");
};