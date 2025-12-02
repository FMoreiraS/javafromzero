package core.kenums.domain;

public enum FormOfPayment {

    CREDIT {
        @Override
        public double calcDiscount(double value) {
            double discountPercentage = 0.05;
            return value * discountPercentage;
        }
    },
    DEBT {
        @Override
        public double calcDiscount(double value) {
            double discountPercentage = 0.1;
            return value * discountPercentage;
        }
    };

    public double calcDiscount(double value) {return 0;}
}
