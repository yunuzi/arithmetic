function higherOrderFunction(func) {
    return function (num) {
        return func(num);
    };
}

function double(num) {
    return num * 2;
}

const doubleFunc = higherOrderFunction(double);
console.log(doubleFunc(10)); // 20



// 柯里化
function curry(func) {
    return function curried(...args) {
        if (args.length >= func.length) {
            return func.apply(this, args);
        } else {
            return function (...args2) {
                return curried.apply(this, [...args, ...args2]);
            };
        }
    };
}

function sum(a, b, c) {
    return a + b + c;
}

const curriedSum = curry(sum);
console.log(curriedSum(1)(2)(3)); // 6