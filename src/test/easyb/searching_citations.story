import miniohtu.*

description 'User wants to search citations based on different criteria.' 

scenario 'User searches successfully.', {
	given 'Tags are typed and search button is pressed.'
	when 'Citations are found that match the search criteria.'
	then 'Matching items are shown to the user.'
}

scenario 'User fails the search action.', {
	given 'Tags are typed and search button is pressed.'
	when 'No matching items are found.'
	then 'A message is shown explaining the lack of results.'
}