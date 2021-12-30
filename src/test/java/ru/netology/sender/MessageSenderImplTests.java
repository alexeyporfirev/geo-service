package ru.netology.sender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

import java.util.HashMap;
import java.util.Map;

public class MessageSenderImplTests {

    @Test
    public void testSendMessageFromRussia() {
        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.123.12.19");

        GeoService geo = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geo.byIp("172.123.12.19")).thenReturn(new Location("Moscow", Country.RUSSIA, "Lenina", 15));

        LocalizationService local = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(local.locale(Country.RUSSIA)).thenReturn("Добро пожаловать");

        MessageSender sender = new MessageSenderImpl(geo, local);

        Assertions.assertEquals("Добро пожаловать", sender.send(headers));
    }

    @Test
    public void testSendMessageFromUSA() {
        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.123.12.19");

        GeoService geo = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geo.byIp("96.123.12.19")).thenReturn(new Location("New York", Country.USA, "Street", 15));

        LocalizationService local = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(local.locale(Country.USA)).thenReturn("Welcome");

        MessageSender sender = new MessageSenderImpl(geo, local);

        Assertions.assertEquals("Welcome", sender.send(headers));
    }

    @Test
    public void testSendMessageFromGermany() {
        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "77.123.12.19");

        GeoService geo = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geo.byIp("77.123.12.19")).thenReturn(new Location("Darmstadt", Country.GERMANY, "Karl-Marx", 25));

        LocalizationService local = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(local.locale(Country.GERMANY)).thenReturn("Welcome");

        MessageSender sender = new MessageSenderImpl(geo, local);

        Assertions.assertEquals("Welcome", sender.send(headers));
    }

    @Test
    public void testSendMessageFromBrazil() {
        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "111.123.12.19");

        GeoService geo = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geo.byIp("111.123.12.19")).thenReturn(new Location("Sao-Paolo", Country.BRAZIL, "Pele str", 1000));

        LocalizationService local = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(local.locale(Country.BRAZIL)).thenReturn("Welcome");

        MessageSender sender = new MessageSenderImpl(geo, local);

        Assertions.assertEquals("Welcome", sender.send(headers));
    }
}
