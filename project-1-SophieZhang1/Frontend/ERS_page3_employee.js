const url = "http://localhost:3000/" 

document.getElementById("getUsersButton").addEventListener("click", getusers);
document.getElementById("loginButton").addEventListener("click", loginFunction);

async function getusers() {

    let response = await fetch(url + "Users");

    console.log(response);

    if(response.status === 200){

        let data = await response.json(); 

        console.log(data);

        for(let Users of data) {

            let row = document.createElement("tr");

            let cell = document.createElement("td");
            cell.innerHTML = Users.user_id;
            row.appendChild(cell);

            let cell2 = document.createElement("td");
            cell2.innerHTML = Users.username;
            row.appendChild(cell2);

            let cell3 = document.createElement("td");
            cell3.innerHTML = Users.password;
            row.appendChild(cell3);

            let cell4 = document.createElement("td");
            cell4.innerHTML = Users.first_name;
            row.appendChild(cell4);

            let cell5 = document.createElement("td");
            cell5.innerHTML = Users.last_name;
            row.appendChild(cell5);

            let cell6 = document.createElement("td");
            cell6.innerHTML = Users.email;
            row.appendChild(cell6);

            let cell7 = document.createElement("td");
            cell7.innerHTML = Users.user_role_id;
            row.appendChild(cell7);

            document.getElementById("UsersBody").appendChild(row);
        }

    }

}

window.addEventListener( "load", function () {
    function sendData() {
      const XHR = new XMLHttpRequest();
  
      const FD = new FormData( form );
  
      XHR.addEventListener( "load", function(event) {
        alert( event.target.responseText );
      } );
  
      XHR.addEventListener( "error", function( event ) {
        alert( 'Oops! Something went wrong.' );
      } );
  
      XHR.open( "POST", "localhost:3000/Reimbursement" );
  
      XHR.send( FD );
    }
  
    const form = document.getElementById( "myForm" );
  
    form.addEventListener( "submit", function ( event ) {
      event.preventDefault();
  
      sendData();
    } );
  } );
