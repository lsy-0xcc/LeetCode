var CQueue = function () {
  this.isReverse = true;
  this.normal = [];
  this.reverse = [];
};

/**
 * @return {number}
 */
CQueue.prototype.deleteHead = function () {
  if (
    (this.isReverse && this.reverse.length === 0) ||
    (!this.isReverse && this.normal.length === 0)
  ) {
    return -1;
  }
  if (!this.isReverse) {
    while (this.normal.length > 0) {
      this.reverse.push(this.normal.pop());
    }
    this.isReverse = true;
  }
  return this.reverse.pop();
};

/**
 * @param {number} value
 * @return {void}
 */
CQueue.prototype.appendTail = function (value) {
  if (this.isReverse) {
    while (this.reverse.length > 0) {
      this.normal.push(this.reverse.pop());
    }
    this.isReverse = false;
  }
  this.normal.push(value);
};
