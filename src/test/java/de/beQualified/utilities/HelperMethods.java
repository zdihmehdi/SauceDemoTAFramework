package de.beQualified.utilities;

import org.openqa.selenium.WebElement;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HelperMethods {
    public static <T extends Comparable<T>> boolean isAscendingOrder(List<T> myList) {
        for (int i = 0; i < myList.size() - 1; i++) {
            if (myList.get(i).compareTo(myList.get(i + 1)) > 0) {
                return false;
            }
        }
        return true;
    }

    public static <T extends Comparable<T>> boolean isDescendingOrder(List<T> myList) {
        for (int i = 0; i < myList.size() - 1; i++) {
            if (myList.get(i).compareTo(myList.get(i + 1)) < 0) {
                return false;
            }
        }
        return true;
    }

    public static Map<String, List<Double>> getSortedListOfPrices(List<WebElement> prices) {
        List<Double> ascendingOrder = prices.stream()
                .map(WebElement::getText)
                .map(text -> text.replaceAll("[^\\d.]", ""))
                .map(Double::parseDouble)
                .sorted()
                .toList();

        List<Double> descendingOrder = prices.stream()
                .map(WebElement::getText)
                .map(text -> text.replaceAll("[^\\d.]", ""))
                .map(Double::parseDouble)
                .sorted(Comparator.reverseOrder())
                .toList();

        Map<String, List<Double>> sortedLists = new HashMap<>();
        sortedLists.put("ascending", ascendingOrder);
        sortedLists.put("descending", descendingOrder);

        return sortedLists;
    }

    public static Map<String, List<String>> getSortedListOfNames(List<WebElement> names) {
        List<String> ascendingOrder = names.stream()
                .map(WebElement::getText)
                .sorted()  // Ascending order
                .toList();

        List<String> descendingOrder = names.stream()
                .map(WebElement::getText)
                .sorted(Comparator.reverseOrder())  // Descending order
                .toList();

        Map<String, List<String>> sortedLists = new HashMap<>();
        sortedLists.put("ascending", ascendingOrder);
        sortedLists.put("descending", descendingOrder);

        return sortedLists;
    }
}
