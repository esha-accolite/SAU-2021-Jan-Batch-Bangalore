window.onload = function(){
    document.getElementById("submission").onclick= function(){

        var elements = document.getElementsByClassName("required_field");
        // console.log(elements);

        for (let i = 0; i < elements.length; i++) {
            var val = elements[i].value;
            console.log(val);
            if(val==="")
                return alert("All fields are required!");
        }

        //Putting a constraint that password should be atleast of 8 characters
        //IIFE
        (function() {
            var pass = document.getElementById("password").value;
            console.log(pass);
            if(pass.length<8)
                return alert("Password should have atleast 8 characters!");
        })();

        var emailid = document.getElementById("email").value;
        if(!(/\S+@[A-Za-z]+.com/.test(emailid)))
            return alert("Invalid EmailId. Please try again!");

        var gen = document.getElementById("gender").value;
        if(gen==="Select")
            return alert("Gender not specified. Please try again!");

        alert("Form submitted successfully!");
        
        var data = 
        '{\n'+
        '  "FirstName": "'+elements[0].value+'",\n'+
        '  "LastName": "'+elements[1].value+'",\n'+
        '  "Password": "'+elements[2].value+'",\n'+
        '  "Email": "'+elements[3].value+'",\n'+
        '  "Gender": "'+elements[4].value+'",\n'+
        '  "Radio": "'+elements[5].value+'",\n'+
        '{';

        console.log(data);
    };
    
}

// console.log("JS works!");