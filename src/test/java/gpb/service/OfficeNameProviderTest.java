package gpb.service;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNull;


public class OfficeNameProviderTest {

    @Test
    public void getRandomOfficeFromFile() {
        String officesFile = this.getClass().getResource("/offices.test").getPath();
        OfficeNameProvider sut = new OfficeNameProvider(officesFile);
        assertThat(Arrays.asList("Office1", "Office2"), hasItem(sut.getRandomOffice()));
    }

    @Test
    public void getRandomOfficeReturnsNullIfFileIsAbsent() {
        OfficeNameProvider sut = new OfficeNameProvider("");
        assertNull(sut.getRandomOffice());
    }

}