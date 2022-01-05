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

public class LocalizationServiceImplTests {

    @Test
    public void testLocaleRussia() {
        LocalizationServiceImpl localization = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(localization.locale(Country.RUSSIA)).thenReturn("Добро пожаловать");

        Assertions.assertEquals(
                "Добро пожаловать",
                localization.locale(Country.RUSSIA));
    }

    @ParameterizedTest
    @EnumSource(value = Country.class, names = {"USA", "BRAZIL", "GERMANY"})
    public void testLocaleForWelcome(Country country) {
        LocalizationServiceImpl localization = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(localization.locale(country)).thenReturn("Welcome");

        Assertions.assertEquals(
                "Welcome",
                localization.locale(country));
    }


}
