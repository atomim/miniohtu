import miniohtu.*

description 'User is able to edit existing citations.'

scenario 'User changes the information of a citation.', {
	given 'User is at the citation\'s editing form.'
	when 'Update button is pressed.'
	then 'The citation\'s information is changed to match the typed information.'
}