package bank.boundary;

import bank.entities.GetRequest;
import bank.entities.RequestList;
import bank.entities.User;

public class DataAccessor {

	public DataAccessor(){

	}

	public GetRequest getRequest(int id){
		return null;
	}

	public RequestList getRequestsForReview(){
		return null;
	}

	public void getRequestsToBeIssued(){

	}

	public void saveRequest(GetRequest request){

	}

	public boolean userExists(User user){
		return false;
	}
}//end DataAccessor