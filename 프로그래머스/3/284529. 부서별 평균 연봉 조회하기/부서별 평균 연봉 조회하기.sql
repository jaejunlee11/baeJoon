select e.DEPT_ID, d.DEPT_NAME_EN, round(AVG(e.SAL),0) as "AVG_SAL"
from HR_EMPLOYEES e
left join HR_DEPARTMENT d
on e.DEPT_ID = d.DEPT_ID
group by e.DEPT_ID
order by AVG_SAL desc;