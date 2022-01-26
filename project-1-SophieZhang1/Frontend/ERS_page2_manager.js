const url = "http://localhost:3000/" 

document.getElementById("getReimbursementButton").addEventListener("click", getreimbursement);

async function getreimbursement() {

    let response = await fetch(url + "Reimbursement");

    console.log(response);

    if(response.status === 200){

        let data = await response.json(); 

        console.log(data); 

            for(let Reimbursement of data) {
            
                let row = document.createElement("tr");

                let cell = document.createElement("td");
                cell.innerHTML = Reimbursement.reibm_id;
                row.appendChild(cell);
               
                let cell2 = document.createElement("td");
                cell2.innerHTML = Reimbursement.status;
                row.appendChild(cell2);
                
                let cell3 = document.createElement("td");
                cell3.innerHTML = Reimbursement.reibm_submitted;
                row.appendChild(cell3);
                 
                let cell4 = document.createElement("td");
                cell4.innerHTML = Reimbursement.reibm_resolved;
                row.appendChild(cell4);
                 
                let cell5 = document.createElement("td");
                cell5.innerHTML = Reimbursement.reibm_description;
                row.appendChild(cell5);
                 
                let cell6 = document.createElement("td");
                cell6.innerHTML = Reimbursement.reibm_receipt;
                row.appendChild(cell6);

                let cell7 = document.createElement("td");
                cell7.innerHTML = Reimbursement.author;
                row.appendChild(cell7);

                let cell8 = document.createElement("td");
                cell8.innerHTML = Reimbursement.resolver;
                row.appendChild(cell8);   

                let cell9 = document.createElement("td");
                cell9.innerHTML = Reimbursement.reimb_status_id;
                row.appendChild(cell9);

                let cell10 = document.createElement("td");
                cell10.innerHTML = Reimbursement.remib_type_id;
                row.appendChild(cell10);

                let cell11 = document.createElement("td");
                cell11.innerHTML = Reimbursement.amount;
                row.appendChild(cell11);
                
                document.getElementById("ReimbursementBody").appendChild(row);

            }
        }

    }





