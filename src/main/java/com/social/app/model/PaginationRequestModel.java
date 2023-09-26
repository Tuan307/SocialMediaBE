package com.social.app.model;

import com.social.app.model.feature_authentication.User;

public class PaginationRequestModel {
    private int pageNumber;
    private int pageCount;

    private User user;
    public PaginationRequestModel(int pageNumber, int pageCount) {
        this.pageNumber = pageNumber;
        this.pageCount = pageCount;
    }

    public User getUser() {
        return user;
    }

    public void setObject(User object) {
        this.user = object;
    }

    public PaginationRequestModel(int pageNumber, int pageCount, User object) {
        this.pageNumber = pageNumber;
        this.pageCount = pageCount;
        this.user = object;
    }

    public PaginationRequestModel() {
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    @Override
    public String toString() {
        return "PaginationRequestModel{" +
                "pageNumber=" + pageNumber +
                ", pageCount=" + pageCount +
                '}';
    }
}
