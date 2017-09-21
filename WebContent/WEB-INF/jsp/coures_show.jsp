<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
    <%@ page import="java.util.List" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/lib/bootstrap/css/bootstrap.css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/css/js/jquery-1.11.1.js" ></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/css/lib/bootstrap/js/bootstrap.min.js" ></script>
<title>Insert title here</title>
<style type="text/css">
		
	
	
</style>
<script type="text/javascript">
	function deleteCoures(id) {
		var isDel = confirm("确定删除?");
		if (isDel) {
			location.href = "${pageContext.request.contextPath}/coures/deleteCoures.action?id="+id;
		}
	};
	function selectAlls() {
		$("input[name=selectId]").prop("checked",$("#selectAll").is(":checked"));
	};
	function deleteAll() {
		var isDel = confirm("确定删除？");
		if (isDel) {
			$("#delForm").submit();
		}
	}
	
	function goPage(pageIndex) {
		$("#pageIndex").val(pageIndex);
		$("#pageList").submit();
	}
</script>
</head>
<body>
			<%@include file="common/coures.jsp" %>
	<div class="container">
		    <div class="row">
		        <div class="col-md-2">
		            <div class="list-group">
		                <a href="${pageContext.request.contextPath}/coures/pageList.action" class="list-group-item active">课程管理</a>
		                <a href="${pageContext.request.contextPath}/coures/toAddCoures.action" class="list-group-item ">添加课程</a>
		            </div>
		        </div>
		        <div class="col-md-10">
		            <ul class="nav nav-tabs">
		                <li class="active">
		                    <a href="${pageContext.request.contextPath}/coures/pageList.action">课程列表</a>
		                </li>
		                <li  >
		                	<a href="${pageContext.request.contextPath}/coures/toAddCoures.action">添加课程</a>
		                </li>
		            </ul>
		            <form class="form-inline" action="${pageContext.request.contextPath}/coures/pageList.action?pageSize=${searchCondition.pageSize}" id="pageList" >
					<input type="hidden" name="pageIndex" id="pageIndex"/>
							课程名称：<input  class="form-control " type="text" name="coures.name" value="${searchCondition.coures.name}"/>
							课程学分：<input class="form-control " type="text" name="coures.grade" value="${searchCondition.coures.grade}"/>
							<input type="submit" value="查询">
							</form>
			<form id="delForm" action="${pageContext.request.contextPath}/coures/deleteAll">
				<table  class="table table-striped table-bordered table-hover">
				
				<tr>
					<td><input type="checkbox" id="selectAll" onclick="selectAlls();"/></td>
					<td>id</td>
					<td>课程</td>
					<td>学分</td>
					<td>所学班级</td>
					<td>修改</td>
					<td>删除</td>
				</tr>
				<tr>
					<td>
						<input type="button" onclick="deleteAll();" value="批量 删除" />
					</td>
				</tr>
				
				<c:forEach items="${pageBean.list}" var="coures">
					<tr>
					<td><input type="checkbox" name="selectId" value="${coures.id}"/></td>
					<td>${coures.id}</td>
					<td>${coures.name}</td>
					<td>${coures.grade }</td>
					<td>
						<c:forEach items="${coures.banjiList}" var="banji">
								${banji.name}
						</c:forEach>
					</td>	
					<td><a class="btn btn-primary" href="${pageContext.request.contextPath}/coures/toUpdateCoures.action?id=${coures.id}">修改</a></td>
					<td><a class="btn btn-danger" href="javascript:deleteCoures(${coures.id})">删除</a></td>
					<td></td>
				</tr>
				</c:forEach>
				</table>
			</form>
			</div>
		</div>
	</div>
				
					
					<!--分页按钮-->
		<div class="container">
			<div class="row">
				<div class="col-md-8">
				  	<ul class="pagination">
				    	<c:if test="${pageBean.pageIndex == 1}">
				    		<li class="disabled">
               				  <a href="javascript:void(0);" aria-label="Previous">
                   				<span aria-hidden="true">&laquo;</span>
						
				        	</a>
				    	</c:if>
				    	<c:if test="${pageBean.pageIndex != 1}">
				    		<li>
				      			<a href="${pageContext.request.contextPath}/coures/pageList.action?pageIndex=${pageBean.pageIndex - 1}" aria-label="Previous">
				        		<span aria-hidden="true">&laquo;</span>
				     		 </a>
				     		</li>
				      	</c:if>
				      	
				    <c:forEach begin="1" end="${pageBean.totalPage}" var="page"> 
				    	<c:if test="${pageBean.pageIndex != page}">
				    		<li><a href="${pageContext.request.contextPath}/coures/pageList.action?pageIndex=${page}">${page}</a></li>
				    		</c:if>  
				    	<c:if test="${pageBean.pageIndex == page }">
							<li class="active"><a href="${pageContext.request.contextPath}/coures/pageList.action?pageIndex=${page}">${page}</a></li>			    	
				    	</c:if>
				    </c:forEach>
				    <c:if test="${pageBean.pageIndex == pageBean.totalPage}">
				      		<li class="disabled">
               				  <a href="javascript:void(0);" aria-label="Previous">
                   				<span aria-hidden="true">&raquo;</span>
				        		</a>
				    	</c:if>
				    	<c:if test="${pageBean.pageIndex != pageBean.totalPage}">
				    		<li>
				      			<a href="${pageContext.request.contextPath}/coures/pageList.action?pageIndex=${pageBean.pageIndex + 1}" aria-label="Previous">
				        		<span aria-hidden="true">&raquo;</span>
				     		 	</a>
				     		 </li>
				      	</c:if>
				  </ul>
				</div>
			</div>
		</div>
</body>
</html>