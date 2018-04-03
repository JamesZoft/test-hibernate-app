package hibernateTesting;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.security.SecureRandom;
import java.util.List;

public class TestEntityRepository {

	private SessionFactory sessionFactory;

	public TestEntityRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<TestEntity> list() {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
//		List<TestEntity> list = session.createNativeQuery("select e.* from testentity e", TestEntity.class)
//			.addEntity("e", TestEntity.class).list();
		List<TestEntity> list = session.createQuery("select e from TestEntity e", TestEntity.class).list();
		t.commit();
		session.close();
		return list;
	}

	public void persist(TestEntity entity) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		SecureRandom secureRandom = new SecureRandom();
		entity.setId(secureRandom.nextLong());
		session.persist(entity);
		t.commit();
		session.close();
	}
}
