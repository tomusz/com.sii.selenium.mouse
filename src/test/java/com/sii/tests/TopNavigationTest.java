package com.sii.tests;

import com.sii.consts.TestConstants;
import com.sii.pages.TopMenuPage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class TopNavigationTest extends BaseTest {


    @Test
    @Tag(TestConstants.REGRESSION)
    @Tag(TestConstants.NAVIGATION)
    public void childForNavigationElementShouldBeVisible() {
        TopMenuPage topMenuPage = new TopMenuPage(driver);
        topMenuPage.moveMoseToClothesCategory()
                .waitForClothesSubcategory()
                .moveMoseToAccessoriesCategory()
                .waitForAccessoriesSubcategory()
                .moveMoseToArtCategory();
    }

}
