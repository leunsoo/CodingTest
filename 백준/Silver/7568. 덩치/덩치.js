const fs = require('fs');

const input = fs.readFileSync('dev/stdin').toString().trim().split('\n');

const N = parseInt(input[0]);
const people = input.slice(1).map((line) => line.split(' ').map(Number));

let result = [];

for (let i = 0; i < N; ++i) {
  let rank = 1; // 기본 순위

  for (let j = 0; j < N; ++j) {
    if (i === j) continue;

    if (people[j][0] > people[i][0] && people[j][1] > people[i][1]) {
      rank++;
    }
  }

  result.push(rank);
}

console.log(result.join(' '));
