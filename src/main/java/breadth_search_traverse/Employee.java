package breadth_search_traverse;

import java.util.List;

/**
 * @ClassName Employee
 * @Description TODO
 * @Author shishi
 * @Date 2019/7/23 19:17
 **/
public class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
}
