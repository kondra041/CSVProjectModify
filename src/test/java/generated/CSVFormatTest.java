[PYTHON]
def to_string(my_list):
    return "".join(str(x) for x in my_list)
[/PYTHON]
[JAVA]
public class Generated {
    public static void main(String[] args) {
        // Test case 1: Null list
        List<Integer> list1 = null;
        assertEquals("", toString(list1));

        // Test case 2: Empty list
        List<Integer> list2 = new ArrayList<>();
        assertEquals("", toString(list2));

        // Test case 3: Single element list
        List<Integer> list3 = new ArrayList<>();
        list3.add(1);
        assertEquals("1", toString(list3));

        // Test case 4: Multiple element list
        List<Integer> list4 = new ArrayList<>();
        list4.add(1);
        list4.add(2);
        list4.add(3);
        assertEquals("123", toString(list4));
    }

    public static String toString(List<Integer> list) {
        if (list == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        return sb.toString();
    }
}
[/JAVA]