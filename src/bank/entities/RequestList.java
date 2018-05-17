package bank.entities;

import java.util.ArrayList;
import java.util.Arrays;

public class RequestList {

    public ArrayList<GetRequest> getmGetRequest() {
        return mGetRequest;
    }

    private ArrayList<GetRequest> mGetRequest = new ArrayList<>();

    public RequestList(GetRequest... requests) {
        mGetRequest = new ArrayList<>();
        mGetRequest.addAll(Arrays.asList(requests));
    }

    public void add(GetRequest gr){
        mGetRequest.add(gr);
    }
}//end RequestList