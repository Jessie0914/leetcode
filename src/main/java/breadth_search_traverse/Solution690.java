package breadth_search_traverse;

/**
 * @ClassName Solution690
 * @Description 690.员工的重要性
 * @Author shishi
 * @Date 2019/7/23 19:16
 **/

import java.util.Iterator;
import java.util.List;

/**
 * 给定一个保存员工信息的数据结构，它包含了员工唯一的id，重要度 和 直系下属的id
 * 输入: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
 * 输出: 11
 */
public class Solution690 {
    // 我是先根据id找到以他开始的那个员工
    // 然后将他的直系下属List拿出来遍历，递归计算他的importances
    // 题解里面还有一个类似的方法，用栈来保存id，只要栈不为空，就一直往下计算
    public int getImportance(List<Employee> employees, int id) {
        Iterator<Employee> iterator = employees.iterator();
        int sum = 0;
        // 找到第一个员工，才能往下计算
        Employee firstEmployee = null;
        while (iterator.hasNext()){
            Employee employee = iterator.next();
            if (employee.id==id){
                firstEmployee = employee;
                sum += firstEmployee.importance;
                break;
            }
        }

        // 找它的直系下属
        List<Integer> subordinates = firstEmployee.subordinates;
        if (subordinates==null) return sum;
        Iterator<Integer> subordinateIterator = subordinates.iterator();
        while (subordinateIterator.hasNext()){
            int subId = subordinateIterator.next();{
                int subImportance = getImportance(employees, subId);
                sum+=subImportance;
            }
        }

        return sum;
    }
}