var argumentsLength = function(...args) {
    var parse = JSON.parse(JSON.stringify(args))
    return parse.length
}


argumentsLength(1, 2, 3);

