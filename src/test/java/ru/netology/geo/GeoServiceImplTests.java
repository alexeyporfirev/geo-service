package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

public class GeoServiceImplTests {

    @ParameterizedTest
    @ValueSource(strings = {"172.0.32.11", "172.10.10.10", "172.12.34.56"})
    public void testByIpFromRussia(String ip) {
        Location loc = Mockito.mock(Location.class);
        Mockito.when(loc.getCountry()).thenReturn(Country.RUSSIA);
        GeoService geo = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geo.byIp(ip)).thenReturn(loc);

        Assertions.assertEquals(
                Country.RUSSIA,
                geo.byIp(ip).getCountry());
    }


    @ParameterizedTest
    @ValueSource(strings = {"96.123.12.19", "96.10.10.10", "96.12.34.56"})
    public void testByIpFromUSA(String ip) {
        Location loc = Mockito.mock(Location.class);
        Mockito.when(loc.getCountry()).thenReturn(Country.USA);
        GeoService geo = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geo.byIp(ip)).thenReturn(loc);

        Assertions.assertEquals(
                Country.USA,
                geo.byIp(ip).getCountry());
    }
}
