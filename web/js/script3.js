$(document).ready(function()
{
	// Variable to set the duration of the animation
	var animationTime = 500;
	
	// Variable to store the colours
	var colours = ["bd2c33", "e49420", "ecdb00", "3bad54", "1b7db9"];

	// Add raiting3 information box after raiting3
	var raiting3Infobox = $("<div />")
		.attr("id", "raiting3info")
		.insertAfter($("#raiting3"));

	// Function to colorize the right raiting3s
	var colourizeRatings = function(nrOfRatings) {
		$("#raiting3 li a").each(function() {
			if($(this).parent().index() <= nrOfRatings) {
				$(this).stop().animate({ backgroundColor : "#" + colours[nrOfRatings] } , animationTime);
			}
		});
	};
	
	// Handle the hover events
	$("#raiting3 li a").hover(function() {
		
		// Empty the raiting3 info box and fade in
		raiting3Infobox
			.empty()
			.stop()
			.animate({ opacity : 1 }, animationTime);
		
		// Add the text to the raiting3 info box
		$("<p />")
			.html($(this).html())
			.appendTo(raiting3Infobox);
		
		// Call the colourize function with the given index
		colourizeRatings($(this).parent().index());
	}, function() {
		
		// Fade out the raiting3 information box
		raiting3Infobox
			.stop()
			.animate({ opacity : 0 }, animationTime);
		
		// Restore all the raiting3 to their original colours
		$("#raiting3 li a").stop().animate({ backgroundColor : "#333" } , animationTime);
	});
	
	// Prevent the click event and show the raiting3
	$("#raiting3 li a").click(function(e) {
		e.preventDefault();
                document.cali3.facilidad.value=($(this).parent().index() + 1);
                document.cali3.idDocente.value;
                document.cali3.idAsignatura.value;
                document.cali3.Asignatura.value;
                document.cali3.idAlumno.value;
                document.cali3.nombreA.value;
                document.cali3.apellidoP.value;
                document.cali3.apellidoM.value;
                document.cali3.submit();
                alert("Acabas de otorgale a "+document.cali3.nombreA.value+" "+document.cali3.apellidoP.value+" una puntuacion de "+($(this).parent().index() + 1)+" en facilidad");
	});
});