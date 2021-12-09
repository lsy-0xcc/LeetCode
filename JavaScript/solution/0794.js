/**
 * @param {string[]} board
 * @return {boolean}
 */

 const O = 'O'
 const X = 'X'
 var validTicTacToe = function (board) {
 
   let boardCell = [];
   board.forEach(line => {
     boardCell.push(line.split(''))
   })
   let OCount = 0;
   let XCount = 0;
   boardCell.forEach(line => {
     line.forEach(cell => {
       if (cell === O) {
         OCount++
       } else if (cell === X) {
         XCount++
       }
     })
   })
   if (XCount - OCount !== 0 && XCount - OCount !== 1) {
     return false
   }
   
   let count = { X: 0, O: 0 }
   boardCell.forEach(line => {
     checkWin(line[0], line[1], line[2], count)
   })
   for (let i = 0; i <= 2; i++) {
     checkWin(boardCell[0][i], boardCell[1][i], boardCell[2][i], count)
   }
   checkWin(boardCell[0][0], boardCell[1][1], boardCell[2][2], count)
   checkWin(boardCell[0][2], boardCell[1][1], boardCell[2][0], count)
 
   if(XCount-OCount === 1){
     return ((count.X === 0 || count.X === 1) && count.O === 0 )|| (count.X === 2 && XCount === 5)
   } if ( XCount === OCount){
     return (count.O === 0|| count.O===1)&& count.X === 0
   } else {
     return false
   }
 };
 
 var checkWin = function (a, b, c, count) {
   if (a === b && b === c) {
     let win = a
     if (a === X) {
       count.X++
     } else if (a === O) {
       count.O++
     }
   }
 }