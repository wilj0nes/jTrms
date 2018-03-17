package DB_Objects;

import oracle.sql.DATE;

import java.sql.Blob;

public class Request {
    private int id;
    private DATE date; // this might not work

    private String city;
    private String state;
    private int zip;
    private float cost;
    private String format;
    private String justification;

    private int blobID;
    private Blob blob;

    private String status;
    private int ownerID;

    private String type;
    private int typeID;
    private String rejectionReason;

    public Request(int id,
                   String city,
                   String state,
                   int zip,
                   float cost,
                   String format,
                   String justification,
                   int blobID,
                   Blob blob,
                   String status,
                   int ownerID,
                   String type,
                   int typeID,
                   String rejectionReason){
        this.setId(id);
        this.setState(state);
        this.setZip(zip);
        this.setCost(cost);
        this.setFormat(format);
        this.setJustification(justification);
        this.setBlobID(blobID);
        this.setBlob(blob);
        this.setStatus(status);
        this.setOwnerID(ownerID);
        this.setType(type);
        this.setTypeID(typeID);
        this.setRejectionReason(rejectionReason);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DATE getDate() {
        return date;
    }

    public void setDate(DATE date) {
        this.date = date;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getJustification() {
        return justification;
    }

    public void setJustification(String justification) {
        this.justification = justification;
    }

    public int getBlobID() {
        return blobID;
    }

    public void setBlobID(int blobID) {
        this.blobID = blobID;
    }

    public Blob getBlob() {
        return blob;
    }

    public void setBlob(Blob blob) {
        this.blob = blob;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(int ownerID) {
        this.ownerID = ownerID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public String getRejectionReason() {
        return rejectionReason;
    }

    public void setRejectionReason(String rejectionReason) {
        this.rejectionReason = rejectionReason;
    }
}
