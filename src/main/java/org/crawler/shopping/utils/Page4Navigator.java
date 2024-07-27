package org.crawler.shopping.utils;

import org.springframework.data.domain.Page;

import java.util.Arrays;
import java.util.List;

public class Page4Navigator<T> {
    //private static final long serialVersionUID = -3720998571176536865L;
    Page<T> pageFromJPA;
   private int navigatePages;
    private int totalPages;
    private int number;
    private long totalElements;
    private int size;
    private int numberOfElements;
    private List<T> content;
    private boolean HasContent;
    private boolean first;
    private boolean last;
    private boolean HasNext;
    private boolean HasPrevious;

    private int [] navigatePageNums;
    public Page4Navigator(){
    }
    public Page4Navigator(Page<T> pageFromJPA, int navigatePages){
        this.pageFromJPA = pageFromJPA;
        this.navigatePages = navigatePages;
        totalPages = pageFromJPA.getTotalPages();
        number = pageFromJPA.getNumber();
        totalElements = pageFromJPA.getTotalElements();
        size = pageFromJPA.getSize();
        numberOfElements = pageFromJPA.getNumberOfElements();
        content = pageFromJPA.getContent();
        HasContent = pageFromJPA.hasContent();
        first = pageFromJPA.isFirst();
        last = pageFromJPA.isLast();
        HasNext = pageFromJPA.hasNext();
        HasContent = pageFromJPA.hasContent();
        HasPrevious = pageFromJPA.hasPrevious();
        calcNavigatePageNums();
    }

    private void calcNavigatePageNums() {
        int navigatePageNums[];
        int totalPages = getTotalPages();
        int num = getNumber();
        if(totalPages <= navigatePages){
            navigatePageNums = new int[totalPages];
            for(int i=0;i<totalPages;i++){
                navigatePageNums[i] = i+1;
            }
        }else{
            navigatePageNums = new int[navigatePages];
            int startNum = num-navigatePages/2;
            int endNum = num+navigatePages/2;
            if(startNum<1){
                startNum=1;
                for(int i=0;i<navigatePages;i++){
                    navigatePageNums[i] = startNum++;
                }
            }else if (endNum>totalPages){
                endNum = totalPages;
                for(int i=navigatePages-1;i>=0;i--){
                    navigatePageNums[i] = endNum--;
                }
            }else{
                for(int i=0;i<navigatePages;i++){
                    navigatePageNums[i] = startNum++;
                }
            }
        }
        this.navigatePageNums = navigatePageNums;
    }

    public int getNavigatePages() {
        return navigatePages;
    }

    public void setNavigatePages(int navigatePages) {
        this.navigatePages = navigatePages;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }

    public void setNumberOfElements(int numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public boolean isHasContent() {
        return HasContent;
    }

    public void setHasContent(boolean hasContent) {
        HasContent = hasContent;
    }

    public boolean isFirst() {
        return first;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }

    public boolean isLast() {
        return last;
    }

    public void setLast(boolean last) {
        this.last = last;
    }

    public boolean isHasNext() {
        return HasNext;
    }

    public void setHasNext(boolean hasNext) {
        HasNext = hasNext;
    }

    public boolean isHasPrevious() {
        return HasPrevious;
    }

    public void setHasPrevious(boolean hasPrevious) {
        HasPrevious = hasPrevious;
    }


    public int[] getNavigatePageNums() {
        return navigatePageNums;
    }

    public void setNavigatePageNums(int[] navigatePageNums) {
        this.navigatePageNums = navigatePageNums;
    }
    @Override
    public String toString() {
        return "Page4Navigator{" +
                "pageFromJPA=" + pageFromJPA +
                ", navigatePages=" + navigatePages +
                ", totalPages=" + totalPages +
                ", number=" + number +
                ", totalElements=" + totalElements +
                ", size=" + size +
                ", numberOfElements=" + numberOfElements +
                ", content=" + content +
                ", isHasContent=" + HasContent +
                ", first=" + first +
                ", last=" + last +
                ", isHasNext=" + HasNext +
                ", isHasPrevious=" + HasPrevious +
                ", navigatepageNums=" + Arrays.toString(navigatePageNums) +
                '}';
    }
}


