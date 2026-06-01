[PYTHON]
def get_unique_elements(my_list):
    return list(set(my_list))
[/PYTHON]
[JAVA]
package generated;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UniqueElements {
    public static List<Integer> getUniqueElements(List<Integer> myList) {
        Set<Integer> set = new HashSet<>();
        set.addAll(myList);
        return set.stream().collect(Collectors.toList());
    }
}
[/JAVA]
[PYTHON]
def get_unique_elements(my_list):
    return list(set(my_list))
[/PYTHON]
[JAVASCRIPT]
function getUniqueElements(myList) {
  return [...new Set(myList)];
}
[/JAVASCRIPT]