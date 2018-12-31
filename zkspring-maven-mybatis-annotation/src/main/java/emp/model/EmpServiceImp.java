package emp.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.zkoss.zk.ui.select.annotation.WireVariable;
//@Service("empService")
public class EmpServiceImp implements EmpService{
//	@Autowired
//	@Qualifier("empDAO")
	private EmpDAO_interface dao;

//	public EmpService() {
//		dao = new EmpHibernateDAO();
//	}

	public EmpDAO_interface getDao() {
		return dao;
	}

	public void setDao(EmpDAO_interface dao) {
		this.dao = dao;
	}

	public EmpVO insert(String ename, String job, java.sql.Date hiredate,
			Double sal, Double comm, Integer deptno) {

		EmpVO empVO = new EmpVO();

		empVO.setEname(ename);
		empVO.setJob(job);
		empVO.setHiredate(hiredate);
		empVO.setSal(sal);
		empVO.setComm(comm);
		empVO.setDeptno(deptno);
		dao.insert(empVO);

		return empVO;
	}
	
	//�w�d�� Struts 2 �Ϊ�
	public void insert(EmpVO empVO) {
		dao.insert(empVO);
	}

	public EmpVO updateEmp(Integer empno, String ename, String job,
			java.sql.Date hiredate, Double sal, Double comm, Integer deptno) {

		EmpVO empVO = new EmpVO();

		empVO.setEmpno(empno);
		empVO.setEname(ename);
		empVO.setJob(job);
		empVO.setHiredate(hiredate);
		empVO.setSal(sal);
		empVO.setComm(comm);
		empVO.setDeptno(deptno);
		dao.update(empVO);

		return dao.findByPrimaryKey(empno);
	}
	
	//�w�d�� Struts 2 �Ϊ�
	public void updateEmp(EmpVO empVO) {
		dao.update(empVO);
	}

	public void delete(Integer empno) {
		dao.delete(empno);
	}

	public EmpVO findByPrimaryKey(Integer empno) {
		return dao.findByPrimaryKey(empno);
	}
@Override
	public List<EmpVO> getAll() {
		return dao.getAll();
	}
}
