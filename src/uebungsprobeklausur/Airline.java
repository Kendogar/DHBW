package uebungsprobeklausur;

/**
 * Created by Lars Krakhecke on 01.10.2015.
 */
public class Airline {
    private String code, name;

    public Airline(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public Airline() {

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
