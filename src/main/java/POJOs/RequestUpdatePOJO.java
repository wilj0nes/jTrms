package POJOs;

public class RequestUpdatePOJO {
    private int id;
    private String status;
    private String rejectionReason;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRejectionReason() {
        return rejectionReason;
    }

    public void setRejectionReason(String rejectionReason) {
        this.rejectionReason = rejectionReason;
    }

    @Override
    public String toString() {
        return "RequestUpdatePOJO{" +
                "status='" + status + '\'' +
                ", rejectionReason='" + rejectionReason + '\'' +
                '}';
    }
}
