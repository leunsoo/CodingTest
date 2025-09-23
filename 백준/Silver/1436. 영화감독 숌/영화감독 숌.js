const fs = require('fs');
const N = parseInt(fs.readFileSync('/dev/stdin').toString().trim());

let count = 0; 
let num = 666;

while (true) {
    if (num.toString().includes('666')) {
        count++;
        
        if (count === N) {
            console.log(num);
            break;
        }
    }
    
    num++; 
}