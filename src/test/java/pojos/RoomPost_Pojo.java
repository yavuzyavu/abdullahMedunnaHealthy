package pojos;

public class RoomPost_Pojo {


           /* "price": 0,
            "roomNumber": 0,
            "roomType": "TWIN",
            "status": true

            */
    private int price;
    private int roomNumber;
    private String roomType;
    private boolean status;

    public RoomPost_Pojo(int price, int roomNumber, String roomType, boolean status) {
        this.price = price;
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.status = status;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public RoomPost_Pojo() {
    }

    @Override
    public String toString() {
        return "RoomPost_Pojo{" +
                "price=" + price +
                ", roomNumber=" + roomNumber +
                ", roomType='" + roomType + '\'' +
                ", status=" + status +
                '}';
    }
}
