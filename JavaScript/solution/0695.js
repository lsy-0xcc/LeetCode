/**
 * @param {number[][]} image
 * @param {number} sr
 * @param {number} sc
 * @param {number} newColor
 * @return {number[][]}
 */
 var floodFill = function (image, sr, sc, newColor) {
  let currColor = image[sr][sc];
  if (currColor !== newColor) {
    dfs(image, sr, sc, currColor, newColor);
  }
  return image;
  
};

var dfs = function (image, sr, sc, color, newColor){
  image[sr][sc] = newColor;
  let pixelsToFill = [
    [sr + 1, sc],
    [sr - 1, sc],
    [sr, sc + 1],
    [sr, sc - 1],
  ];
  for (let pixel of pixelsToFill) {
    let [r, c] = pixel;
    if (r >= 0 && r < image.length && c >= 0 && c < image[0].length) {
      if (image[r][c] === color) {
        floodFill(image, r, c, newColor);
      }
    }
  }
}