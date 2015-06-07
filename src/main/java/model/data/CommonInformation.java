package model.data;

/**
 * Created by kehanyang on 15/5/31.
 */
public class CommonInformation {

    private String name = "";

    private String telephone = "";

    public CommonInformation(String name, String telephone) {
        this.name = name;
        this.telephone = telephone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
