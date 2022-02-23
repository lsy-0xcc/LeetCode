/**
 * @param {string} s
 * @return {string}
 */
const reverseOnlyLetters = function (s) {
  let array = s.split("");
  let i = 0;
  let j = array.length - 1;
  while (i < j) {
    while (i < array.length && !isLetter(array[i])) i++;
    if (i >= j) break;
    while (j >= 0 && !isLetter(array[j])) j--;
    if (i >= j) break;
    [array[i], array[j]] = [array[j], array[i]];
    i++;
    j--;
  }
  return array.join("");
};

const isLetter = function (char) {
  return (char >= "a" && char <= "z") || (char >= "A" && char <= "ZZ");
};
