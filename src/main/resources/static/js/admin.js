let users = [];
let donations = [];

async function loadUsers(){

    const response = await api("/api/admin/users");

    users = await response.json();

    document.getElementById("userCount").innerHTML = users.length;

    let rows = "";

    users.forEach(user=>{

        rows += `

        <tr>

        <td>${user.id}</td>

        <td>${user.fullName}</td>

        <td>

        <span class="badge bg-primary">

        ${user.role}

        </span>

        </td>

        <td>

        <button

        class="btn btn-danger btn-sm"

        onclick="deleteUser(${user.id})">

        <i class="bi bi-trash-fill"></i>

        </button>

        </td>

        </tr>

        `;

    });

    document.getElementById("userTable").innerHTML = rows;

}

async function loadDonations(){

    const response = await api("/api/admin/donations");

    donations = await response.json();

    document.getElementById("donationCount").innerHTML = donations.length;

    const active = donations.filter(d=>d.status==="AVAILABLE").length;

    document.getElementById("activeCount").innerHTML = active;

    let rows = "";

    donations.forEach(d=>{

        let badge="";

        switch(d.status){

            case "AVAILABLE":

                badge='<span class="badge bg-success">Available</span>';

                break;

            case "CLAIMED":

                badge='<span class="badge bg-warning text-dark">Claimed</span>';

                break;

            case "DELIVERED":

                badge='<span class="badge bg-primary">Delivered</span>';

                break;

            default:

                badge='<span class="badge bg-secondary">'+d.status+'</span>';

        }

        rows += `

        <tr>

        <td>${d.foodName}</td>

        <td>${badge}</td>

        </tr>

        `;

    });

    document.getElementById("donationTable").innerHTML = rows;

}

async function deleteUser(id){

    if(!confirm("Delete this user?"))

        return;

    const response = await api("/api/admin/users/"+id,"DELETE");

    if(response.ok){

        loadUsers();

    }

}

loadUsers();

loadDonations();