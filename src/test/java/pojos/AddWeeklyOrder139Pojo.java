package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddWeeklyOrder139Pojo implements Serializable {
    private String weeklyOrderId;
    private String title;
    private double subTotal;
    private int deliveryCost;
    private int tip;
    private String total;
    private String type;
    private List<Map>orders;

    public AddWeeklyOrder139Pojo(String weeklyOrderId, String title, double subTotal, int deliveryCost, int tip, String total, String type, List<Map> orders) {
        this.weeklyOrderId = weeklyOrderId;
        this.title = title;
        this.subTotal = subTotal;
        this.deliveryCost = deliveryCost;
        this.tip = tip;
        this.total = total;
        this.type = type;
        this.orders = orders;
    }

    public AddWeeklyOrder139Pojo() {
    }

    public String getWeeklyOrderId() {
        return weeklyOrderId;
    }

    public void setWeeklyOrderId(String weeklyOrderId) {
        this.weeklyOrderId = weeklyOrderId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public int getDeliveryCost() {
        return deliveryCost;
    }

    public void setDeliveryCost(int deliveryCost) {
        this.deliveryCost = deliveryCost;
    }

    public int getTip() {
        return tip;
    }

    public void setTip(int tip) {
        this.tip = tip;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Map> getOrders() {
        return orders;
    }

    public void setOrders(List<Map> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "AddWeeklyOrder{" +
                "weeklyOrderId='" + weeklyOrderId + '\'' +
                ", title='" + title + '\'' +
                ", subTotal=" + subTotal +
                ", deliveryCost=" + deliveryCost +
                ", tip=" + tip +
                ", total='" + total + '\'' +
                ", type='" + type + '\'' +
                ", orders=" + orders +
                '}';
    }
}
