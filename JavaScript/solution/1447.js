/**
 * @param {number} n
 * @return {string[]}
 */
var simplifiedFractions = function (n) {
  let primes = [
    2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71,
    73, 79, 83, 89, 97,
  ];
  if (n <= 1 || n > 100) {
    return [];
  }
  if (n === 2) {
    return ["1/2"];
  }

  let map = new Map();
  for (let i = 2; i <= n; i++) {
    let set = new Set();
    for (let prime of primes) {
      if (prime > i) {
        break;
      }
      if (i % prime === 0) {
        set.add(prime);
      }
    }
    map.set(i, set);
  }

  let result = [];
  for (let i = 2; i <= n; i++) {
    result.push(`1/${i}`);
    for (let j = 2; j < i; j++) {
      let isNotSimple = false;
      for (let prime of map.get(j)) {
        isNotSimple = isNotSimple || map.get(i).has(prime);
      }
      if (!isNotSimple) {
        result.push(`${j}/${i}`);
      }
    }
  }
  return result;
};

let generatePrime = function (n) {
  if (n <= 1) {
    return [];
  }
  let primes = [];
  for (let i = 2; i <= n; i++) {
    let isPrime = true;
    for (let prime of primes) {
      isPrime = isPrime && i % prime != 0;
    }
    if (isPrime) {
      primes.push(i);
    }
  }
  console.log(primes);
};

console.log(simplifiedFractions(6));
