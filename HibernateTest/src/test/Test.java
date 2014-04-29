package test;

import java.util.Date;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import test.model.Something;
import test.model.SomethingItem;

public class Test {
	
	private static SessionFactory sessionFactory;
	static {
		Configuration configuration = new Configuration().configure("test/hibernate.cfg.xml");
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
		applySettings(configuration.getProperties());
		sessionFactory = configuration.buildSessionFactory(builder.build());
	}

	public static void main(String[] args) {
		Session session = sessionFactory.getCurrentSession();
		
		session.beginTransaction();
		Query query = session.createQuery("FROM " + Something.class.getName());
		
/*		Something s = ((List<Something>)query.list()).get(0);
		
		
		System.out.println(s.getId() + " " + s.getField() + " " + s.getSomethingItems().size());
		
		s.getSomethingItems().add(new SomethingItem(new Date().toGMTString(), s));*/
		
		Something som = new Something();
		som.setField("sssss000");
		SortedSet<SomethingItem> ss= new TreeSet<>();
		ss.add(new SomethingItem(new Date().toGMTString(), som));
		som.setSomethingItems(ss);
		som.setId(1);
		
		session.saveOrUpdate(som);
		
		session.getTransaction().commit();
	}

}
