document.getElementById("btn").addEventListener("click", () => {
	const cardStyle = document.getElementById("verification").style.display;
	if(cardStyle == "none"){
		document.getElementById("verification").style.display = "block";
	} else{
		document.getElementById("verification").style.display = "none";
	}
});