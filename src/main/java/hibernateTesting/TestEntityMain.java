package hibernateTesting;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class TestEntityMain {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file

		//creating seession factory object
		SessionFactory factory=cfg.buildSessionFactory();

		TestEntityRepository testEntityRepository = new TestEntityRepository(factory);

		TestEntity testEntity = new TestEntity();
		TestEntity testEntity2 = new TestEntity();
		testEntity2.setName("testname");
		System.out.println("persisting");
		testEntityRepository.persist(testEntity);
		testEntityRepository.persist(testEntity2);

		List<TestEntity> list = testEntityRepository.list();

		System.out.println(list.get(0).toString());
		System.out.println(list.get(1).toString());
		factory.close();
	}
}
