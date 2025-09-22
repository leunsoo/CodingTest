const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split(' ');
const N = parseInt(input[0]);
const K = parseInt(input[1]);

function factorial(n) {
    if (n <= 1) return 1;
    let result = 1;
    for (let i = 2; i <= n; i++) {
        result *= i;
    }
    return result;
}

// 이항계수 계산: C(N, K) = N! / (K! * (N-K)!)
const result = factorial(N) / (factorial(K) * factorial(N - K));
console.log(result);