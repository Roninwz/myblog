package test;

import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public final class HibernateUtil {
	// ��ʼ��һ��ThreadLocal����
	private static final ThreadLocal sessionTL = new ThreadLocal();
	private static Configuration configuration;
	private final static SessionFactory sessionFactory;

	static {
		try {
			// ���������ļ�hibernate.cfg.xml
			configuration = new Configuration().configure();

			// ��ûỰ����
			// sessionFactory = configuration.buildSessionFactory();

			// ����Hibernate4.0֮������������ԣ�Service Register����
			StandardServiceRegistry ssrRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();
			sessionFactory = configuration.buildSessionFactory(ssrRegistry);

		} catch (Throwable ex) {
			ex.printStackTrace();
			throw new ExceptionInInitializerError(ex);
		}
	}

	/**
	 * ��ȡSession
	 */
	public static Session currentSession() {
		// sessionTL��get()�������ݵ�ǰ�̷߳������Ӧ���߳��ڲ�������
		// Ҳ����������Ҫ��Session�����߳�����¹������ݿ������ǲ���ȫ�ġ�
		// ThreadLocal��֤��ÿ���̶߳����Լ���Session��
		Session session = (Session) sessionTL.get();
		// ���sessionΪnull�����һ���µ�session
		if (session == null) {
			// ����һ�����ݿ����Ӷ���session��
			session = sessionFactory.openSession();
			// ��������ݿ�����session��ThreadLocal�С�
			sessionTL.set(session);
		}
		// �����ǰ�߳��Ѿ����ʹ����ݿ��ˣ�
		// ���sessionTL��get()�Ϳ��Ի�ȡ���߳��ϴλ�ȡ�������ݿ����Ӷ���
		return session;
	}

	/**
	 * �ر�Session
	 */
	@SuppressWarnings("unchecked")
	public static void closeSession() {
		Session session = (Session) sessionTL.get();
		sessionTL.set(null);
		session.close();
	}
}
