/**
 * Definition for isBadVersion()
 * 
 * @param {integer} version number
 * @return {boolean} whether the version is bad
 * isBadVersion = function(version) {
 *     ...
 * };
 */

/**
 * @param {function} isBadVersion()
 * @return {function}
 */
 var solution = function (isBadVersion) {
  /**
   * @param {integer} n Total versions
   * @return {integer} The first bad version
   */
  return function (n) {
    let begin = 0;
    let end = n;
    let middle;
    while (begin < end) {
      middle = begin + Math.floor((end - begin) / 2);
      if (isBadVersion(middle)) {
        end = middle;
      } else {
        begin = middle + 1;
      }
    }
    return end;
  };
};
