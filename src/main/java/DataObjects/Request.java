package DataObjects;

import oracle.sql.DATE;

import java.sql.Blob;

public class Request {
    private int id;
    private DATE date; // this might not work

    private String address;
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
    private String description;

    public Request(int id,
                   String address,
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
                   String rejectionReason,
                   String description){
        this.setId(id);
        this.setAddress(address);
        this.setCity(city);
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
        this.setDescription(description);
    }

    public Request(){};


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress(){
        return this.address;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public DATE getDate() {
        return this.date;
    }

    public void setDate(DATE date) {
        this.date = date;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZip() {
        return this.zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public float getCost() {
        return this.cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public String getFormat() {
        return this.format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getJustification() {
        return this.justification;
    }

    public void setJustification(String justification) {
        this.justification = justification;
    }

    public int getBlobID() {
        return this.blobID;
    }

    public void setBlobID(int blobID) {
        this.blobID = blobID;
    }

    public Blob getBlob() {
        return this.blob;
    }

    public void setBlob(Blob blob) {
        this.blob = blob;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getOwnerID() {
        return this.ownerID;
    }

    public void setOwnerID(int ownerID) {
        this.ownerID = ownerID;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getTypeID() {
        return this.typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public String getRejectionReason() {
        return this.rejectionReason;
    }

    public void setRejectionReason(String rejectionReason) {
        this.rejectionReason = rejectionReason;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Request{" +
                "id=" + id +
                ", date=" + date +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip=" + zip +
                ", cost=" + cost +
                ", format='" + format + '\'' +
                ", justification='" + justification + '\'' +
                ", blobID=" + blobID +
                ", blob=" + blob +
                ", status='" + status + '\'' +
                ", ownerID=" + ownerID +
                ", type='" + type + '\'' +
                ", typeID=" + typeID +
                ", rejectionReason='" + rejectionReason + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
