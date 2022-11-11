package model.classes;
import model.enums.MovieTag;

public class ReceiptItem {
    private String ticketType;
    private Double price;
    private MovieTag movietag;

    public ReceiptItem(String ticketType, Double price, MovieTag movietag) {
        this.ticketType = ticketType;
        this.price = price;
        this.movietag = movietag;
    }
    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public MovieTag getMovietag() {
        return movietag;
    }

    public void setMovietag(MovieTag movietag) {
        this.movietag = movietag;
    }
}
