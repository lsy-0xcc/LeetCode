/**
 * @param {string} text
 * @return {number}
 */
 var maxNumberOfBalloons = function(text) {
  let map = new Map();
  for (let char of text.split("")) {
    if (map.has(char)) {
      map.set(char, map.get(char) + 1);
    } else {
      map.set(char, 1);
    }
  }
  let count = [
    map.get("b") ?? 0,
    map.get("a") ?? 0,
    Math.floor((map.get("l") ?? 0) / 2),
    Math.floor((map.get("o") ?? 0) / 2),
    map.get("n") ?? 0,
  ];
  return Math.min(...count);
};