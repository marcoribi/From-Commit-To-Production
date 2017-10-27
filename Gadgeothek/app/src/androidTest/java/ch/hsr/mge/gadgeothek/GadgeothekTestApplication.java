package ch.hsr.mge.gadgeothek;

import ch.hsr.mge.gadgeothek.http.MockedHttpClient;
import ch.hsr.mge.gadgeothek.service.LibraryService;

public class GadgeothekTestApplication extends GadgeothekApplication {

    public static MockedHttpClient mockedHttpClient;

    @Override
    protected LibraryService createLibraryService(String url) {
        mockedHttpClient = new MockedHttpClient();
        return new LibraryService(url, mockedHttpClient);
    }
}
