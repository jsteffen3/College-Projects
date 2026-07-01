/**
 * Initialization routine.
 */
(function() {
	for (var i = 0; i < localStorage.length; i++) {
		var obj = localStorage.getItem(i);
		var date = document.createElement('li');
		var amount = document.createElement('li');
		var purpose = document.createElement('li');
		date.textContent = obj.date;
		amount.textContent = obj.amount;
		purpose.textContent = obj.purpose;
		document.querySelector('#date').append(date);
		document.querySelector('#purpose').append(purpose);
		document.querySelector('#amount').append(amount);
	}
});