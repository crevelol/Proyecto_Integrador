(function() {
    'use strict';
    var pais = document.getElementById('paise').value;
    console.log(pais);
    if (pais == 'España') {
    	document.getElementById("log").innerHTML="<img src='IMAGES/PAIS/españa.jpg' style='width: 5rem; height: 3rem;'/>";
	}else if(pais == 'Ecuador'){
		document.getElementById("log").innerHTML="<img src='IMAGES/PAIS/ecuador.jpg' style='width: 5rem; height: 3rem;'/>";
	}else if(pais == 'Colombia'){
		document.getElementById("log").innerHTML="<img src='IMAGES/PAIS/colombia.png' style='width: 5rem; height: 3rem;'/>";
	}else if(pais == 'Peru'){
		document.getElementById("log").innerHTML="<img src='IMAGES/PAIS/peru.jpg' style='width: 5rem; height: 3rem;'/>";
	}else if(pais == 'Estados Unidos'){
		document.getElementById("log").innerHTML="<img src='IMAGES/PAIS/eunidos.png' style='width: 5rem; height: 3rem;'/>";
	}
    
})();
