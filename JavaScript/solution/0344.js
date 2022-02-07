var reverseString = function (s) {
  let left = 0;
  let right = s.length - 1;
  let temp;
  while (left < right) {
    temp = s[left];
    s[left] = s[right];
    s[right] = temp;
    left++;
    right--;
  }
  return s;
};