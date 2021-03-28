
package com.technight.myrestaurants.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.technight.myrestaurants.models.Center;

public class Region {

    @SerializedName("center")
    @Expose
    private Center center;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Region() {
    }

    /**
     * 
     * @param center
     */
    public Region(Center center) {
        super();
        this.center = center;
    }

    public Center getCenter() {
        return center;
    }

    public void setCenter(Center center) {
        this.center = center;
    }

}
