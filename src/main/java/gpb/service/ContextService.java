package gpb.service;

public class ContextService {
    private String officesFileName;
    private int N;
    private String url;
    private String paymentsFileName;
    private boolean isValid = false;

    public ContextService(String[] args) {
        check(args);
        if (isValid)
            parseArguments(args);
    }

    public boolean isValid() {
        return isValid;
    }

    private void check(String[] args) {
        isValid = true;
        if (args.length < 4) {
            isValid = false;
            System.out.println("Usage  : java -jar payclient <offices filename> <num of payments> <payment url> <accepted payments filename>");
            System.out.println("Example: java -jar payclient offices.txt 100 http://example.com:3089/pay payments.txt");
        }
    }

    private void parseArguments(String[] args) {
        officesFileName = args[0];
        N = Integer.valueOf(args[1]);
        url = args[2];
        paymentsFileName = args[3];
    }

    public String getOfficesFileName() {
        return officesFileName;
    }

    public int getN() {
        return N;
    }

    public String getUrl() {
        return url;
    }
    public String getPaymentsFileName() {
        return paymentsFileName;
    }
}
