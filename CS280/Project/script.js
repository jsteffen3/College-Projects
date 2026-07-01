/**
 * Initialization routine.
 */
(function() {
  redraw();
  document.querySelector("#return").addEventListener("submit", (ev) => eventHandler(ev));
});

function eventHandler() {
  var MyStorage = window.localStorage;
  var obj;
  obj.date = document.getElementById('date').value;
  obj.purpose = document.getElementById('purpose').value;
  obj.amount = document.getElementById('amount').value
  MyStorage.setItem(MyStorage.length, obj);
  redraw();
}

function redraw() {
	var MyStorage = window.localStorage;
	for (var i = 0; i < MyStorage.length; i++) {
		var obj = MyStorage.getItem(i);
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
}