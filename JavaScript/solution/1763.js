/**
 * @param {string} s
 * @return {string}
 */
 var longestNiceSubstring = function (s) {
  let niceLen = 0;
  let niceStr = "";
  for (let i = 0; i < s.length - 1; i++) {
    for (let j = 1; j < s.length; j++) {
      let temp = s.substring(i, j + 1);
      let isNice = checkString(temp);
      if (isNice && temp.length > niceLen) {
        niceLen = temp.length;
        niceStr = temp;
      }
    }
  }
  return niceStr;
};

var convertString = function (char) {
  if (char >= "a" && char <= "z") {
    return char.toUpperCase();
  } else {
    return char.toLowerCase();
  }
};

var checkString = function (s) {
  let charSet = new Set();
  for (let char of s) {
    charSet.add(char);
  }
  let isNice = true;
  for (let char of s) {
    isNice = isNice && charSet.has(convertString(char));
  }
  return isNice;
};