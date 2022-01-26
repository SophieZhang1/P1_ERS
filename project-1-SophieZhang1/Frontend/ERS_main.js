const url = "http://localhost:3000/" 

document.getElementById("getReimbursementButton").addEventListener("click", getreimbursement);
document.getElementById("loginButton").addEventListener("click", loginFunction);

async function loginFunction() {

    let usern = document.getElementById("username").value;
    let userp = document.getElementById("password").value;

    let user = {
        username:usern,
        password:userp
    }
    
    console.log(user)

    let response = await fetch (url + "login", {

        method: "POST", 
        body: JSON.stringify(user), 
        credentials: "include"
       
    });

    console.log(response.status); 

    if(response.status === 202) {
        
        document.getElementById("loginRow").innerText="Welcome!";
    } else {
        document.getElementById("loginRow").innerText="Login failed! Refresh the page";
    }


}
