async function loadDashboard(){

    const response=await api("/api/donations");

    const donations=await response.json();

    let available=0;

    let claimed=0;

    let delivered=0;

    let rows="";

    document.getElementById("totalDonations").innerHTML=donations.length;

    donations.slice(0,5).forEach(d=>{

        let badge="";

        switch(d.status){

            case "AVAILABLE":

                available++;

                badge='<span class="badge bg-success">Available</span>';

                break;

            case "CLAIMED":

                claimed++;

                badge='<span class="badge bg-warning text-dark">Claimed</span>';

                break;

            case "DELIVERED":

                delivered++;

                badge='<span class="badge bg-primary">Delivered</span>';

                break;

            default:

                badge='<span class="badge bg-secondary">'+d.status+'</span>';

        }

        rows+=`

        <tr>

            <td>${d.foodName}</td>

            <td>${d.quantity}</td>

            <td>${badge}</td>

            <td>${d.expiryTime}</td>

        </tr>

        `;

    });

    document.getElementById("availableDonations").innerHTML=available;

    document.getElementById("claimedDonations").innerHTML=claimed;

    document.getElementById("deliveredDonations").innerHTML=delivered;

    document.getElementById("donationTable").innerHTML=rows;

}

loadDashboard();