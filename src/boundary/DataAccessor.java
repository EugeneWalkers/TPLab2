package boundary;

import entities.GetRequest;
import entities.RequestList;
import entities.User;

public class DataAccessor {

	public DataAccessor(){

	}

	public void finalize() throws Throwable {

	}

	public GetRequest GetRequest(int id){
		return null;
	}

	public RequestList GetRequestsForReview(){
		return null;
	}

	public void GetRequestsToBeIssued(){

	}

	void SaveRequest(GetRequest request){

	}

	public boolean UserExists(User user){
		return false;
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