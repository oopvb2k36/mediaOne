package com.onemedia.control;

import java.util.Date;

/**
 * Created by PhamHai on 9/20/2016.
 */
public class Tag {

    public Tag(String code) {
        setCode(code);
    }

    @Override
    public boolean equals(Object obj) {
        return code.equals(((Tag)obj).getCode());
    }

    @Override
    public int hashCode() {
        return code.hashCode();
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setNote(String note) {
        this.note = note;
    }

    private String code;
    private String creator;
    private Date createdDate;
    private Date modifiedDate;
    private String note;
}
