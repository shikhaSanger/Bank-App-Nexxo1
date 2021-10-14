package Dao;

import io.ebean.*;

public class DbConnector {
    public static ExpressionFactory expression() {
        EbeanServer defaultDB = Ebean.getServer("default");
        return defaultDB.getExpressionFactory();
    }

    public static <T> Query<T> find(Class<T> beanType) {
        EbeanServer defaultDB = Ebean.getServer("default");
        return defaultDB.find(beanType);
    }

    public static <T> Query<T> createQuery(Class<T> beanType) {
        EbeanServer defaultDB = Ebean.getServer("default");
        return defaultDB.createQuery(beanType);
    }

    public static <T> SqlQuery createSqlQuery(String sql) {
        EbeanServer defaultDB = Ebean.getServer("default");
        return defaultDB.createSqlQuery(sql);
    }

    public static void save(Object bean) {
        EbeanServer defaultDB = Ebean.getServer("default");
        defaultDB.save(bean);
    }

    public static void update(Object bean) {
        EbeanServer defaultDB = Ebean.getServer("default");
        defaultDB.update(bean);
    }

    public static void delete(Object bean) {
        EbeanServer defaultDB = Ebean.getServer("default");
        defaultDB.delete(bean);
    }

    public static void refresh(Object bean) {
        EbeanServer defaultDB = Ebean.getServer("default");
        defaultDB.refresh(bean);
    }

    public static SqlUpdate createUpdateQuery(String s) {
        EbeanServer defaultDB = Ebean.getServer("default");
        return defaultDB.createSqlUpdate(s);
    }

    public static EbeanServer getServer(String serverName) {
        return Ebean.getServer(serverName);
    }
}

