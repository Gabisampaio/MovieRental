/**
 * Created by Gabriela on 31/10/16.
 */
class NewReleasePrice extends Price{

    @Override
    int getPriceCode() {
        NEW_RELEASE
    }

    @Override
    double getCharge(int daysRented) {
        daysRented * 3
    }

    int getPoints(int daysRented){
        (daysRented > 1) ? 2 : 1
    }
}
