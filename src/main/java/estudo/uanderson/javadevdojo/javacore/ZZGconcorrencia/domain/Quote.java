package estudo.uanderson.javadevdojo.javacore.ZZGconcorrencia.domain;

//storeName:price:discountCode
public final class Quote {
    private final String storeName;
    private final double price;
    private final Discount.Code discountCode;

    public Quote(String storeName, double price, Discount.Code discountCode) {
        this.storeName = storeName;
        this.price = price;
        this.discountCode = discountCode;
    }

    /**
     * EN-US

     * Creates new Quote object from the value following the pattern storename:price:discount
     * @param value containing storeName:price:discountCode
     * @return new Quote with values from @param value
     *
     * PT-BR
     *   Cria um novo objeto Quote a partir do valor seguindo o padrão storename:price:discount
     *  @param value contendo storeName:price:discountCode
     *  @return nova cotação com valores do valor @param
     *
     */


    public static Quote newQuote(String value){
        String[] values = value.split(":");

        return new Quote(values[0], Double.parseDouble(values[1]), Discount.Code.valueOf(values[2]));

    }

    @Override
    public String toString() {
        return "Quote{" +
                "storeName='" + storeName + '\'' +
                ", price=" + price +
                ", discountCode=" + discountCode +
                '}';
    }

    public String getStoreName() {
        return storeName;
    }

    public double getPrice() {
        return price;
    }

    public Discount.Code getDiscountCode() {
        return discountCode;
    }
}//class



