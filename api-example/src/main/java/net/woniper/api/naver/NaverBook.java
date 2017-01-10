package net.woniper.api.naver;

import java.util.List;

/**
 * Created by woniper on 2017. 1. 10..
 */
public class NaverBook {

    private String lastBuildDate;
    private int total;
    private int start;
    private int display;
    private List<Item> items;

    public String getLastBuildDate() {
        return lastBuildDate;
    }

    public NaverBook setLastBuildDate(String lastBuildDate) {
        this.lastBuildDate = lastBuildDate;
        return this;
    }

    public int getTotal() {
        return total;
    }

    public NaverBook setTotal(int total) {
        this.total = total;
        return this;
    }

    public int getStart() {
        return start;
    }

    public NaverBook setStart(int start) {
        this.start = start;
        return this;
    }

    public int getDisplay() {
        return display;
    }

    public NaverBook setDisplay(int display) {
        this.display = display;
        return this;
    }

    public List<Item> getItems() {
        return items;
    }

    public NaverBook setItems(List<Item> items) {
        this.items = items;
        return this;
    }

    @Override
    public String toString() {
        return "NaverBook{" +
                "lastBuildDate='" + lastBuildDate + '\'' +
                ", total=" + total +
                ", start=" + start +
                ", display=" + display +
                '}';
    }

    public static class Item {
        private String title;
        private String link;
        private String image;
        private String author;
        private String price;
        private String discount;
        private String publisher;
        private String pubdate;
        private String isbn;
        private String description;

        public String getTitle() {
            return title;
        }

        public Item setTitle(String title) {
            this.title = title;
            return this;
        }

        public String getLink() {
            return link;
        }

        public Item setLink(String link) {
            this.link = link;
            return this;
        }

        public String getImage() {
            return image;
        }

        public Item setImage(String image) {
            this.image = image;
            return this;
        }

        public String getAuthor() {
            return author;
        }

        public Item setAuthor(String author) {
            this.author = author;
            return this;
        }

        public String getPrice() {
            return price;
        }

        public Item setPrice(String price) {
            this.price = price;
            return this;
        }

        public String getDiscount() {
            return discount;
        }

        public Item setDiscount(String discount) {
            this.discount = discount;
            return this;
        }

        public String getPublisher() {
            return publisher;
        }

        public Item setPublisher(String publisher) {
            this.publisher = publisher;
            return this;
        }

        public String getPubdate() {
            return pubdate;
        }

        public Item setPubdate(String pubdate) {
            this.pubdate = pubdate;
            return this;
        }

        public String getIsbn() {
            return isbn;
        }

        public Item setIsbn(String isbn) {
            this.isbn = isbn;
            return this;
        }

        public String getDescription() {
            return description;
        }

        public Item setDescription(String description) {
            this.description = description;
            return this;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "title='" + title + '\'' +
                    ", link='" + link + '\'' +
                    ", image='" + image + '\'' +
                    ", author='" + author + '\'' +
                    ", price='" + price + '\'' +
                    ", discount='" + discount + '\'' +
                    ", publisher='" + publisher + '\'' +
                    ", pubdate='" + pubdate + '\'' +
                    ", isbn='" + isbn + '\'' +
                    ", description='" + description + '\'' +
                    '}';
        }
    }
}
