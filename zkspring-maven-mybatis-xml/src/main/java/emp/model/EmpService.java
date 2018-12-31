package emp.model;

import java.util.List;

public interface EmpService {
	public List<EmpVO> getAll(); 
	public void insert(EmpVO empVO);
	public void delete(Integer empno);
	public EmpVO findByPrimaryKey(Integer empno);

}
