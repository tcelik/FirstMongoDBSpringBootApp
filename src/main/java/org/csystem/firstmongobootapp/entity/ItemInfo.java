package org.csystem.firstmongobootapp.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "items")
public class ItemInfo {
    private String name;
    private String [] color;
    private String where;


    public ItemInfo()
    {

    }

    public ItemInfo(String name, String[] color, String where)
    {
        this.name = name;
        this.color = color;
        this.where = where;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getColor() {
        return color;
    }

    public void setColor(String[] color) {
        this.color = color;
    }

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }
}
