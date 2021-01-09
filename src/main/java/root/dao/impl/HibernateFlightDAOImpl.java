package root.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import root.dao.IFlightDAO;
import root.model.Flight;

import javax.persistence.NoResultException;
import java.util.List;

@Repository
public class HibernateFlightDAOImpl implements IFlightDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Flight getFlightByEAN(String ean) {
        Session session = this.sessionFactory.openSession();
        Query<Flight> query = session.createQuery("FROM root.model.Flight WHERE ean = :ean");
        query.setParameter("ean", ean);
        Flight flight = null;
        try {
            flight = query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println("Flight not found");
        }
        session.close();
        return flight;
    }

    @Override
    public void updateFlight(Flight flight) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(flight);
            tx.commit();
        } catch (Exception e) {
            if(tx != null)
                tx.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void persistFlight(Flight flight) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(flight);
            tx.commit();
        } catch (Exception e) {
            if(tx != null)
                tx.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public Flight getFlightById(int id) {
        Session session = this.sessionFactory.openSession();
        Query<Flight> query = session.createQuery("FROM root.model.Flight WHERE id = :id");
        query.setParameter("id", id);
        Flight flight = null;
        try {
            flight = query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println("Flight not found");
        }
        session.close();
        return flight;
    }

    @Override
    public List<Flight> getFlightsByCategory(Flight.Category category) {
        Session session = this.sessionFactory.openSession();
        Query<Flight> query = session.createQuery("FROM root.model.Flight WHERE category = :category");
        query.setParameter("category", category);
        List<Flight> flights = query.getResultList();
        session.close();
        return flights;
    }

    @Override
    public List<Flight> getAllFlights() {
        Session session = this.sessionFactory.openSession();
        Query<Flight> query = session.createQuery("FROM root.model.Flight");
        List<Flight> flights = query.getResultList();
        session.close();
        return flights;
    }
}