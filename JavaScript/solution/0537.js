/**
 * @param {string} num1
 * @param {string} num2
 * @return {string}
 */
var complexNumberMultiply = function (num1, num2) {
  let regexr = /(-?\d+)\+(-?\d+)i/;
  let [, t1, t2] = num1.match(regexr);
  let [, t3, t4] = num2.match(regexr);
  let [a, b, c, d] = [t1, t2, t3, t4].map((e) => parseInt(e));
  return `${a * c - b * d}+${a * d + b * c}i`;
};
