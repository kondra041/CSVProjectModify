[PYTHON]
def get_unique_elements(my_list):
    unique_elements = []
    for element in my_list:
        if element not in unique_elements:
            unique_elements.append(element)
    return unique_elements
[/PYTHON]
[JAVA]
/**
 * Returns a new List with all duplicate elements removed
 * @param list the original List
 * @return a new List with all duplicate elements removed
 */
public static <T> List<T> getUniqueElements(List<T> list) {
    return new ArrayList<>(new LinkedHashSet<>(list));
}
[/JAVA]
[PHP]
<?php
function get_unique_elements($my_list) {
    $unique_elements = [];
    foreach ($my_list as $element) {
        if (!in_array($element, $unique_elements)) {
            $unique_elements[] = $element;
        }
    }
    return $unique_elements;
}
[/PHP]