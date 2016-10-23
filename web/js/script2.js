$(document).ready(function()
{
	// Variable to set the duration of the animation
	var animationTime = 500;
	
	// Variable to store the colours
	var colours = ["bd2c33", "e49420", "ecdb00", "3bad54", "1b7db9"];

	// Add raiting2 information box after raiting2
	var raiting2Infobox = $("<div />")
		.attr("id", "raiting2info")
		.insertAfter($("#raiting2"));

	// Function to colorize the right raiting2s
	var colourizeRatings = function(nrOfRatings) {
		$("#raiting2 li a").each(function() {
			if($(this).parent().index() <= nrOfRatings) {
				$(this).stop().animate({ backgroundColor : "#" + colours[nrOfRatings] } , animationTime);
			}
		});
	};
	
	// Handle the hover events
	$("#raiting2 li a").hover(function() {
		
		// Empty the raiting2 info box and fade in
		raiting2Infobox
			.empty()
			.stop()
			.animate({ opacity : 1 }, animationTime);
		
		// Add the text to the raiting2 info box
		$("<p />")
			.html($(this).html())
			.appendTo(raiting2Infobox);
		
		// Call the colourize function with the given index
		colourizeRatings($(this).parent().index());
	}, function() {
		
		// Fade out the raiting2 information box
		raiting2Infobox
			.stop()
			.animate({ opacity : 0 }, animationTime);
		
		// Restore all the raiting2 to their original colours
		$("#raiting2 li a").stop().animate({ backgroundColor : "#333" } , animationTime);
	});
	
	// Prevent the click event and show the raiting2
	$("#raiting2 li a").click(function(e) {
		e.preventDefault();
                document.cali2.ayuda.value=($(this).parent().index() + 1);
                document.cali2.idDocente.value;
                document.cali2.idAsignatura.value;
                document.cali2.Asignatura.value;
                document.cali2.idAlumno.value;
                document.cali2.nombreA.value;
                document.cali2.apellidoP.value;
                document.cali2.apellidoM.value;
                document.cali2.submit();
                alert("Acabas de otorgale a "+document.cali2.nombreA.value+" "+document.cali2.apellidoP.value+" una puntuacion de "+($(this).parent().index() + 1)+" en ayuda");
	});
});