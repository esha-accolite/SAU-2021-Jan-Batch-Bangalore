class input {
    constructor(param) {
        this.input = param;
    }
    validate() {
        var str = this.input;
        if(/[0-9]/.test(str))
        {
            console.log("Digit should not be present!");
            return false;
        }
        return true;
    };
    calculateLength() {
        console.log("Length : "+this.input.length);
        return this.input.length;
    };
    getUpperCase() {
        console.log("UpperCase : "+this.input.toUpperCase());
        return this.input.toUpperCase();
    };
    getLowerCase() {
        console.log("LowerCase : "+this.input.toLowerCase());
        return this.input.toLowerCase();
    };
    seperate() {
        var str,lstr,v="",c="";
        str = this.input;
        lstr = this.input.toLowerCase();
        for(let i=0;i<this.input.length;i++)
        {
            if((lstr.charAt(i) == 'a') || (lstr.charAt(i) == 'e') || (lstr.charAt(i) == 'i') || (lstr.charAt(i) == 'o') || (lstr.charAt(i) == 'u'))
            {
                v += str.charAt(i);
            }
            else if(!(/[0-9]/.test(lstr)))
            {
                c += str.charAt(i);
            }
        }
        document.getElementById("vowOp").innerHTML = v;
        document.getElementById("consOp").innerHTML = c;
        console.log("Vowels : "+v);
        console.log("Consonants : "+c);
        return;
    };
}

function callFunction() {
    var inputValue = document.getElementById("inputTxt").value;
    let inputObject = new input(inputValue);
    if(inputObject.validate(inputValue)){
        document.getElementById("lengthOp").innerHTML = inputObject.calculateLength();
        document.getElementById("ucOp").innerHTML = inputObject.getUpperCase();
        document.getElementById("lcOp").innerHTML = inputObject.getLowerCase();
        inputObject.seperate();
    }
}