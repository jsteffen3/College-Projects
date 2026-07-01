'use strict';

let data = [
	{ 'userid': 'alice', 'password': 'batteryhorsestaplecorrect', 'dateadded': '2019-08-15' },
	{ 'userid': 'bob', 'password': 'alk98CKDjwc90$^akjc%R8o', 'dateadded': '2019-08-16' },
	{ 'userid': 'charlie', 'password': 'weakpassword', 'dateadded': '2019-08-30' },
	{ 'userid': 'eve', 'password': 'leetHax0rwithR00t', 'dateadded': '2020-07-15' },
];

/**
 * Builds a Bootstrap list group item that contains the header row:
 *   +---------------+---------------+---------------+
 *   |    Username   |   Password    |  Date Added   |
 *   +---------------+---------------+---------------+
 * Note that the structure of elements should be (with appropriate classes):
 *   <li>
 *     <div>
 *       <div>Username</div>
 *       <div>Password</div>
 *       <div>Date Added</div>
 *     </div>
 *   </li>
 */
function buildTableHeader() {
	// TODO: Your code here
	return '';
}

/**
 * Given a dataItem, builds a Bootstrap list group item that contains a
 * row with three columns:
 *   +---------------+---------------+---------------+
 *   |     userid    |   password    |   dateadded   |
 *   +---------------+---------------+---------------+
 * For full credit, the password should be shown as ***** be default, and
 * this text is inside a button. Assuming the password is 'hello', the button
 * should contain the following attribute:
 *
 *   onclick="flipText(this, 'hello')"
 *
 * The structure (<li> and <div> elements) should be the same as above.
 *
 * @param {object} dataItem Contains fields userid, password, and dateadded
 */
function buildDataRow(dataItem) {
	// TODO: Your code here
	return '';
}

/**
 * If the button's .innerText is '*****', change it to show the user's
 * password. Otherwise, it is showing the password and the text should
 * switch back to '*****'.
 *
 * @param {object} button The button that was clicked
 * @param {string} password The text to toggle with '*****'
 */
function flipText(btn, password) {

	// TODO: Your code here
}

/**
 * Given a form, clears the inputs' value fields (sets them to '').
 *
 * @param {object} form The form with the fields to clear.
 */
function resetForm(form) {
	// TODO: Set the form's fields to ''

	// Remove the was-validated class to get rid of the feedback.
	form.classList.remove('was-validated');
}

/**
 * Entry point function. This will run when the script is loaded.
 */
(function() {
	// Javascript timing weirdness: We want to make sure the list group,
	// form, etc., all have had a chance to load. Wrapping the code in
	// this block makes sure everything has loaded.
	window.addEventListener('load', function() {

		// TODO: Remove this alert message and complete the rest of this
		// function based on the provided comments.
		alert('Welcome to Javascript');

		// Get the #userList HTML element
		const userlist = document.querySelector('#userList');

		// Call the function to build the table header and store this string

		// For each item of data, call buildDataRow, concatenating the lines

		// Set the #userList element's .innerHTML value to the header + lines

		// Add user form handling. Start by getting the form.

		// When the form is submitted, the code in this function gets run
		form.addEventListener('submit', function(event) {
			// FIRST: Add the 'was-validated' class to show feedback
			if (!form.classList.contains('was-validated')) {
				form.classList.add('was-validated');
			}

			// TODO: If this returns true, add a new row to the table. Note that
			// the form is an object, each input can be identified by the id name,
			// and each input has a value field. Concatenate the new content line
			// to the .innerHTML of the #userList element. Then clear and reset
			// the form.
			if (form.checkValidity()) {
				// TODO: Your code here
			}

			// KEEP THIS LAST. It stops the page from reloading.
			event.preventDefault();
			event.stopPropagation();
		}, false);

		// When the reset button is clicked, clear the values of the form's
		// input fields.
		const reset = document.querySelector('#addUserReset');
		reset.addEventListener('click', function() { resetForm(form); }, false);
	}, false);
})();
