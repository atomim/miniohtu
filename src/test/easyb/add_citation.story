import miniohtu.*

description 'User can add different citations'

scenario "user can add inproceedings", {
    given 'system is started'    
    when 'a request for a specific inproceeding is given'
    then 'correct citation is given by the system'
}

