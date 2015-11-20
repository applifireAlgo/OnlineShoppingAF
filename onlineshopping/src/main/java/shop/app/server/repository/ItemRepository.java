package shop.app.server.repository;
import com.athena.server.repository.SearchInterface;
import com.athena.annotation.Complexity;
import com.athena.annotation.SourceCodeAuthorClass;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;
import java.util.List;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;

@SourceCodeAuthorClass(createdBy = "jack@doe.com", updatedBy = "jack@doe.com", versionNumber = "2", comments = "Repository for Item Master table Entity", complexity = Complexity.LOW)
public interface ItemRepository<T> extends SearchInterface {

    public List<T> findAll() throws SpartanPersistenceException;

    public T save(T entity) throws SpartanPersistenceException;

    public List<T> save(List<T> entity) throws SpartanPersistenceException;

    public void delete(String id) throws SpartanPersistenceException;

    public void update(T entity) throws SpartanConstraintViolationException, SpartanPersistenceException;

    public void update(List<T> entity) throws SpartanPersistenceException;

    public List<T> findByProduct(String product) throws Exception, SpartanPersistenceException;

    public List<T> findByBrand(String brand) throws Exception, SpartanPersistenceException;

    public List<T> findByCategory(String category) throws Exception, SpartanPersistenceException;

    public T findById(String itemId) throws Exception, SpartanPersistenceException;

    public List<T> FetchItemDetails(String itemId) throws Exception, SpartanPersistenceException;
}
