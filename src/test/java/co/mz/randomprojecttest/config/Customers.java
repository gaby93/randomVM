package co.mz.randomprojecttest.config;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */
@XmlRootElement
@XmlSeeAlso(Customer.class)
public class Customers extends ArrayList<Customer> {

    // ======================================
    // =            Constructors            =
    // ======================================

    public Customers() {
        super();
    }

    public Customers(Collection<? extends Customer> c) {
        super(c);
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================

    @XmlElement(name = "customer")
    public List<Customer> getCustomers() {
        return this;
    }

    public void setBooks(List<Customer> customers) {
        this.addAll(customers);
    }
}
