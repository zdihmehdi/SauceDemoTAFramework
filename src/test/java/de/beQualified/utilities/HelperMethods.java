package de.beQualified.utilities;

import org.openqa.selenium.WebElement;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class centralizes the implementation of some useful methods that are used throughout the framework.
 */
public class HelperMethods {

    /**
     * A generic method that tests if a list of objects is in ascending order.
     *
     * @param objectsList The list of objects to verify the order of elements.
     * @return boolean True if the list is in ascending order, otherwise false.
     */
    public static <T extends Comparable<T>> boolean isAscendingOrder(List<T> objectsList) {
        for (int i = 0; i < objectsList.size() - 1; i++) {
            if (objectsList.get(i).compareTo(objectsList.get(i + 1)) > 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * A generic method that tests if a list of objects is in descending order.
     *
     * @param objectsList The list of objects to verify the order of elements.
     * @return boolean True if the list is in descending order, otherwise false.
     */
    public static <T extends Comparable<T>> boolean isDescendingOrder(List<T> objectsList) {
        for (int i = 0; i < objectsList.size() - 1; i++) {
            if (objectsList.get(i).compareTo(objectsList.get(i + 1)) < 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * A method that returns a map with ascending and descending ordered product prices.
     *
     * @param pricesWebElements The web elements containing the product prices.
     * @return Map<String, List < Double>> A map with keys values for ascending and descending orders, each containing a list of corresponding prices list.
     */
    public static Map<String, List<Double>> getSortedListOfPrices(List<WebElement> pricesWebElements) {
        List<Double> ascendingOrder = pricesWebElements.stream()
                .map(WebElement::getText)
                .map(text -> text.replaceAll("[^\\d.]", ""))
                .map(Double::parseDouble)
                .sorted()
                .toList();

        List<Double> descendingOrder = pricesWebElements.stream()
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

    /**
     * A method that returns a map with ascending and descending ordered product names.
     *
     * @param namesWebElements The web elements containing the product names.
     * @return Map<String, List < Double>> A map with keys values for ascending and descending orders, each containing a list of corresponding names list.
     */
    public static Map<String, List<String>> getSortedListOfNames(List<WebElement> namesWebElements) {
        List<String> ascendingOrder = namesWebElements.stream()
                .map(WebElement::getText)
                .sorted()  // Ascending order
                .toList();

        List<String> descendingOrder = namesWebElements.stream()
                .map(WebElement::getText)
                .sorted(Comparator.reverseOrder())  // Descending order
                .toList();

        Map<String, List<String>> sortedLists = new HashMap<>();
        sortedLists.put("ascending", ascendingOrder);
        sortedLists.put("descending", descendingOrder);

        return sortedLists;
    }
}