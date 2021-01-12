function sum(str) {
    let sum = 0;
    for(let i = 0; i < str.length; i++)
    {
        if (/[0-9]/.test(str[i]))
            sum += parseInt(str[i]);
    }
    return sum;
}

// sum("ref23kop7t");