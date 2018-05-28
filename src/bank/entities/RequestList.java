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

    public void add(GetRequest gr) {
        mGetRequest.add(gr);
    }

    public void removeById(int id) {
        for (int i = 0; i < mGetRequest.size(); i++) {
            if (mGetRequest.get(i).getId() == id) {
                mGetRequest.remove(i);
                break;
            }
        }
    }

    public void clear() {
        mGetRequest.clear();
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (GetRequest request : mGetRequest) {
            builder.append(request.toString());
            builder.append("\n");
        }
        return builder.toString();
    }

    public void remove(GetRequest request){
        mGetRequest.remove(request);
    }
}//end RequestList