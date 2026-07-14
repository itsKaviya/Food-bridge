async function saveDonation(){

    const donation={

        foodName:document.getElementById("foodName").value,

        quantity:Number(document.getElementById("quantity").value),

        description:document.getElementById("description").value,

        expiryTime:document.getElementById("expiryTime").value,

        pickupAddress:document.getElementById("pickupAddress").value

    };

    if(

        donation.foodName==="" ||

        donation.quantity<=0 ||

        donation.description===""

    ){

        alert("Please complete all required fields.");

        return;

    }

    const response=await api(

        "/api/donations",

        "POST",

        donation

    );

    if(response.ok){

        alert("Donation Added Successfully!");

        window.location="/donations";

    }

    else{

        alert("Unable to save donation.");

    }

}