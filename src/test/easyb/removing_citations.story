import miniohtu.*

description 'User needs to be able to remove citations from the system.'

scenario 'User removes citations.', {
	given 'Delete button is pressed.'
	when 'Citations are selected.'
	then 'The selected citations are removed from the database. Other citations remain.'
}

scenario 'User presses delete button but does not specify targets for the operation.', {
	given 'Delete button is pressed.'
	when 'No citations are selected.'
	then 'Nothing is removed from the database.'
}