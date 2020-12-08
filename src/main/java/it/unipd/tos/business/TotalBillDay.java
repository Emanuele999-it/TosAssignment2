////////////////////////////////////////////////////////////////////
// [EMANUELE] [PASE] [1201250]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business;

import java.util.List;
import java.time.LocalTime;

import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.User;

public class TotalBillDay {

    private User user;
    private LocalTime time;
    private double price;
    private List < MenuItem > list;
    
    public TotalBillDay(List < MenuItem > list, User user, LocalTime time, double price) {
        this.list = list;
        this.user = user;
        this.time = time;
        this.price = price;
    }

    public int getTime() {
        return ((time.getHour() * 60 * 60) + (time.getMinute() * 60) + time.getSecond());
    }

    public double getPrice() {
        return price;
    }

    public void changePrice(double p) {
        price = p;
    }

    
    public List < MenuItem > getList() {
        return list;
    }

    public User getUser() {
        return user;
    }

    
}