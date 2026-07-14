async function registerUser(){

    const body={

        fullName:document.getElementById("fullName").value.trim(),

        email:document.getElementById("email").value.trim(),

        phoneNumber:document.getElementById("phoneNumber").value.trim(),

        password:document.getElementById("password").value.trim(),

        role:document.getElementById("role").value

    };

    if(

        body.fullName==="" ||

        body.email==="" ||

        body.phoneNumber==="" ||

        body.password==="" ||

        body.role===""

    ){

        alert("Please fill all fields.");

        return;

    }

    const response=await fetch("/api/auth/register",{

        method:"POST",

        headers:{

            "Content-Type":"application/json"

        },

        body:JSON.stringify(body)

    });

    if(response.ok){

        alert("Registration Successful!");

        window.location="/";

    }

    else{

        alert("Registration Failed!");

    }

}