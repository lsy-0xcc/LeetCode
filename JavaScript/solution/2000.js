/**
 * @param {string} word
 * @param {character} ch
 * @return {string}
 */
 var reversePrefix = function (word, ch) {
  let index = word.indexOf(ch);
  return index === -1
    ? word
    : word
        .substring(0, index + 1)
        .split("")
        .reverse()
        .join("") + word.substring(index + 1, word.length);
};