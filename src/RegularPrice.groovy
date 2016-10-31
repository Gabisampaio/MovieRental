/**
 * Created by Gabriela on 31/10/16.
 */
class RegularPrice extends Price{

    @Override
    int getPriceCode() {
        REGULAR
    }

    @Override
    double getCharge(int daysRented) {
        double amount = 2
        if (daysRented > 2)
            amount += (daysRented - 2) * 1.5
        amount
    }
}
