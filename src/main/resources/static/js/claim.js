let claims = [];

async function loadClaims() {

    const response = await api("/api/claims");

    claims = await response.json();

    displayClaims(claims);

}

function displayClaims(list){

    let rows="";

    if(list.length===0){

        rows=`
        <tr>

        <td colspan="5" class="text-center">

        No Claims Available

        </td>

        </tr>
        `;

    }

    list.forEach(c=>{

        let badge="";

        switch(c.status){

            case "PENDING":

                badge='<span class="badge bg-warning text-dark">Pending</span>';

                break;

            case "ACCEPTED":

                badge='<span class="badge bg-primary">Accepted</span>';

                break;

            case "PICKED_UP":

                badge='<span class="badge bg-info text-dark">Picked Up</span>';

                break;

            case "DELIVERED":

                badge='<span class="badge bg-success">Delivered</span>';

                break;

            default:

                badge='<span class="badge bg-secondary">'+c.status+'</span>';

        }

        rows += `

        <tr>

        <td>${c.id}</td>

        <td>${c.donation.foodName}</td>

        <td>${badge}</td>

        <td>

        ${c.volunteer ? c.volunteer.fullName : "-"}

        </td>

        <td>

        <button
        class="btn btn-primary btn-sm me-1"
        onclick="assignVolunteer(${c.id})">

        <i class="bi bi-person-plus-fill"></i>

        </button>

        <button
        class="btn btn-warning btn-sm me-1"
        onclick="pickup(${c.id})">

        <i class="bi bi-truck"></i>

        </button>

        <button
        class="btn btn-success btn-sm"
        onclick="deliver(${c.id})">

        <i class="bi bi-check-circle-fill"></i>

        </button>

        </td>

        </tr>

        `;

    });

    document.getElementById("claimTable").innerHTML=rows;

}

async function assignVolunteer(id){

    const volunteerId=prompt("Enter Volunteer ID");

    if(!volunteerId) return;

    await api(`/api/claims/${id}/assign/${volunteerId}`,"PUT");

    loadClaims();

}

async function pickup(id){

    await api(`/api/claims/${id}/pickup`,"PUT");

    loadClaims();

}

async function deliver(id){

    await api(`/api/claims/${id}/deliver`,"PUT");

    loadClaims();

}

loadClaims();