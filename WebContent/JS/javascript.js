(function() {
    'use strict';
    var session = document.getElementById('sesion').value;
    console.log(session);
    if (session == 'true') {
    	document.getElementById('session').style.display = 'block';
    	document.getElementById('error').style.display = 'none';
	}
})();
