package bank.entities;

public class RequestWithReport {
    private final GetRequest request;
    private String report;
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

    public String getReport() {
        return report;
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
