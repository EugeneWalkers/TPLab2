package bank.entities;

public class RequestWithReport {
    private final GetRequest request;
    private Report report;
    private boolean isAcceptedFromBankEmployee;

    public RequestWithReport(GetRequest request, boolean isAcceptedFromBankEmployee) {
        this.request = request;
        this.isAcceptedFromBankEmployee = isAcceptedFromBankEmployee;
    }

    public void setAcceptedFromBankEmployee(boolean acceptedFromBankEmployee) {
        isAcceptedFromBankEmployee = acceptedFromBankEmployee;
    }

    public void setReport(Report report) {
        this.report = report;
    }

    public Report getReport() {
        return report;
    }

    public boolean isAcceptedFromBankEmployee() {
        return isAcceptedFromBankEmployee;
    }

    public GetRequest getRequest() {
        return request;
    }
}
