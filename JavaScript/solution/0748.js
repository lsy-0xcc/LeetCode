/**
 * @param {string} licensePlate
 * @param {string[]} words
 * @return {string}
 */
 var shortestCompletingWord = function (licensePlate, words) {
  let pattern = /[a-z]/g
  let patternArray = licensePlate.toLowerCase().match(pattern)
  let patternSum = {}
  patternArray.forEach(e => {
    if (!patternSum[e]) {
      patternSum[e] = 1
    } else {
      patternSum[e]++
    }
  })
  let minLen = Number.MAX_VALUE
  let result = null
  for (let i = words.length - 1; i >= 0; i--) {
    let word = words[i]
    if (check(word, patternSum)) {
      let wordLen = word.length
      if (wordLen <= minLen) {
        result = word
        minLen = wordLen
      }
    }
  }
  return result
};

let check = function (str, patternSum) {
  let array = str.split('')
  let sum = {}
  for (let i in patternSum) {
    sum[i] = 0
  }
  array.forEach(e => {
    if (patternSum[e]) {
      sum[e]++
    }
  })
  let correct = true
  for (let i in patternSum) {
    correct = correct && sum[i] >= patternSum[i]
  }
  // console.log(sum, correct)
  return correct
}