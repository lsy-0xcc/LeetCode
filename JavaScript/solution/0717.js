/**
 * @param {number[]} bits
 * @return {boolean}
 */
 var isOneBitCharacter = function(bits) {
  let pos = 0;
  let lastPos;
  let len = bits.length;
  while (pos < len) {
    lastPos = pos;
    if (bits[pos] === 0) {
      pos += 1;
    } else {
      pos += 2;
    }
  }
  return lastPos === len - 1;
};