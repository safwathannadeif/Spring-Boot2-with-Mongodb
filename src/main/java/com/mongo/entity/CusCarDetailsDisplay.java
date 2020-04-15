package com.mongo.entity;
import java.util.List;
import java.util.stream.Collectors;
public class CusCarDetailsDisplay {
    private String name;
    private String cusId;
    List<CusCarDetailsElmDisplay>  cusCarDetailsElmListDisplay ;
    public CusCarDetailsDisplay() {
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCusId() {
        return cusId;
    }
    public void setCusId(String cusId) {
        this.cusId = cusId;
    }
    public List<CusCarDetailsElmDisplay> getCusCarDetailsElmListDisplay() {
        return cusCarDetailsElmListDisplay;
    }
    public void setCusCarDetailsElmListDisplay(List<CusCarDetailsElmDisplay> cusCarDetailsElmListDisplay) {
        this.cusCarDetailsElmListDisplay = cusCarDetailsElmListDisplay;
    }
    @Override
    public String toString() {
        String strOfelms = cusCarDetailsElmListDisplay.stream().map(elm-> elm.toString()).collect(Collectors.joining("\n\t")) ;
        return "CusCarDetailsDisplay{" +
                "name='" + name + '\'' +
                ", cusId='" + cusId + '\'' +
                ", cusCarDetailsElmListDisplay=\n\t" + strOfelms +
                '}';
    }
}
