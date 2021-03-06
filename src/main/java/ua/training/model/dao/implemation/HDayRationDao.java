package ua.training.model.dao.implemation;

import lombok.extern.log4j.Log4j2;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import ua.training.constant.Attributes;
import ua.training.constant.Mess;
import ua.training.controller.commands.exception.DataSqlException;
import ua.training.model.dao.DayRationDao;
import ua.training.model.entity.DayRation;

import javax.persistence.NoResultException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Log4j2
public class HDayRationDao implements DayRationDao {
    /**
     * The main runtime interface between a Java application and Hibernate.
     *
     * @see Session
     */
    private Session session;

    HDayRationDao(Session session) {
        this.session = session;
    }

    @Override
    public void create(DayRation entity) {
        session.beginTransaction();
        Integer id = (Integer) session.save(entity);
        entity.setId(id);
        session.getTransaction().commit();
    }

    /**
     * Load day ration from database by id
     *
     * @param id Integer
     * @throws DataSqlException
     */
    @Override
    public Optional<DayRation> findById(Integer id) {
        try {
            return Optional.of(session.load(DayRation.class, id));
        } catch (ObjectNotFoundException e) {
            log.error(e.getMessage() + Mess.LOG_DAY_RATION_GET_BY_ID);
            throw new DataSqlException(Attributes.SQL_EXCEPTION);
        }
    }

    @Override
    public void update(DayRation entity) {
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
    }

    /**
     * Load and delete DayRation from database by id
     *
     * @param id Integer
     */
    @Override
    public void delete(Integer id) {
        String hqlDelRationCompos = DB_PROPERTIES.deleteCompositionByDayRationId();
        findById(id).ifPresent(dr -> {
            session.beginTransaction();

            Query query = session.createQuery(hqlDelRationCompos);
            query.setParameter("idDayRation", id);
            query.executeUpdate();

            session.delete(dr);
            session.getTransaction().commit();
            session.clear();
        });
    }

    @Override
    public void close() {
        session.flush();
        session.close();
    }

    /**
     * Check DayRation by date and user
     *
     * @param localDate LocalDate
     * @param idUser    Integer
     * @return dayRation Optional<DayRation>
     */
    @Override
    public Optional<DayRation> checkDayRationByDateAndUserId(LocalDate localDate, Integer idUser) {
        String hql = DB_PROPERTIES.getDayRationByDateAndUser();
        Optional<DayRation> dayRation;

        Query<DayRation> query = session.createQuery(hql, DayRation.class);
        query.setParameter("oDate", localDate);
        query.setParameter("idUser", idUser);

        try {
            dayRation = Optional.ofNullable(query.getSingleResult());
        } catch (NoResultException e) {
            dayRation = Optional.empty();
        }

        return dayRation;
    }

    /**
     * Get monthly DayRation for graphic
     *
     * @param month  Integer
     * @param year   Integer
     * @param userId Integer
     * @return dayRationList List<DayRation>
     */
    @Override
    public List<DayRation> getMonthlyDayRationByUser(Integer month, Integer year, Integer userId) {
        String hql = DB_PROPERTIES.getMonthlyDayRationByUser();

        Query<DayRation> query = session.createQuery(hql, DayRation.class);
        query.setParameter("mDate", month);
        query.setParameter("yDate", year);
        query.setParameter("idUser", userId);

        return query.getResultList();
    }
}
