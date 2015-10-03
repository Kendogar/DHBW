package uebungsprobeklausur;

/**
 * Created by Lars Krakhecke on 01.10.2015.
 */
public class Destination {
    private String name, ortsname, code;

    public Destination(String name, String ortsname, String code) {
        this.name = name;
        this.ortsname = ortsname;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrtsname() {
        return ortsname;
    }

    public void setOrtsname(String ortsname) {
        this.ortsname = ortsname;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
