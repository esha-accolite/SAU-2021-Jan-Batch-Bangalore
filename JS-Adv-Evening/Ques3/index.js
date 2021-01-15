class student {
    constructor(firstname,lastname,age,gender,rollno,dob){
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.gender = gender;
        this.rollno = rollno;
        this.dob = dob;
    };
}


window.onload = function(){
    var arr = {};
    document.getElementById("submission").onclick= function(){

        var elements = document.getElementsByClassName("required_field");
        // console.log(elements);

        for (let i = 0; i < elements.length; i++) {
            var val = elements[i].value;
            console.log(val);
            if(val==="")
                return alert("required!");
        }
        

        var gen = document.getElementById("gender").value;
        if(gen==="Select")
            return alert("Gender not specified. Please try again!");

        alert("Form submitted successfully!");

        let obj = new student(elements[0].value,elements[1].value,elements[2].value,elements[3].value,elements[4].value,elements[5].value,);
        obj.occupation = elements[6].value;

        var data = 
        {
        "FirstName": obj.firstname,
        "LastName": obj.lastname,
        "Age": obj.age,
        "Gender": obj.gender,
        // "Roll_No": obj.rollno,
        "DOB": obj.dob,
        "Occupation": obj.occupation
        }

        console.log(obj);
        arr[obj.rollno]=data;
        console.log(arr);
        // console.log(data);

        // //disabled the get button if no student details have been entered
        // let el = document.getElementsByClassName("get");
        // for (let i = 0; i < el.length; i++) {
        //     el[i].removeAttribute('disabled');
        // }

    };
    document.getElementById("getdata").onclick = function(){
        let roll = document.getElementById("getroll").value;
        // console.log(roll);
        if(arr.length===0)
        {
            return alert("No students added yet!");
        }
        if(arr[roll])
                console.log(arr[roll]);
            else
                return alert("Roll No. does not exist");
    };  
}

// console.log("JS works!");

