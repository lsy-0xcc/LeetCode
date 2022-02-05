/**
 * @param {number[][]} rectangles
 * @return {number}
 */
 var countGoodRectangles = function(rectangles) {
  let maxRectSize = 0;
   let count = 0;
   for (let rect of rectangles) {
     if (Math.min(...rect) > maxRectSize) {
       maxRectSize = Math.min(...rect);
       count = 1;
     } else if (Math.min(...rect) === maxRectSize) {
       count++;
     }
   }
   return count;
 };