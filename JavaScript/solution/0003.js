/**
 * @param {string} s
 * @return {number}
 */
 const lengthOfLongestSubstring = function (s) {
  if (!s) {
    return 0;
  }
  let charList = s.split("");
  let charSet = new Set();
  let begin = 0;
  let end = 0;
  let maxLen = 0;
  while (end < charList.length) {
    let char = charList[end];
    if (charSet.has(char)) {
      while (charList[begin] !== char) {
        charSet.delete(charList[begin]);
        begin++;
      }
      begin = begin + 1;
    } else {
      charSet.add(char);
      maxLen = Math.max(maxLen, end - begin + 1);
    }
    end++;
  }
  return maxLen;
};