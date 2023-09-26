package com.social.app.model;

public class ResponseResult {
    private Status status;
    private Object data;

    private int pageCount;

    private int page;

    public ResponseResult(Status status, Object data) {
        this.status = status;
        this.data = data;
    }

    public ResponseResult(Status status, Object data, int pageCount, int page) {
        this.status = status;
        this.data = data;
        this.pageCount = pageCount;
        this.page = page;
    }

    public ResponseResult() {
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "ResponseResult{" +
                "status=" + status +
                ", data=" + data +
                ", pageCount=" + pageCount +
                ", page=" + page +
                '}';
    }
}
