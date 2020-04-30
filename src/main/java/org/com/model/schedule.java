package org.com.model;

//import org.springframework.format.annotation.DateTimeFormat;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.GregorianCalendar;

@Entity
@Table(name = "schedule")
public class schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int scheduleId;

    private int cost;

    @OneToOne
    @JoinColumn(name = "Airport_Code_S")
    private airport sourceAirport;

    @OneToOne
    @JoinColumn(name = "Airport_Code_D")
    private airport destinationAirport;

    @Override
    public String toString() {
        return "schedule{" +
                "scheduleId=" + scheduleId +
                ", cost=" + cost +
                ", sourceAirport=" + sourceAirport +
                ", destinationAirport=" + destinationAirport +
                '}';
    }

    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public airport getSourceAirport() {
        return sourceAirport;
    }

    public void setSourceAirport(airport sourceAirport) {
        this.sourceAirport = sourceAirport;
    }

    public airport getDestinationAirport() {
        return destinationAirport;
    }

    public void setDestinationAirport(airport destinationAirport) {
        this.destinationAirport = destinationAirport;
    }
}