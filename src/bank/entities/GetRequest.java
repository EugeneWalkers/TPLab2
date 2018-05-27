package bank.entities;

import java.util.Objects;

public class GetRequest {

	public String getClientName() {
		return clientName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	private int id;
	private String clientName;
	private int value;

	public GetRequest(int id, String clientName, int value){
		this.id = id;
		this.clientName = clientName;
		this.value = value;
	}

	@Override
	public String toString(){
		return id + ":" + clientName + ":" + value;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetRequest request = (GetRequest) o;
        return id == request.id &&
                value == request.value &&
                Objects.equals(clientName, request.clientName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, clientName, value);
    }
}//end GetRequest