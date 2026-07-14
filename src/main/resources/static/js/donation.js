let donations=[];

async function loadDonations(){

    const response=await api("/api/donations");

    donations=await response.json();

    display(donations);

}

function display(list){

    let rows="";

    if(list.length===0){

        rows=`

<tr>

<td colspan="6"

class="text-center">

No Donations Found

</td>

</tr>

`;

    }

    list.forEach(d=>{

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

        rows+=`

<tr>

<td>${d.id}</td>

<td>${d.foodName}</td>

<td>${d.quantity}</td>

<td>${badge}</td>

<td>${d.expiryTime}</td>

<td>

<button

class="btn btn-warning btn-sm"

onclick="editDonation(${d.id})">

<i class="bi bi-pencil"></i>

</button>

<button

class="btn btn-danger btn-sm"

onclick="deleteDonation(${d.id})">

<i class="bi bi-trash"></i>

</button>

</td>

</tr>

`;

    });

    document.getElementById("donationTable").innerHTML=rows;

}

function searchDonation(){

    const text=document.getElementById("search").value.toLowerCase();

    const filtered=donations.filter(d=>

        d.foodName.toLowerCase().includes(text)

    );

    display(filtered);

}

function editDonation(id){

    window.location="/add-donation?id="+id;

}

async function deleteDonation(id){

    if(!confirm("Delete Donation?"))

        return;

    await api("/api/donations/"+id,"DELETE");

    loadDonations();

}

loadDonations();