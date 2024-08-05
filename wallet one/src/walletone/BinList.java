package walletone;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class BinList {

    public static final List<Integer> binNumbers = Arrays.asList(
            400229, 400344, 403444, 403694, 410608, 410673, 411507, 412174,
            414303, 414304, 414305, 414306, 414311, 414313, 414325, 414349,
            414356, 414358, 414359, 414360, 414361, 414362, 414381, 414382,
            414385, 414396, 414398, 414709, 415417, 415557, 419310, 423340,
            430572, 438800, 438805, 438806, 438810, 438814, 438860, 438861,
            438864, 438874, 438883, 438885, 438886, 438888, 479124, 480213,
            486201, 486236, 486240, 486241, 486242, 486243, 486245, 486249,
            486254, 486255, 486258, 486273, 486274, 486284, 486288, 486289,
            486291, 487333, 487334, 493109, 493422, 517805, 521506, 529107,
            529115, 529123, 529149, 529156, 529172, 546630, 552851, 552869,
            558958
    );

    public static String getRandomBinNumber() {
        Random random = new Random();
        int randomBinNumber = binNumbers.get(random.nextInt(binNumbers.size()));
        return String.valueOf(randomBinNumber);
    }

}
