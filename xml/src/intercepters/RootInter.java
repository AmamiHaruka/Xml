package intercepters;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class RootInter extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		ActionContext actionContext=arg0.getInvocationContext();
		Map<String, Object> session=actionContext.getSession();
		String role=(String) session.get("role");
		if(role.equals("common")||role==null){
			return null;
		}else{
			return arg0.invoke();
		}
	}

}
