import miniohtu.*

description 'User needs to be able to log in to the system.'

scenario 'User successfully logs in.', {
	given 'User types username and password and presses login button'
	when 'The entered identification information is correct.'
	then 'User is granted with full privileges to the application.'
}

scenario 'User tries to log in with incorrect username.', {
	given 'User types username and password and presses login button'
	when 'No account exists with such username.'
	then 'An error message is shown and user is not logged in.'
}

scenario 'User tries to log in with incorrect password.', {
	given 'User types username and password and presses login button'
	when 'No account exists with such password.'
	then 'An error message is shown and user is not logged in.'
}