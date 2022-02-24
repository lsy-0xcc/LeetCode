/**
 * @param {number[][]} grid
 * @return {number[]}
 */
 var findBall = function (grid) {
  let balls = [];
  for (let i = 0; i < grid[0].length; i++) {
    balls.push([0, i]);
  }
  for (let i = 0; i < balls.length; i++) {
    for (let j = 0; j < grid.length; j++) {
      let fallDelta = fall(balls[i], grid);
      if (fallDelta === 0) {
        break;
      } else {
        balls[i] = [balls[i][0] + 1, balls[i][1] + fallDelta];
      }
    }
  }
  return balls.map((item) => (item[0] === grid.length ? item[1] : -1));
};

const fall = function (ball, grid) {
  let [x, y] = [...ball];

  if (grid[x][y] === 1 && grid[x][y + 1] && grid[x][y + 1] === 1) {
    return 1;
  } else if (grid[x][y] === -1 && grid[x][y - 1] && grid[x][y - 1] === -1) {
    return -1;
  } else {
    return 0;
  }
};