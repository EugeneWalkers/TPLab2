package bank.boundary;

import bank.entities.*;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataAccessor {

    private static final String clientsQueue = "waitingClients.txt";
    private static final String clientsReport = "reports/report";
    private static final String fromClerkToReferent = "FromClerkToReferent.txt";
    private static final String metadata = "metadata.txt";
    private static final String creditDepartmentReportsMetadata = "Credit Reports/metadata.txt";
    private static final String creditDepartmentReports = "Credit Reports/";
    private static final String userReportsMetadata = "User reports/metadata.txt";
    private static final String userReports = "User reports/";

    private static RequestList clientListInQueue = new RequestList();

    private static int id = -1;

    static GetRequest getRequest(int id) {
        ArrayList<GetRequest> requests = clientListInQueue.getmGetRequest();
        for (GetRequest g : requests) {
            if (g.getId() == id) {
                return g;
            }
        }
        return null;
    }

    public static void setRequest(String user, int value) {
        ArrayList<GetRequest> requests = clientListInQueue.getmGetRequest();
        for (GetRequest request : requests) {
            if (request.getClientName().equals(user)) {
                request.setValue(value);
                break;
            }
        }
        rewriteUsers();
    }

    private static void rewriteUsers() {
        FileWriter writer = null;
        try {
            writer = new FileWriter(clientsQueue, false);

            ArrayList<GetRequest> requests = clientListInQueue.getmGetRequest();
            for (GetRequest request : requests) {
                writer.append(String.valueOf(request.getId()))
                        .append(":")
                        .append(request.getClientName()).append(":")
                        .append(String.valueOf(request.getValue()))
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

    public static RequestList getRequestsForReview() {
        clientListInQueue.clear();
        StringBuilder builder = new StringBuilder();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(clientsQueue));
            while (!builder.append(reader.readLine()).toString().equals("null")) {
                String[] temp = builder.toString().split(":");
                GetRequest request = new GetRequest(Integer.parseInt(temp[0]),
                        temp[1],
                        Integer.parseInt(temp[2]));
                clientListInQueue.add(request);
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
        return clientListInQueue;
    }

    static void getRequestsToBeIssued() {

    }

    public static String getReport(final String client) {
        final Map<String, String> map = new HashMap<>();
        final StringBuilder builder = new StringBuilder();
        StringBuilder path = new StringBuilder();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(creditDepartmentReportsMetadata));
            while (!builder.append(reader.readLine()).toString().equals("null")) {
                final String[] someClient = builder.toString().split(":");
                if (someClient[0].equals(client)){
                    path.append(someClient[1]);
                    builder.delete(0, builder.length());
                    break;
                }
                builder.delete(0, builder.length());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        reader = null;
        StringBuilder report = new StringBuilder("");
        StringBuilder temp = new StringBuilder();
        try {
            reader = new BufferedReader(new FileReader(creditDepartmentReports + path.toString() + ".txt"));
            while (!temp.append(reader.readLine()).toString().equals("null")){
                report.append(temp.toString());
                report.append("\n");
                temp.delete(0, temp.length());
            }
            return report.toString();
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
        return null;
    }

    public static String getUserReport(final String client) {
        final Map<String, String> map = new HashMap<>();
        final StringBuilder builder = new StringBuilder();
        StringBuilder path = new StringBuilder();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(userReportsMetadata));
            while (!builder.append(reader.readLine()).toString().equals("null")) {
                final String[] someClient = builder.toString().split(":");
                if (someClient[0].equals(client)){
                    path.append(someClient[1]);
                    builder.delete(0, builder.length());
                    break;
                }
                builder.delete(0, builder.length());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        reader = null;
        StringBuilder report = new StringBuilder("");
        StringBuilder temp = new StringBuilder();
        try {
            reader = new BufferedReader(new FileReader(userReports + path.toString() + ".txt"));
            while (!temp.append(reader.readLine()).toString().equals("null")){
                report.append(temp.toString());
                report.append("\n");
                temp.delete(0, temp.length());
            }
            return report.toString();
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
        return null;
    }
    public static String createUserReport(final String rep, final String client) {

        final StringBuilder builder = new StringBuilder();
        StringBuilder path = new StringBuilder();

        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(userReportsMetadata));
            boolean bool=true;
            ArrayList<String> somePaths = new ArrayList<>();
            ArrayList<String> someClients = new ArrayList<>();
            while (!builder.append(reader.readLine()).toString().equals("null")) {
                final String[] someClient = builder.toString().split(":");
                someClients.add(someClient[0]);
                somePaths.add(someClient[1]);
                if (someClient[0].equals(client)){
                    path.append(someClient[1]);
                    bool=!bool;
                    builder.delete(0, builder.length());
                    break;
                }
                builder.delete(0, builder.length());
            }
            if(bool){
                FileWriter fw = new FileWriter(userReportsMetadata);

                BufferedWriter out1 = new BufferedWriter(fw);
                for(int i=0;i<someClients.size();i++){

                    out1.append(someClients.get(i)).append(":").append(somePaths.get(i)).append("\n");
                }
                out1.append(client).append(":").append("report"+id);
                path=new StringBuilder(client);
                out1.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        File ff = new File(userReports + path.toString() + ".txt");
        if ((ff.exists())) {
            FileWriter fstream1 = null;
            try {
                fstream1 = new FileWriter(userReports + path.toString() + ".txt");

                BufferedWriter out1 = new BufferedWriter(fstream1);
                out1.write("");
                out1.append(rep);
                out1.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                ff.createNewFile();
                FileWriter fstream1 = null;
                try {
                    fstream1 = new FileWriter(userReports + path.toString() + ".txt");

                    BufferedWriter out1 = new BufferedWriter(fstream1);
                    out1.write("");
                    out1.append(rep);
                    out1.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    public static List<RequestWithReport> getRequestsForReferent() {
        final List<RequestWithReport> result = new ArrayList<>();
        final StringBuilder builder = new StringBuilder();
        try {
            final BufferedReader reader = new BufferedReader(new FileReader(fromClerkToReferent));
            while (!builder.append(reader.readLine()).toString().equals("null")) {
                final String[] temp = builder.toString().split(":");

                result.add(new RequestWithReport(
                        new GetRequest(Integer.parseInt(temp[0]),
                        temp[1],
                        Integer.parseInt(temp[2])),
                        Boolean.parseBoolean(temp[3]),
                        Boolean.parseBoolean(temp[4])
                ));
                builder.delete(0, builder.length());
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void sendCopyOfTheReportToBankEmployee(final GetRequest request) {
        List<RequestWithReport> requests = getRequestsForReferent();
        for (final RequestWithReport requestWithReport : requests) {
            if (requestWithReport.getRequest().equals(request)) {
                requestWithReport.setRedirectedToBankEmployee(true);
                break;
            }
        }
        try {
            final FileWriter writer = new FileWriter(fromClerkToReferent, false);
            writer.write("");
            for (final RequestWithReport requestWithReport : requests) {
                final GetRequest r = requestWithReport.getRequest();
                writer.append(String.valueOf(r.getId()))
                        .append(":").append(r.getClientName())
                        .append(":").append(String.valueOf(r.getValue()))
                        .append(":").append(String.valueOf(requestWithReport.isRedirectedToBankEmployee()))
                        .append(":").append(String.valueOf(requestWithReport.isAcceptedFromBankEmployee()))
                        .append("\n");
            }
            writer.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public static void acceptCopyOfTheReport(final GetRequest request) {
        List<RequestWithReport> requests = getRequestsForReferent();
        for (final RequestWithReport requestWithReport : requests) {
            if (requestWithReport.getRequest().equals(request)) {
                requestWithReport.setRedirectedToBankEmployee(false);
                requestWithReport.setAcceptedFromBankEmployee(true);
                break;
            }
        }
        try {
            final FileWriter writer = new FileWriter(fromClerkToReferent, false);
            writer.write("");
            for (final RequestWithReport requestWithReport : requests) {
                final GetRequest r = requestWithReport.getRequest();
                writer.append(String.valueOf(r.getId()))
                        .append(":").append(r.getClientName())
                        .append(":").append(String.valueOf(r.getValue()))
                        .append(":").append(String.valueOf(requestWithReport.isRedirectedToBankEmployee()))
                        .append(":").append(String.valueOf(requestWithReport.isAcceptedFromBankEmployee()))
                        .append("\n");
            }
            writer.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public static boolean saveRequest(GetRequest request) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(fromClerkToReferent, true);
            writer.append(String.valueOf(request.getId()))
                    .append(":").append(request.getClientName())
                    .append(":").append(String.valueOf(request.getValue()))
                    .append(":").append("false")
                    .append(":").append("false")
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
            clientListInQueue.remove(request);
            writeUsersInQueueFromList();
        }
        return false;
    }

    private static boolean writeUsersInQueueFromList(){
        FileWriter writer = null;
        try {
            writer = new FileWriter(clientsQueue, false);
            writer.write(clientListInQueue.toString());
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

    public static boolean userExists(User user) {
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

    static boolean writeToQueue(User user, int value) {
        FileWriter writer = null;
        try {
            id = getLastId() + 1;
            writer = new FileWriter(clientsQueue, true);
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

    private static int getLastId() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(metadata));
            id = Integer.parseInt(reader.readLine());
            return id;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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

    static boolean isUserInQueue(User user) {
        StringBuilder builder = new StringBuilder("");
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(clientsQueue));
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
                            builder.delete(0, builder.length());
                        }
                    }
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return false;

    }

    static int getIdByUsername(String username) {
        StringBuilder builder = new StringBuilder("");
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(clientsQueue));
            while (!builder.append(reader.readLine()).toString().equals("null")) {
                if (builder.toString().split(":")[1].equals(username)) {
                    return Integer.parseInt(builder.toString().split(":")[0]);
                }
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
        return -1;
    }

    static boolean writeReport(int id, String text) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(clientsReport + id, true);
            writer.append(text);
            writer.close();
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

    static boolean incrementId(){
        FileWriter writer = null;
        id = getLastId();
        try {
            writer = new FileWriter(metadata, false);
            writer.write(String.valueOf(id + 1));
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
}