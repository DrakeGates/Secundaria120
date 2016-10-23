$(document).ready(function()
{
	// Variable to set the duration of the animation
	var animationTime = 500;
	
	// Variable to store the colours
	var colours = ["bd2c33", "e49420", "ecdb00", "3bad54", "1b7db9"];

	// Add raiting1 information box after raiting1
	var raiting1Infobox = $("<div />")
		.attr("id", "raiting1info")
		.insertAfter($("#raiting1"));

	// Function to colorize the right raiting1s
	var colourizeRatings = function(nrOfRatings) {
		$("#raiting1 li a").each(function() {
			if($(this).parent().index() <= nrOfRatings) {
				$(this).stop().animate({ backgroundColor : "#" + colours[nrOfRatings] } , animationTime);
			}
		});
	};
	
	// Handle the hover events
	$("#raiting1 li a").hover(function() {
		
		// Empty the raiting1 info box and fade in
		raiting1Infobox
			.empty()
			.stop()
			.animate({ opacity : 1 }, animationTime);
		
		// Add the text to the raiting1 info box
		$("<p />")
			.html($(this).html())
			.appendTo(raiting1Infobox);
		
		// Call the colourize function with the given index
		colourizeRatings($(this).parent().index());
	}, function() {
		
		// Fade out the raiting1 information box
		raiting1Infobox
			.stop()
			.animate({ opacity : 0 }, animationTime);
		
		// Restore all the raiting1 to their original colours
		$("#raiting1 li a").stop().animate({ backgroundColor : "#333" } , animationTime);
	});
	
	// Prevent the click event and show the raiting1
	$("#raiting1 li a").click(function(e) {
		e.preventDefault();
                document.cali1.claridad.value=($(this).parent().index() + 1);
                document.cali1.idDocente.value;
                document.cali1.idAsignatura.value;
                document.cali1.Asignatura.value;
                document.cali1.idAlumno.value;
                document.cali1.nombreA.value;
                document.cali1.apellidoP.value;
                document.cali1.apellidoM.value;
                document.cali1.submit();
                alert("Acabas de otorgale a "+document.cali1.nombreA.value+" "+document.cali1.apellidoP.value+" una puntuacion de "+($(this).parent().index() + 1)+" en claridad");
	});
});