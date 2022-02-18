/**
 * initialize your data structure here.
 */
 var MinStack = function () {
  this.stack = [];
  this.minStack = [];
};

/**
 * @param {number} x
 * @return {void}
 */
MinStack.prototype.push = function (x) {
  this.stack.push(x);
  if (this.minStack.length === 0 || this.minStack[this.minStack.length - 1] >= x) {
    this.minStack.push(x);
  }
};

/**
 * @return {void}
 */
MinStack.prototype.pop = function () {
  let result = this.stack.pop();
  if (result !== undefined && result === this.minStack[this.minStack.length - 1]) {
    this.minStack.pop();
  }
};

/**
 * @return {number}
 */
MinStack.prototype.top = function () {
  return this.stack[this.stack.length - 1];
};

/**
 * @return {number}
 */
MinStack.prototype.min = function () {
  return this.minStack[this.minStack.length - 1];
};
