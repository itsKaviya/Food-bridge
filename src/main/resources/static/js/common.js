function logout(){

    localStorage.removeItem("token");

    window.location="/";

}

function getToken(){

    return localStorage.getItem("token");

}

async function api(url,method="GET",body=null){

    const options={

        method:method,

        headers:{

            "Content-Type":"application/json"

        }

    };

    const token=getToken();

    if(token){

        options.headers["Authorization"]="Bearer "+token;

    }

    if(body){

        options.body=JSON.stringify(body);

    }

    return await fetch(url,options);

}