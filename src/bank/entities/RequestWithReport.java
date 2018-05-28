package bank.entities;

public class RequestWithReport {
    private final GetRequest request;
    private String report;
    private String userReport;
    private boolean isRedirectedToBankEmployee;
    private boolean isAcceptedFromBankEmployee;

    public RequestWithReport(GetRequest request,
                             boolean isRedirectedToBankEmployee,
                             boolean isAcceptedFromBankEmployee) {
        this.request = request;
        this.isRedirectedToBankEmployee = isRedirectedToBankEmployee;
        this.isAcceptedFromBankEmployee = isAcceptedFromBankEmployee;
    }

    public void setAcceptedFromBankEmployee(boolean acceptedFromBankEmployee) {
        isAcceptedFromBankEmployee = acceptedFromBankEmployee;
    }

    public void setReport(String report) {
        this.report = report;
    }
    public void setReports(String report, String ureport) {
        this.userReport = ureport;
        this.report = report;
    }
    public void setUserReport(String report) {
        this.userReport = report;
    }

    public String getReport() {
        return report;
    }
    public String getUserReport() {
        return userReport;
    }

    public boolean isAcceptedFromBankEmployee() {
        return isAcceptedFromBankEmployee;
    }

    public GetRequest getRequest() {
        return request;
    }

    public boolean isRedirectedToBankEmployee() {
        return isRedirectedToBankEmployee;
    }

    public void setRedirectedToBankEmployee(boolean redirectedToBankEmployee) {
        isRedirectedToBankEmployee = redirectedToBankEmployee;
    }
}
