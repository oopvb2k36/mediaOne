package com.onemedia.control;

/**
 * Created by PhamHai on 9/20/2016.
 */
public class Provider {

    public Provider(Tag tag, String name) {
        setTag(tag);
        setName(name);
    }

    @Override
    public boolean equals(Object obj) {
        return tag.equals(((Provider)(obj)).getTag());
    }

    @Override
    public int hashCode() {
        return tag.hashCode();
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public Tag getTag() {
        return tag;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private Tag tag;
    private String name;
    private String address;
}
