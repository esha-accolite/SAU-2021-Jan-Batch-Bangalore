function has_same_digits(num) {
    var first_digit = num % 10;
    while (num>0) 
    {
        if (num % 10 !== first_digit)
            return false;
        num = Math.floor(num/10);
    }
    return true;
}

// has_same_digits(222222);
// has_same_digits(225679);
  