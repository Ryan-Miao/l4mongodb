package com.test;

import com.mongodb.MongoClient;
import org.bson.types.ObjectId;
import org.junit.Test;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.annotations.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/**
 * Created by rmiao on 8/11/2016.
 */
public class QuickTour {

    private static final Datastore datastore = getDatastore();

    public static void main(String[] args) {
        final Employee elmer = new Employee("Elmer Fudd", 123.0);
        Key<Employee> save = datastore.save(elmer);

    }

    @Test
    public void testDate(){
        TimeZone timeZone = TimeZone.getDefault();
        System.out.println(timeZone);
        Date a = new Date();
        System.out.println("default:  "+a);
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        System.out.println("UTC:   "+a);
        TimeZone.setDefault(timeZone);
        Employee one = new Employee("a",a);
        Key<Employee> save = datastore.save(one);
        Object id = save.getId();
        System.out.println(id);

        List<Employee> employees = datastore.createQuery(Employee.class)
                .asList();
        Employee employee = employees.get(0);
        Date updateTime = employee.getUpdateTime();
        System.out.println(updateTime);

    }

    @Test
    public void testDate2(){

    }



    private static Datastore getDatastore() {
        final Morphia morphia = new Morphia();
        morphia.mapPackage("com.test");

        // create the Datastore connecting to the database running on the default port on the local host
        final Datastore datastore = morphia.createDatastore(new MongoClient(), "morphia_example");
        datastore.getDB().dropDatabase();
        datastore.ensureIndexes();
        return datastore;
    }
}

@Entity("employees")
@Indexes(@Index(value = "salary", fields = @Field("salary")))
class Employee {
    @Id
    private ObjectId id;
    private String name;
    private Integer age;
    private Date updateTime;
    @Reference
    private Employee manager;
    @Reference
    private List<Employee> directReports = new ArrayList<Employee>();
    @Property("wage")
    private Double salary;




    public Employee() {
    }

    public Employee(final String name, final Double salary) {
        this.name = name;
        this.salary = salary;
    }

    public Employee(String name, Date updateTime) {
        this.name = name;
        this.updateTime = updateTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public List<Employee> getDirectReports() {
        return directReports;
    }

    public void setDirectReports(final List<Employee> directReports) {
        this.directReports = directReports;
    }

    public ObjectId getId() {
        return id;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(final Employee manager) {
        this.manager = manager;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(final Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", updateTime=" + updateTime +
                ", manager=" + manager +
                ", directReports=" + directReports +
                ", salary=" + salary +
                '}';
    }
}
