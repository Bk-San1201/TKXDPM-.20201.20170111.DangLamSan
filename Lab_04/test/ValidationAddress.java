import controller.PlaceOrderController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.Assert.assertEquals;

public class ValidationAddress {
    private PlaceOrderController placeOrderController;

    @BeforeEach
    void setUp() throws Exception {
        placeOrderController = new PlaceOrderController();
    }

    @ParameterizedTest
    @CsvSource({
            "123 Wano Quoc,true",
            ",false",
            ",#12 san lee,false"
    })
    public void test(String address, boolean trueVal) {
        boolean boolVal = placeOrderController.validateAddress(address);
        assertEquals(trueVal, boolVal);
    }
}
