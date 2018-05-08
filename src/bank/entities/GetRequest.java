package bank.entities;

public class GetRequest {

	public String getClientName() {
		return clientName;
	}

	private String clientName;
	private int value;

	public GetRequest(String clientName){
		this.clientName = clientName;
	}

	@Override
	public String toString(){
		return "Request from " + clientName.toUpperCase() + ".";
	}
}//end GetRequest