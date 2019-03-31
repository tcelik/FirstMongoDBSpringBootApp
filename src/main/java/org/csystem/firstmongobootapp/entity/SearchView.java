package org.csystem.firstmongobootapp.entity;

public class SearchView {
    private String itemName;

    public SearchView()
    {

    }

    public SearchView(String itemName) {
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
