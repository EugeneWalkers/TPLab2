package bank.entities;

import java.util.ArrayList;
import java.util.Arrays;

public class RequestList {

    public ArrayList<GetRequest> getmGetRequest() {
        return mGetRequest;
    }

    private ArrayList<GetRequest> mGetRequest;

    public RequestList(GetRequest... requests) {
        mGetRequest = new ArrayList<>();
        mGetRequest.addAll(Arrays.asList(requests));
    }
}//end RequestList