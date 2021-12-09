/**
 * @param {number} n
 * @return {string}
 */
var countAndSay = function (n) {
  if (n === 1) {
    return "1";
  } else if (n === 2) {
    return "11";
  } else {
    let last = "11";
    let str = "";
    for (let i = 2; i < n; i++) {
      let array = last.split("");
      let lastChar = array[0];
      let lastCharCount = 1;
      str = "";
      for (let j = 1; j < array.length; j++) {
        if (array[j] !== lastChar) {
          str = str + lastCharCount + lastChar;
          lastChar = array[j];
          lastCharCount = 1;
        } else {
          lastCharCount++;
        }
      }
      if (lastCharCount > 0) {
        str = str + lastCharCount + lastChar;
      }
      last = str;
    }

    return str;
  }
};

console.log(countAndSay(123))