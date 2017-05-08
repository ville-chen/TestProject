package com.selenium;

import com.alibaba.fastjson.JSON;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2017/5/8.
 */
public class PageCollector {
    public static void main(String[] args) {
        String urlSeedJson = "[{\"applicationKey\":\"5e684998342b40f9b2ce9543befdec51\",\"createBy\":\"57a39f2ce4b0e454e2210357\",\"createDate\":1490962376000,\"createName\":\"dev\",\"createRoleIds\":\"57a39f2ce4b0e454e2210352\",\"dataType\":\"STRING\",\"elementAttr\":\"\",\"error\":false,\"exception\":false,\"failure\":false,\"i18n\":{},\"id\":\"58de47c877c8bd67cb88b46c\",\"ifDeleted\":false,\"ifNull\":false,\"ifOld\":false,\"isArray\":false,\"isDel\":false,\"key\":\"name\",\"modifyBy\":\"57a39f2ce4b0e454e2210357\",\"modifyDate\":1490962376000,\"modifyName\":\"dev\",\"modifyRoleIds\":\"57a39f2ce4b0e454e2210352\",\"msg\":\"\",\"name\":\"产品名\",\"resultReplaces\":\"\",\"selector\":\"#mod-detail-title .d-title\",\"success\":true,\"type\":\"CSS\",\"urlSeedId\":\"58de431a77c8bd67cb88b46b\",\"version\":1},{\"applicationKey\":\"5e684998342b40f9b2ce9543befdec51\",\"createBy\":\"57a39f2ce4b0e454e2210357\",\"createDate\":1493274785000,\"createName\":\"dev\",\"createRoleIds\":\"57a39f2ce4b0e454e2210352\",\"dataType\":\"BIG_DECIMAL\",\"elementAttr\":\"\",\"error\":false,\"exception\":false,\"failure\":false,\"i18n\":{},\"id\":\"590190a10cf2815767a538f9\",\"ifDeleted\":false,\"ifNull\":false,\"ifOld\":false,\"isArray\":false,\"isDel\":false,\"key\":\"productPrice\",\"modifyBy\":\"57a39f2ce4b0e454e2210357\",\"modifyDate\":1494042267000,\"modifyName\":\"dev\",\"modifyRoleIds\":\"57a39f2ce4b0e454e2210352\",\"msg\":\"\",\"name\":\"价格\",\"resultReplaces\":\"\",\"selector\":\".price .value\",\"success\":true,\"type\":\"CSS\",\"urlSeedId\":\"58de431a77c8bd67cb88b46b\",\"version\":4},{\"applicationKey\":\"5e684998342b40f9b2ce9543befdec51\",\"createBy\":\"57a39f2ce4b0e454e2210357\",\"createDate\":1493285259000,\"createName\":\"dev\",\"createRoleIds\":\"57a39f2ce4b0e454e2210352\",\"dataType\":\"STRING\",\"elementAttr\":\"\",\"error\":false,\"exception\":false,\"failure\":false,\"i18n\":{},\"id\":\"5901b98b7cea79c2e0c00883\",\"ifDeleted\":false,\"ifNull\":false,\"ifOld\":false,\"isArray\":false,\"isDel\":false,\"key\":\"description\",\"modifyBy\":\"57a39f2ce4b0e454e2210357\",\"modifyDate\":1493285259000,\"modifyName\":\"dev\",\"modifyRoleIds\":\"57a39f2ce4b0e454e2210352\",\"msg\":\"\",\"name\":\"描述\",\"resultReplaces\":\"\",\"selector\":\"mod-detail-attributes\",\"success\":true,\"type\":\"ID\",\"urlSeedId\":\"58de431a77c8bd67cb88b46b\",\"version\":1},{\"applicationKey\":\"5e684998342b40f9b2ce9543befdec51\",\"createBy\":\"57a39f2ce4b0e454e2210357\",\"createDate\":1493285308000,\"createName\":\"dev\",\"createRoleIds\":\"57a39f2ce4b0e454e2210352\",\"dataType\":\"STRING\",\"elementAttr\":\"src\",\"error\":false,\"exception\":false,\"failure\":false,\"i18n\":{},\"id\":\"5901b9bb7cea79c2e0c00884\",\"ifDeleted\":false,\"ifNull\":false,\"ifOld\":false,\"isArray\":false,\"isDel\":false,\"key\":\"mainImageUrl\",\"modifyBy\":\"57a39f2ce4b0e454e2210357\",\"modifyDate\":1493285571000,\"modifyName\":\"dev\",\"modifyRoleIds\":\"57a39f2ce4b0e454e2210352\",\"msg\":\"\",\"name\":\"主图\",\"resultReplaces\":\"\",\"selector\":\".box-img img\",\"success\":true,\"type\":\"CSS\",\"urlSeedId\":\"58de431a77c8bd67cb88b46b\",\"version\":2},{\"applicationKey\":\"5e684998342b40f9b2ce9543befdec51\",\"createBy\":\"57a39f2ce4b0e454e2210357\",\"createDate\":1493285376000,\"createName\":\"dev\",\"createRoleIds\":\"57a39f2ce4b0e454e2210352\",\"dataType\":\"STRING\",\"elementAttr\":\"data-lazy-src\",\"error\":false,\"exception\":false,\"failure\":false,\"i18n\":{},\"id\":\"5901ba007cea79c2e0c00885\",\"ifDeleted\":false,\"ifNull\":false,\"ifOld\":false,\"isArray\":true,\"isDel\":false,\"key\":\"productImageUrls\",\"modifyBy\":\"57a39f2ce4b0e454e2210357\",\"modifyDate\":1493988902000,\"modifyName\":\"dev\",\"modifyRoleIds\":\"57a39f2ce4b0e454e2210352\",\"msg\":\"\",\"name\":\"附图\",\"resultReplaces\":\".60x60.jpg=.jpg\",\"selector\":\".tab-content-container .box-img img\",\"success\":true,\"type\":\"CSS\",\"urlSeedId\":\"58de431a77c8bd67cb88b46b\",\"version\":11},{\"applicationKey\":\"5e684998342b40f9b2ce9543befdec51\",\"createBy\":\"57a39f2ce4b0e454e2210357\",\"createDate\":1493885948000,\"createName\":\"dev\",\"createRoleIds\":\"57a39f2ce4b0e454e2210352\",\"dataType\":\"STRING\",\"elementAttr\":\"src\",\"error\":false,\"exception\":false,\"failure\":false,\"i18n\":{},\"id\":\"590ae3fb0cf2718796a227b3\",\"ifDeleted\":false,\"ifNull\":false,\"ifOld\":false,\"isArray\":true,\"isDel\":false,\"key\":\"productImageUrls\",\"modifyBy\":\"57a39f2ce4b0e454e2210357\",\"modifyDate\":1493886594000,\"modifyName\":\"dev\",\"modifyRoleIds\":\"57a39f2ce4b0e454e2210352\",\"msg\":\"\",\"name\":\"附图\",\"resultReplaces\":\".32x32.jpg=.jpg\",\"selector\":\".list-leading .box-img img\",\"success\":true,\"type\":\"CSS\",\"urlSeedId\":\"58de431a77c8bd67cb88b46b\",\"version\":5},{\"applicationKey\":\"5e684998342b40f9b2ce9543befdec51\",\"createBy\":\"57a39f2ce4b0e454e2210357\",\"createDate\":1493886073000,\"createName\":\"dev\",\"createRoleIds\":\"57a39f2ce4b0e454e2210352\",\"dataType\":\"STRING\",\"elementAttr\":\"src\",\"error\":false,\"exception\":false,\"failure\":false,\"i18n\":{},\"id\":\"590ae4790cf2718796a227b4\",\"ifDeleted\":false,\"ifNull\":false,\"ifOld\":false,\"isArray\":true,\"isDel\":false,\"key\":\"productImageUrls\",\"modifyBy\":\"57a39f2ce4b0e454e2210357\",\"modifyDate\":1493993060000,\"modifyName\":\"dev\",\"modifyRoleIds\":\"57a39f2ce4b0e454e2210352\",\"msg\":\"\",\"name\":\"附图\",\"resultReplaces\":\"\",\"selector\":\"#mod-detail-description img\",\"success\":true,\"type\":\"CSS\",\"urlSeedId\":\"58de431a77c8bd67cb88b46b\",\"version\":9}]\n";
        System.setProperty("webdriver.chrome.driver", "D:/developer/Python36/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        Map<String, Object> result = singleCollector("https://detail.1688.com/offer/547548706882.html", urlSeedJson, driver);
        driver.close();
        driver.quit();

    }

    public static Map<String, Object> singleCollector(String url, String urlSeedJson, WebDriver driver) {
        Map<String, Object> map = new HashedMap();
        try {
            List<PageExtractSelectorDto> pageExtractSelectorDtos = JSON.parseArray(urlSeedJson, PageExtractSelectorDto.class);

            if (CollectionUtils.isNotEmpty(pageExtractSelectorDtos)) {

                driver.get(url);
                ((JavascriptExecutor) driver).executeScript(webDriverJs());

                //System.out.println(driver.getPageSource());

                for (PageExtractSelectorDto pageExtractSelectorDto : pageExtractSelectorDtos) {
                    DataType dataType = DataType.valueOf(pageExtractSelectorDto.getDataType());
                    PageExtractSelectorType pageExtractSelectorType = PageExtractSelectorType.valueOf(pageExtractSelectorDto.getType());
                    String elementAttr = pageExtractSelectorDto.getElementAttr();
                    //aa,bb=cc,dd
                    String[] searchs = null, replaces = null;
                    if (StringUtils.isNotBlank(pageExtractSelectorDto.getResultReplaces())) {
                        String[] resultReplaces = StringUtils.split(pageExtractSelectorDto.getResultReplaces(), "=");
                        searchs = StringUtils.split(resultReplaces[0], ",");
                        replaces = StringUtils.split(resultReplaces[1], ",");
                    }
                    By by;
                    switch (pageExtractSelectorType) {
                        case ID:
                            by = By.id(pageExtractSelectorDto.getSelector());
                            break;
                        case CLAZZ:
                            by = By.className(pageExtractSelectorDto.getSelector());
                            break;
                        case XPATH:
                            by = By.xpath(pageExtractSelectorDto.getSelector());
                            break;
                        case CSS:
                            by = By.cssSelector(pageExtractSelectorDto.getSelector());
                            break;
                        default:
                            by = By.cssSelector(pageExtractSelectorDto.getSelector());
                    }
                    if (pageExtractSelectorDto.getIsArray()) {
                        List<WebElement> elements = driver.findElements(by);
                        List<Object> values = new ArrayList();
                        for (WebElement element : elements) {
                            String val;
                            if (StringUtils.isNotBlank(elementAttr)) {
                                val = element.getAttribute(elementAttr);
                            } else {
                                val = element.getText();
                            }
                            Object value;
                            switch (dataType) {
                                case INTEGER:
                                    value = new Integer(val);
                                    break;
                                case DOUBLE:
                                    value = new Double(val);
                                    break;
                                case BIG_DECIMAL:
                                    value = new BigDecimal(val);
                                    break;
                                case STRING:
                                    if (searchs != null && replaces != null) {
                                        value = StringUtils.replaceEach(val, searchs, replaces);
                                    } else {
                                        value = val;
                                    }
                                    break;
                                default:
                                    value = val;
                            }
                            if (StringUtils.isNotBlank(val)) {
                                values.add(value);
                            }
                        }
                        if (map.get(pageExtractSelectorDto.getKey()) != null) {
                            if (CollectionUtils.isNotEmpty(values)) {
                                List<Object> _values = (List<Object>) map.get(pageExtractSelectorDto.getKey());
                                _values.addAll(values);
                                map.put(pageExtractSelectorDto.getKey(), _values);
                            }
                        } else {
                            map.put(pageExtractSelectorDto.getKey(), values);
                        }
                    } else {
                        WebElement element = driver.findElement(by);
                        Object value;
                        String val;
                        if (StringUtils.isNotBlank(elementAttr)) {
                            val = element.getAttribute(elementAttr);
                        } else {
                            val = element.getText();
                        }
                        switch (dataType) {
                            case INTEGER:
                                value = new Integer(val);
                                break;
                            case DOUBLE:
                                value = new Double(val);
                                break;
                            case BIG_DECIMAL:
                                value = new BigDecimal(val);
                                break;
                            case STRING:
                                if (searchs != null && replaces != null) {
                                    value = StringUtils.replaceEach(val, searchs, replaces);
                                } else {
                                    value = val;
                                }
                                break;
                            default:
                                value = val;
                        }
                        map.put(pageExtractSelectorDto.getKey(), value);
                    }
                }
            } else {
                //TODO
            }
        } catch (Exception e) {
            e.printStackTrace();
            driver.close();
        }
        return map;
    }

    private static String webDriverJs() {
        StringBuffer js = new StringBuffer();
        js.append("var TIMES = 10");
        js.append(", INTERVAL = 600");
        js.append(", delta = 1500");
        js.append(", preScrollTop = 0");
        js.append(", curScrollTOp = 0;");
        js.append("var scroll = function() {");
        js.append("    preScrollTop = window.pageYOffset;");
        js.append("    TIMES --;");
        js.append("    document.body.scrollTop = preScrollTop + delta;");
        js.append(" };");
        js.append(" scroll();");
        js.append(" var timer = setInterval(function() {");
        js.append("     curScrollTOp = window.pageYOffset;");
        js.append("     if (TIMES <= 0 || (curScrollTOp - preScrollTop) <= 3 ) {");
        js.append("         clearInterval(timer);");
        js.append("     }");
        js.append("     scroll();");
        js.append("  }, INTERVAL);");
        return js.toString();
    }
}
