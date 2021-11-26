<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../includes/header.jsp"%>


<div class="row">
  <div class="col-lg-12">
    <h1 class="page-header">My Music Info</h1>
  </div>
  <!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
  <div class="col-lg-12">
    <div class="panel panel-default">

      <div class="panel-heading">Play List Modify Page</div>
      <!-- /.panel-heading -->
      <div class="panel-body">

      <form role="form" action="/board/modify" method="post">
      
        <input type='hidden' name='pageNum' value='<c:out value="${cri.pageNum }"/>'>
        <input type='hidden' name='amount' value='<c:out value="${cri.amount }"/>'>
		<input type='hidden' name='keyword' value='<c:out value="${cri.keyword }"/>'>
      
 
<div class="form-group">
  <label>No</label> 
  <input class="form-control" name='pno' 
     value='<c:out value="${playlist.pno}"/>' readonly="readonly">
</div>

<div class="form-group">
  <label>Play List Name</label> 
  <input class="form-control" name='name' 
    value='<c:out value="${playlist.name } }"/>' >
</div>

<div class="form-group">
  <label>RegDate</label> 
  <input class="form-control" name='regDate'
    value='<fmt:formatDate pattern = "yyyy/MM/dd" value = "${playlist.regDate}" />'  readonly="readonly">            
</div>

<div class="form-group">
  <label>UpdateDate</label> 
  <input class="form-control" name='updateDate'
    value='<fmt:formatDate pattern = "yyyy/MM/dd" value = "${playlist.updateDate}" />'  readonly="readonly">            
</div>

          

  <button type="submit" data-oper='modify' class="btn btn-default">Modify</button>
  <button type="submit" data-oper='remove' class="btn btn-danger">Remove</button>
  <button type="submit" data-oper='list' class="btn btn-info">Play List</button>
</form>


      </div>
      <!--  end panel-body -->

    </div>
    <!--  end panel-body -->
  </div>
  <!-- end panel -->
</div>
<!-- /.row -->

<script type="text/javascript">
$(document).ready(function() {


	  var formObj = $("form");

	  $('button').on("click", function(e){
	    
	    e.preventDefault(); 
	    
	    var operation = $(this).data("oper");
	    
	    console.log(operation);
	    
	    if(operation === 'remove'){
	      formObj.attr("action", "/music/remove");
	      
	    }else if(operation === 'list'){
	   
	      formObj.attr("action", "/music/list").attr("method","get");
	      
	      var pageNumTag = $("input[name='pageNum']").clone();
	      var amountTag = $("input[name='amount']").clone();
	      var keywordTag = $("input[name='keyword']").clone();   
	      
	      formObj.empty();
	      
	      formObj.append(pageNumTag);
	      formObj.append(amountTag);
	      formObj.append(keywordTag);
	       
	    }
	    
	    formObj.submit();
	  });

});
</script>
  




<%@include file="../includes/footer.jsp"%>
