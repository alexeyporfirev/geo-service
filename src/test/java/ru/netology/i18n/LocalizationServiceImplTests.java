package ru.netology.i18n;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LocalizationServiceImplTests {

    @Test
    public void testLocaleRussia() {
        LocalizationService local =  new LocalizationServiceImpl();
        String expected = local.locale(Country.RUSSIA);
        //act
        String result = "Добро пожаловать";
        //assert
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @EnumSource(value = Country.class, names = {"USA", "BRAZIL", "GERMANY"})
    public void testLocaleForWelcome(Country country) {
        LocalizationService local = new LocalizationServiceImpl();
        String expected = local.locale(country);
        //act
        String result = "Welcome";
        //assert
        assertEquals(expected, result);
    }
}
