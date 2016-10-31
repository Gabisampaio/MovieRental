/**
 * Created by Gabriela on 31/10/16.
 */
class ChildrensPrice extends Price{

    @Override
    int getPriceCode() {
        CHILDRENS
    }

    @Override
    double getCharge(int daysRented) {
        double amount = 1.5
        if (daysRented > 3)
            amount += (daysRented - 3) * 1.5
        amount
    }
}
