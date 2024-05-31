package arrays;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class PriorityQueueTest {

    static class Employee implements Comparable<Employee> {
        private String name;
        private Integer salary;
        Employee(String name, int salary) {
            this.name = name;
            this.salary = salary;
        }

        @Override
        public int compareTo(Employee o) {
            return o.salary.compareTo(this.salary);
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", salary=" + salary +
                    '}';
        }
    }

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(750,500,900,100);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.addAll(list.subList(1,list.size()));
        System.out.println(pq);
        System.out.println(pq.poll());
        pq.add(50);
        System.out.println(pq.peek());
        System.out.println(pq);



        List<Employee> employees = Arrays.asList(new Employee("John", 1000), new Employee("Jane", 20));
        PriorityQueue<Employee> employeePQ = new PriorityQueue<Employee>();
        for(Employee e: employees) {
            employeePQ.add(e);
        }
        System.out.println(employeePQ);
        System.out.println(employeePQ.peek());
    }

}
