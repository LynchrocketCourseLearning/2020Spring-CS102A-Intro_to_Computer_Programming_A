public enum PhoneModel {
    IPHONE(9999),
    HUAWEI(8888),
    PIXEL(6666),
    SAMSUNG(9399),
    LG(5588);

    private int price;
    private String phone;
    public int getPrice() {
        return price;
    }
    public String getPhone(){
        return phone;
    }
    PhoneModel (int price){
        this.price = price;
    }

}
