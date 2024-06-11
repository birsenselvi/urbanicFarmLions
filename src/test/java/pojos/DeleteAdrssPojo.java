package pojos;

public class DeleteAdrssPojo {

    private boolean success;
    private String descr;

    public DeleteAdrssPojo(boolean success, String descr) {
        this.success = success;
        this.descr = descr;
    }

    public DeleteAdrssPojo() {
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    @Override
    public String toString() {
        return "DeleteAdrssPojo{" +
                "success=" + success +
                ", descr='" + descr + '\'' +
                '}';
    }
}
