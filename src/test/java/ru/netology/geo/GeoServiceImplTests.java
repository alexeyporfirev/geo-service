package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GeoServiceImplTests {

    @ParameterizedTest
    @ValueSource(strings = {"172.0.32.11", "172.10.10.10", "172.12.34.56"})
    public void testByIpFromRussia(String ip) {
        GeoService geo =  new GeoServiceImpl();
        Country expected = Country.RUSSIA;
        //act
        Country result = geo.byIp(ip).getCountry();
        //assert
        assertEquals(expected, result);
    }


    @ParameterizedTest
    @ValueSource(strings = {"96.123.12.19", "96.10.10.10", "96.12.34.56"})
    public void testByIpFromUSA(String ip) {
        GeoService geo =  new GeoServiceImpl();
        Country expected = Country.USA;
        //act
        Country result = geo.byIp(ip).getCountry();
        //assert
        assertEquals(expected, result);
    }

    @Test
    public void testByIpFromLocalhost() {
        GeoService geo =  new GeoServiceImpl();
        Country expected = null;
        //act
        Country result = geo.byIp("127.0.0.1").getCountry();
        //assert
        assertEquals(expected, result);
    }
}
