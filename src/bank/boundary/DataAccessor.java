package bank.boundary;

import bank.entities.GetRequest;
import bank.entities.RequestList;
import bank.entities.User;

import java.io.*;
import java.util.ArrayList;

public class DataAccessor {

    static RequestList list = new RequestList();

    private static int id = 0;

    public GetRequest getRequest(int id) {
        ArrayList<GetRequest> requests = list.getmGetRequest();
        for (GetRequest g :requests) {
            if (g.getId() == id){
                return g;
            }
        }
        return null;
    }

    void setRequest(String user, int value){
        ArrayList<GetRequest> requests = list.getmGetRequest();
        for (GetRequest request : requests) {
            if (request.getClientName().equals(user)) {
                request.setValue(value);
                break;
            }
        }
        rewriteUsers();
    }

    private void rewriteUsers(){
        FileWriter writer = null;
        try {
            writer = new FileWriter("waitingClients.txt", false);

            ArrayList<GetRequest> requests = list.getmGetRequest();
            for (int i=0; i<requests.size(); i++){
                writer.append(String.valueOf(requests.get(i).getId()))
                        .append(":")
                        .append(requests.get(i).getClientName()).append(":")
                        .append(String.valueOf(requests.get(i).getValue()))
                        .append("\n");
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    RequestList getRequestsForReview() {
        list.clear();
        StringBuilder builder = new StringBuilder();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("waitingClients.txt"));
            while (!builder.append(reader.readLine()).toString().equals("null")) {
                String[] temp = builder.toString().split(":");
                GetRequest request = new GetRequest(Integer.parseInt(temp[0]),
                        temp[1],
                        Integer.parseInt(temp[2]));
                list.add(request);
                builder.delete(0, builder.length());
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }

    public void getRequestsToBeIssued() {

    }

    public void saveRequest(GetRequest request) {

    }

    public boolean userExists(User user) {
        BufferedReader reader = null;
        StringBuilder buffer = new StringBuilder("");
        try {
            reader = new BufferedReader(new FileReader("logins.txt"));
            while (!buffer.append(reader.readLine()).toString().equals("null")) {
                String[] temp = buffer.toString().split(":");
                if (temp[0].equals(user.getName()) && temp[1].equals(user.getPassword())) {
                    user.setType(temp[2]);
                    return true;
                }
                buffer.delete(0, buffer.length());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    boolean writeToQueue(User user, int value) {
        FileWriter writer = null;
        try {
            id = getLastId() + 1;
            writer = new FileWriter("waitingClients.txt", true);
            writer.append(String.valueOf(id))
                    .append(":")
                    .append(user.getName()).append(":")
                    .append(String.valueOf(value))
                    .append("\n");
            return true;
        } catch (IOException e1) {
            e1.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return false;
    }

    private int getLastId(){
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("waitingClients.txt"));
            StringBuilder builder = new StringBuilder();
            while(!builder.append(reader.readLine()).toString().equals("null")){
                id = Integer.parseInt(builder.toString().split(":")[0]);
                builder.delete(0, builder.length());
            }
            return id;
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally{
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    boolean isUserInQueue(User user) {
        StringBuilder builder = new StringBuilder("");
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("waitingClients.txt"));
            while (!builder.append(reader.readLine()).toString().equals("null")) {
                if (builder.toString().split(":")[1].equals(user.getName())) {
                    return true;
                }
                builder.delete(0, builder.length());
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    if (!builder.toString().equals("null")) {
                        while (!builder.append(reader.readLine()).toString().equals("null")) {
                            String[] temp = builder.toString().split(":");
                            id = Integer.parseInt(temp[0]);
                            builder.delete(0, builder.length());
                        }
                    }
                    id++;
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return false;

    }
}