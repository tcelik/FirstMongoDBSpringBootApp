package org.csystem.firstmongobootapp.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "sensors")
public class SensorInfo {
    private String name;
    private double data;
    private String place;

    public SensorInfo()
    {

    }

    public SensorInfo(String name, double data, String place)
    {
        this.name = name;
        this.data = data;
        this.place = place;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public double getData()
    {
        return data;
    }

    public void setData(double data)
    {
        this.data = data;
    }

    public String getPlace()
    {
        return place;
    }

    public void setPlace(String place)
    {
        this.place = place;
    }
}
