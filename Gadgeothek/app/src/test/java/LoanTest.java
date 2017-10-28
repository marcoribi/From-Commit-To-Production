import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import ch.hsr.mge.gadgeothek.domain.Gadget;
import ch.hsr.mge.gadgeothek.domain.Loan;

/**
 * Created by marcoribi on 28.10.17.
 */

public class LoanTest {
    @Test
    public void testGadgetIsLent() {
        Gadget gadget = new Gadget("Device");

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2017);
        calendar.set(Calendar.MONTH, 9);
        calendar.set(Calendar.DAY_OF_MONTH, 10);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        Loan loan = new Loan("1", gadget, calendar.getTime(), null);

        Assert.assertThat(loan.isLent(), Is.is(false));
    }
}
