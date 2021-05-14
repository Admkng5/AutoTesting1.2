package com.google;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.Map;

public class Tests extends BaseTest {

    @Test
    public void googleSearchTestPO() {
        wd.get("https://www.google.com/");
        GoogleSecondPO googleSecondPO = new GoogleSecondPO(wd);
        googleSecondPO.googleSearch("Открытие");
        GoogleSecondAfterSearchPO googleSecondAfterSearchPO = new GoogleSecondAfterSearchPO(wd);
        List<WebElement> resultSearch = googleSecondAfterSearchPO.getResultSearch();
        Assertions.assertTrue(resultSearch.stream().anyMatch(x->x.getText()
                        .contains("www.open.ru")),"Не найдено");
        wd.get("https://www.open.ru");
        OpenBankPage openBankPage = new OpenBankPage(wd);

        List<Map<String,String >> collectExchangeRates = openBankPage.getCollectExchangeRates();
        System.out.println(collectExchangeRates);
        Assertions.assertTrue(
                Double.parseDouble(collectExchangeRates.stream()
                                .filter(x->x.get("Валюта обмена").contains("USD"))
                                .findFirst()
                                .get().get("Банк покупает").replace(",",".")
                )
                        <
                        Double.parseDouble(collectExchangeRates.stream()
                                        .filter(x->x.get("Валюта обмена").contains("EUR"))
                                        .findFirst()
                                        .get().get("Банк продает").replace(",",".")
                        )
        );
    }

}
