package model;

public class Year extends BaseModel{
    private String val;

    public Year() {}

    public Year(String val) {
        this.val = val;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }
}
