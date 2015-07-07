package gson;

/**
 * Created by Lars on 07.07.2015.
 */
public class geonames {
    public String getFcodeName() {
        return fcodeName;
    }

    public void setFcodeName(String fcodeName) {
        this.fcodeName = fcodeName;
    }

    public String getToponymName() {
        return toponymName;
    }

    public void setToponymName(String toponymName) {
        this.toponymName = toponymName;
    }

    public String getCountrycode() {
        return countrycode;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }

    public String getFcl() {
        return fcl;
    }

    public void setFcl(String fcl) {
        this.fcl = fcl;
    }

    public String getFclName() {
        return fclName;
    }

    public void setFclName(String fclName) {
        this.fclName = fclName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWikipedia() {
        return wikipedia;
    }

    public void setWikipedia(String wikipedia) {
        this.wikipedia = wikipedia;
    }

    public String getFcode() {
        return fcode;
    }

    public void setFcode(String fcode) {
        this.fcode = fcode;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getGeonameId() {
        return geonameId;
    }

    public void setGeonameId(double geonameId) {
        this.geonameId = geonameId;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String fcodeName, toponymName, countrycode, fcl, fclName, name, wikipedia, fcode;
    public double lng, geonameId, lat;
    public int population;

//    @Override
//    public int compareTo(geonames comparePop) {
//        int tempComparePop=comparePop.getPopulation();
//        /* For Ascending order*/
//        return this.population -  tempComparePop;
//
//        /* For Descending order do like this */
//        //return compareage-this.studentage;
//    }
}


