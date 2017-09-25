<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/css/js/jquery-1.11.1.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/lib/bootstrap/css/bootstrap.css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/css/lib/bootstrap/js/bootstrap.min.js" ></script>
<script type="text/javascript">
		
</script>
<style type="text/css">
	.from_b{
		border: 1px solid #555; 
		padding: 10px;
		border-top:none;
	}

</style>
</head>

<body>
	<%@include file="common/banjicoures.jsp" %>
	<div class="container">
		    <div class="row">
		        <div class="col-md-2">
		            <div class="list-group">
		                <a href="${pageContext.request.contextPath}/manager/pageList.action" class="list-group-item ">教务管理</a>
		                <a href="${pageContext.request.contextPath}/manager/toAddManager.action" class="list-group-item active">添加教务</a>
		            </div>
		        </div>
		        <div class="col-md-10">
		            <ul class="nav nav-tabs">
		                <li >
		                    <a href="${pageContext.request.contextPath}/manager/pageList.action">教务列表</a>
		                </li>
		                <li class="active" >
		                	<a href="${pageContext.request.contextPath}/manager/toAddManager.action">添加教务</a>
		                </li>
		            </ul>
	
				<form class="form_b" action="${pageContext.request.contextPath}/manager/addManager.action" method="post"> 
					<div class="input-group input-group-sm">
						<table  class="table table-striped table-bordered table-hover">
							<c:forEach items="${banjiList}" var="banji">
								<tr>
									<td><input type="hidden" name="banji.id" value="${banji.id}"></td>
									<td>${banji.name}</td>
									<td>
										<c:forEach items="${couresList}" var="coures">
											<input type="checkbox" name="coures.id" value="${coures.id}">${coures.name}
										</c:forEach>
									</td>
									<td><input class="btn btn-primary" type="submit" value="添加"></td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>