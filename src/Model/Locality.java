package Model;

public class Locality {
    private String localityId;
    private Integer zipCode;
    private String name;

    public Locality(String localityId, Integer zipCode, String name) {
        this.localityId = localityId;
        this.zipCode = zipCode;
        this.name = name;
    }

    public String getLocalityId() {
        return localityId;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public String getName() {
        return name;
    }



}
