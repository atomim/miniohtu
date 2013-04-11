import miniohtu.*

description 'User is able to add tags to citations for searching.'

scenario 'Tags are succesfully added.', {
	given 'User is at the form of adding tags and submit button is pressed.'
	when 'All tags are unique.'
	then 'The entered tags are saved into the database and they refer to the wanted citation.'
}

scenario 'User gives a same citation multiple identical tags.', {
	given 'User is at the form of adding tags and submit button is pressed.'
	when 'All of the tags are not unique.'
	then 'Only the unique tags are saved into the database and are made to refer the citation.'
}