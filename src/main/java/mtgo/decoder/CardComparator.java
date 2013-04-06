package mtgo.decoder;

import java.util.Comparator;

/**
 *
 * @author North
 */
class CardComparator implements Comparator<Card> {

    @Override
    public int compare(Card a, Card b) {
        int result = a.getSet().compareTo(b.getSet());
        if (result == 0) {
            int aNumber;
            int bNumber;
            try {
                aNumber = Integer.parseInt(a.getCardNo().split("/")[0]);
            } catch (Exception e) {
                return -1;
            }
            try {
                bNumber = Integer.parseInt(b.getCardNo().split("/")[0]);
            } catch (Exception e) {
                return 1;
            }
            return aNumber - bNumber;
        } else {
            return result;
        }
    }
}
