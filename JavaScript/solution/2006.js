/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
 const countKDifference = function(nums, k) {
  let len = nums.length
let count = 0;
for(let i = 0; i<len; i++){
  let a = nums[i]
  for(let j = i+1; j<len; j++){
    let b = nums[j]
    if(a-b === k || b-a === k){
      count++;
    }
  }
}
return count;
};