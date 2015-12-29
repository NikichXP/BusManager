package rest;

public class Error {

    private String error = "";

    public String getError() {
        return error;
    }

    public void setError(String errmsg) {
        this.error = errmsg;
    }

    public Error(String errmsg) {
        this.error = errmsg;
    }
}
