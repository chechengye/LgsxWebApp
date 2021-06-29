package com.lovecoding.vo;

import com.lovecoding.pojo.Product;

import java.util.List;

public class Page {

    private int currentPage;
    private int totalPages;
    private int maxCount;
    private List<Product> productList;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getMaxCount() {
        return maxCount;
    }

    public void setMaxCount(int maxCount) {
        this.maxCount = maxCount;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "Page{" +
                "currentPage=" + currentPage +
                ", totalPages=" + totalPages +
                ", maxCount=" + maxCount +
                ", productList=" + productList +
                '}';
    }
}
